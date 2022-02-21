package com.example.simplecrud_member.model.member.get;

import com.example.simplecrud_member.model.member.shared.MemberProfile;
import lombok.Getter;
import lombok.Setter;

public class GetMemberProfileResponse {

    @Getter
    @Setter
    private int memberId;

    @Getter
    @Setter
    private String name;
}
