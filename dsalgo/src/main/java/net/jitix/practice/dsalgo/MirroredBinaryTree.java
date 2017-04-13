package net.jitix.practice.dsalgo;

import java.util.Queue;
import java.util.Stack;

import net.jitix.practice.dsalgo.common.BTreeNode;

public class MirroredBinaryTree<T extends Comparable<T>> {

	public boolean isMirrored(BTreeNode<T> root){
		int level=0;
		
		
		
		
		return false;
	}
	
	private boolean traverseBreadthFirst(int level, Queue<BTreeNode<T>> bfsQueue){
		if(bfsQueue.isEmpty()){
			return true;
		}
		else{
			//expand the current elements
			expandCurrentElements(level,bfsQueue);
			
			//for the given level check if there are that many repeated sequences of size level
			if(!checkRepeatedSequence(level,bfsQueue)){
				return false;
			}
			else{
				return traverseBreadthFirst(level+1, bfsQueue);
			}
		}
	}
	
	private void expandCurrentElements(int level,Queue<BTreeNode<T>> bfsQueue) {
		int numElements=level*2;
		while(bfsQueue.peek()!=null && numElements>0){
			BTreeNode<T> element=bfsQueue.poll();
			if(element.getLeft()!=null){
				bfsQueue.offer(element.getLeft());
			}
			if(element.getRight()!=null){
				bfsQueue.offer(element.getRight());
			}
			numElements--;
		}
	}

	private boolean checkRepeatedSequence(int size, Queue<BTreeNode<T>> queue){
		Stack<BTreeNode<T>> stk=new Stack<>(); 
		for(int i=0;i<size;i++){
			stk.push(queue.poll());
		}
		for(int i=0;i<size;i++){
			if(!stk.pop().equals(queue.poll())){
				return false;
			}
		}
		return true;
	}
	
}
