package data_structures.trees;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Tree<Integer> tree = new Tree<>();

        int nodeCount = Integer.parseInt(console.nextLine());

        for (int i = 1; i < nodeCount; i++) {
            String[] nodes = console.nextLine().split(" ");

            int parent = Integer.parseInt(nodes[0]);
            int child = Integer.parseInt(nodes[1]);

            tree.fillTree(parent, child);
        }

       // tree.printTree();

        tree.getLeafNodeValues().forEach(System.out::println);

        System.out.println(tree.getSize());
    }
}
