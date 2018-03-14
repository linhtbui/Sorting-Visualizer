package edu.grinnell.sortingvisualizer.sorts;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.grinnell.sortingvisualizer.events.SortEvent;

public class Sorts {

	public static <T extends Comparable<T>> void selectionSort(T[] arr) {
		for(int i=0; i<arr.length; i++) {
			T min = arr[i];
			for(int j=i; j<arr.length; j++) {
				if(arr[j].compareTo(min) < 0) {
					T temp = min;
					min = arr[j];
					arr[j] = temp;
				}
			}
			arr[i] = min;
		}
	}

	public static <T extends Comparable<T>> void insertionSort(T[] arr) {
		for(int i = 1; i<arr.length; i++) {
			for(int j = i; j > 0 && (arr[j-1].compareTo(arr[j]) > 0); j--) {
				T temp = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = temp;
			}
		}
	}

	public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
		int swaps = -1;
		while(swaps != 0) {
			swaps = 0;	
			for(int i=1; i<arr.length; i++) {
				if(arr[i-1].compareTo(arr[i]) > 0) {
					T temp = arr[i];
					arr[i] = arr[i-1];
					arr[i-1] = temp;
					swaps++;
				}
			}
		}
	}

	private static <T extends Comparable<T>> void merge(T[] arr, int lo, int mid, int hi) {

		if (lo == mid) {
			return;
		} else {
			// merge sort the two halves
			merge(arr, lo, (lo + mid) / 2, mid);
			merge(arr, mid, (mid + hi) / 2, hi);

			// merge the two halves
			ArrayList<T> auxArr = new ArrayList<>();
			int first  = lo;
			int second = mid;

			while (first < mid || second < hi) {

				if(first < mid && second >= hi) {
					auxArr.add(arr[first]);
					first++;
				} else if(first >= mid && second < hi) {
					auxArr.add(arr[second]);
					second++;
				} else if(arr[first].compareTo(arr[second]) < 0) {
					auxArr.add(arr[first]);
					first++;
				} else {
					auxArr.add(arr[second]);
					second++;
				} 
			}
			for(int i=0; i<hi-lo; i++) {
				arr[i+lo] = auxArr.get(i);
			}
		}



	}

	public static <T extends Comparable<T>> void mergeSort(T[] arr) {
		merge(arr, 0, (arr.length) / 2, arr.length);
	}

	/**Determine the pivot by taking the median of the first, middle, and last element
	 * Guarantees that we will not choose the worst-case pivot
	 * @param arr
	 * @param low
	 * @param high
	 * @return pivot, an integer position within the array
	 */
	/*
	public static <T extends Comparable<T>> int findPivot(T[] arr, int low, int high) {
		int mid = (high-low) /2;
		T first = arr[low];
		T middle = arr[mid];
		T last = arr[high];
		if ((first.compareTo(middle) <= 0) && (middle.compareTo(last) <= 0)) {
			return mid;
		}
		else if ((middle.compareTo(last) <= 0) && (last.compareTo(first) <= 0)) {
			return high;
		}
		else {
			return low;
		}
	}
	
	public static <T extends Comparable<T>> int partition(T[] arr, int low, int high) {
		int pivotIndex = findPivot(arr, low, high);
		T pivot = arr[pivotIndex];
		arr[pivotIndex] = arr[high];
		arr[high] = pivot;
		int i = high-1;
		for (int j=low; j<i; j++) {
			if(arr[j].compareTo(pivot) >= 0 && (arr[i].compareTo(pivot) <= 0)) {
				T temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i--;
			}
		}
		arr[high] = arr[i-1];
		arr[i-1] = pivot;
		return i-1;
	}
	
	public static <T extends Comparable<T>> void quickSortHelper(T[] arr, int low, int high) {
		if (low < (high-1)) {
			System.out.println("low = " + low + " high = " + high);
			for (int i=0; i<arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			int part = partition(arr, low, high);
			quickSortHelper(arr, low, part-1);
			quickSortHelper(arr, part+1, high);
		}
	}
	
	public static <T extends Comparable<T>> void quickSort(T[] arr) {
		quickSortHelper(arr, 0, arr.length-1);
	}
*/
	public static <T extends Comparable<T>> boolean isSorted(List<T> lst) {
		if (lst.size() <= 1) {
			return true;
		}
		for (int i = 1; i < lst.size(); i++) {
			if (lst.get(i-1).compareTo(lst.get(i)) > 0) {
				return false;
			}   
		}
		return true;
	}

	public static <T extends Comparable<T>> void bogoSort(T[] arr) {
		List<T> lst = new ArrayList<T>();
		for (int i = 0; i < arr.length; i++) {
			lst.add(arr[i]);
		}
		while(!isSorted(lst)) {
			Collections.shuffle(lst);
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = lst.get(i);
		}
	}
	
	public static <T extends Comparable<T>> void eventSort(ArrayList<T> l, List<SortEvent<T>> events) {
		
	}
}
