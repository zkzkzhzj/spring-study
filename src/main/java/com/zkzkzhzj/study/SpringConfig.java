package com.zkzkzhzj.study;

import com.zkzkzhzj.study.repository.MemberRepository;
import com.zkzkzhzj.study.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

// 직접 스프링 빈을 등록 하기
@Configuration
public class SpringConfig {
    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 스프링 빈에 등록 되어 멤버 서비스에 등록
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }
}
