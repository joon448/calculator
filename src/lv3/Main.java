package lv3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();

        while(true) {
            // 두 수 입력
            double num1;
            double num2;
            try{
                //첫 번째 수 입력
                System.out.print("첫 번째 수를 입력하세요: ");
                num1 = scanner.nextDouble();
                //두 번째 수 입력
                System.out.print("두 번째 수를 입력하세요: ");
                num2 = scanner.nextDouble();
            } catch(InputMismatchException e){
                System.out.println("실수를 입력해주세요.");
                scanner.nextLine();
                continue;
            }

            //개행 문자 처리
            scanner.nextLine();

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
            Optional<Double> result = calculator.calculate(num1, num2, operator);
            if (result.isEmpty()) {
                continue;
            }

            System.out.printf("%.3f\n", result.get());

            //반복 종료 조건
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String status = scanner.nextLine().trim();
            if (status.equals("exit")) {
                System.out.println("종료되었습니다.");
                break;
            }
        }

        // Calculator methods 테스트 코드
        System.out.println("=======Calculator methods 테스트=======");
        System.out.println("현재까지의 연산 결과 목록: " + calculator.getResults());
        System.out.print("결과 조회 기준값을 입력하세요(기준값보다 큰 값만 출력): ");
        double threshold = scanner.nextDouble();
        System.out.println("필터링 후 연산 결과 목록: " + calculator.getFilteredResults(threshold));
        scanner.close();
    }
}
