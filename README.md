# SOAP API 만들기

[Producing a SOAP web service](https://spring.io/guides/gs/producing-web-service) 를 참고하여 재작성한 Spring Boot 기반의 단순한 SOAP API 예제 프로젝트입니다.  
XSD(`src/main/resources/META-INF/schemas/user.xsd`)로부터 JAXB 클래스를 생성하고, Spring Web Services로 SOAP 엔드포인트를 제공합니다.

## 기술 스택

- Java 17
- Spring Boot 4.0.0
- Spring Web Services (`spring-boot-starter-webservices`)
- JAXB 코드 생성 (jaxb2-maven-plugin 4.0.0)
- (옵션) WSDL4J (`wsdl4j`)

## 프로젝트 구조

```
root
├─ src/main/java/com/example/soap
│ ├─ SoapDemoApplication.java
│ ├─ UserEndpoint.java
│ ├─ UserRepository.java
│ └─ WebServiceConfig.java
├─ src/main/resources
│ ├─ META-INF/schemas/user.xsd
│ └─ application.properties
├─ request.xml
└─ pom.xml
```
