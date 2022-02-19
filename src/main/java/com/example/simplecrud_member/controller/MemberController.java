package com.example.simplecrud_member.controller;

import com.example.simplecrud_member.model.member.get.GetMemberProfileResponse;
import com.example.simplecrud_member.model.member.search.SearchMemberProfilesResponse;
import com.example.simplecrud_member.model.member.shared.MemberProfile;
import com.example.simplecrud_member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity getMemberProfile(@PathVariable int memberId) {
        //validate
        if (memberId <= 0){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        //
        var memberProfile = this.memberService.getMemberProfileById(memberId);
        if (memberProfile == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        //wrapping
        var body = new GetMemberProfileResponse();
        body.setMemberProfile(memberProfile);

        return new ResponseEntity(body, HttpStatus.OK);
    }

    /**
     * 사용자 정보 조회
     * @return
     */
    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public ResponseEntity getMemberProfiles(@RequestParam(value = "memberIds") List<Integer> memberIds) {
        //validate
        if (memberIds == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        if (memberIds.size() == 0) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        //
        var memberProfiles = this.memberService.getMemberProfileByIds(memberIds);
        if (memberProfiles == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        //wrapping
        var body = new SearchMemberProfilesResponse();
        body.setMemberProfiles(memberProfiles);

        return new ResponseEntity(body, HttpStatus.OK);
    }
}
