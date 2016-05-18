package com.chen.algorithm;

/**
 * 选择排序：执行完一次内for循环后最小的一个数放在了数组的最前面。
 * 每一趟从待排序的数据元素中选出最小（或最大）的一个元素，顺序放在已排好序的数列的最后，直到全部待排序的数据元素排完
 * @author chenguoquan
 *
 */
public class SelectSort {
	
	public static void main(String[] args) {
		 Integer[] intgArr = { 5, 9, 1, 0, 4, 2, -6, 3, 8, 0, 76, -7, 7, 11, 12,
	                19, 8, 9, 10, 28, 53 };
		 SelectSort intgArrSelectSort=new SelectSort();
		 intgArrSelectSort.select(intgArr);
		 for(Integer intObj:intgArr){
			 System.out.println(intObj+"---------");
		 }
	}

	private void select(Integer[] array) {
		int minIndex;
		for(int i=0;i<array.length;i++){
			minIndex=i;
			for(int j=i+1;j<array.length;j++){
				if(array[j].compareTo(array[minIndex])<0){
					minIndex=j;
				}
			}
			swap(array,i,minIndex);
		}
		
	}

	private void swap(Integer[] intgArr, int x, int y) {
		int temp;
        temp = intgArr[x];
        intgArr[x] = intgArr[y];
        intgArr[y] = temp;
		
	}

}
