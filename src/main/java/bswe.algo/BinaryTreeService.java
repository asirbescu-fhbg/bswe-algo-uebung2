/* author: Graf Andreas, Sirbescu Amalia, Vass Viktoria
 * date: 19.10.2023
 * project: uebung2
 * package: bswe.algo
 * desc:
 */

package bswe.algo;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class BinaryTreeService {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		InputHandler inputHandler = new InputHandler();
		MyBinaryTree binaryTree = inputHandler.createBinaryTree();

		boolean keepAsking = true;
		while (keepAsking) {

			String menuTraverse = "\n\n" + """
					Please select an option:
					
					1 - PREORDER
					2 - INORDER
					3 - POSTORDER
					4 - LEVEL_ORDER
					5 - REMOVE ELEMENT
					6 - NEW BINARY-TREE
					7 - EXIT
					""";
			System.out.println(menuTraverse);
			String traverseChoice = scanner.nextLine();
			switch (traverseChoice) {
				case "1" -> binaryTree.traverse(TraverseMethod.PREORDER);
				case "2" -> binaryTree.traverse(TraverseMethod.INORDER);
				case "3" -> binaryTree.traverse(TraverseMethod.POSTORDER);
				case "4" -> binaryTree.traverse(TraverseMethod.LEVEL_ORDER);
				case "5" -> inputHandler.addOrRemoveNumbersFromUserInput(binaryTree, false);
				case "6" -> binaryTree = inputHandler.createBinaryTree();
				case "7" -> keepAsking = false;
				default -> System.err.println("Invalid choice: " + traverseChoice + " - Try again ...");
			}
		}

		System.out.println("Closing Application ...");
	}
}
