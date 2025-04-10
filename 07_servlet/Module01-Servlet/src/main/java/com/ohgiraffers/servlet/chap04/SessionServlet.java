package com.ohgiraffers.servlet.chap04;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/*
* 세션(HttpSession)
* -세션은 서버 측에서 클라이언트(사용자)의 상태를 유지하기 위한 객체로, http의 setateless특성을 보완한다
* -"httpSession" 인터페이스를 통해 제공되며, 각 클라이언트 마다 고유한 세션 ID (예 : Jsessionid)를 생성해 관리한다.
*
* -주요 역할 :
*   - 사용자별 데이터를 서버 메모리나 설정에 따라 DB에 저장
*   - 쿠키(기본적으로 "JsesstionId")를 통해 세션 ID를 클라이언트와 주고 받음
*
* -동작 :
* 1.req.getsession(true) : 세션이 없으면 새로 생성하고, 있으면 기존 세션 반환
* 2.req.getSessing(false) : 기존 세션이 있으면 반환, 없으면 null
* 3.setAttribute(String nema, Object value)로 데이터 저장 getAttribute(String name)
* 4.setMaxInactiveInterval(int seconds)로 세션 유효 시간을 설정
*
* -특징 :
*   - 데이터는 서버에 저장되어 쿠키보다 보안성이 높음
*   - 브라우저 종료시 기본적으로 만료되지만, 유효 시간을 명시적으로 설정 가능
*   - 세션은 클라이언트가 아닌 서버 자원을 사용하기 떄문에 과도한 사용시 메모리 부담 발생 가능
* */

@WebServlet("/session")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");

        HttpSession session = req.getSession(false);//false면 없는대로 고
        String loggInUser = null;
        String secret = null;

        if (session != null) { //세션 저장소가 열려있다면
            loggInUser = (String) session.getAttribute("loggInUser");
            secret = (String) session.getAttribute("secret"); //세션에 있는  secret값
        }
        req.setAttribute("loggInUser", loggInUser != null ? loggInUser : "로그인 안됨"); //null이 아니라면 : null이라면
        req.setAttribute("secret", secret != null && loggInUser != null ? secret : "비밀 없음");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/chap04/session-result.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        String username = req.getParameter("username");
        String secret = req.getParameter("secret");

        if(username != null || secret != null) {
            HttpSession session = req.getSession(true);
            String existingUser = (String) session.getAttribute("loggInUser");

            if(existingUser == null || existingUser.equals(username)) {
                session.setAttribute("loggInUser", username); //이 코드 삭제시 -> 로그인 되어있는 상황에서 secret 값만 변경 가능
                if(secret != null && !secret.isEmpty()) {
                    session.setAttribute("secret", secret);
                }
                session.setMaxInactiveInterval(30);
            }else{
                session.setAttribute("loggInUser", username);
                if(secret != null && !secret.isEmpty()) {
                    session.setAttribute("secret", secret);
                }
                session.setMaxInactiveInterval(30);
            }
        }
        doGet(req, resp);
    }
}
