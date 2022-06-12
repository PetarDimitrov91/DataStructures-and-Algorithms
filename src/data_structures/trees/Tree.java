package data_structures.trees;

import java.util.ArrayList;
import java.util.List;

public class Tree<T> {
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
    }

    private TreeNode<T> root;
}
