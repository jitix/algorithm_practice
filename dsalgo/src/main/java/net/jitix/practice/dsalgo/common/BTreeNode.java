package net.jitix.practice.dsalgo.common;

public class BTreeNode<T extends Comparable<T>> {

	private T data;
	private BTreeNode<T> left;
	private BTreeNode<T> right;

	public BTreeNode(T data, BTreeNode<T> left, BTreeNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(BTreeNode<T> left) {
		this.left = left;
	}

	public BTreeNode<T> getRight() {
		return right;
	}

	public void setRight(BTreeNode<T> right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "BTreeNode [data=" + data + ", left=" + left + ", right=" + right + "]";
	}

}
