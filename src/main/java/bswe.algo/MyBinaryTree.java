/* author: Graf Andreas, Sirbescu Amalia, Vass Viktoria
 * date: 19.10.2023
 * project: uebung2
 * package: bswe.algo
 * desc:
 */

package bswe.algo;

public class MyBinaryTree implements BinaryTree {

	Node root = null;

	@Override
	public void add(int element) {
		if (root == null) {
			root = new Node(element);
			return;
		}

		Node currentNode = root;
		boolean res = setNode(currentNode, new Node(element));
		System.out.println((res ? "Node inserted: " : "Node not inserted: ") + element);
	}

	private boolean setNode(Node currentNode, Node nodeToInsert){
		if (currentNode.getValue() == nodeToInsert.getValue()) {
			System.err.println("Node already exists");
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

	@Override
	public void remove(int element) {
		if (root == null) {
			System.out.println("The binary tree is empty, therefore can not remove an element.");
			return;
		}

		root = removeNode(root, element);
	}

	private Node removeNode(Node currentNode, int element) {
		if (currentNode == null)
			return currentNode;

		if (element < currentNode.getValue())
			currentNode.setLeft(removeNode(currentNode.getLeft(), element));
		else if (element > currentNode.getValue())
			currentNode.setRight(removeNode(currentNode.getRight(), element));
		else {
			if (currentNode.getLeft() != null && currentNode.getRight() != null) {
				Node rightNode = currentNode.getRight();
				currentNode = currentNode.getLeft();
				currentNode.setRight(rightNode);
			}
			else
				currentNode = (currentNode.getLeft() != null) ? currentNode.getLeft() : currentNode.getRight();
		}

		return currentNode;
	}

	@Override
	public void traverse(TraverseMethod method) {
		switch(method){
			case PREORDER -> preorder(root);
			case INORDER -> inorder(root);
			case POSTORDER -> postorder(root);
			case LEVEL_ORDER -> levelorder(root);
		}
	}

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

	private void levelorder(Node node) {

		int max = treeHeight(node);
		for (int i = 0; i < max; i++) {
			printLevel(root, 0, i);
		}
	}

	private void printLevel(Node node, int now, int dest){
		if(node == null) return;

		if(now == dest)
			System.out.print(node.getValue() + " ");

		printLevel(node.getLeft(), now + 1, dest);
		printLevel(node.getRight(), now + 1, dest);
	}

	public void reset(){
		root = null;
		System.out.println("BinaryTree has been deleted.");
	}

	private void postorder(Node node){
		if(node == null) return;

		postorder(node.getLeft());
		postorder(node.getRight());

		System.out.print(node.getValue() + " ");
	}

	private void inorder(Node node) {
		if(node == null) return;

		inorder(node.getLeft());

		System.out.print(node.getValue() + " ");

		inorder(node.getRight());
	}

	private void preorder(Node node) {
		if(node == null) return;

		System.out.print(node.getValue() + " ");
		preorder(node.getLeft());
		preorder(node.getRight());
	}
}
