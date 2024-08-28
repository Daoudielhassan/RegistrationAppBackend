package com.RegistrationAppBackend.repository;

import com.RegistrationAppBackend.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Integer> {
    public boolean existsMemberByEmail(String email);

}
