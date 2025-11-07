public enum Operator {
    L_PAREN(3),
    R_PAREN(3),
    MULTIPLY(1),
    DIVIDE(1),
    PLUS(0),
    MINUS(0);

    public final int precedence;
    private Operator(int precedence) {
        this.precedence = precedence;
    }
}
