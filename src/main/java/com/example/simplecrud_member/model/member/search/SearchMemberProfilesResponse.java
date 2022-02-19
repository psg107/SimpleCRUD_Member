package com.example.simplecrud_member.model.member.search;

import com.example.simplecrud_member.model.member.shared.MemberProfile;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class SearchMemberProfilesResponse {

    @Getter
    @Setter
    private List<MemberProfile> memberProfiles;
}
