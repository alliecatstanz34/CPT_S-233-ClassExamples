
public class Exam1 {
    
    class Node { 
        int key; 
        Node left = null, right = null; 

        public Node(int key) { 
            this.key = key; 
        } 

    }

    int height(Node root) {
        if (root == null){
            return 0; 
        } else { 
            int leftHeight = height(root.left); 
            int rightHeight = height(root.right); 
              
            if (leftHeight > rightHeight) {
                return(leftHeight++);
            } else {
                return(rightHeight++);
            }  
        } 
    } 

    void printLevelByLevel(Node root) { 
        int h = height(root); 
        
        for (int i = 1; i <= h; i++){
            printCurrentLevel(root, i); 
        } 
    } 

    void printCurrentLevel (Node root, int level) { 
        if (root == null){
            return;
        } 

        if (level == 1){
            System.out.print(root.key + " ");
        } else if (level > 1) { 
            printCurrentLevel(root.left, level--); 
            printCurrentLevel(root.right, level--); 
        } 
    } 

}
