package com.example.simplecrud_member.controller;

import com.example.simplecrud_member.model.common.ServiceResponse;
import com.example.simplecrud_member.model.member.service.get.GetMemberProfileResponse;
import com.example.simplecrud_member.model.member.service.search.SearchMemberProfilesResponse;
import com.example.simplecrud_member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /**
     * 사용자 정보 조회
     * @param memberId
     * @return
     */
    @RequestMapping(path = "/{memberId}", method = RequestMethod.GET)
    public ServiceResponse<GetMemberProfileResponse> getMemberProfile(@PathVariable int memberId) {
        //validate
        if (memberId <= 0){
            return new ServiceResponse(HttpStatus.BAD_REQUEST);
        }

        //
        var memberProfile = this.memberService.getMemberProfileById(memberId);
        if (memberProfile == null) {
            return new ServiceResponse(HttpStatus.NOT_FOUND);
        }

        return new ServiceResponse(HttpStatus.OK, memberProfile);
    }

    /**
     * 사용자 정보 조회
     * @return
     */
    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public ServiceResponse<SearchMemberProfilesResponse> getMemberProfiles(@RequestParam(value = "memberIds") List<Integer> memberIds) {
        //validate
        if (memberIds == null) {
            return new ServiceResponse(HttpStatus.BAD_REQUEST);
        }
        if (memberIds.size() == 0) {
            return new ServiceResponse(HttpStatus.BAD_REQUEST);
        }

        //
        var memberProfiles = this.memberService.getMemberProfileByIds(memberIds);
        if (memberProfiles == null) {
            return new ServiceResponse(HttpStatus.NOT_FOUND);
        }

        return new ServiceResponse(HttpStatus.OK, memberProfiles);
    }
}
