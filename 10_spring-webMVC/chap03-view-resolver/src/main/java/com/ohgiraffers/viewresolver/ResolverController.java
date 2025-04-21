package com.ohgiraffers.viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/*")
public class ResolverController {

    @GetMapping("string")
    public String stringReturning(Model model){ //매개변수 Model model => 컨트롤러에서 뷰(예: Thymeleaf 템플릿)로 데이터를 전달하기 위해 사용(추가)
        model.addAttribute("forwardMessage", "문자열로 뷰 이름을 반환함"); //Model 객체에 키-값 쌍 형태로 데이터를 추가 (추가)
        /*
         * 문자열(반환타입이 String)로 뷰 이름을 반환한다는 것은 반환후
         * ThyleafViewResolver에게 resources/templates를 prefix로 .html을 suffix로 하여
         * resources.template/result.html 파일을 응답뷰로 설정하라는 의미가 된다
         * ++ ViewResolver가 해석하여 실제 뷰 파일(HTML 템플릿)을 찾음
         * 키: "forwardMessage" (뷰에서 참조할 이름).
         * 문자열로 뷰 이름을 반환함" (뷰에 표시될 실제 데이터).
         * */
        return "result"; //뷰 이름 -> ThymeleafViewResolver를 사용해 이를 resources/templates/result.html로 해석 -> 뷰 템플릿에서 ${forwardMessage}로 참조
    } // 뷰 리졸브와 타임리프에 관해서는 main.html 참조

    @GetMapping("string-redirect")
    public String stringRedirect(Model model){ //리다이렉트는 보통 get 유발, 조회할 때 많이 사용 (POST는 폼에 데이터를 담아서 서버로 보낼 때 주로사용)
        // 단순 리다이렉트 동작 테스트로, URL 접근 가능한 GET 적합.

        model.addAttribute("test","테스트를 위한 값입니다.");
        //접두사로 redirect: 를 하게되면 forward가 아닌 redirect 시키게 된다 , 로그인을 했는데 비밀번호 오류 : 로그인 다시 해줘 요청할 때 리다이렉트 쓰기도함
        //redirect : 요청에 대한 응답 처리에서 요청 정보를 잃어버리고 다시 요청
        return "redirect:/"; //역할: redirect: 접두사를 사용해 클라이언트를 지정된 URL(/, 루트 경로)로 리다이렉트.(추가)
    }
    @GetMapping("string-redirect-attr")
    public String stringRedirectFlashAttribute(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("flashMessage1","리다이렉트를 사용 redirect");
        //임시저장소에 요청 데이터 저장 (다음 요청시 까지만)

        return "redirect:/";
    }

    @GetMapping("modeladnview")
    public ModelAndView modeladnview(ModelAndView mv){

        mv.addObject("forwardMessage","modelAndView를 사용한 모델과 뷰 반환"); //데이터
        mv.setViewName("result"); //view 페이지에 이동될 경로 , 뷰 이름
        return mv; //뷰 이름 + 데이터를 명시적으로 묶어서 관리(추가)
    }

    @GetMapping("modelandview-redirect")
    public ModelAndView modelAndViewRedirect(ModelAndView mv){
        mv.setViewName("redirect:/");
        return mv;
    }

    @GetMapping("modelandview-redirect-attr")
    public ModelAndView modelAndViewRedirect(ModelAndView mv, RedirectAttributes rttr){

        rttr.addFlashAttribute("flashMessage2","modelAndView르 ㄹ활용한 redirect attr");
        return mv;
    }

}
