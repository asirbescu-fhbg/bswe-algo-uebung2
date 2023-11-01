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
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;

public class InputHandler {

	Scanner scanner = new Scanner(System.in);

	/**
	 * Reads the file from the given path and adds them to the binary tree object.
	 * @param binaryTree The binary tree object.
	 * @param path The path of the file to read.
	 * @return True if the file has been read successfully, otherwise false.
	 */
	public boolean addNumbersFromFile(BinaryTree binaryTree, Path path) {
		boolean res = true;
		if (Files.exists(path)) {
			try {
				String line = Files.readString(path);
				String[] numbers = line.split(";");
				if(numbers.length < 1){
					System.err.println("The file is empty.");
					res = false;
				}

				for (String n : numbers) {
					binaryTree.add(Integer.parseInt(n));
				}
			} catch (IOException e) {
				System.err.println("An Exception occured while reading the file: " + path);
				res = false;
			}
		}

		return res;
	}

	/**
	 * Asks the user to input numbers for adding or removing to binary tree.
	 * @param binaryTree The binary tree object.
	 * @param add True if the numbers should be added to the tree.
	 *            False if the numbers should be removed from the tree.
	 */
	public void addOrRemoveNumbersFromUserInput(BinaryTree binaryTree, boolean add) {
		String menu = """
		Please enter a number you want to add to the binary tree.
		When finished, enter "exit"
		""";
		if(!add)
			menu = menu.replace("add to", "remove from");

		System.out.println(menu);
		int input = 0;
		while (!scanner.hasNext("exit")) {
			if (scanner.hasNextInt()) {
				input = scanner.nextInt();

				if (add)
					binaryTree.add(input);
				else
					binaryTree.remove(input);
			} else {
				System.out.println("Please enter a number or exit");
			}
			scanner.nextLine();
		}
		scanner.nextLine();
	}

	/**
	 *  Creates a new Binary Tree.
	 * 	Asks the User for the input method.
	 * @return The created binary tree object.
	 */
	public MyBinaryTree createBinaryTree() {
		MyBinaryTree binaryTree = new MyBinaryTree();

		String menuInput = """
					Please select an input method:
							
					1 ... Read numbers from file
					2 ... Manual entry of numbers
					9 ... Exit
				""";

		boolean keepAsking = true;
		while (keepAsking) {
			System.out.println(menuInput);
			String choice = scanner.nextLine();

			switch (choice) {
				case "1" -> {
					Path path = Paths.get("src/main" +
							"/resources", "numbers.csv");

					if (!addNumbersFromFile(binaryTree, path))
						continue;

					System.out.println("Read numbers from File: " + path + "\n");

					keepAsking = false;
				}
				case "2" -> {
					addOrRemoveNumbersFromUserInput(binaryTree, true);
					keepAsking = false;
				}
				case "9" -> {
					System.out.println("Closing Application ...");
					System.exit(0);
				}
				default -> System.err.println("Not a valid choice. Try again ...");
			}
		}

		return binaryTree;
	}

}
