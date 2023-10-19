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
			System.out.println("Root node is null");
			return;
		}

		Node currentNode = root;
		boolean res = removeNode(currentNode, new Node(element));
		System.out.println((res ? "Node removed: " : "Node not removed: ") + element);
	}

	private boolean removeNode(Node currentNode, Node nodeToRemove){
		if (currentNode.getValue() == nodeToRemove.getValue()) {
			if(currentNode.getLeft() != null)
				currentNode = currentNode.getLeft();
			else if (currentNode.getRight() != null)
				currentNode = currentNode.getRight();
			else
				currentNode = null;

			return true;
		}

		if (currentNode.getValue() > nodeToRemove.getValue()) {
			return removeNode(currentNode.getLeft() != null ? currentNode.getLeft() : currentNode.getRight(), nodeToRemove);
		} else {
			return removeNode(currentNode.getRight() != null ? currentNode.getRight() : currentNode.getLeft(), nodeToRemove);
		}
	}

	@Override
	public void traverse(TraverseMethod method) {

	}
}
