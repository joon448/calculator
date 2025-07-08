package lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArithmeticCalculator<T extends Number> {
    private List<Double> results =  new ArrayList<>();

    public Optional<Double> calculate(T n1, T n2, OperatorType operator){
        double num1 = n1.doubleValue();
        double num2 = n2.doubleValue();
        double result;
        switch (operator) {
            case ADD:
                result = num1 + num2;
                break;
            case SUB:
                result = num1 - num2;
                break;
            case MUL:
                result = num1 * num2;
                break;
            case DIV:
                // 나눗셈 분모 0 예외 처리
                if (num2 == 0) {
                    System.out.println("나눗셈 연산에서 분모(두 번째 정수)에 0이 입력될 수 없습니다.");
                    return Optional.empty();
                }
                result = num1 / num2;
                break;
            default:
                System.out.println("잘못된 연산입니다.");
                return Optional.empty();
        }
        results.add(result);
        return Optional.of(result);
    }

    public List<Double> getResults() {
        return results;
    }

    public void setResults(List<Double> results) {
        this.results = results;
    }

    public void removeResult(){
        if (!results.isEmpty()) {
            results.remove(0);
        }
    }
}
