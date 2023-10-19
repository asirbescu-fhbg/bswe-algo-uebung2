/* author: Graf Andreas, Sirbescu Amalia, Vass Viktoria
 * date: 19.10.2023
 * project: uebung2
 * package: bswe.algo
 * desc:
 */

package bswe.algo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MyBinaryTreeTest {

	@Test
	void add() {
		BinaryTree binaryTree = new MyBinaryTree();
		binaryTree.add(12);
		binaryTree.add(14);
		binaryTree.add(18);
		binaryTree.add(11);
		binaryTree.add(11);
		binaryTree.add(8);
		binaryTree.add(5);
		binaryTree.add(2);
	}

	@Test
	void remove() {
		BinaryTree binaryTree = new MyBinaryTree();
		binaryTree.add(12);
		binaryTree.add(16);
		binaryTree.add(18);
		binaryTree.add(20);
		binaryTree.add(15);
		binaryTree.add(14);
		binaryTree.add(13);
		binaryTree.add(8);
		binaryTree.add(5);
		binaryTree.add(2);

		binaryTree.remove(16);
		binaryTree.remove(2);
	}

	@Test
	void traverse() {
		BinaryTree binaryTree = new MyBinaryTree();
		binaryTree.add(12);
		binaryTree.add(16);
		binaryTree.add(18);
		binaryTree.add(20);
		binaryTree.add(15);
		binaryTree.add(14);
		binaryTree.add(13);
		binaryTree.add(22);
		binaryTree.add(24);
		binaryTree.add(17);
		binaryTree.add(18);
		binaryTree.add(8);
		binaryTree.add(7);
		binaryTree.add(8);
		binaryTree.add(3);
		binaryTree.add(5);
		binaryTree.add(2);

		binaryTree.traverse(TraverseMethod.PREORDER);
	}
}