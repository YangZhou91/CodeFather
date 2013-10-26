import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class IEEE_HKN {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        String input = "";
        int totalNumber = 0;
        
        if (stdin.hasNext()) {
        	input = stdin.nextLine();
        }
        
        String[] temp = input.split(",");
        int[] bounds = new int[]{Integer.parseInt(temp[0]), Integer.parseInt(temp[1])};
        int[] boundExp = new int[2];
        int exp = 0, value = 1;
        
        while (value < bounds[0]) {
        	exp += 1;
        	value = 1<<exp;
        }
        
        boundExp[0] = exp;
        
        while (value <= bounds[1]) {
        	exp += 1;
        	value = 1<<exp;
        }
        
        boundExp[1] = exp - 1;
        
        for (exp = boundExp[0]; exp < boundExp[1]; exp++) {
        	totalNumber += 1<<((int)exp/2);
        }
        
        if (boundExp[1] >= boundExp[0]) {
        	for (int i = bounds[0]; i < 1<<boundExp[0]; i++) {
        		if (isBinaryPalindrome(i)) {
        			totalNumber += 1;
        		}
        	}
        	
        	for (int i = 1<<boundExp[1]; i < bounds[1]; i++) {
        		if (isBinaryPalindrome(i)) {
        			totalNumber += 1;
        		}
        	}
        } else {
        	for (int i = bounds[0]; i <= bounds[1]; i++) {
        		if (isBinaryPalindrome(i)) {
        			totalNumber += 1;
        		}
        	}
        }
        
        System.out.println(totalNumber);
        
        stdin.close();
    }
    
    public static boolean isBinaryPalindrome(int number) {
    	char[] bin = Integer.toBinaryString(number).toCharArray();
    	
    	for (int i = 0, j = bin.length - 1; i < j; i++, j--) {
    		if (bin[i] != bin[j]) {
    			return false;
    		}
    	}
    	
    	return true;
    }
}