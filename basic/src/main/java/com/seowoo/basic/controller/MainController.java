package com.seowoo.basic.controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import com.seowoo.basic.dto.request.PostRequestBodyDto;
import com.seowoo.basic.provider.JwtProvider;
import com.seowoo.basic.service.MainService;

import lombok.RequiredArgsConstructor;

// description : Controller - 레이어드 아키텍처 상의 프레젠테이션 영역 //
// description : 사용자로부터 입력을 받고 서비스 결과를 반환하는 영역 //

// description : REST API 형식의 Response 를 반환하는 Controller 임을 명시 //
// description : REST API 형식의 Response - Response 타입이 JSON 형태인 Response //
@RestController

// description : @RequestMapping - Request 의 URL 패턴에 따라 클래스 및 메소드를 결정하는 어노테이션 //
// description : 예) http://localhost:8080 //
@RequestMapping("")
@RequiredArgsConstructor
public class MainController {

     // description : Spring Bean 으로 등록된 인스턴스를 IoC 로 DI 하기 위해서는 //
     // description : @Autowired 를 이용한 필드객체로 DI, 생성자로 DI, setter 로 DI 방식을 사용해야함 //
     // description : Spring 공식 문서에서는 생성자를 이용한 의존성 주입을 권장 //
     // description : 생성자를 통한 의존성 주입은 @Autowired 를 지정할 필요가 없음 //
     // description : 멤버변수를 필수 변수(final)로 지정하여 lombok 의 @RequiredArgsConstructor 로 쉽게 DI 할 수 있음 //
     private final MainService mainService;

     private final JwtProvider jwtProvider;

     // description : @RequestMapping 중 Get method 에 대해서만 인식 //
     @GetMapping("/")
     public String getMethod() {
          return mainService.hello();
     }

     // description : @RequestMapping 중 Post method 에 대해서만 인식 //
     @PostMapping("/")
     public String postMethod() {
          return "post method";
     }

     // description : @RequestMapping 중 Patch method 에 대해서만 인식 //
     @PatchMapping("/")
     public String patchMethod() {
          return "patch method";
     }

     // description : @RequestMapping 중 Put method 에 대해서만 인식 //
     @PutMapping("/")
     public String putMethod() {
          return "put method";
     }

     // description : @RequestMapping 중 Delete method 에 대해서만 인식 //
     @DeleteMapping("/")
     public String deleteMethod() {
          return "delete method";
     }

     // description : @PathVariable - Path 자체를 변수의 값으로 인식 //
     // description : {variable} 로 표현 -> @PathVariable("variable") //
     @GetMapping("/path-variable/{value}")
     public String getPathVariable(@PathVariable("value") String value) {
          return "입력한 Path Variable은 " + value + " 입니다.";
     }

     // description : @RequestParam - Query Parameter 로 key 와 value 를 받아옴 //
     // description : 요청시 ?name1=value1&name2=value2... //
     // description : @RequestParam("name1") //
     @GetMapping("/parameter")
     public String getParameter(
          @RequestParam("name") String name,
          @RequestParam("age") int age
     ) {
          return "이름: " + name + " 나이: " + age;
     }

     // description : @RequestBody - Request Body 에 포함된 데이터를 받아옴, 문자열 혹은 객체로 받을 수 있음 //
     // description : 요청시 일반적으로 JSON 형태로 Request Body 를 전송 //
     // description : @RequestBody //
     @PostMapping("/request-body")
     public String postRequestBody(
          // @RequestBody String requestBody
          @RequestBody @Valid PostRequestBodyDto requestBody
     ) {
          return "입력한 Request Body 는 " + requestBody.getName() + " 입니다.";
     }

     // description : Response Entity - Response 의 상태 및 헤더, 본문(body)을 직접 제어할 수 있는 클래스 //
     @GetMapping("/response-entity")
     public ResponseEntity<String> getResponseEntity() {
          return ResponseEntity.status(HttpStatus.FORBIDDEN).body("response Entity");
     }

     @GetMapping("/jwt/{sub}")
     public String getJwt(
       @PathVariable("sub") String sub
     ) {
       String jwt = jwtProvider.create(sub);
       return jwt;
     }
   
     @PostMapping("/jwt")
     public String validateJwt(
       @RequestParam("jwt") String jwt
     ) {
       String subject = jwtProvider.validate(jwt);
       return subject;
     }

     @PostMapping("/principle")
     public String principle (
          @AuthenticationPrincipal String subject
     ) {
          return "토큰에 포함된 subject는 " + subject + "입니다.";
     }

}
