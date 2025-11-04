package com.example.shop.member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Repository
 * 현재 구현: 메모리 저장소 (Map 사용)
 */
@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Member> findAll(){
        return em.createQuery("SELECT m FROM Member m", Member.class)
                .getResultList();
    }

    public Member findById(String loginId){
        List<Member> result = em.createQuery(
                "SELECT t FROM Member t WHERE t.loginId = :loginId", Member.class)
                .setParameter("loginId", loginId).getResultList();

        return result.isEmpty() ? null : result.get(0);
        //empty면 null, 아니면 리스트 첫번째 반환
    }

    public void save(Member member){
        em.persist(member);
    }

    public void deleteById(String id){
        Member member = em.find(Member.class, id);
        em.remove(member);
    }
}

