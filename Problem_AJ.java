import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Problem_AJ {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        
        int number = 0;
        
        if (stdin.hasNext()) {
        	number = stdin.nextInt();
        }

        int[] slopes = new int[number];
        
        for (int i = 0; i < number; i++) {
        	if (stdin.hasNext()) {
        		slopes[i] = stdin.nextInt();
        	}
        }
        
        int index = 0, velocity = 0;
        
        while (index < number) {
        	if (slopes[index] >=0 && velocity < 0) {
        		velocity = 0;
        	}
        	
        	velocity += slopes[index++];
        }
        
        if (velocity < 0) {
        	velocity = 0;
        }
        
        System.out.println(velocity);
        
        stdin.close();
    }
}