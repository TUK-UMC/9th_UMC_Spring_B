package com.example.chapter6.domain.member.service.command;

import com.example.chapter6.domain.member.converter.MemberConverter;
import com.example.chapter6.domain.member.dto.MemberReqDTO;
import com.example.chapter6.domain.member.dto.MemberResDTO;
import com.example.chapter6.domain.member.entity.Food;
import com.example.chapter6.domain.member.entity.Member;
import com.example.chapter6.domain.member.entity.Preference;
import com.example.chapter6.domain.member.exception.MemberException;
import com.example.chapter6.domain.member.exception.code.MemberErrorCode;
import com.example.chapter6.domain.member.repository.FoodRepository;
import com.example.chapter6.domain.member.repository.MemberRepository;
import com.example.chapter6.domain.member.repository.PreferenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final FoodRepository foodRepository;
    private final PreferenceRepository preferenceRepository;

    // 회원가입
    @Override
    public MemberResDTO.JoinDTO signup(
            MemberReqDTO.JoinDTO dto
    ){
        // 사용자 생성
        Member member = MemberConverter.toMember(dto);
        // DB 적용
        memberRepository.save(member);

        // 선호 음식 존재 여부 확인
        if (dto.preferCategory().size() > 1){
            List<Preference> preferenceList = new ArrayList<>();

            // 선호 음식 ID별 조회
            for (Long id : dto.preferCategory()){

                // 음식 존재 여부 검증
                Food food = foodRepository.findById(id)
                        .orElseThrow(() -> new MemberException(MemberErrorCode.MEMBER_NOT_FOUND));

                // MemberFood 엔티티 생성 (컨버터 사용해야 함)
                Preference preference = Preference.builder()
                        .member(member)
                        .food(food)
                        .build();

                // 사용자 - 음식 (선호 음식) 추가
                preferenceList.add(preference);
            }

            // 모든 선호 음식 추가: DB 적용
            preferenceRepository.saveAll(preferenceList);
        }


        // 응답 DTO 생성
        return MemberConverter.toJoinDTO(member);
    }
}