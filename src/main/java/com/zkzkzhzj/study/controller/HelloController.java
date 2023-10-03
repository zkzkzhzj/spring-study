package com.zkzkzhzj.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    // get, post : 도메인 주소를 찾아서 매핑
    @GetMapping("hello")
    public String hello(Model model) {
        // 리턴해줄 페이지에 넘겨줄 값 세팅
        model.addAttribute("data옴", "Hello!!!");

        // resources -> templates 하단 *.html 에서 * 과 매핑
        return "hello";
    }

    // 매핑 추가
    @GetMapping("hello-mvc")
    // 직접 입력하지 않고 도메인에서 파라매터를 가져온다
    public String helloMvc(@RequestParam("name") String name, Model model){
        // 가져온 파라매터 넘겨주기
        model.addAttribute("name", name);

        return "hello-template";
    }
}
