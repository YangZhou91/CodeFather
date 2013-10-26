import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Problem_AQ {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        
        int N = 0, M = 0;
        if (stdin.hasNext()) {
        	N = stdin.nextInt();
        }
        if (stdin.hasNext()) {
        	M = stdin.nextInt();
        }
        
        int size = (int)Math.pow((double) 2, (double) N);
        int[][] bobStrategy = new int[size][N];
        for (int i = 0; i < size; i++) {
        	int temp = stdin.nextInt();
        	for (int j = 0; j < N; j++) {
	        	bobStrategy[i][N - 1 - j] = (int)(temp / (int)Math.pow(10, j)) % 10;
        	}
        }
        
        int compatible = 1, casino = 0;
        for (int i = 0; i < size; i++) {
            int[] casinoStrategy = new int[N];
            int aliceStrategy = 0, numberOfWins = 0;
            
        	for (int j = 0; j < N; j++) {
        		casinoStrategy[j] = (casino >> j) % 2;
        	}
        	
        	for (int j = 0; j < N; j++) {
        		System.out.print(casinoStrategy[j]);
        	}
        	System.out.println();
        	
        	for (int k = 0; k < N; k++) {
        		if (numberOfWins >= M) {
        			break;
        		}
        		
        		if (aliceStrategy == bobStrategy[i][k] && aliceStrategy == casinoStrategy[k]) {
        			numberOfWins++;
        		}
        		
        		if (bobStrategy[i][k] != casinoStrategy[k]) {
        			if (casinoStrategy.length % 2 == 1) {
        				aliceStrategy = casinoStrategy[k];
        			} else {
        				aliceStrategy = 1 - casinoStrategy[k];
        			}
        		} else {
        			if (casinoStrategy[k] == 1 && casinoStrategy.length % 2 == 1) {
        				aliceStrategy = 1 - casinoStrategy[k];
        			} else if (casinoStrategy[k] == 0 && casinoStrategy.length % 2 == 1) {
        				aliceStrategy = 1 - casinoStrategy[k];
        			} else {
        				aliceStrategy = casinoStrategy[k];
        			}
        		}
        	}
        	
        	if (numberOfWins < M) {
        		compatible = 0;
        		break;
        	}
        	
        	casino++;
        }
        
        System.out.println(compatible);
        
        stdin.close();
    }
}