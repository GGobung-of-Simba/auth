package com.java.appserver.home;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClient;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Map;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @PostMapping("/signIn")
    public String signIn(@ModelAttribute HomeReqDTO homeReqDTO, HttpServletResponse res) {

        Map<String, String> resultMap = getToken(homeReqDTO);

        System.out.println(homeReqDTO);
        System.out.println(getToken(homeReqDTO));
        System.out.println(resultMap);
        System.out.println(resultMap.get("access_token"));

        Cookie jwtCoo = new Cookie("jwtCookie", resultMap.get("access_token"));
        // HttpOnly 설정: 클라이언트 측 JavaScript에서 쿠키를 접근할 수 없도록 보호 (XSS 공격 방지)
        jwtCoo.setHttpOnly(true);
        
        // Path 설정: "/" 경로 이하의 모든 요청에서 해당 쿠키를 포함하도록 설정
        jwtCoo.setPath("/");
        
        // MaxAge 설정: 쿠키의 유효기간을 300초
        jwtCoo.setMaxAge(300);
        
        // 생성한 쿠키를 HTTP 응답에 추가 (클라이언트에 쿠키가 전달됨)
        res.addCookie(jwtCoo);

        return "redirect:/?ok";
    }

    private Map<String, String> getToken(HomeReqDTO homeReqDTO){
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("grant_type","client_credentials");
        formData.add("client_id",homeReqDTO.getId());
        formData.add("client_secret",homeReqDTO.getPwd());

        return RestClient.create().post()
                .uri("http://localhost:9000/oauth2/token")
                .header("Content-Type","application/x-www-form-urlencoded")
                .body(formData)
                .retrieve()
                .toEntity(Map.class)
                .getBody();
    }
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class HomeReqDTO {

    private String id;
    private String pwd;
//    롬복 없이 할 줄 알아보자
}