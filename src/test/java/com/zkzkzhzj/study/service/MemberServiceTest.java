package com.zkzkzhzj.study.service;

import com.zkzkzhzj.study.domain.Member;
import com.zkzkzhzj.study.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

// shift + command + t 자동 생성
class MemberServiceTest {

    MemberService memberService;

    // 디비 값을 초기화 하기 위해 레포지토리를 가져온다
    MemoryMemberRepository memberRepository;

    // di - 의존성 주입
    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void join() {
        // 3가지 단계로 구분지어 테스트 코드 작성(주석으로 인하여 빠른 구분 가능)

        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        // option + command + v 할당 변수 빠르게 만들기
        Member findMemeber = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMemeber.getName());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        // 예외가 발생해야 옳바른 동작임을 체크
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        // 예외가 발생해야 옳바른 동작 테스트
        /*
        try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
        */

        //then

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}