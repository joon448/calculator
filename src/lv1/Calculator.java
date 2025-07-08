package lv1;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 양의 정수 입력
        System.out.print("첫 번째 숫자를 입력하세요 (0 이상의 정수): ");
        int num1 = scanner.nextInt();
        System.out.print("두 번째 숫자를 입력하세요 (0 이상의 정수): ");
        int num2 = scanner.nextInt();
        //개행 문자 처리
        scanner.nextLine();

        //사칙연산 기호 입력
        System.out.print("사칙연산 기호를 입력하세요: ");
        char operator = scanner.nextLine().charAt(0);

        //연산
        int result = 0;
        switch (operator){
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
                if (num2 == 0){
                    System.out.println("나눗셈 연산에서 분모(두 번째 정수)에 0이 입력될 수 없습니다.");
                    scanner.close();
                    System.exit(0);
                }
                result = num1 / num2;
                break;
            default:
                System.out.println("잘못된 입력입니다.");
                scanner.close();
                System.exit(0);
        }
        System.out.printf("%d %c %d = %d", num1, operator, num2, result);
        scanner.close();
    }
}