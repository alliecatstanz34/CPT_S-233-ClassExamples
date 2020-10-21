// Red Black Tree implementation in Java
// Author: Algorithm Tutor
// Tutorial URL: https://algorithmtutor.com/Data-Structures/Tree/Red-Black-Trees/

// data structure that represents a node in the tree
class Node {
    int data; // holds the key
    Node parent; // pointer to the parent
    Node left; // pointer to left child
    Node right; // pointer to right child
    int color; // 1 . Red, 0 . Black
}


// class RedBlackTree implements the operations in Red Black Tree
public class RedBlackTree {
    private Node root;
    private Node TNULL;

    private void preOrderHelper(Node node) {
        if (node != TNULL) {
            System.out.print(node.data + " ");
            preOrderHelper(node.left);
            preOrderHelper(node.right);
        } 
    }

    private void inOrderHelper(Node node) {
        if (node != TNULL) {
            inOrderHelper(node.left);
            System.out.print(node.data + " ");
            inOrderHelper(node.right);
        } 
    }

    private void postOrderHelper(Node node) {
        if (node != TNULL) {
            postOrderHelper(node.left);
            postOrderHelper(node.right);
            System.out.print(node.data + " ");
        } 
    }

    private Node searchTreeHelper(Node node, int key) {
        if (node == TNULL || key == node.data) {
            return node;
        }

        if (key < node.data) {
            return searchTreeHelper(node.left, key);
        } 
        return searchTreeHelper(node.right, key);
    }

    // fix the rb tree modified by the delete operation
    private void fixDelete(Node x) {
    
    }


