package com.example.simplecrud_member.controller;

import com.example.simplecrud_member.exception.InvalidRequestModelException;
import com.example.simplecrud_member.model.common.ServiceResponse;
import com.example.simplecrud_member.model.member.service.get.GetMemberProfileRequest;
import com.example.simplecrud_member.model.member.service.get.GetMemberProfileResponse;
import com.example.simplecrud_member.model.member.service.search.SearchMemberProfilesRequest;
import com.example.simplecrud_member.model.member.service.search.SearchMemberProfilesResponse;
import com.example.simplecrud_member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /**
     * 사용자 정보 조회
     * @param request
     * @return
     */
    @RequestMapping(path = "", method = RequestMethod.GET)
    public ServiceResponse<GetMemberProfileResponse> getMemberProfile(GetMemberProfileRequest request) {
        try{
            //validate
            request.validate();

            //model parameter
            var memberId = request.getMemberId();

            //service
            var memberProfile = this.memberService.getMemberProfileById(memberId);
            if (memberProfile == null) {
                return new ServiceResponse(HttpStatus.NOT_FOUND);
            }

            //return
            return new ServiceResponse(HttpStatus.OK, memberProfile);
        } catch (InvalidRequestModelException ex) {
            return new ServiceResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
        } catch (Exception ex) {
            return new ServiceResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    /**
     * 사용자 정보 조회
     * @return
     */
    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public ServiceResponse<SearchMemberProfilesResponse> getMemberProfiles(SearchMemberProfilesRequest request) {
        try {
            //validate
            request.validate();

            //model parameter
            var memberIds = request.getMemberIds();

            //service
            var memberProfiles = this.memberService.getMemberProfileByIds(memberIds);
            if (memberProfiles == null) {
                return new ServiceResponse(HttpStatus.NOT_FOUND);
            }

            //return
            return new ServiceResponse(HttpStatus.OK, memberProfiles);
        } catch (InvalidRequestModelException ex) {
            return new ServiceResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
        } catch (Exception ex) {
            return new ServiceResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }
}
