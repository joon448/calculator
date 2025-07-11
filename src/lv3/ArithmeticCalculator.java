package lv3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> {
    private List<BigDecimal> results =  new ArrayList<>();

    public Optional<BigDecimal> calculate(T num1, T num2, OperatorType operator){
        BigDecimal bd1 = new BigDecimal(num1.toString());
        BigDecimal bd2 = new BigDecimal(num2.toString());
        BigDecimal result;
        switch (operator) {
            case ADD:
                result = bd1.add(bd2);
                break;
            case SUB:
                result = bd1.subtract(bd2);
                break;
            case MUL:
                result = bd1.multiply(bd2);
                break;
            case DIV:
                // 나눗셈 분모 0 예외 처리
                if (bd2.compareTo(BigDecimal.ZERO) == 0) {
                    System.out.println("나눗셈 연산에서 분모(두 번째 정수)에 0이 입력될 수 없습니다.");
                    return Optional.empty();
                }
                result = bd1.divide(bd2, 10, RoundingMode.HALF_UP);
                break;
            default:
                System.out.println("잘못된 연산입니다.");
                return Optional.empty();
        }
        results.add(result);
        return Optional.of(result);
    }

    public List<BigDecimal> getResults() {
        return results;
    }

    public void setResults(List<BigDecimal> results) {
        this.results = results;
    }

    public void removeResult(){
        if (!results.isEmpty()) {
            results.remove(0);
        }
    }

    public List<BigDecimal> getFilteredResults(T threshold){
        BigDecimal thresholdDecimal = new BigDecimal(threshold.toString());

        return results.stream()
                .filter(result -> result.compareTo(thresholdDecimal) > 0)
                .collect(Collectors.toList());
    }
}
