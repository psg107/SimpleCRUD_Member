package com.example.simplecrud_member.mapper;

import com.example.simplecrud_member.model.member.shared.MemberProfile;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *resources/mapper/mapper.xml 와 매핑되는 인터페이스 정의
 */
@Mapper
@Repository
public interface IMemberMapper {

    /**
     * 사용자 정보 가져오기
     * @param memberId
     * @return
     */
    MemberProfile getMemberProfile(int memberId);

    /**
     * 사용자 정보 가져오기
     * @param memberIds
     * @return
     */
    List<MemberProfile> getMemberProfiles(List<Integer> memberIds);
}
