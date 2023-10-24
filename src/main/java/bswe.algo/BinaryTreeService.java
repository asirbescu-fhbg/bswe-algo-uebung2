/* author: Graf Andreas, Sirbescu Amalia, Vass Viktoria
 * date: 19.10.2023
 * project: uebung2
 * package: bswe.algo
 * desc:
 */

package bswe.algo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BinaryTreeService {

	public static void main(String[] args) {

		MyBinaryTree binaryTree = new MyBinaryTree();

		Path path = Paths.get("src/main" +
				"/resources", "numbers.csv");

		FileUtil fu = new FileUtil();
		fu.addNumbersFromFile(binaryTree, path);

		binaryTree.traverse(TraverseMethod.INORDER);

	}

}
