/* author: Graf Andreas, Sirbescu Amalia, Vass Viktoria
 * date: 19.10.2023
 * project: uebung2
 * package: bswe.algo
 * desc:
 */

package bswe.algo;

public class MyBinaryTree implements BinaryTree {

	Node root = null;

	/**
	 * Creates a new instance of the MyBinaryTree class.
	 */
	public MyBinaryTree(){}

	/**
	 * Adds the given element to the binary tree.
	 * @param element The element to add.
	 */
	@Override
	public void add(int element) {
		if (root == null) {
			root = new Node(element);
			System.out.println("Root node created: " + element);

			return;
		}

		Node currentNode = root;
		boolean res = setNode(currentNode, new Node(element));
		System.out.println((res ? "Node inserted: " : "Node not inserted: ") + element);
	}

	/**
	 * Sets a node in the binary tree based on its value.
	 * This is a private helper method that recursively finds the appropriate
	 * position for inserting the element into the tree and inserts it.
	 *
	 * @param currentNode The current node being considered.
	 * @param nodeToInsert The node to be inserted.
	 * @return True if the node is successfully inserted, false if it already exists.
	 */
	private boolean setNode(Node currentNode, Node nodeToInsert){
		if (currentNode.getValue() == nodeToInsert.getValue()) {
			System.out.println("Node already exists");
			return false;
		}

		if (currentNode.getValue() > nodeToInsert.getValue()) {
			if(currentNode.getLeft() == null)
				currentNode.setLeft(nodeToInsert);
			else
				return setNode(currentNode.getLeft(), nodeToInsert);
		} else {
			if(currentNode.getRight() == null)
				currentNode.setRight(nodeToInsert);
			else
				return setNode(currentNode.getRight(), nodeToInsert);
		}

		return true;
	}

	/**
	 * Removes the given element from the Binary Tree.
	 * @param element The element to remove.
	 */
	@Override
	public void remove(int element) {
		if (root == null) {
			System.out.println("The binary tree is empty, therefore can not remove an element.");
			return;
		}

		root = removeNode(root, element);
	}

	/**
	 * Removes a specified element from the binary tree.
	 * This is a private helper method that recursively searches for and
	 * removes the specified element from the tree.
	 *
	 * @param currentNode The current node being considered.
	 * @param element The element to be removed.
	 * @return The modified node structure after removal.
	 */
	private Node removeNode(Node currentNode, int element) {
		if (currentNode == null)
			return currentNode;

		if (element < currentNode.getValue())
			currentNode.setLeft(removeNode(currentNode.getLeft(), element));
		else if (element > currentNode.getValue())
			currentNode.setRight(removeNode(currentNode.getRight(), element));

		/** If the element is neither smaller nor greater than the currentNode,
		 * then we have found the element to be removed. */
		else {
			// checks if the currentNode (= element) has two children and sets the currentNode to its left subtree
			// and sets the right subtree of the NEW currentNode to the original rightNode
			if (currentNode.getLeft() != null && currentNode.getRight() != null) {
				Node rightNode = currentNode.getRight();
				currentNode = currentNode.getLeft();
				currentNode.setRight(rightNode);
			}
			else
				// if there is a child, then NEW currentNode = the value of its child, else null
				currentNode = (currentNode.getLeft() != null) ? currentNode.getLeft() : currentNode.getRight();

			System.out.println("Successfully removed element: " + element);
		}

		return currentNode;
	}

	/**
	 * Output the numbers following the given traverse method.
	 * @param method The traverse method to use.
	 */
	@Override
	public void traverse(TraverseMethod method) {
		switch(method){
			case PREORDER -> preorder(root);
			case INORDER -> inorder(root);
			case POSTORDER -> postorder(root);
			case LEVEL_ORDER -> levelorder(root);
		}
	}

	/**
	 * Calculates the height of the current binary tree.
	 * @param node The root node.
	 * @return Returns the height of the tree.
	 */
	private int treeHeight(Node node) {
		if (node == null) {
			return 0;
		} else {
			int lh = treeHeight(node.getLeft());
			int rh = treeHeight(node.getRight());

			if (lh > rh) {
				return (lh + 1);
			} else {
				return (rh + 1);
			}
		}
	}

	/**
	 * Prints the binary tree following the level order traverse method.
	 * @param node The root node.
	 */
	private void levelorder(Node node) {

		int max = treeHeight(node);
		for (int i = 0; i < max; i++) {
			printLevel(root, 0, i);
		}
	}

	/**
	 * Prints the nodes at a specific level of the binary tree.
	 * This method recursively traverses the tree to find and print nodes at the specified level.
	 *
	 * @param node The current node being considered.
	 * @param now  The current level of the node.
	 * @param dest The target level to print nodes.
	 */
	private void printLevel(Node node, int now, int dest){
		if(node == null) return;

		if(now == dest)
			System.out.print(node.getValue() + " ");

		if(now < dest) {
		printLevel(node.getLeft(), now + 1, dest);
		printLevel(node.getRight(), now + 1, dest);
		}
	}

	/**
	 * Sets the root node of the binary tree to null and therefore resets the tree.
	 */
	public void reset(){
		root = null;
		System.out.println("BinaryTree has been deleted.");
	}

	/**
	 * Prints the tree following the post order traverse method.
	 * @param node The root node.
	 */
	private void postorder(Node node){
		if(node == null) return;

		postorder(node.getLeft());
		postorder(node.getRight());

		System.out.print(node.getValue() + " ");
	}

	/**
	 * Prints the tree following the inorder traverse method.
	 * @param node The root node.
	 */
	private void inorder(Node node) {
		if(node == null) return;

		inorder(node.getLeft());

		System.out.print(node.getValue() + " ");

		inorder(node.getRight());
	}

	/**
	 * Prints the tree following the preorder traverse method.
	 * @param node The root node.
	 */
	private void preorder(Node node) {
		if(node == null) return;

		System.out.print(node.getValue() + " ");
		preorder(node.getLeft());
		preorder(node.getRight());
	}
}
