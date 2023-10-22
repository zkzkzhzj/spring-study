package com.zkzkzhzj.study.repository;

import com.zkzkzhzj.study.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemoryMemberRepositoryTest {

    MemberRepository repository = new MemoryMemberRepository();

    // 테스트를 수행할 때 마다 수행되는 콜백 메소드
    @AfterEach
    void afterEach() {
        repository.clearStore();
    }

    @Test
    void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        // 단순 출력 비교
        System.out.println("result = " + (result == member));
        // JUnit 에서 제공되는 비교 클래스, 일치하지 않을경우 테스트 케이스 통과 못함
        org.junit.jupiter.api.Assertions.assertEquals(member, result);
        // 최근에 자주 사용되는 비교(상단 클래스를 더 편하게 사용)
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName(member1.getName()).get();
        Assertions.assertThat(member1).isEqualTo(result);
    }

    @Test
    void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        Assertions.assertThat(result).hasSize(2);
    }
}