    private void rbTransplant(Node u, Node v){
        if (u.parent == null) {
            root = v;
        } else if (u == u.parent.left){
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        v.parent = u.parent;
    }

    private void deleteNodeHelper(Node node, int key) {
        // find the node containing key
    
    }
  
  // fix the red-black tree
  private void fixInsert(Node k){
    Node u;
    while (k.parent.color == 1) { //violation of property #3
        if (k.parent == k.parent.parent.right) { // IF THERE IS A TRIANGLE FORMATION
            u = k.parent.parent.left; // uncle
            if (u.color == 1) { // uncle is red
                // case 3.1
                u.color = 0;
                k.parent.color = 0;
                k.parent.parent.color = 1;
                k = k.parent.parent;
            } else {                    //u is black
                if (k == k.parent.left) { // node is a left child 
                    // case 3.2.2
                    k = k.parent;
                    rightRotate(k);
                }
                // case 3.2.1           // node is a right child
                k.parent.color = 0;
                k.parent.parent.color = 1;
                leftRotate(k.parent.parent);
            }
        } else {
            u = k.parent.parent.right; // uncle

            if (u.color == 1) {
                // mirror case 3.1
                u.color = 0;
                k.parent.color = 0;
                k.parent.parent.color = 1;
                k = k.parent.parent;  
            } else {
                if (k == k.parent.right) {
                    // mirror case 3.2.2 -- Triangle formation 
                    k = k.parent;
                    leftRotate(k);
                }
                // mirror case 3.2.1 -- Line formation 
                k.parent.color = 0;
                k.parent.parent.color = 1;
                rightRotate(k.parent.parent);
            }
        }
        if (k == root) {
            break;
        }
    }
    root.color = 0;
  }

  private void printHelper(Node root, String indent, boolean last) {
        // print the tree structure on the screen
        if (root != TNULL) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "     ";
            } else {
                System.out.print("L----");
                indent += "|    ";
            }
                
            String sColor = root.color == 1?"RED":"BLACK";
            System.out.println(root.data + "(" + sColor + ")");
            printHelper(root.left, indent, false);
            printHelper(root.right, indent, true);
        }
  }

  //constructor

  public RedBlackTree() {
    TNULL = new Node();
    TNULL.color = 0;
    TNULL.left = null;
    TNULL.right = null;
    root = TNULL;
  }

  // Pre-Order traversal
  // Node.Left Subtree.Right Subtree
  public void preorder() {
    preOrderHelper(this.root);
  }

  // In-Order traversal
  // Left Subtree . Node . Right Subtree
  public void inorder() {
    inOrderHelper(this.root);
  }

  // Post-Order traversal
  // Left Subtree . Right Subtree . Node
  public void postorder() {
    postOrderHelper(this.root);
  }

  // search the tree for the key k
  // and return the corresponding node
  public Node searchTree(int k) {
    return searchTreeHelper(this.root, k);
  }

  // find the node with the minimum key
  public Node minimum(Node node) {
    while (node.left != TNULL) {
      node = node.left;
    }
    return node;
  }

  // find the node with the maximum key
  public Node maximum(Node node) {
    while (node.right != TNULL) {
      node = node.right;
    }
    return node;
  }

  // find the successor of a given node
  public Node successor(Node x) {
    // if the right subtree is not null,
    // the successor is the leftmost node in the
    // right subtree
    if (x.right != TNULL) {
      return minimum(x.right);
    }

    // else it is the lowest ancestor of x whose
    // left child is also an ancestor of x.
    Node y = x.parent;
    while (y != TNULL && x == y.right) {
      x = y;
      y = y.parent;
    }
    return y;
  }

  // find the predecessor of a given node
  public Node predecessor(Node x) {
    // if the left subtree is not null,
    // the predecessor is the rightmost node in the 
    // left subtree
    if (x.left != TNULL) {
      return maximum(x.left);
    }

    Node y = x.parent;
    while (y != TNULL && x == y.left) {
      x = y;
      y = y.parent;
    }

    return y;
  }

  // rotate left at node x
  public void leftRotate(Node x) {
    Node y = x.right;
    x.right = y.left;
    if (y.left != TNULL) {
      y.left.parent = x;
    }
    y.parent = x.parent;
    if (x.parent == null) {
      this.root = y;
    } else if (x == x.parent.left) {
      x.parent.left = y;
    } else {
      x.parent.right = y;
    }
    y.left = x;
    x.parent = y;
  }

  // rotate right at node x
  public void rightRotate(Node x) {
    Node y = x.left;
    x.left = y.right;
    if (y.right != TNULL) {
      y.right.parent = x;
    }
    y.parent = x.parent;
    if (x.parent == null) {
      this.root = y;
    } else if (x == x.parent.right) {
      x.parent.right = y;
    } else {
      x.parent.left = y;
    }
    y.right = x;
    x.parent = y;
  }

  // insert the key to the tree in its appropriate position
  // and fix the tree
  public void insert(int key) {

    // Ordinary Binary Search Insertion
    Node node = new Node();
    node.parent = null;
    node.data = key;
    node.left = TNULL;
    node.right = TNULL;
    node.color = 1; // new node must be red

    Node prev = null;
    Node current= this.root;

    while (current != TNULL) {
        prev = current;
      if (node.data < current.data) {
        current = current.left;
      } else {
        current = current.right;
      }
    }

    // y is parent of x
    node.parent = prev;
    if (prev == null) {
      root = node;
    } else if (node.data < prev.data) {
        prev.left = node;
    } else {
        prev.right = node;
    }

    // if new node is a root node, simply return
    if (node.parent == null){
      node.color = 0;
      return;
    }

    // if the grandparent is null, simply return
    if (node.parent.parent == null) {
      return;
    }

    // Fix the tree
    fixInsert(node);
  }

  public Node getRoot(){
    return this.root;
  }

  // delete the node from the tree
  public void deleteNode(int data) {
    deleteNodeHelper(this.root, data);
  }

  // print the tree structure on the screen
  public void prettyPrint() {
        printHelper(this.root, "", true);
  }
  
  public static void main(String [] args){
      RedBlackTree bst = new RedBlackTree();
        bst.insert(8);
      bst.insert(18);
      bst.insert(5);
      bst.insert(15);
      bst.insert(17);
      bst.insert(25);
      bst.insert(40);
      bst.insert(80);
      bst.deleteNode(25);
      bst.prettyPrint();
  }
}