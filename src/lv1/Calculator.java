package lv1;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("첫 번째 숫자를 입력하세요 (0 이상의 정수): ");
        int num1 = scanner.nextInt();
        System.out.print("두 번째 숫자를 입력하세요 (0 이상의 정수): ");
        int num2 = scanner.nextInt();
        scanner.close();
    }
}