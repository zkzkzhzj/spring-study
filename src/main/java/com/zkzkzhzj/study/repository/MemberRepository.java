package com.zkzkzhzj.study.repository;

import com.zkzkzhzj.study.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    // java8 : null 일 수 있는 객체를 Optional 로 반환해서 null 체크 처리
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
