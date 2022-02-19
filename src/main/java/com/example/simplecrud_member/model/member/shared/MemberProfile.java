package com.example.simplecrud_member.model.member.shared;

import lombok.Getter;
import lombok.Setter;

public class MemberProfile {
    @Getter
    @Setter
    private int memberId;

    @Getter
    @Setter
    private String name;
}
