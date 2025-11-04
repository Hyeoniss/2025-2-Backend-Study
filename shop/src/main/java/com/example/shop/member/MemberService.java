package com.example.shop.member;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.shop.member.dto.MemberUpdateRequest;
import com.example.shop.member.dto.MemberCreateRequest;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor

public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Long createMember(MemberCreateRequest request) {
        Member existingMember = memberRepository.findById(request.getLoginId());

        if (existingMember != null) {
            throw new RuntimeException("이미 존재하는 로그인 아이디입니다" + request.getLoginId());
        }

        Member member = new Member(
                request.getLoginId(),
                request.getPassword(),
                request.getPhoneNumber(),
                request.getAddress()
        );

    memberRepository.save(member);

    return member.getId();
    }

    @Transactional
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Transactional
    public Member getMemberById(String id) {
        Member member = memberRepository.findById(id);

        if (member == null) {
            throw new RuntimeException("회원을 찾을 수 없음");
        }

        return member;
    }

    @Transactional
    public void updateMember(String id, MemberUpdateRequest request) {
        Member member = memberRepository.findById(id);

        if (member == null) {
            throw new RuntimeException("회원을 찾을 수 없음");
        }

        member.updateInfo(request.getPassword(), request.getPhoneNumber(), request.getAddress());
    }

    @Transactional
    public void deleteMember(String id) {
        Member member = memberRepository.findById(id);

        if (member == null) {
            throw new RuntimeException("회원을 찾을 수 없음");
        }

        memberRepository.deleteById(id);

    }
}
