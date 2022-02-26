package com.example.simplecrud_member.model.member.service.get;

import com.example.simplecrud_member.exception.InvalidRequestModelException;
import com.example.simplecrud_member.model.common.ValidatableRequestModel;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @see com.example.simplecrud_member.controller.MemberController
 * @see com.example.simplecrud_member.model.member.service.get.GetMemberProfileResponse
 */
public class GetMemberProfileRequest extends ValidatableRequestModel {

    @Getter
    @Setter
    private int memberId;

    @Override
    public void validate() throws InvalidRequestModelException {
        if (this.memberId <= 0){
            throw new InvalidRequestModelException("사용자 아이디가 잘못되었습니다.");
        }
    }
}
