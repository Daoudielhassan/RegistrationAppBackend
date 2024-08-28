package com.RegistrationAppBackend.jpa;

import com.RegistrationAppBackend.repository.MemberRepository;
import com.RegistrationAppBackend.dao.MemberDao;
import com.RegistrationAppBackend.model.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository("jpa")
public class MemberJPADataAcessService implements MemberDao {
    private final MemberRepository memberRepository;

    public MemberJPADataAcessService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void AddMember(Member member) {
        memberRepository.save(member);
    }

    @Override
    public boolean existsPersonWithEmail(String email) {
        return memberRepository.existsMemberByEmail(email);
    }

    @Override
    public Optional<Member> FindById(Integer Id) {
        return memberRepository.findById(Id);
    }

    @Override
    public List<Member> SelectAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public void DeleteMemberFindById(Integer Id) {
        memberRepository.deleteById(Id);
    }
}
