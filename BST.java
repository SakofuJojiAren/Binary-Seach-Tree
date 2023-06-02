/**
 * Implementation of BST methods
 * @author Allen G. Saakov
 */


// Create a Helper Class
class Node {

    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class BST {

    Node root; // root of BST

    BST() {
        root = null;
    }

    Node insertRec(Node root, int data) {
        // insert into tree
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) // insert left child
            root.left = insertRec(root.left, data);
        else if (data > root.data) // insert right child
            root.right = insertRec(root.right, data);

        return root;
    }

    /**
     * Insert element into the tree
     * @param data element to be placed in tree
     */
    void insert(int data) {
        root = insertRec(root, data);
        System.out.println("New item inserted into tree => " +
                data);
    }

    /**
     * Postorder transversal
     * @param root root of the node
     */
    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.println(root.data);
        }
    }

    /**
     * Find the max value in the tree
     * @param node the node
     */
    static int findMax(Node node) {
        if (node == null)
            return Integer.MIN_VALUE;
        int res = node.data;
        int lres = findMax(node.left);
        int rres = findMax(node.right);
        if (lres > res)
            res = lres;
        if (rres > res)
            res = rres;
        return res;
    }

    /**
     * Preorder transversal
     * @param root the root of the node
     */
    void preorderRec(Node root) {
        if (root != null) {
            System.out.println(root.data);
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    /**
     * Inorder transversal
     * @param root the root of the node
     */
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.data);
            inorderRec(root.right);
        }
    }

    static Node deleteNode(Node root, int key) {
        if (root == null)
            return root;
        if (key > root.data) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.data) {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    /**
     * A top to down search of a binary search tree.
     * @param root the root of the node
     * @param key the key to be searched for
     */
    static boolean depthSearch(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        if (key > root.data) {
            return depthSearch(root.right, key);
        } else {
            return depthSearch(root.left, key);
        }
    }

    /**
     * Find the number of elements in the tree
     * @param node the node
     */
    static int treeCount(Node node) {
        if (node == null)
            return 0;
        return treeCount(node.left) + 1 + treeCount(node.right);
    }

    public static void main(String[] args) {

        BST tree = new BST(); // create tree object
        /* Tree operations ************************/
        // build the tree
        // insert into tree
        tree.insert(27);
        tree.insert(13);
        tree.insert(42);
        tree.insert(6);
        tree.insert(17);
        tree.insert(33);
        tree.insert(48);
        // print max element of tree
        System.out.println("\nMaximum element is " +
                tree.findMax(tree.root));
        // print postorder of tree
        System.out.println("\nPostorder -> ");
        tree.postorderRec(tree.root);
        System.out.println("\nPreorder -> ");
        tree.preorderRec(tree.root);
        System.out.println("\nInorder -> ");
        tree.inorderRec(tree.root);
        System.out.println("\nThe number of elements in the tree are ");
        System.out.println(treeCount(tree.root));
        System.out.println("\nCheck if an element is in the tree: ");
        System.out.println("\nCase where the key is in the tree");
        System.out.println(depthSearch(tree.root, 13));
        System.out.println("\nCase where the key is not in the tree");
        System.out.println(depthSearch(tree.root, 343));
        System.out.println("\nDelete");

    }

}
