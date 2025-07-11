package lv3;

import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArithmeticCalculator<Number> calculator = new ArithmeticCalculator<>();
        Number num1;
        Number num2;
        while(true) {
            try {
                //첫 번째 수 입력
                System.out.print("첫 번째 수를 입력하세요: ");
                String input1 = scanner.nextLine().trim();
                if (input1.contains(".")) {
                    num1 = Double.parseDouble(input1);
                } else {
                    num1 = Integer.parseInt(input1);
                }
                //두 번째 수 입력
                System.out.print("두 번째 수를 입력하세요: ");
                String input2 = scanner.nextLine().trim();

                if (input2.contains(".")) {
                    num2 = Double.parseDouble(input2);
                } else {
                    num2 = Integer.parseInt(input2);
                }
            } catch (NumberFormatException e) {
                System.out.println("실수를 입력해주세요.");
                continue;
            }

            //사칙연산 기호 입력
            System.out.print("사칙연산 기호를 입력하세요: ");
            String operatorInput =  scanner.nextLine().trim();
            Optional<OperatorType> operatorType = OperatorType.findOperator(operatorInput);

            //사칙연산 기호 입력 예외 처리
            if (operatorType.isEmpty()){
                System.out.println("잘못된 연산기호입니다.");
                continue;
            }
            OperatorType operator = operatorType.get();

            //Calculator class 이용하여 연산 처리
            Optional<BigDecimal> result = calculator.calculate(num1, num2, operator);
            if (result.isEmpty()) {
                continue;
            }

            System.out.println(result.get());

            //반복 종료 조건
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String status = scanner.nextLine().trim();
            if (status.equals("exit")) {
                System.out.println("종료되었습니다.");
                break;
            }
        }

        // Calculator methods 테스트
        runTest(scanner, calculator);
        scanner.close();
    }

    public static void runTest(Scanner scanner, ArithmeticCalculator<Number> calculator) {
        // Calculator methods 테스트
        System.out.println("=======Calculator methods 테스트=======");
        System.out.println("현재까지의 연산 결과 목록: " + calculator.getResults());
        double threshold;
        while (true) {
            System.out.print("결과 조회 기준값을 입력하세요(기준값보다 큰 값만 출력): ");
            try {
                threshold = scanner.nextDouble();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다.");
                scanner.nextLine();
            }
        }
        System.out.println("필터링 후 연산 결과 목록: " + calculator.getFilteredResults(threshold));
    }
}
