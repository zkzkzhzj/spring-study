package com.zkzkzhzj.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String helloMvc(@RequestParam("name") String name, Model model) {
        // 가져온 파라매터 넘겨주기
        model.addAttribute("name", name);

        return "hello-template";
    }

    // 문자열 반환 추가
    @GetMapping("hello-string")
    // 반환 Body(http protocol)에 값을 넣어서 반환
    @ResponseBody
    public String helloString(@RequestParam("name") String name, Model model) {
        // 해당 문자 그대로 반환(큰 의미 없는 반환)
        return "hello" + name;
    }

    // api 반환 추가
    @GetMapping("hello-api")
    // 객체를 반환하면 json 으로 반환되게 기본 셋팅(xml 로 반환될 경우 셋팅 변경 필요)
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name, Model model) {
        Hello hello = new Hello();
        hello.setName(name);
        // 객체를 만들고 json 형식으로 반환
        return hello;
    }

    // api 반환 클래스 선언
    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
