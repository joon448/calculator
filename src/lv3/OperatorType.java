package lv3;


import java.util.Optional;

public enum OperatorType {
    ADD("+"),
    SUB("-"),
    MUL("*"),
    DIV("/");

    private final String operator;

    OperatorType(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public static Optional<OperatorType> findOperator(String operator) {
        for (OperatorType type : values()) {
            if (type.operator.equals(operator)) {
                return Optional.of(type);
            }
        }
        return Optional.empty();
    }
}

