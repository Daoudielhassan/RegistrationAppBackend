package com.ayoub.dao;

import com.ayoub.model.Member;

import java.util.List;
import java.util.Optional;

public interface MemberDao {
    Optional<Member> FindById(Integer Id);
    void DeleteMemberFindById(Integer Id);
    List<Member> SelectAllMembers();

    public void AddMember(Member member);
    boolean existsPersonWithEmail(String email);


}