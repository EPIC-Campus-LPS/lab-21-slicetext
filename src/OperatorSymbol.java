public class OperatorSymbol implements Symbol{
    public Operator operator;

    public OperatorSymbol(Operator operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return switch (operator) {
            case L_PAREN -> "(";
            case R_PAREN -> ")";
            case MULTIPLY -> "*";
            case DIVIDE -> "/";
            case PLUS -> "+";
            case MINUS -> "-";
        };
    }

    @Override
    public boolean equals(Object o) {
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        return operator.equals(((OperatorSymbol) o).operator);
    }
}
