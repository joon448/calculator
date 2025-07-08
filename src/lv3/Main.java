package lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while(true) {
            // 정수 입력
            int num1;
            int num2;
            try{
                //첫 번째 정수 입력
                System.out.print("첫 번째 숫자를 입력하세요 (0 이상의 정수): ");
                num1 = scanner.nextInt();
                if (num1 < 0){
                    System.out.println("0 이상의 정수를 입력해주세요.");
                    continue;
                }
                //두 번째 정수 입력
                System.out.print("두 번째 숫자를 입력하세요 (0 이상의 정수): ");
                num2 = scanner.nextInt();
                if (num2 < 0) {
                    System.out.println("0 이상의 정수를 입력해주세요.");
                    continue;
                }
            } catch(InputMismatchException e){
                System.out.println("0 이상의 정수를 입력해주세요.");
                scanner.nextLine();
                continue;
            }

            //개행 문자 처리
            scanner.nextLine();

            //사칙연산 기호 입력
            System.out.print("사칙연산 기호를 입력하세요: ");
            String operatorInput =  scanner.nextLine().trim();
            //사칙연산 기호 입력 예외 처리
            if (operatorInput.isEmpty()){
                System.out.println("잘못된 입력입니다.");
                continue;
            }
            char operator = operatorInput.charAt(0);

            //Calculator class 이용하여 연산 처리
            Integer result = calculator.calculate(num1, num2, operator);
            if (result  == null) {
                continue;
            }

            System.out.println(result);

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
        System.out.println("가장 먼저 저장된 결과를 삭제합니다..");
        calculator.removeResult();
        System.out.println("삭제 후 연산 결과 목록: " + calculator.getResults());
        System.out.println("연산 결과를 [1, 2, 3, 4]로 설정합니다..");
        calculator.setResults(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        System.out.println("설정 후 연산 결과 목록: " + calculator.getResults());

        scanner.close();
    }
}
