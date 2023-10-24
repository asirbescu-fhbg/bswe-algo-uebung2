/* author: Sirbescu Amalia
 * date: 24.10.2023
 * project: uebung2
 * package: bswe.algo
 * desc:
 */

package bswe.algo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtil {

	public void addNumbersFromFile(BinaryTree binaryTree, Path path) {
		if (Files.exists(path)) {
			try {
				String line = Files.readString(path);
				String[] numbers = line.split(";");
				for (String n : numbers) {
					binaryTree.add(Integer.parseInt(n));
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

}
