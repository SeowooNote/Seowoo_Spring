# Seowoo_Spring
Spring boot (Java, Postman) 관련 공부 자료입니다.

## Controller
### @RestController
- JSON 형태의 Response body를 반환하기 위한 Controller임을 명시하는 어노테이션
-  REST API 개발을 위해 일반적으로 사용되는 어노테이션이며 Response의 ContentType으로 HTML을 반환하지 않음
- #### @Controller + @ResponseBody의 형태
     - #### @Controller
          - HTML 형태의 Response body를 반환하기 위한 Controller임을 명시하는 어노테이션이며 Response의 ContentType으로 HTML 이외의 타입을 반환하지 않음
     - #### @ResponseBody
          - HTTP Response의 Body를 직접 작성하기 위해 사용되는 어노테이션이며 기본적으로 JSON 타입을 반환
### @RequestMapping
- HTTP 요청과 컨트롤러 클래스 혹은 메서드를 매핑하기 위해 사용되는 어노테이션이다. 어떤 URL 패턴이 어떤 클래스 혹은 메서드에 매핑될지 지정

## Request Method
### @GetMapping()
- RequestMapping 기능을 GET Method에 한정시켜 안정성과 가독성을 높이기 위한 어노테이션
### @PostMapping()
- RequestMapping 기능을 POST Method에 한정시켜 안정성과 가독성을 높이기 위한 어노테이션
### @PatchMapping()
- RequestMapping 기능을 PATCH Method에 한정시켜 안정성과 가독성을 높이기 위한 어노테이션
### @DeleteMapping()
- RequestMapping 기능을 DELETE Method에 한정시켜 안정성과 가독성을 높이기 위한 어노테이션

## Request Data (Parameter)
### @PathVariable()
- Get, Delete Method에서 요청시 데이터를 전송받는 방식, path 자체를 데이터로 받아오는 방법
- REST API의 GET, DELETE 요청에서 데이터를 전송할 때 많이 사용되는 방식
### @RequestParam
- Get, Delete Method에서 요청시 데이터를 전송받는 방식, path에 데이터를 추가하여 받아오는 방법
- REST API 형식 보다는 정적 웹 서버에 HTML 요청시 데이터를 전송하고자 할때 많이 사용
### @RequestBody
- Post, Put, Patch Method에서 요청시 데이터를 전송받는 방식, Request Body 데이터를 포함하여 전송하는데 이때는 JSON 형태의 데이터 포멧을 이용해 객체로 데이터를 받거나 문자열로 데이터를 받을 수 있음
- Controller에서 전송한 데이터를 받기 위해서는 객체 혹은 문자열로 받아야 함
## Response 처리
### ResponseEntity
- Response 의 상태 및 헤더, 본문(body)을 직접 제어할 수 있는 클래스
## DTO
Data Transfer Object로 일반 적인 소프트웨어 개발에서 데이터를 서로 다른 레이어 간의 데이터를 전송하기 위해 사용되는 객체
### Lombok
- Getter, Setter, Constructor, equals/hashCode, toString 등 클래스에서 자주 사용되지만 반복적으로 생성되는 메서드를 간편하게 생성해주는 라이브러리
- ex. @Getter, @Setter ...
### Validator
- 스프링 프레임워크에서 제공해 주는 유효성 검증 관련 인터페이스
- 클라이언트로부터 전달 받은 데이터를 데이터타입, 길이, 형태를 검증하여 오류가 있는 경우 오류 메세지를 반환
- ex. @NotNull, @NotEmpty, @NotBlank, @Max, @Min, @Size, ...
## CORS
Cross-Origin Resource Sharing의 약어로, 웹 브라우저에서 실행되는 스크립트가 다른 출처의 리소스에 접근하는 것을 제어하는 보안 메커니즘