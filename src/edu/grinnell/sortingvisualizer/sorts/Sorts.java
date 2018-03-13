package edu.grinnell.sortingvisualizer.sorts;
import java.util.ArrayList;
import java.util.List;

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

	public static <T extends Comparable<T>> void QuickSort(T[] arr) {

	}

	public static <T extends Comparable<T>> void BOGOSort(T[] arr) {

	}
	
	void eventSort(ArrayList<T> l, List<SortEvent<T>> events) {
		
	}
}
