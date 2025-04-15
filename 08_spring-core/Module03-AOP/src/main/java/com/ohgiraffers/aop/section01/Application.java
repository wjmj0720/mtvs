package com.ohgiraffers.aop.section01;

public class Application {
    public static void main(String[] args) {
        System.out.println("AOP를 적용하지 않았을 때 문제 확인");

        MemberService memberService = new MemberService();

        try{
            System.out.println("회원가입 테스트 하기");
            Member member = new Member("홍길동","ㅁㅇ1213314","www@naver.com","010-0000-0000","user");
            memberService.registerMember(member);

            System.out.println("회원 조회 테스트");
            Member findMember = memberService.getMember(member.getEmail());
            System.out.println(findMember);

        } catch (Exception e) {
            System.out.println("오류가 발생됨");
        }
    }
}
