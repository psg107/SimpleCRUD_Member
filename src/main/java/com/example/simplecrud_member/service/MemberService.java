package com.example.simplecrud_member.service;

import com.example.simplecrud_member.model.member.common.MemberProfile;
import com.example.simplecrud_member.repository.MemberRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberProfile getMemberProfileById(int memberId) {
        var memberProfile = this.memberRepository.getMemberProfile(memberId);

        return memberProfile;
    }

    public List<MemberProfile> getMemberProfileByIds(List<Integer> memberIds) {
        var memberProfiles = this.memberRepository.getMemberProfiles(memberIds);

        return memberProfiles;
    }
}
