package com.ohgiraffers.aop.section01;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MemberService {

    private Map<String, Member> memberRepository = new HashMap<String, Member>(); //map :키, 밸류 -> 키는 중복x

    public void registerMember(Member member) {
        //성능 측정 --> 횡단(공통) 관심사
        long startTime = System.currentTimeMillis();

        try{
            //로그
            System.out.println("[로그] 회원가입 시작 : "+member.getEmail());

            //트랜잭션 처리 해야됨
            System.out.println("====트랜잭션 시작====");
            if(member.getEmail() == null || member.getEmail().isEmpty()){
                throw new IllegalArgumentException("이메일은 필수입니다.");
            }

            if(member.getPassword() == null || member.getPassword().isEmpty()){
                throw new IllegalArgumentException("비밀번호는 필수입니다.");
            }

            if(member.getPassword().length() < 8){
                throw new IllegalArgumentException("비밀번호는 8글자 이상이어야합니다.");
            }

            if(memberRepository.containsKey(member.getEmail())){
                throw new IllegalArgumentException("이미 등록된 이메일입니다." + member.getEmail());
            }

            memberRepository.put(member.getEmail(), member);
            //비즈니스 로직 종료

            //로그
            System.out.println("회원 저장 완료: " + member.getEmail());
            //커밋 처리 해야됨
            System.out.println("====트랜잭션 커밋====");
        }catch(Exception e){
            //롤백 처리 해야됨
            System.out.println("[로그] - 오류 발생");
            System.out.println("====트랜잭션 롤백====");
            throw new RuntimeException(e);
        }finally{
            long endTime = System.currentTimeMillis();
            //성능 측정
            System.out.println("[성능] 회원가입 처리 시간 : " + (endTime - startTime) + "ms");
        }
    }

    public Member getMember(String email) {
        long startTime = System.currentTimeMillis();

        try{
            System.out.println("[로그] 회원 조회 시작 : "+email);

            if(email == null || email.isEmpty()){
                throw new IllegalArgumentException("이메일을 입력해주세요.");
            }
            Member member = memberRepository.get(email);
            if(member == null){
                throw new IllegalArgumentException("존재하지 않는 회원입니다. "+email);
            }
            System.out.println("[로그] 회운 조회 성공"+member.getEmail());

            return member;
        } catch (Exception e) {
            System.out.println("[로그] 회원 조회 실패 : "+email);
            throw new RuntimeException(e);
        }finally{
            long endTime = System.currentTimeMillis();
            System.out.println("[성능] 회원 조회 처리시간 : " + (endTime - startTime) + "ms");
        }
    }

    public void updatePassword(String email, String currentPassword, String newPassword) {
        //성능측정
        long startTime = System.currentTimeMillis();

        try{
            //로그
            System.out.println("[로그] 비밀번호 변경 시작 : "+email);
            //트랜잭션 시작
            System.out.println("트랜잭션 스타트");
            if(email == null || email.isEmpty()){
                throw new IllegalArgumentException("이메일은 필수입니다.");
            }

            if(currentPassword == null || currentPassword.isEmpty()){
                throw new IllegalArgumentException("비밀번호는 필수입니다.");
            }

            if(newPassword == null || newPassword.isEmpty()){
                throw new IllegalArgumentException("비밀번호는 필수입니다.");
            }

            if(newPassword.length() < 8){
                throw new IllegalArgumentException("비밀번호는 8글자 이상이어야 합니다.");
            }

            Member member = memberRepository.get(email);

            if(member == null){
                throw new IllegalArgumentException("존재하지 않는 회원입니다. "+email);
            }

            if(!member.getPassword().equals(currentPassword)){
                throw new IllegalArgumentException("현재 비밀번호와 일치하지 않습니다");
            }

            member.setPassword(newPassword);
            memberRepository.put(email, member);
            //비즈니스 로직 종료


            //트랜잭션
            System.out.println("[트랜잭션 커밋]");
        } catch (Exception e) {
            //롤백
            System.out.println("[트랜잭션] 롤백");
            //로그
            System.out.println("[로그] 비밀번호 변경 실패");
            throw new RuntimeException(e);
        }finally{
            //성능측정
            long endTime = System.currentTimeMillis();
            System.out.println("[성능] "+ (endTime - startTime)+"ms");
        }
    }

    public void deleteMember(String email) {
        long startTime = System.currentTimeMillis();

        try{
            //로깅
            System.out.println("[로그] 회원탈퇴 시작 "+email);
            //트랜젝션
            System.out.println("[트랜잭션] 시작");

            if(email == null || email.isEmpty()){
                throw new IllegalArgumentException("이메일을 입력해주세요");
            }
            if(!memberRepository.containsKey(email)){
                throw new IllegalArgumentException("존재하지 않는 회원입니다.");
            }

            //회원삭제
            memberRepository.remove(email);

            //트랜젝션
            System.out.println("[트랜젝션] 커밋");
        }catch(Exception e){
            //로깅
            System.out.println("[로그] 회원가입 실패 "+email);

            //트랜젝션
            System.out.println("[트랜젝션] 롤백");
        }finally{
            long endTime = System.currentTimeMillis();
            //성능 측정
            System.out.println("[성능] "+ (endTime - startTime)+"ms");
        }
    }


}
