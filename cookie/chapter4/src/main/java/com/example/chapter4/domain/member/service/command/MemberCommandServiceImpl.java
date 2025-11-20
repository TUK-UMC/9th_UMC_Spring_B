package com.example.chapter4.domain.member.service.command;

import com.example.chapter4.domain.member.dto.MemberReqDTO;
import com.example.chapter4.domain.member.dto.MemberResDTO;
import com.example.chapter4.domain.member.entity.Food;
import com.example.chapter4.domain.member.entity.Member;
import com.example.chapter4.domain.member.entity.Preference;
import com.example.chapter4.domain.member.repository.FoodRepository;
import com.example.chapter4.domain.member.repository.MemberRepository;
import com.example.chapter4.domain.member.converter.MemberConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final FoodRepository foodRepository;

    @Override
    @Transactional
    public MemberResDTO.JoinDTO signup(MemberReqDTO.JoinDTO dto) {
        // 음식 엔티티 목록 조회
        List<Food> foods = foodRepository.findAllById(dto.preferredFoodIds());

        // DTO를 Member 엔티티로 변환
        Member member = MemberConverter.toMember(dto);

        // 선호 Preference 리스트 생성
        List<Preference> preferenceList = new ArrayList<>();
        for (Food food : foods) {
            Preference preference = Preference.builder()
                    .member(member)
                    .food(food)
                    .build();
            preferenceList.add(preference);
        }
        member.getPreferenceList().addAll(preferenceList);

        // 회원 및 선호 저장
        Member saved = memberRepository.save(member);

        // 저장된 엔티티를 DTO로 변환해서 반환
        return MemberConverter.toJoinDTO(saved);
    }
}
