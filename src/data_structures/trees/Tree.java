package data_structures.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Tree<T extends Comparable<T>> {
    private static class TreeNode<T> {
        private T value;
        private boolean hasParent;
        private List<TreeNode<T>> children;

        public TreeNode(T value) {
            if (value == null) {
                throw new IllegalArgumentException("cannot insert new value");
            }

            this.value = value;
            this.children = new ArrayList<>();
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            if (value == null) {
                throw new IllegalArgumentException("cannot insert new value");
            }

            this.value = value;
        }

        public void addChild(TreeNode<T> child) {
            if (child == null) {
                throw new IllegalArgumentException("cannot insert new value");
            }

            if (child.hasParent) {
                throw new IllegalArgumentException("The node already has a parent!");
            }

            child.hasParent = true;
            this.children.add(child);
        }

        public TreeNode<T> getChild(int index) {
            return this.children.get(index);
        }

        public int getChildrenCount() {
            return this.children.size();
        }
    }

    private TreeNode<T> root;
    private int size;

    public Tree() {
        this.root = null;
    }

    public Tree(T value) {
        if (value == null) {
            throw new IllegalArgumentException("cannot insert new value");
        }

        this.root = new TreeNode<>(value);
        this.size = 0;
    }

    @SafeVarargs
    public Tree(T value, Tree<T>... children) {
        this(value);

        for (Tree<T> child : children) {
            this.size++;
            this.root.addChild(child.root);
        }
    }

    public TreeNode<T> getRoot() {
        return this.root;
    }

    public int getSize() {
        return size;
    }

    public void fillTree(T parentVal, T childVal) {
        TreeNode<T> child = new TreeNode<>(childVal);
        child.hasParent = true;

        if (this.root == null) {
            this.root = new TreeNode<>(parentVal);
            this.root.children.add(child);
            this.size += 2;
        } else if (parentVal == root.value) {
            this.root.children.add(child);
            this.size++;
        } else {
            for (TreeNode<T> node : root.children) {
                if (node.value == parentVal) {
                    node.children.add(child);
                    this.size++;
                    break;
                }
            }
        }
    }

    private void printTreeDFS(TreeNode<T> child, String spaces) {
        if (this.root == null) {
            return;
        }

        if (child == null) {
            return;
        }

        System.out.println(spaces + child.value);
        child.children.forEach((e) -> printTreeDFS(e, spaces + "  "));
    }

    public void printTree() {
        this.printTreeDFS(this.root, "");
    }

    private List<T> getLeafNodeValues(TreeNode<T> child, List<T> leafs) {
        if (child == null) {
            return leafs;
        }

        if (child.hasParent && child.children.size() == 0) {
            leafs.add(child.value);
        }

        child.children.forEach(e -> getLeafNodeValues(e, leafs));

        return leafs;
    }

    public List<T> getLeafNodeValues() {
        return this.getLeafNodeValues(this.root, new ArrayList<>())
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
