package com.example.simplecrud_member.repository;

import com.example.simplecrud_member.mapper.IMemberMapper;
import com.example.simplecrud_member.model.member.shared.MemberProfile;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * mybatis를 사용한 Member 정보 관리
 */
@Component
public class MemberRepository {

    private final IMemberMapper mapper;

    public MemberRepository(IMemberMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * 사용자 정보 조회
     * @param memberId
     * @return
     */
    public MemberProfile getMemberProfile(int memberId) {
        var memberProfile = this.mapper.getMemberProfile(memberId);

        return memberProfile;
    }

    /**
     * 사용자 정보 조회
     * @param memberIds
     * @return
     */
    public List<MemberProfile> getMemberProfiles(List<Integer> memberIds) {
        var memberProfiles = this.mapper.getMemberProfiles(memberIds);

        return memberProfiles;
    }
}
