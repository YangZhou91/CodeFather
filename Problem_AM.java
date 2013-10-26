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
        int[][] path = new int[Integer.parseInt(dimensions[0])][Integer.parseInt(dimensions[1])];
        
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
        
        // Dijkstra
        int left, right, minIndex;
        for (int index = mountain.length - 2; index >= 0; index--) {
        	for (int horiIndex = 0; horiIndex < mountain[index].length; horiIndex++) {
        		if (horiIndex == 0) {
        			left = horiIndex;
        		} else {
        			left = horiIndex - 1;
        		}
        		
        		if (horiIndex == mountain[index].length - 1) {
        			right = horiIndex;
        		} else {
        			right = horiIndex + 1;
        		}
        		
        		minIndex = left;
        		
        		for (int i = right; i >= left; i--) {
        			if (mountain[index + 1][i] <= mountain[index + 1][minIndex]) {
        				minIndex = i;
        			}
        		}
        		
        		mountain[index][horiIndex] += mountain[index + 1][minIndex];
        		path[index][horiIndex] = minIndex;
        	}
        }

        minIndex = 0;
        int minRisk = mountain[0][0];
        
        for (int i = 1; i < mountain[0].length; i++) {
        	if (mountain[0][i] < minRisk) {
        		minRisk = mountain[0][i];
        		minIndex = i;
        	}
        }
        
        Queue finalPath = new LinkedList();
        
        for (int i = 0; i < mountain.length; i++) {
        	finalPath.add(new String("[" + i  + "," + minIndex + "]"));
        	minIndex = path[i][minIndex];
        }
        
        System.out.print("Minimum risk path = ");

        while (!finalPath.isEmpty()) {
        	System.out.print((String)finalPath.remove());
        }
        
        System.out.println();
        
        System.out.println("Risks along the path = " + minRisk);
        
        stdin.close();
    }
}