package com.ayoub.service;

import com.ayoub.Exception.DuplicateResourceException;
import com.ayoub.Exception.ResourceNotFound;
import com.ayoub.dao.MemberDao;
import com.ayoub.model.Member;
import com.ayoub.registrationrequest.MemberRegistrationRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private final MemberDao memberDAO;

    public MemberService(@Qualifier("jpa")MemberDao memberDAO) {
        this.memberDAO = memberDAO;
    }

    public void AddMember(MemberRegistrationRequest memberRegistrationRequest) {
        String email = memberRegistrationRequest.email();
        if (memberDAO.existsPersonWithEmail(email)){
            throw new DuplicateResourceException("email already taken");
        };
        Member member = new Member(
                memberRegistrationRequest.firstName(),
                memberRegistrationRequest.lastName(),
                memberRegistrationRequest.phoneNumber(),
                memberRegistrationRequest.email()
        );
        memberDAO.AddMember(member);
    }
    public List<Member> SelectAllMembers() {
        return memberDAO.SelectAllMembers();
    }
    public Member FindMemberById(Integer id) {
        return memberDAO.FindById(id)
                .orElseThrow(()-> new ResourceNotFound(
                        "member with id [%s] not found".formatted(id)));
    }
    public void deleteMemberById(Integer id) {
        Member member = memberDAO.FindById(id)
                .orElseThrow(() -> new ResourceNotFound(
                        "Member with id [%s] not found".formatted(id)));
        memberDAO.DeleteMemberFindById(member.getId());
    }

}
