package lv1;

import javax.crypto.spec.PSource;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
            String operatorInput =  scanner.nextLine();
            //사칙연산 기호 입력 예외 처리
            if (operatorInput.isEmpty()){
                System.out.println("잘못된 입력입니다.");
                continue;
            }
            char operator = operatorInput.charAt(0);

            //연산
            int result = 0;
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    // 나눗셈 분모 0 예외 처리
                    if (num2 == 0) {
                        System.out.println("나눗셈 연산에서 분모(두 번째 정수)에 0이 입력될 수 없습니다.");
                        continue;
                    }
                    result = num1 / num2;
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
                    continue;
            }
            System.out.println(result);

            //반복 종료 조건
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String status = scanner.nextLine();
            if (status.equals("exit")) {
                System.out.println("종료되었습니다.");
                break;
            }
        }
        scanner.close();

    }
}