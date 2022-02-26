package com.example.simplecrud_member.model.member.service.get;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @see com.example.simplecrud_member.controller.MemberController
 * @see com.example.simplecrud_member.model.member.service.get.GetMemberProfileRequest
 */
public class GetMemberProfileResponse {

    @Getter
    @Setter
    private int memberId;

    @Getter
    @Setter
    private String name;
}
