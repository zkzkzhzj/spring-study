package com.zkzkzhzj.study.controller;

import com.zkzkzhzj.study.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

// spring bean 등록, 컨트롤러로 가지고 있음
@Controller
public class MemberController {

    private final MemberService memberService;

    // 등록된 멤버 서비스와 연결(동일한 객체 사용)
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
