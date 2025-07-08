package lv2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        while(true) {
            int num1;
            int num2;
            try {
                System.out.print("첫 번째 숫자를 입력하세요 (0 이상의 정수): ");
                num1 = scanner.nextInt();
                if (num1 < 0) {
                    System.out.println("0 이상의 정수를 입력해주세요.");
                    continue;
                }

                System.out.print("두 번째 숫자를 입력하세요 (0 이상의 정수): ");
                num2 = scanner.nextInt();
                if (num2 < 0) {
                    System.out.println("0 이상의 정수를 입력해주세요.");
                    continue;
                }
            } catch (InputMismatchException var8) {
                System.out.println("0 이상의 정수를 입력해주세요.");
                scanner.nextLine();
                continue;
            }

            scanner.nextLine();
            System.out.print("사칙연산 기호를 입력하세요: ");
            String operatorInput = scanner.nextLine();
            if (operatorInput.isEmpty()) {
                System.out.println("잘못된 입력입니다.");
            } else {
                char operator = operatorInput.charAt(0);

                //Calculator class 이용하여 연산 처리
                Integer result = calculator.calculate(num1, num2, operator);
                if (result  == null) {
                    continue;
                }

                System.out.println(result);
                System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                String status = scanner.nextLine();
                if (status.equals("exit")) {
                    System.out.println("종료되었습니다.");
                    scanner.close();
                    return;
                }
            }
        }
    }
}
