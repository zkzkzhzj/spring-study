package com.zkzkzhzj.study;

import com.zkzkzhzj.study.aop.TimeTraceAop;
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

    @Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }

    // 해당 부분의 연결만 바꿔주면은 기존 코드의 변경없이 memory -> jdbc 로 깔끔하게 변경(객체 지향의 장점)
//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
}
