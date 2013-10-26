import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Problem_AG {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        
        int N = 0, K = 0;
        Queue<int[]> queue = new LinkedList<int[]>();
        while (true) {
        	if (stdin.hasNext()) {
        		N = stdin.nextInt();
        	}
        	
        	if (stdin.hasNext()) {
        		K = stdin.nextInt();
        	}
        	
        	if (N == 0 && K == 0) {
        		break;
        	}
        	
        	queue.add(new int[]{N, K});
        }
        
        while (!queue.isEmpty()) {
        	int[] caseTest = (int[]) queue.remove();
        	int ways = 2;
        	N = caseTest[0];
        	K = caseTest[1];

        	N = N - 1;
        	int count = 0;
        	while (K > 1) {
        		ways *= combination(N - 1, 1);
        		K -= 1;
        		count++;
        		
        		if (count % 2 == 0) {
        			N = N - 1;
        		}
        	}
        	
        	System.out.println(ways);
        }
    }
    
	public static int factorial(int n) {
		int fac = 1;
		while (n > 0) {
			fac *= n;
			n--;
		}
		
		return fac;
	}
	
	public static int combination(int total, int selection) {
		return factorial(total) / (factorial(selection) * factorial(total - selection));
	}
}