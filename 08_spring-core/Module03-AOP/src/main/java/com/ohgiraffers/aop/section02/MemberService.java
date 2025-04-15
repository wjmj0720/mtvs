package com.ohgiraffers.aop.section02;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MemberService {

    private Map<String, Member> memberRepository = new HashMap<String, Member>(); //map :키, 밸류 -> 키는 중복x

    public void registerMember(Member member) {
        {


            if (member.getEmail() == null || member.getEmail().isEmpty()) {
                throw new IllegalArgumentException("이메일은 필수입니다.");
            }

            if (member.getPassword() == null || member.getPassword().isEmpty()) {
                throw new IllegalArgumentException("비밀번호는 필수입니다.");
            }

            if (member.getPassword().length() < 8) {
                throw new IllegalArgumentException("비밀번호는 8글자 이상이어야합니다.");
            }

            if (memberRepository.containsKey(member.getEmail())) {
                throw new IllegalArgumentException("이미 등록된 이메일입니다." + member.getEmail());
            }

            memberRepository.put(member.getEmail(), member);
            //비즈니스 로직 종료


        }
    }

    public Member getMember(String email) {
        long startTime = System.currentTimeMillis();

        try {
            //  System.out.println("[로그] 회원 조회 시작 : "+email);

            if (email == null || email.isEmpty()) {
                throw new IllegalArgumentException("이메일을 입력해주세요.");
            }
            Member member = memberRepository.get(email);
            if (member == null) {
                throw new IllegalArgumentException("존재하지 않는 회원입니다. " + email);
            }
            // System.out.println("[로그] 회운 조회 성공"+member.getEmail());

            return member;
        } catch (Exception e) {
            // System.out.println("[로그] 회원 조회 실패 : "+email);
            throw new RuntimeException(e);
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.println("[성능] 회원 조회 처리시간 : " + (endTime - startTime) + "ms");
        }
    }

    public void updatePassword(String email, String currentPassword, String newPassword) {


        {
            if (email == null || email.isEmpty()) {
                throw new IllegalArgumentException("이메일은 필수입니다.");
            }

            if (currentPassword == null || currentPassword.isEmpty()) {
                throw new IllegalArgumentException("비밀번호는 필수입니다.");
            }

            if (newPassword == null || newPassword.isEmpty()) {
                throw new IllegalArgumentException("비밀번호는 필수입니다.");
            }

            if (newPassword.length() < 8) {
                throw new IllegalArgumentException("비밀번호는 8글자 이상이어야 합니다.");
            }

            Member member = memberRepository.get(email);

            if (member == null) {
                throw new IllegalArgumentException("존재하지 않는 회원입니다. " + email);
            }

            if (!member.getPassword().equals(currentPassword)) {
                throw new IllegalArgumentException("현재 비밀번호와 일치하지 않습니다");
            }

            member.setPassword(newPassword);
            memberRepository.put(email, member);
            //비즈니스 로직 종료


        }
    }

    public void deleteMember(String email) {
        long startTime = System.currentTimeMillis();

        {

            if (email == null || email.isEmpty()) {
                throw new IllegalArgumentException("이메일을 입력해주세요");
            }
            if (!memberRepository.containsKey(email)) {
                throw new IllegalArgumentException("존재하지 않는 회원입니다.");
            }

            //회원삭제
            memberRepository.remove(email);


        }


    }
}
