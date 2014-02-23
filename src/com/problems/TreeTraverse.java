/**
 * 
 */
package com.problems;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * @author sivasubb
 *
 */
public class TreeTraverse {
	
	interface Node{
		int getValue();
        List<Node> getChildren();
	}

	public static void BreadthFirst(Node n){
		Queue<Node> nodes = new ArrayDeque<Node>();
		nodes.add(n);
		
		while(nodes.peek() != null){
			Node c = nodes.poll();
			List<Node> children = c.getChildren();
			for(Node ch : children){
				nodes.add(ch);
			}
		}
	}

	public static void main(String[] args) {

	}

}
