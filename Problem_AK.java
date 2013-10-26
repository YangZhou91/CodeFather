import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Problem_AK {
	
	static class TreeNode {
		public LinkedList<Integer> forward;
		public LinkedList<Integer> backward;
		
		public TreeNode() {
			this.forward = new LinkedList<Integer>();
			this.backward = new LinkedList<Integer>();
		}
	}

    public static void main(String[] args) {
    	Scanner stdin = new Scanner(System.in);
    	Stack<Integer> rootStack = new Stack<Integer>();
    	
    	int numOfVertice = 0;
    	if (stdin.hasNext()) {
    		numOfVertice = stdin.nextInt();
    	}
    	
    	TreeNode[] nodes = new TreeNode[numOfVertice];
    	
    	int nodeOne = 0, nodeTwo = 0;
    	
    	for (int i = 0; i < numOfVertice - 1; i++) {
    		if (stdin.hasNext()) {
    			nodeOne = stdin.nextInt();
    		}
    		
    		if (stdin.hasNext()) {
    			nodeTwo = stdin.nextInt();
    		}
    		
    		if (nodes[nodeOne - 1] == null) {
    			nodes[nodeOne - 1] = new TreeNode();
    		}
    		if (nodes[nodeTwo - 1] == null) {
    			nodes[nodeTwo - 1] = new TreeNode();
    		}
    		
    		nodes[nodeOne - 1].forward.add(new Integer(nodeTwo - 1));
    		nodes[nodeTwo - 1].backward.add(new Integer(nodeOne - 1));
    	}
    	
    	int index = 0;
    	Stack<Integer> tempStack = new Stack<Integer>();
    	for(;index < numOfVertice; index++) {
    		if (nodes[index].forward.size() >= 2) {
    			if (nodes[index].backward.size() <= 1) {
    				tempStack.add(new Integer(index));
    				continue;
    			}
    			
    			boolean flag = true;
    			for (int j = 0; j < nodes[index].forward.size(); j++) {
    				if (nodes[nodes[index].forward.get(j).intValue()].forward.size() > 0) {
    					flag = false;
    				}
    			}
    			if (flag) {
    				tempStack.add(new Integer(index));
    			}
    		}
    	}
    	
    	while (!tempStack.isEmpty()) {
    		index = tempStack.pop().intValue();
    		int cursorIndex = index;
    		boolean rootFlag = true;
    		while (index > 0 && nodes[cursorIndex].backward.size() == 1) {
    			cursorIndex = nodes[cursorIndex].backward.getFirst().intValue();
    			if (nodes[cursorIndex].forward.size() > 1) {
    				rootFlag = false;
    				break;
    			}
    		}
    		
	    	if (rootFlag) {
	    		rootStack.add(new Integer(index));
		    	
		    	while (index > 0 && nodes[index].backward.size() == 1) {
		    		index = nodes[index].backward.getFirst().intValue();
		    		rootStack.add(new Integer(index));
		    	}
	    	}
    	}
    	
    	int[] roots = new int[rootStack.size()];
    	index = 0;
    	
    	while (!rootStack.empty()) {
    		roots[index++] = rootStack.pop().intValue() + 1;
    	}
    	
    	Arrays.sort(roots);
    	
    	for (index = 0; index < roots.length; index++) {
    		System.out.println(roots[index]);
    	}
    	
    	stdin.close();
    }
    
}