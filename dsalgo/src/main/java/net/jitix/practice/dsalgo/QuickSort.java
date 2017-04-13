package net.jitix.practice.dsalgo;

public class QuickSort<T extends Comparable<T>> {

	public T[] sort(T[] array){
		int pivotPos=getPivotPos(array.length);
		
		rearrange(array,pivotPos);
		
		return array;
	}
	
	private int getPivotPos(int arrLen){
		if(arrLen>0){
			return arrLen-1;
		}
		else{
			return 0;
		}
	}
	
	private void rearrange(T[] array,int pivotPos){
		for(int currPos=0;currPos<array.length;currPos++){
			if(array[currPos].compareTo(array[pivotPos])>1){
				swap(array,currPos,pivotPos);
			}
		}
	}
	
	private void swap(T[] array,int pos1,int pos2){
		T temp=array[pos1];
		array[pos1]=array[pos2];
		array[pos2]=temp;
	}
}
