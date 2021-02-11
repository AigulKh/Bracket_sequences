import java.util.Scanner;
import java.util.Stack;

public class Bracket_sequences {
    final static char ROUND_BRACKET = '(';
    final static char ROUND_BRACKET_ = ')';
    final static char SQUARE_BRACKET = '[';
    final static char SQUARE_BRACKET_ = ']';
    final static char BRACE = '{';
    final static char BRACE_ = '}';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            System.out.println(isBrackets(line));
        }
        scanner.close();
    }

    public static boolean isBrackets(String line) {
        Stack <Character> stack = new Stack<>();

        for (char element: line.toCharArray()) {
            if (element == ROUND_BRACKET || element == SQUARE_BRACKET || element == BRACE)
                stack.push(element);
            else {
                if (stack.isEmpty())
                    return false;
                switch (element) {
                    case ROUND_BRACKET_:
                        if (stack.peek() == ROUND_BRACKET)
                            stack.pop();
                        else return false;
                        break;
                    case SQUARE_BRACKET_:
                        if (stack.peek() == SQUARE_BRACKET)
                            stack.pop();
                        else return false;
                        break;
                    case BRACE_:
                        if (stack.peek() == BRACE)
                            stack.pop();
                        else return false;
                        break;
                }
            }
        }

        return stack.isEmpty();
    }
}