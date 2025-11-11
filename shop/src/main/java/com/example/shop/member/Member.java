package com.example.shop.member;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "members")
public class Member {

    // 회원 고유 식별자
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private Long id;

    // 회원 아이디
    @Column(name="member_login_id", length=50)
    private String loginId;

    // 비밀번호
    @Column(name="member_pw", length=100)
    private String password;

    // 전화번호
    @Column(name="member_phone", length=20)
    private String phoneNumber;

    // 주소
    @Column(name="member_address", length=255)
    private String address;

    // 적립금
    @Column(name="member_point")
    private int point;

    public Member(String loginId, String password, String phoneNumber, String address) {
        this.loginId = loginId;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.point = 0;
    }

    //회원정보 수정 - 아이디는 불가
    public void updateInfo(String password, String phoneNumber, String address) {
        if(password != null) {
            this.password = password;
        }

        if(phoneNumber != null) {
            this.phoneNumber = phoneNumber;
        }

        if(address != null) {
            this.address = address;
        }
    }
}
