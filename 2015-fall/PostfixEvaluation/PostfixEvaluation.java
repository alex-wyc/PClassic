import java.util.*;
import java.io.File;
import java.io.IOException;
import java.lang.Math;

public class PostfixEvaluation{
		
	public static void main(String[] args) throws IOException{
		String expression = ""; 
	    Scanner in = new Scanner(new File("PostfixEvaluationIN.txt"));
		while(in.hasNext()){
			expression = in.nextLine();
			
			System.out.printf("%.1f\n", solve(expression));
		}
	}
	
	public static double solve (String expression){
	    Stack<Float> myStack = new Stack<Float>();

        String op = "+-*/";
        Float currentf, arg1, arg2;
        char current = ' ';

	    for (int i = 0 ; i < expression.length() ; i++) {
	        current = expression.charAt(i);
	        switch (current) {
                case '+':
                    arg1 = myStack.pop();
                    arg2 = myStack.pop();
                    myStack.push(arg1 + arg2);
                    break;
                case '-':
                    arg1 = myStack.pop();
                    arg2 = myStack.pop();
                    myStack.push(arg2 - arg1);
                    break;
                case '*':
                    arg1 = myStack.pop();
                    arg2 = myStack.pop();
                    myStack.push(arg1 * arg2);
                    break;
                case '/':
                    arg1 = myStack.pop();
                    arg2 = myStack.pop();
                    myStack.push(arg2 / arg1);
                    break;
                default:
                    currentf = Float.parseFloat("" + current);
                    myStack.push(currentf);
                    break;
            }
        }
		return myStack.pop();
	}
}
