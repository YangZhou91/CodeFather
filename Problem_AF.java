import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Problem_AF {
	public static int TOTAL_STUDENTS = 1337;

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        
        int tests = 0;
        if (stdin.hasNext()) {
        	tests = stdin.nextInt();
        }
        
        int[] favNumbers = new int[tests];
        int[] positions = new int[tests];
        for (int i = 0; i < tests; i++) {
        	if (stdin.hasNext()) {
        		favNumbers[i] = stdin.nextInt();
        		positions[i] = 0;
        	}
        }
        
        for (int i = 0; i < tests; i++) {
        	int step = 1, favNum = favNumbers[i], position = 1, currentNum = 1;
        	
        	while (true) {
        		if (currentNum == favNum) {
        			positions[i] = position;
        			break;
        		}
        		
        		position = (position + step + TOTAL_STUDENTS) % TOTAL_STUDENTS;
        		currentNum += 1;
        		if (containsOrHasSeven(currentNum)) {
        			step = 0 - step;
        		}
        	}
        }
        
        for (int i = 0; i < tests; i++) {
        	System.out.println(positions[i]);
        }
        	
        stdin.close();
    }
    
    public static boolean containsOrHasSeven(int num) {
    	if (num % 7 == 0) {
    		return true;
    	}
    	
    	while (num > 1) {
    		if (num % 10 == 7) {
    			return true;
    		}
    		
    		num /= 10;
    	}
    	
    	return false;
    }
}