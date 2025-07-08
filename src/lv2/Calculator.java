package lv2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Integer> results =  new ArrayList<Integer>();

    public Integer calculate(int num1, int num2, char operator){
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
                    return null;
                }
                result = num1 / num2;
                break;
            default:
                System.out.println("잘못된 입력입니다.");
                return null;
        }
        results.add(result);
        return result;
    }

    public List<Integer> getResults() {
        return results;
    }

    public void setResults(List<Integer> results) {
        this.results = results;
    }

    public void removeResult(){
        if (!results.isEmpty()) {
            results.remove(0);
        }
    }
}
