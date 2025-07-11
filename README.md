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
- `generic`을 이용하여 실수 연산 기능 확장
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
│   ├── OperatorType.java
│   ├── ArithmeticCalculator.java
│   └── Main.java
└── README.md
```

&nbsp;

## 클래스 및 주요 메서드 설명

### Lv 1.
#### Main.java
- 사용자 입력을 받아 계산 수행
- 특정 입력 받았을 때 반복 실행 종료

&nbsp;

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
- 종료 시 `runTest()` 메서드를 실행해 결과 목록 조회 및 삭제 기능 시연

&nbsp;

### Lv 3.
#### OperatorType.java
- 연산 기호 ADD(`+`), SUB(`-`), MUL(`*`), DIV(`/`)를 enum 상수로 정의
- `Optional<OperatorType> findOperator(String operator)`를 통해 입력 문자열과 매칭되는 연산 기호 반환

#### ArithmeticCalculator.java
| 메서드 | 설명 |
|--------|------|
| `Optional<BigDecimal> calculate(T num1, T num2, OperatorType operator)` | 제네릭 숫자 입력 받아 BigDecimal로 연산 수행, 결과를 리스트에 저장 |
| `List<BigDecimal> getResults()` | 저장된 연산 결과 조회 |
| `void setResults(List<BigDecimal> results)` | 결과 리스트 전체 덮어쓰기 |
| `void removeResult()` | 가장 오래된 결과 1개 삭제 |
| `List<BigDecimal> getFilteredResults(double threshold)` | 기준값보다 큰 결과들만 필터링해서 반환 |


#### Main.java
- 사용자 입력을 받아 계산 수행
- 계산기 객체를 활용하여 연산 및 결과 기록
- 특정 입력 받았을 때 반복 실행 종료
- 종료 시 `runTest()` 메서드를 실행해 필터링 결과 조회 기능 시연


&nbsp;

## 개발 중 해결한 문제들

#### 🟨 Lv 1. `nextInt()` 후 `nextLine()`이 바로 안 먹힘
- **원인:** `nextInt()`가 숫자 입력만 처리하고, 개행문자 `\n`은 버퍼에 남기기 때문
- **해결:** `scanner.nextLine()`을 추가로 호출하여 개행문자를 소비

#### 🟨 Lv 1. `nextInt()`에 문자열 입력 시 예외 발생
- **원인:** `int` 타입에 문자열이 들어와서 `InputMismatchException` 발생
- **해결:** `try-catch`로 예외 처리하고, 입력 실패 시 루프 재시작

#### 🟨 Lv 1. 연산자 입력이 공백일 경우 `charAt(0)` 예외 발생
- **원인:** 빈 문자열에서 `charAt(0)` 호출 시 `StringIndexOutOfBoundsException`
- **해결:** `.trim().isEmpty()`로 먼저 빈 문자열 검사

#### 🟦 Lv 2. int에 null 반환 불가
- **원인:** `int`는 primitive type이므로 `null` 저장 불가
- **해결:** `Integer` (Wrapper Class)로 변경하여 null 사용 가능

#### 🟩 Lv 3. Enum의 적용 범위 고민
- **원인:** 연산자 기호만 저장할지, 계산 로직까지 포함할지 고민
- **해결:** 연산자는 enum에 문자열 기호만 저장, 계산은 `ArithmeticCalculator` 내부에서 수행

#### 🟩 Lv 3. Generic의 적용 방법 고민
- **원인:** 결과 콘텐츠 필드 타입을 T로 두지, Double로 고정할지 결정 필요
- **해결:** 다양한 숫자 타입 입력을 위해 T extends Number로 제약. 계산은 doubleValue()로 처리, 결과는 List<Double>로 고정
- **추가 해결:** int 및 double을 Number로 받아옴. 계산은 BigDecimal 타입으로 처리

#### 🟦 Lv 2. & 🟩 Lv 3 코드의 가독성
- **해결:** 테스트 코드들을 `runTest()` 메서드로 분리 

&nbsp;


## 향후 개선 방향
- 잘못된 입력이 들어오는 경우, 해당 단계부터 다시 입력하도록 수정

&nbsp;


## 학습 포인트

- Java 기본 문법 정리 및 예외 처리
- 객체지향 설계: 클래스 분리, 캡슐화
- 리스트, enum, 제네릭, 람다 등 Java 문법 적용
