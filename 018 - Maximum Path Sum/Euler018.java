import java.util.*;

public class Euler018 {

	/*

	Approach: This can be solved by building a tree and using a modified version of Djikstra's algorithm to find the
	"longest" path instead of the shortest path. I defined my own simple Node class to use when building the tree.

	Time complexity: The solution calculates the "path length" to each value of the triangle. Since the number of values
	in the triangle is (n*(n+1))/2, the time complexity is O(N^2)

	Space complexity: The space complexity is also O(N^2)

	 */

	class Node {

		private Node[] children;
		private int value;
		private String id;

		Node(String id, int val) {
			this.id = id;
			this.value = val;
		}
	}


	public static void main(String[] args) {
		Euler018 e018 = new Euler018();
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {

			// First build a tree of Nodes from System.in

			int n = in.nextInt();
			Node root = e018.new Node("0-0",in.nextInt());
			Node[] previousLevel = new Node[1];
			previousLevel[0] = root;

			for (int a1 = 1; a1 < n; a1++) {
				Node[] currentLevel = new Node[a1+1];
				for (int a2 = 0; a2 <= a1; a2++) {
					Node child = e018.new Node(a1 + "-" + a2,in.nextInt());
					currentLevel[a2] = child;
					if (a2 > 0) {
						previousLevel[a2-1].children = new Node[]{currentLevel[a2-1],currentLevel[a2]};
					}
				}
				previousLevel = currentLevel;
			}

			// Modified version of Djikstra's algorithm to find "longest" path

			Map<String,Integer> paths = new HashMap<>();
			Queue<Node> nodes = new LinkedList<>();
			nodes.add(root);
			paths.put(root.id, root.value);

			while(nodes.size() > 0) {
				Node currentNode = nodes.poll();
				if (currentNode.children != null) {
					for (Node child : currentNode.children) {
						int sum = paths.get(currentNode.id) + child.value;
						if (paths.containsKey(child.id)) {
							if (sum > paths.get(child.id)) paths.put(child.id, sum);
						} else {
							paths.put(child.id, sum);
						}
						nodes.add(child);
					}
				}
			}
			System.out.println(Collections.max(paths.values()));
		}
	}
}