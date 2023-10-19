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
		Node node = new Node(element);
		if (root == null) {
			root = node;
		}

		if (node.getValue() == root.getValue()) {
			System.err.println("Node already exists");
		} else if (node.getValue() < root.getValue()) {
			root.setLeft(node);
		} else {
			root.setRight(node);
		}


	}

	@Override
	public void remove(int element) {

	}

	@Override
	public void traverse(TraverseMethod method) {

	}
}
