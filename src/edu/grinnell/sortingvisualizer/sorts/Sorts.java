package edu.grinnell.sortingvisualizer.sorts;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.grinnell.sortingvisualizer.events.CompareEvent;
import edu.grinnell.sortingvisualizer.events.CopyEvent;
import edu.grinnell.sortingvisualizer.events.SortEvent;
import edu.grinnell.sortingvisualizer.events.SwapEvent;

public class Sorts {

	/**Implements the selection sort algorithm 
	 * 
	 * @param arr, an array of comparables
	 * @return events, a list of actions taken
	 */
	public static <T extends Comparable<T>> List<SortEvent<T>> selectionSort(T[] arr) {
		List<SortEvent<T>> events = new ArrayList<SortEvent<T>>();
		for(int i=0; i<arr.length; i++) {
			int min = i;
			for(int j=i; j<arr.length; j++) {
				events.add(new CompareEvent<T>(j,min));
				if(arr[j].compareTo(arr[min]) < 0) {
					min = j;
				}
			}
			T temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
			events.add(new SwapEvent<T>(i, min));
		}
		return events;
	}

	/**Implements the insertion sort algorithm 
	 * 
	 * @param arr, an array of comparables
	 * @return events, a list of actions taken
	 */
	public static <T extends Comparable<T>> List<SortEvent<T>> insertionSort(T[] arr) {
		List<SortEvent<T>> events = new ArrayList<SortEvent<T>>();
		for(int i = 1; i<arr.length; i++) {
			for(int j = i; j > 0 && (arr[j-1].compareTo(arr[j]) > 0); j--) {
				events.add(new CompareEvent<T>(j-1,j));
				T temp = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = temp;
				events.add(new SwapEvent<T>(j-1, j));
			}
		}
		return events;
	}

	/**Implements the bubble sort algorithm 
	 * 
	 * @param arr, an array of comparables
	 * @return events, a list of actions taken
	 */
	public static <T extends Comparable<T>> List<SortEvent<T>> bubbleSort(T[] arr) {
		List<SortEvent<T>> events = new ArrayList<SortEvent<T>>();
		int swaps = -1;
		while(swaps != 0) {
			swaps = 0;	
			for(int i=1; i<arr.length; i++) {
				events.add(new CompareEvent<T>(i,i-1));
				if(arr[i-1].compareTo(arr[i]) > 0) {
					T temp = arr[i];
					arr[i] = arr[i-1];
					arr[i-1] = temp;
					events.add(new SwapEvent<T>(i, i-1));
					swaps++;
				}
			}
		}
		return events;
	}

    /***
     * Implements merge sort
     * 
     * @param l
     *            an array list
     * @param lo
     *            the index of the starting element to be sorted (inclusive)
     * @param hi
     *            the index of the last element to be sorted (exclusive)
     * 
     * @return a list of important events during the sorting process
     * 
     */
	public static <T extends Comparable<T>> void merge(T[] l, int lo,
			int hi, List<SortEvent<T>> events) {
		int mid, left, right;
		if (lo >= hi)
			return;
		mid = (lo + hi) / 2;
		merge(l, lo, mid, events);
		merge(l, mid + 1, hi, events);

		left = lo;
		right = mid + 1;
		events.add(new CompareEvent<T>(mid, right));
		if(l[mid].compareTo(l[right]) <= 0) {
			return;
		}

		while(left <= mid && right <= hi) {
			events.add(new CompareEvent<T>(left, right));
			if(l[left].compareTo(l[right]) <= 0) {
				left++;
			}
			else {
				T temp = l[right];

				for(int i = right; i > left; i--) {
					CopyEvent<T> copy = new CopyEvent<>(i, l[i - 1]);
					copy.apply(l);
					events.add(copy);
				}
				CopyEvent<T> copy = new CopyEvent<>(left, temp);
				copy.apply(l);
				events.add(copy);
				left++;  mid++;  right++;
			}
		}
	}


