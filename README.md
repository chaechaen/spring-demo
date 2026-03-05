# 📝 Todo List - Spring Boot 웹 애플리케이션

> Thymeleaf 기반 서버 사이드 렌더링(SSR) Todo 관리 애플리케이션

## 📌 프로젝트 소개

할 일(Todo)을 카테고리별로 관리할 수 있는 웹 애플리케이션입니다.  
Controller -> Service -> DAO 순으로 이어지는 동작 흐름을 로그로 확인할 수 있습니다.

## 📁 프로젝트 구조

```
src/main/
├── java/com/example/demo/
│   ├── DemoApplication.java          # 애플리케이션 진입점
│   ├── controller/
│   │   ├── TodoController.java       # Todo CRUD 컨트롤러 (SSR)
│   │   └── JsonController.java       # REST API 컨트롤러 (JSON)
│   ├── service/
│   │   └── TodoService.java          # 비즈니스 로직
│   ├── dao/
│   │   └── TodoDAO.java              # 데이터 액세스 (인메모리)
│   └── model/
│       └── Todo.java                 # Todo 도메인 모델
└── resources/
    ├── application.properties        # 애플리케이션 설정
    ├── templates/
    │   ├── index.html                # 메인 페이지 (Todo 목록)
    │   └── todo-list.html            # Todo 리스트 템플릿
    └── static/css/
        └── style.css                 # 스타일시트
```

## ✨ 주요 기능

### 📋 Todo 목록 조회
- `GET /` — 전체 할 일 목록을 카드 형태로 표시
- 카테고리별 색상 구분 (Study, Project, Career, Health)
- 마감일 기준 **임박**(7일 이내) / **초과** 상태 표시

### ➕ Todo 추가
- `POST /add` — 모달 폼을 통한 새 할 일 등록
- 입력 항목: 카테고리, 제목, 내용, 마감일

### 📊 통계 대시보드
- 전체 할 일 수
- 카테고리 수
- 마감 임박 항목 수

### 🔗 REST API
- `GET /json` — Todo 객체를 JSON 형식으로 반환

## 🚀 실행 방법

### 사전 요구사항
- **Java 17** 이상
- **MySQL** (선택 — 현재 인메모리 데이터 사용)

## 🏗 아키텍처

```
Client Request
    ↓
┌─────────────────────────┐
│   DispatcherServlet     │
└──────────┬──────────────┘
           ↓
┌─────────────────────────┐
│   TodoController        │  ← @Controller (SSR)
│   JsonController        │  ← @RestController (JSON)
└──────────┬──────────────┘
           ↓
┌─────────────────────────┐
│   TodoService           │  ← @Service
└──────────┬──────────────┘
           ↓
┌─────────────────────────┐
│   TodoDAO               │  ← @Component (인메모리 저장소)
└─────────────────────────┘
```

> **Controller → Service → DAO** 계층 구조를 따르며, Spring의 DI(의존성 주입)를 활용합니다.

## 📝 Todo 모델

| 필드 | 타입 | 설명 |
|------|------|------|
| `category` | String | 카테고리 (Study, Project, Career, Health) |
| `title` | String | 할 일 제목 |
| `summary` | String | 간단한 설명 |
| `date` | LocalDate | 마감일 |

## 🔧 로깅 설정

`application.properties`에서 Spring MVC 내부 동작을 추적할 수 있도록 TRACE 레벨 로깅이 설정되어 있습니다:

- `DispatcherServlet` — 요청 처리 흐름
- `HandlerMapping` — URL-Controller 매핑
- `HandlerAdapter` — Controller 메서드 실행
- `ViewResolver` — 뷰 템플릿 해석

## 🛠 기술 스택

| 구분 | 기술 |
|------|------|
| **Language** | Java 17 |
| **Framework** | Spring Boot 4.0.3 |
| **Template Engine** | Thymeleaf |
| **Build Tool** | Gradle |
| **Database Driver** | MySQL Connector/J |
| **Utility** | Lombok |
| **Font** | Pretendard |
