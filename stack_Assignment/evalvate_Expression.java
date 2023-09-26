package stack_Assignment;

import java.util.Stack;

public class evalvate_Expression {

	public static int evalvateexp(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (String token : tokens) {
			if (isoperator(token)) {
				int operand2 = stack.pop();
				int operand1 = stack.pop();
				int result = perfromeoperation(token, operand1, operand2);
				stack.push(result);
			} else {
				stack.push(Integer.parseInt(token));
			}
		}
		return stack.pop();
	}

	private static int perfromeoperation(String token, int operand1, int operand2) {
		switch(token)
		{
		case "+":
				return operand1 + operand2;
		case "-":
				return operand1 - operand2;
		case "*":
				return operand1 * operand2;
		case "/":
			 	return operand1 / operand2;
		default:	 	
			 	return 0;
		}
		
	}

	private static boolean isoperator(String token) {
		return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
	}

	public static void main(String[] args)
	{
		String token[]={"4","13","5","/","+"};
		int result=evalvateexp(token);
		System.out.println(result);

	}

}
