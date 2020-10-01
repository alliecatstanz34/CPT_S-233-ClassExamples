public class AVLTree {

    public class Node {
        int key;
        int height;
        Node left;
        Node right;

        Node(int key) {
            this.key = key;
        }
    }

    private Node root;

    public Node find(int key) {
        Node current = root;
        while (current != null) {
            if (current.key == key) {
               break;
            }
            current = current.key < key ? current.right : current.left;
        }
        return current;
    }

    public Node getRoot() {
        return root;
    }

    public int height() {
        return root == null ? -1 : root.height; //short hand for if else ? if true : if false
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    //recursive utility function of instert 
    private Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        } else if (node.key > key) {
            node.left = insert(node.left, key);
        } else if (node.key < key) {
            node.right = insert(node.right, key);
        } else {
            throw new RuntimeException("duplicate Key!");
        }
        return rebalance(node);
    }

    public void delete(int key) {
        //root = delete(root, key); not written yet 
    }

    //introduce delete 
    // private Node delete(Node node, int key) {
     
    // }

    // private Node mostLeftChild(Node node) {
       

    // }
    
    // AVL COMPONENTS

    private Node rebalance(Node z) {

        updateHeight(z);

        int balance = getBalance(z);
        
        if(balance > 1){
            if(height(z.right.right) > height(z.right.left)){
                z = rotateLeft(z);
            } else {
                z.right = rotateRight(z.right);
                z = rotateLeft(z);
            }
        } else if (balance < -1){
            if (height(z.left.left) > height(z.left.right)){
                z = rotateRight(z);
            } else {
                z.left = rotateLeft(z.left);
                z = rotateRight(z);
            }
        }

        return z;

    }

    private Node rotateRight(Node y) {
       
        Node x = y.left; 
        Node z = x.right; 
        x.right = y;
        y.left = z;

        updateHeight(y);
        updateHeight(x);

        return x;

    }

    private Node rotateLeft(Node y) {
        
        Node x = y.right;
        Node z = x.left;
        x.left = y;
        y.right = z;

        updateHeight(y);
        updateHeight(x);

        return x;

    }

    private void updateHeight(Node n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    private int height(Node n) {
        return n == null ? -1 : n.height;
    }

    public int getBalance(Node n) {
        return (n == null) ? 0 : height(n.right) - height(n.left);
    }

    //Traversal functions
    
    private void inorderRec(Node root) 
    { 
        if (root != null) 
        { 
            inorderRec(root.left); 
            System.out.print(root.key + " "); 
            inorderRec(root.right); 
        } 
    } 
    
    void inorder() 
    { 
        inorderRec(root); 
    } 

     // Driver Program to test above functions 
    public static void main(String[] args) 
    { 
        AVLTree tree = new AVLTree(); 

        /* Let us create following BST 
            50 
        /    \ 
        30   70 
        / \ / \ 
        20 40 60 80 */
        tree.insert(40); 
        tree.insert(20); 
        tree.insert(10); 
        tree.insert(25); 
        tree.insert(30); 
        tree.insert(22); 
        tree.insert(50); 

        System.out.println("Inorder traversal of the given tree"); 
        tree.inorder(); 
     

    } 




}