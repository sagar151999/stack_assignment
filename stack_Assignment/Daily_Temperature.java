package stack_Assignment;

import java.util.Iterator;
import java.util.Stack;

public class Daily_Temperature {
	
	public static int[] dailyTemp(int[] temperature)
	{
		
	        int n = temperature.length;
	        int[] result = new int[n];
	        Stack<Integer> stack = new Stack<>();

	        for (int i = 0; i < n; i++) {
	            while (!stack.isEmpty() && temperature[i] > temperature[stack.peek()]) {
	                int idx = stack.pop();
	                result[idx] = i - idx;
	            }
	            stack.push(i);
	        }

	        return result;
	    }
	

	    public static void main(String[] args) {
	       

	        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
	        int[] result = dailyTemp(temperatures);

	        for (int temp : result) {
	            System.out.print(temp + " ");
	        }
	        
	    }
	}
	