	/**Implements the merge sort algorithm 
	 * 
	 * @param arr, an array of comparables
	 * @return events, a list of actions taken
	 */
	public static <T extends Comparable<T>> List<SortEvent<T>> mergeSort(T[] arr) {
		List<SortEvent<T>> events = new ArrayList<>();
		merge(arr, 0, arr.length - 1, events);
		return events;
	}
	
	/**A helper function to partition arrays for quicksort
	 * 
	 * @param arr, an array to be sorted
	 * @param low, the first index of the partition
	 * @param high, the last index of the partition, exclusive
	 * @return
	 */
	public static <T extends Comparable<T>> List<SortEvent<T>> partition(T[] arr, int low, int high) {
		List<SortEvent<T>> events = new ArrayList<SortEvent<T>>();
		if(low < high) {
	        T pivot = arr[high];
			int i = low -1;
			for (int j = low; j < high; j++) {
				events.add(new CompareEvent<T>(j, high));
				if (arr[j].compareTo(pivot) <= 0) {
					i++;
					T temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;	
					events.add(new SwapEvent<T>(i, j));
				}
			}
			T newtemp = arr[i+1];
			arr[i+1] = arr[high];
			arr[high] = newtemp;
			events.add(new SwapEvent<T>(i+1, high));
			
			int pivotIndex = i +1;
			List<SortEvent<T>> event1 = partition(arr,low, pivotIndex -1);
			List<SortEvent<T>> event2 = partition(arr,pivotIndex + 1, high);
			events.addAll(event1);
			events.addAll(event2);
		}
		return events;		
	}
	
	
	/** Implements the quicksort algorithm
	 * 
	 * @param arr, an array to be sorted
	 * @return events, a list of actions taken
	 */
	public static <T extends Comparable<T>>  List<SortEvent<T>> quickSort(T[] arr) {
		return partition(arr, 0, arr.length-1);
	}
	
	
	/**checks if an array is sorted, recording compare events that occur
	 * 
	 * @param arr, an array that may or may not be sorted
	 * @param events, a list of actions taken
	 * @return whether or not the array is sorted
	 */
	public static <T extends Comparable<T>> boolean isSorted(T[] arr, List<SortEvent<T>> events) {
		if (arr.length <= 1) {
			return true;
		}
		for (int i = 1; i < arr.length; i++) {
			events.add(new CompareEvent<T>(i-1, i));
			if (arr[i-1].compareTo(arr[i]) > 0) {
				return false;
			}   
		}
		return true;
	}

	/**A helper function for BOGO sort that randomly shuffles an array
	 * 
	 * @param arr, an array to be shuffled
	 * @param events, a list of actions taken
	 */
	public static <T extends Comparable<T>> void shuffle(T[] arr, List<SortEvent<T>> events) {
		int index = 0;
		Random rand = new Random();
		for(int i = 0; i < arr.length; i++) {
			index = rand.nextInt(arr.length - 1);
			T temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
			events.add(new SwapEvent<T>(index, i));
		}
	}
	
	/**Implements the bogo sort algorithm
	 * 
	 * @param arr, an array to be sorted
	 * @return events, a list of actions taken
	 */
	public static <T extends Comparable<T>> List<SortEvent<T>> bogoSort(T[] arr) {
		List<SortEvent<T>> events = new ArrayList<SortEvent<T>>();
		while(!isSorted(arr, events)) {
			shuffle(arr, events);
		}
		return events;
	}
	
	/**A function to sort an array by applying the steps of an already-run algorithm on an identical array
	 * 
	 * @param l, an array of comparables
	 * @param events, a list of actions taken by a previous sorting algorithm
	 */
	public static <T extends Comparable<T>> void eventSort(T[] l, List<SortEvent<T>> events) {
		for (int i = 0; i < events.size(); i++) {
			events.get(i).apply(l);
		}
		
	}
}
