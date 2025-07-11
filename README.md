# Java 계산기 프로젝트

## 목표
Java 기초부터 단계적으로 발전시키는 계산기 어플리케이션 구현

&nbsp;

## 개발 프로세스

### Lv 1. 클래스 없이 구현한 계산기
- Scanner를 이용한 입력 처리
- `int`형 두 수와 연산기호 입력
- switch문을 통한 사칙연산 수행
- `exit` 입력 시까지 반복 수행

### Lv 2. 클래스 기반 객체지향 계산기
- `Calculator` 클래스 정의 및 기능 분리
- 연산 결과를 저장하는 컬렉션 필드 정의
- `calculate()`, `getResults()`, `setResults()` 메서드 구현
- 가장 먼저 저장된 결과를 삭제하는 `removeResult()` 메서드 구현
- 필드 직접 접근 제한 → 캡슐화 (private + getter/setter)

### Lv 3. 고급 문법 적용 (도전)
- `double`을 지원하는 실수 연산 기능 확장
- `enum`을 활용한 연산자 표현
- `Stream`과 `lambda`를 활용하여 결과 리스트에서 특정 값 이상 출력 기능 추가

&nbsp;

## 실행 환경

- Java 17

&nbsp;

## 디렉토리 구조

```
calculator/
├── lv1/                  # Lv1. 클래스 없이 구현된 계산기
│   └── Main.java
├── lv2/                  # Lv2. 클래스 기반 객체지향 계산기
│   ├── Calculator.java
│   └── Main.java
├── lv3/                  # Lv3. 심화 계산기
└── README.md
```

&nbsp;

## 클래스 및 주요 메서드 설명

### Lv 1.
#### Main.java
- 사용자 입력을 받아 계산 수행
- 특정 입력 받았을 때 반복 실행 종료


### Lv 2.
#### Calculator.java
| 메서드 | 설명 |
|--------|------|
| `Integer calculate(int num1, int num2, char operator)` | 사칙연산 수행 후 결과 저장 |
| `List<Integer> getResults()` | 저장된 연산 결과 조회 |
| `void setResults(List<Integer> results)` | 결과 리스트 전체 덮어쓰기 |
| `void removeResult()` | 가장 오래된 결과 1개 삭제 |


#### Main.java
- 사용자 입력을 받아 계산 수행
- 계산기 객체를 활용하여 연산 및 결과 기록
- 특정 입력 받았을 때 반복 실행 종료
- 종료 시 결과 목록 조회 및 삭제 기능 시연


&nbsp;

## 개발 중 해결한 문제들

#### 1. `nextInt()` 후 `nextLine()`이 바로 안 먹힘
- **원인:** `nextInt()`가 숫자 입력만 처리하고, 개행문자 `\n`은 버퍼에 남기기 때문
- **해결:** `scanner.nextLine()`을 추가로 호출하여 개행문자를 소비

#### 2. `nextInt()`에 문자열 입력 시 예외 발생
- **원인:** `int` 타입에 문자열이 들어와서 `InputMismatchException` 발생
- **해결:** `try-catch`로 예외 처리하고, 입력 실패 시 루프 재시작

#### 3. 연산자 입력이 공백일 경우 `charAt(0)` 예외 발생
- **원인:** 빈 문자열에서 `charAt(0)` 호출 시 `StringIndexOutOfBoundsException`
- **해결:** `.trim().isEmpty()`로 먼저 빈 문자열 검사

#### 4. int에 null 반환 불가
- **원인:** `int`는 primitive type이므로 `null` 저장 불가
- **해결:** `Integer` (Wrapper Class)로 변경하여 null 사용 가능

&nbsp;


## 향후 개선 방향

- 

&nbsp;


## 학습 포인트

- Java 기본 문법 정리 및 예외 처리
- 객체지향 설계: 클래스 분리, 캡슐화
- 리스트, enum, 제네릭, 람다 등 Java 문법 적용
