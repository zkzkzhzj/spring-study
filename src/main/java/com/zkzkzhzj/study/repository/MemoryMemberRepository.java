package com.zkzkzhzj.study.repository;

import com.zkzkzhzj.study.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    // 실무에서는 동시성 문제가 있어 concurrent 를 사용해야 한다
    private static Map<Long, Member> store = new HashMap<>();
    // 시퀀스 또한 AtomicLong 을 사용해야 한다 ttt
    private static Long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        // store -> 값들을 루프를 돌려서 동일한 name 값을 찾아서 반환 해준다.
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void clearStore() {
        store.clear();
    }
}
