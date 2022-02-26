package com.example.simplecrud_member.model.member.service.search;

import com.example.simplecrud_member.model.member.common.MemberProfile;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class SearchMemberProfilesResponse {

    @Getter
    @Setter
    private List<MemberProfile> memberProfiles;
}
