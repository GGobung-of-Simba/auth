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

import java.util.Map;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @PostMapping("/signIn")
    public String signIn(@ModelAttribute HomeReqDTO homeReqDTO) {

        System.out.println(homeReqDTO);
        System.out.println(getToken(homeReqDTO));
        Map<String, String> resultMap = getToken(homeReqDTO);
        System.out.println(resultMap);
        System.out.println(resultMap.get("access_token"));

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