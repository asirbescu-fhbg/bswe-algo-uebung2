/* author: Graf Andreas, Sirbescu Amalia, Vass Viktoria
 * date: 19.10.2023
 * project: uebung2
 * package: bswe.algo
 * desc:
 */

package bswe.algo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {

	private int value;
	private Node left;
	private Node right;

	public Node(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
}
