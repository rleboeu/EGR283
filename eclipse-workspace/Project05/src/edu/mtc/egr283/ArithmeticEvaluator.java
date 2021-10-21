package edu.mtc.egr283;

/**
 * ArithmeticEvaluator class to evaluate arithmetic expressions
 * @author leboe
 * @version 1.0.0	10-20-2021
 */
public class ArithmeticEvaluator {

	private static final String OPERATORS = "/*+-^%";
	
	private Stack<Double> numeralStack;
	private Stack<Character> operatorStack;
	
	/**
	 * Constructor
	 */
	public ArithmeticEvaluator() {
		this.numeralStack = new Stack<Double>();
		this.operatorStack = new Stack<Character>();
	}// Ending bracket of constructor
	
	/**
	 * Converts an infix String to postfix format
	 * @param infix String to be converted
	 * @return String representation of postfix format
	 */
	public String formatPostfix(String infix) {
		StringBuffer postfix = new StringBuffer();
		StringBuffer numeralBuffer = new StringBuffer();
		
		this.operatorStack.clear();
		
		char currentChar;
		for (int index = 0; index < infix.length(); ++index) {
			currentChar = infix.charAt(index);
			
			// handle numbers with more than 1 digit
			if (this.isNumeral(currentChar)) {
				numeralBuffer.append(currentChar);
			} else if (numeralBuffer.length() != 0) {	// add contents iff there are contents to add
				postfix.append(numeralBuffer.toString() + " ");	// add contents of buffer to postfix
				numeralBuffer.delete(0, numeralBuffer.length()); // reset buffer
			}// Ending bracket of if
			
			// mathematical operator
			if (this.isOperator(currentChar)) {
				this.operatorStack.push(currentChar);
			}// Ending bracket of if
			
			// closing bracket
			if (currentChar == ')') {
				postfix.append(this.operatorStack.pop() + " ");
			}// Ending bracket of if
			
		}// Ending bracket of for loop
		
		// pop remaining operators
		while (this.operatorStack.size() > 0) {
			postfix.append(this.operatorStack.pop() + " ");
		}// Ending bracket of while loop
		
		return postfix.toString().trim();
	}// Ending bracket of metheod convertToPostfix
	
	/**
	 * Evaluates the arithmetic expression 
	 * @param postfix String of arithmetic expression
	 * @return double result of evaluation
	 */
	public double evaluatePostfix(String postfix) {
		StringBuffer numeralBuffer = new StringBuffer();
		
		this.numeralStack.clear();
		
		double[] operands = new double[2];
		char currentChar;
		double result = 0;
		for (int index = 0; index < postfix.length(); ++index) {	// for each index in String postfix
			currentChar = postfix.charAt(index);
			
			// handle numbers with more than 1 digit
			if (this.isNumeral(currentChar)) {
				numeralBuffer.append(currentChar);
			} else if (numeralBuffer.length() != 0) {	
				// add contents iff there are contents to add
				this.numeralStack.push(Double.parseDouble(numeralBuffer.toString()));
				numeralBuffer.delete(0, numeralBuffer.length()); // reset buffer
			}// Ending bracket of if
			
			if (this.isOperator(currentChar)) {
				operands[1] = this.numeralStack.pop();
				operands[0] = this.numeralStack.pop();
				
				switch (currentChar) {
				case '/':
					result = operands[0] / operands[1];
					break;
				case '*':
					result = operands[0] * operands[1];
					break;
				case '+':
					result = operands[0] + operands[1];
					break;
				case '-':
					result = operands[0] - operands[1];
					break;
				case '^':
					result = Math.pow(operands[0], operands[1]);
					break;
				case '%':
					result = operands[0] % operands[1];
					break;
					
					default:
						break;
				}// Ending bracket of switch
				
				this.numeralStack.push(result);
			}// Ending bracket of if operator
		}// Ending bracket of for loop
		
		return this.numeralStack.pop();
	}// Ending bracket of method evaluatePostfix
	
	private boolean isNumeral(char c) {
		return ( c >= 48 && c <= 57 ) || c == '.';	// between 0 and 9, respectively (ASCII values)
	}// Ending bracket of method isNumeral
	
	private boolean isOperator(char c) {
		return ArithmeticEvaluator.OPERATORS.contains(Character.toString(c));
	}// Ending bracket of method isOperator
	
}// Ending bracket of class ArithmeticEvaluator
