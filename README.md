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

|어노테이션 @|기능 설명|예|
|---|---|---|
|@NotNull|null 인지 검증|@NotNull Integer no;|
|@NotEmpty|문자열이 null 혹은 빈문자열인지 검증|@NotEmpty String name;|
|@NotBlank|문자열이 null, 빈문자열, 공백인지 검증|@NotBlank String  name;|
|@Max|최대치 지정|@Max(100) Integer price;|
|@Size|문자열이나 컬렉션이 지정한 사이즈 이하인지 검증|@Size(min=0, max=10) List<Integer> selected;|
|@AssertTrue|값이 true 인지 검증|@AssertTrue  Boolean  empty;|
|@AssertFalse|값이 false 인지 검증|@AssertFalse Boolean empty;|
|@Pattern|지정한 정규 표현과 일치하는지 검증|@Pattern(regexp=”[a-zA-Z0-9]”) String id;|
|@Range|지정한 숫자 내에 있는지 검증|@Range(min=1, max=10) Integer point;|
|@DecimalMax|최대치 지정 (실수형)|@DecimalMax(”100.0”) BigDecimal val;|
|@DecimalMin|최소치 지정 (실수형)|@DecimalMin(”10.0”) BigDecimal val;|
|@Digits|정수부와 실수부 자리수 검증|@Digits(integer=3, fraction=1) BigDecimal  val;|
|@Future|미래 날짜인지 검증|@Future Date date|
|@Past|과거 날짜인지 검증|@Past Date date|
|@Length|지정한 문자열의 길이 내에 있는지 검증|@Length(min =0, max=10) String name|
|@Email|이메일 주소 형식인지 검증|@Email String email;|
|@CreditCardNumber|신용카드 번호 형식인지 검증|@CreditiCarNumber String card;|
|@URL|URL 형식인지 검증|@URL String url;|
|@Valid|중첩 Form을 검증|@Valid SampleForm  sampleForm|

## CORS
Cross-Origin Resource Sharing의 약어로, 웹 브라우저에서 실행되는 스크립트가 다른 출처의 리소스에 접근하는 것을 제어하는 보안 메커니즘

## 요약해라
데이터베이스 연결하기
ORM : 객체 관계 매핑 - 객체와 RDBMS의 테이블을 자동으로 매핑
         (클래스는 데이터베이스의 테이블과 매핑하기 위해 만들어진 것이 아니기 때문에 RDBMS의 테이블과 불일치가 발생 - ORM 은 이러한 불일치와 제약상황을 해결)
JPA : ORM 라이브러리 / 표준 인터페이스
	Hibernate : Java 객체와 데이터베이스 간의 매핑을 처리하는 JPA 구현체
	Persistence : 지속성, 데이터를 영구적으로 저장, 애플리케이션의 실행이 종료된 후에도 사용 가능한 상태로 유지
	
	(build.gradle 파일 내부 dependencies 내에 작성)
	JPA gradle 의존성 주입
		implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	MySQL Connector gradle 의존성 주입
		runtimeOnly 'com.mysql:mysql-connector-j'

	Entity : JPA를 사용하고자 할떄 데이터베이스 테이블과 매핑되는 Java객체
		@Entity : Java 클래스를 JPA Entity로 표시하여 해당 클래스를 데이터베이스의 테이블과 매핑
		@Table : JPA Entity 클래스와 데이터베이스 테이블간의 매핑을 설정하거나 수정할 때 사용
		@Id : JPA Entity 클래스에서 Primary Key에 해당하는 필드를 표시하는 데 사용 / Entity 클래스에 필수로 하나 이상 포함
		@GeneratedValue : Entity 클래스의 Primary Key에 대한 데이터 생성 전략을 지정하는 데 사용 / 주로 @Id 어노테이션이 지정된 필드와 함께 사용되며, 엔터티가 데이터베이스에 저장될 때 자동으로 생성되는 고유한 값을 설정하는 데 도움
			GenerationType의 주요 전략
				GenerationType.AUTO
				GenerationType.IDENTITY
				GenerationType.SEQUENCE
				GenerationType.TABLE
		@Column

	Repository : 비즈니스 로직에서 데이터베이스에 접근하여 데이터베이스 작업을 담당하고, 결과를 Service 계층에 반환 / 인터페이스
		@Repository