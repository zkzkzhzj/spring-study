package com.zkzkzhzj.study;

import com.zkzkzhzj.study.repository.MemberRepository;
import com.zkzkzhzj.study.repository.MemoryMemberRepository;
import com.zkzkzhzj.study.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 직접 스프링 빈을 등록 하기
@Configuration
public class SpringConfig {

    // 스프링 빈에 등록 되어 멤버 서비스에 등록
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
