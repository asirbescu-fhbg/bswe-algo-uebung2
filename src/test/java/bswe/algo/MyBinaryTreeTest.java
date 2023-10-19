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
		binaryTree.add(14);
		binaryTree.add(18);
		binaryTree.add(11);
		binaryTree.add(8);
		binaryTree.add(5);
		binaryTree.add(2);

		binaryTree.remove(11);
		binaryTree.remove(2);
	}

	@Test
	void traverse() {
	}
}