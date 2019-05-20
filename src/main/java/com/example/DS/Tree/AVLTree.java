package com.example.DS.Tree;

//youtube video:  https://www.youtube.com/watch?v=a96JFhw5Ee4

public class AVLTree {
	class Node { 
	    int key, height; 
	    Node left, right; 
	  
	    Node(int d) { 
	        key = d; 
	        height = 1; 
	    } 
	} 
	
    Node root; 
    int height(Node root) { 
        if (root == null) 
            return 0; 
        return root.height; 
    } 
    int max(int a, int b) { 
        return (a > b) ? a : b; 
    } 
    Node rightRotate(Node root) { 
        Node x = root.left; 
        Node T2 = x.right; 
  
        // Perform rotation 
        x.right = root; 
        root.left = T2; 
  
        // Update heights 
        root.height = max(height(root.left), height(root.right)) + 1; 
        x.height = max(height(x.left), height(x.right)) + 1; 
  
        // Return new root 
        return x; 
    } 
  
    Node leftRotate(Node x) { 
        Node y = x.right; 
        Node T2 = y.left; 
  
        // Perform rotation 
        y.left = x; 
        x.right = T2; 
  
        //  Update heights 
        x.height = max(height(x.left), height(x.right)) + 1; 
        y.height = max(height(y.left), height(y.right)) + 1; 
  
        // Return new root 
        return y; 
    } 
  
    int getBalance(Node root) { 
        if (root == null) 
            return 0; 
        return height(root.left) - height(root.right); 
    } 
  
    Node insert(Node node, int key) { 
        if (node == null) 
            return (new Node(key)); 
  
        if (key < node.key) 
            node.left = insert(node.left, key); 
        else if (key > node.key) 
            node.right = insert(node.right, key); 
        else // Duplicate keys not allowed 
            return node; 
  
        node.height = 1 + max(height(node.left), 
                              height(node.right)); 
        int balance = getBalance(node); 
  
//        LL
        if (balance > 1 && key < node.left.key) 
            return rightRotate(node); 
//          RR
        if (balance < -1 && key > node.right.key) 
            return leftRotate(node); 
//        LR
        if (balance > 1 && key > node.left.key) { 
            node.left = leftRotate(node.left); 
            return rightRotate(node); 
        } 
//        RL
        if (balance < -1 && key < node.right.key) { 
            node.right = rightRotate(node.right); 
            return leftRotate(node); 
        } 
        return node; 
    } 
  
    void preOrder(Node node) { 
        if (node != null) { 
            System.out.print(node.key + " "); 
            preOrder(node.left); 
            preOrder(node.right); 
        } 
    } 
  
    public static void main(String[] args) { 
        AVLTree tree = new AVLTree(); 
  
        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 10); 
        tree.root = tree.insert(tree.root, 20); 
        tree.root = tree.insert(tree.root, 30); 
        tree.root = tree.insert(tree.root, 40); 
        tree.root = tree.insert(tree.root, 50); 
        tree.root = tree.insert(tree.root, 25); 
  
        /* The constructed AVL Tree would be 
             30 
            /  \ 
          20   40 
         /  \     \ 
        10  25    50 
        */
        System.out.println("Preorder traversal" + 
                        " of constructed tree is : "); 
        tree.preOrder(tree.root); 
    } 

}
