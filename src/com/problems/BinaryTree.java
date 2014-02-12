package com.problems;

/**
 * Created by Sundar on 2/10/14.
 */
public class BinaryTree {

    public interface Node {
        Node getLeftChild();
        Node getRightChild();
        int getValue();
    }

    boolean isBinary = false;

    public boolean isBinarySearchTree(Node n){
        if(n != null){
            if(n.getLeftChild() != null && n.getRightChild() != null){
                if(n.getLeftChild().getValue() < n.getValue() && n.getValue() > n.getRightChild().getValue()){
                    isBinary = false;
                } else {
                    isBinary = isBinarySearchTree(n.getLeftChild()) && isBinarySearchTree(n.getRightChild());;
                }
            }
        }
        return isBinary;
    }

}
