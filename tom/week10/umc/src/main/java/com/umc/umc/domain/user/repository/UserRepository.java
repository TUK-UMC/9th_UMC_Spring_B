package com.umc.umc.domain.user.repository;

import com.umc.umc.domain.user.dto.CustomUserDetails;
import com.umc.umc.domain.user.dto.MypageDto;
import com.umc.umc.domain.user.entity.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select new com.umc.umc.domain.user.dto.MypageDto(u.name, u.email, u.phoneNumber, u.point)"
            + "from User u where u.id = :userId")
    Optional<MypageDto> findByUserId(@Param("userId") Long userId);

    Optional<User> findByEmail(String username);
}


