//You are keeping the scores for a baseball game with strange rules. At the
//beginning of the game, you start with an empty record.
//You are given a list of strings operations, where operations[i] is the ith operation
//you must apply to the record and is one of the following:
//1) An integer x.
// Record a new score of x.
//2) '+'.
// Record a new score that is the sum of the previous two scores.
//3) 'D'.
// Record a new score that is the double of the previous score.
//4) 'C'.
// Invalidate the previous score, removing it from the record.
//Return the sum of all the scores on the record after applying all the operations.
//The test cases are generated such that the answer and all intermediate calculations
//fit in a 32-bit integer and that all operations are valid.
//Example 1:
//Input: ops = ["5","2","C","D","+"]
//Output: 30
//Explanation:
//"5" - Add 5 to the record, record is now [5].
//"2" - Add 2 to the record, record is now [5, 2].
//"C" - Invalidate and remove the previous score, record is now [5].
//"D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
//"+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
//The total sum is 5 + 10 + 15 = 30.


package stack_Assignment;

import java.util.Stack;

public class Baseball_game {
	
	public static int keepingScore(String[] ops)
	{
		Stack<Integer> stack=new Stack<>();
		for(String s:ops)
		{
			if(s.equals("C"))
			{
				stack.pop();
			}
			else if(s.equals("D"))
			{
				stack.push(2*stack.peek());
			}
			else if(s.equals("+"))
			{
				if(stack.size()>=2)
				{
					int res1=stack.pop();
					int res2=stack.pop();
					int res=res1+res2;
					stack.push(res2);
					stack.push(res1);
					stack.push(res);
				}
			}
			else
			{
			stack.push(Integer.parseInt(s));
		}
			
	}
		int ans=0;
		while(!stack.isEmpty())
		{
			ans+=stack.pop();
		}
		return ans;
	}
	
	public static void main(String[] args) 
	{
		String ops[]= {"5","-2","4","C","D","9","+","+"};
		int result=keepingScore(ops);
		System.out.println(result);
		
	}

}
