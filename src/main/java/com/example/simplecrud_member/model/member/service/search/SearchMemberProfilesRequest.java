package com.example.simplecrud_member.model.member.service.search;

import com.example.simplecrud_member.exception.InvalidRequestModelException;
import com.example.simplecrud_member.model.common.ValidatableRequestModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 *
 * @see com.example.simplecrud_member.controller.MemberController
 * @see com.example.simplecrud_member.model.member.service.search.SearchMemberProfilesResponse
 */
public class SearchMemberProfilesRequest extends ValidatableRequestModel {

    @Getter
    @Setter
    private List<Integer> memberIds;

    @Override
    public void validate() throws InvalidRequestModelException {
        if (memberIds == null) {
            throw new InvalidRequestModelException("사용자 아이디가 입력되지 않았습니다. - 1");
        }
        if (memberIds.size() == 0) {
            throw new InvalidRequestModelException("사용자 아이디가 입력되지 않았습니다. - 2");
        }
        if (memberIds.stream().anyMatch(x -> x <= 0)) {
            throw new InvalidRequestModelException("사용자 아이디가 잘못되었습니다.");
        }
    }
}
