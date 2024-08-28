package com.ayoub.controller;

import com.ayoub.registrationrequest.MemberRegistrationRequest;
import com.ayoub.repository.MemberRepository;
import com.ayoub.service.MemberService;
import com.ayoub.model.Member;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api1")
public class MemberController {
    private final MemberService memberService;
    private final MemberRepository memberRepository;

    public MemberController(MemberService memberService, MemberRepository memberRepository) {
        this.memberService = memberService;
        this.memberRepository = memberRepository;
    }

    @GetMapping
    public List<Member> SelectAllMembers() {
        return memberService.SelectAllMembers();
    }

    @GetMapping("/{id}")
    public Member FindMemberById(@PathVariable Integer id) {
        return memberService.FindMemberById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteMemberById(@PathVariable Integer id) {
         memberService.deleteMemberById(id);
    }
    @PostMapping
    public void registerMember(
            @RequestBody MemberRegistrationRequest request){
        memberService.AddMember(request);
    }

}