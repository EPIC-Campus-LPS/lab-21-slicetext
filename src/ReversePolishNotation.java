import java.util.Stack;

public class ReversePolishNotation {
    public static Stack<Symbol> InfixToPostfix(Stack<Symbol> input) {
        Stack<Symbol> output = new Stack<>();
        Stack<OperatorSymbol> operator = new Stack<>();

        while(!input.isEmpty()) {
            Symbol cur = input.pop();
            if(cur instanceof NumberSymbol) {
                output.push(cur);
            } else if (cur instanceof OperatorSymbol) {
                while(!operator.isEmpty() && operator.peek().operator.precedence >= ((OperatorSymbol) cur).operator.precedence && operator.peek().operator != Operator.L_PAREN) {
                    output.push(operator.pop());
                }
                operator.push((OperatorSymbol) cur);
            } else if (cur instanceof CloseParenthesisSymbol) {
                OperatorSymbol i = operator.peek();
                while(!(i.operator == Operator.L_PAREN)) {
                    output.push(operator.pop());
                    i = operator.peek();
                }
                operator.pop();
            }
        }
        // Flush operator stack
        while(!operator.isEmpty()) {
            output.push(operator.pop());
        }

        return output;
    }

    public static int EvalPostfix(Stack<Symbol> input) {
        Stack<Integer> output = new Stack<>();
        while(!input.isEmpty()) {
            Symbol cur = input.pop();
            if(cur instanceof NumberSymbol) {
                output.push(((NumberSymbol) cur).value);
            } else if (cur instanceof OperatorSymbol) {
                int b = output.pop();
                int a = output.pop();

                int result = switch (((OperatorSymbol) cur).operator) {
                    case Operator.MULTIPLY -> a * b;
                    case DIVIDE -> a / b;
                    case PLUS -> a + b;
                    case MINUS -> a - b;
                    default -> 0;
                };
                output.push(result);
            }
        }
        return output.pop();
    }
}
