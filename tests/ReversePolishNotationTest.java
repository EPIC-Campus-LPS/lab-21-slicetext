import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class ReversePolishNotationTest {

    @org.junit.jupiter.api.Test
    void infixToPostfix() {
        Stack<Symbol> s = new Stack<>();
        s.push(new NumberSymbol(4));
        s.push(new OperatorSymbol(Operator.DIVIDE));
        s.push(new NumberSymbol(3));
        s.push(new OperatorSymbol(Operator.PLUS));
        s.push(new NumberSymbol(2));
        s.push(new OperatorSymbol(Operator.MULTIPLY));
        s.push(new NumberSymbol(1));

        Stack<Symbol> out = new Stack<>();
        out.push(new NumberSymbol(1));
        out.push(new NumberSymbol(2));
        out.push(new OperatorSymbol(Operator.MULTIPLY));
        out.push(new NumberSymbol(3));
        out.push(new NumberSymbol(4));
        out.push(new OperatorSymbol(Operator.DIVIDE));
        out.push(new OperatorSymbol(Operator.PLUS));

        assertEquals(out, ReversePolishNotation.InfixToPostfix(s));
    }

    @org.junit.jupiter.api.Test
    void infixToPostfixParen() {
        Stack<Symbol> s = new Stack<>();
        s.push(new CloseParenthesisSymbol());
        s.push(new NumberSymbol(3));
        s.push(new OperatorSymbol(Operator.PLUS));
        s.push(new NumberSymbol(2));
        s.push(new OperatorSymbol(Operator.L_PAREN));
        s.push(new OperatorSymbol(Operator.MULTIPLY));
        s.push(new NumberSymbol(1));

        Stack<Symbol> out = new Stack<>();
        out.push(new NumberSymbol(1));
        out.push(new NumberSymbol(2));
        out.push(new NumberSymbol(3));
        out.push(new OperatorSymbol(Operator.PLUS));
        out.push(new OperatorSymbol(Operator.MULTIPLY));

        assertEquals(out, ReversePolishNotation.InfixToPostfix(s));
    }

    @org.junit.jupiter.api.Test
    void evalPostfix() {
        Stack<Symbol> rpn = new Stack<>();
        rpn.push(new OperatorSymbol(Operator.PLUS));
        rpn.push(new OperatorSymbol(Operator.DIVIDE));
        rpn.push(new NumberSymbol(3));
        rpn.push(new NumberSymbol(6));
        rpn.push(new OperatorSymbol(Operator.MULTIPLY));
        rpn.push(new NumberSymbol(2));
        rpn.push(new NumberSymbol(1));

        assertEquals(4, ReversePolishNotation.EvalPostfix(rpn));
    }
}