import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Problem_AM {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        
        String dimension = "";
        
        if (stdin.hasNext()) {
        	dimension = stdin.nextLine();
        }
        
        String[] dimensions = dimension.split("\\s+");
        int[][] mountain = new int[Integer.parseInt(dimensions[0])][Integer.parseInt(dimensions[1])];
        
        String tempString = "";
        
        for (int i = 0; i < mountain.length; i++) {
        	if (stdin.hasNext()) {
        		tempString = stdin.nextLine();
        	}
        	
        	String[] values = tempString.split("\\s+");
        	for (int j = 0; j < mountain[i].length; j++) {
        		mountain[i][j] = Integer.parseInt(values[j]);
        	}
        }
        
        stdin.close();
    }
}