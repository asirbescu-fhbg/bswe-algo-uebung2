/* author: Graf Andreas, Sirbescu Amalia, Vass Viktoria
 * date: 19.10.2023
 * project: uebung2
 * package: bswe.algo
 * desc:
 */

package bswe.algo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.io.PrintStream;

class MyBinaryTreeTest {

	static BinaryTree binaryTree = new MyBinaryTree();

	@BeforeEach
	 void setup(){
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

		System.setOut(new PrintStream(TestHelper.outputStreamCaptor));
		System.setErr(new PrintStream(TestHelper.outputStreamCaptor));
	}

	@AfterEach
	void cleanup(){
		if(binaryTree instanceof MyBinaryTree tree)
			tree.reset();

		System.setIn(TestHelper.backupSysIn);
		System.setOut(TestHelper.backupSysOut);
		TestHelper.outputStreamCaptor.reset(); // clear the outputstream
	}

	@Test
	void add() {
		binaryTree.traverse(TraverseMethod.INORDER);

		String outputBefore = TestHelper.outputStreamCaptor.toString();
		Assertions.assertTrue(outputBefore.contains("2 3 5 7 8 12 13 14 15 16 17 18 20 22 24"));

		binaryTree.add(37);
		binaryTree.add(1);

		binaryTree.traverse(TraverseMethod.INORDER);

		String outputAfter = TestHelper.outputStreamCaptor.toString();
		Assertions.assertTrue(outputAfter.contains("1 2 3 5 7 8 12 13 14 15 16 17 18 20 22 24 37"));

	}

	@Test
	void remove() {
		binaryTree.remove(16);
		binaryTree.remove(2);
	}

	@Test
	void preorder() {
		binaryTree.traverse(TraverseMethod.PREORDER);
	}

	@Test
	void inorder() {
		binaryTree.traverse(TraverseMethod.INORDER);
	}

	@Test
	void levelorder() {
		binaryTree.traverse(TraverseMethod.LEVEL_ORDER);
		String output = TestHelper.outputStreamCaptor.toString();
		Assertions.assertTrue(output.contains("12 8 16 7 15 18 3 14 17 20 2 5 13 22 24 "));
	}
}