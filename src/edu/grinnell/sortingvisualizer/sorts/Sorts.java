package edu.grinnell.sortingvisualizer.sorts;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.grinnell.sortingvisualizer.events.CompareEvent;
import edu.grinnell.sortingvisualizer.events.CopyEvent;
import edu.grinnell.sortingvisualizer.events.SortEvent;
import edu.grinnell.sortingvisualizer.events.SwapEvent;

public class Sorts {

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

	
	private static <T extends Comparable<T>> List<SortEvent<T>> merge(T[] arr, int lo, int mid, int hi) {
		List<SortEvent<T>> events = new ArrayList<SortEvent<T>>();
		List<T> temp = new ArrayList<T>();
		int first = lo;
		int second = mid;
		while (first < mid && second < hi) {
			events.add(new CompareEvent<T>(first,second));
			if(arr[first].compareTo(arr[second]) < 1) {
				temp.add(arr[first++]);				
			} else {
				temp.add(arr[second++]);
			}
		}
		
		while (first < mid) {
			temp.add(arr[first++]);	
		}
		
		while (second < hi) {
			temp.add(arr[second++]);
		}
		
		for(int j = 0; j < temp.size(); j++) {
			arr[j+lo] = temp.get(j);
			events.add(new CopyEvent<T>(j+lo,(T) temp.get(j)));
		}
		return events;

	}
	
	public static <T extends Comparable<T>> List<SortEvent<T>> mergeSortHelper(T[] arr, int lo, int hi) {
		List<SortEvent<T>> events = new ArrayList<SortEvent<T>>();
		if (hi > lo + 1) {
			int mid = lo + (hi - lo) /2;
			List<SortEvent<T>> event1 = mergeSortHelper(arr, lo, mid);
			List<SortEvent<T>> event2 = mergeSortHelper(arr, mid, hi);
			List<SortEvent<T>> event3 = merge(arr, lo, mid, hi);
			events.addAll(event1);
			events.addAll(event2);
			events.addAll(event3);
		}
		return events;
	}

	public static <T extends Comparable<T>> List<SortEvent<T>> mergeSort(T[] arr) {
		
		List<SortEvent<T>> events = mergeSortHelper(arr, 0, arr.length);
		return events;
	}

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
	public static <T extends Comparable<T>> List<SortEvent<T>> partition(T[] arr, int low, int high) {
		List<SortEvent<T>> events = new ArrayList<SortEvent<T>>();
		if(low < high) {
			T pivot = arr[findPivot(arr,low, high)];
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
	
	public static <T extends Comparable<T>>  List<SortEvent<T>> quickSort(T[] arr) {
		return partition(arr, 0, arr.length-1);
	}
	
	
	
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
	
	
	public static <T extends Comparable<T>> List<SortEvent<T>> bogoSort(T[] arr) {
		List<SortEvent<T>> events = new ArrayList<SortEvent<T>>();
		while(!isSorted(arr, events)) {
			shuffle(arr, events);
		}
		return events;
	}
	
	public static <T extends Comparable<T>> void eventSort(T[] l, List<SortEvent<T>> events) {
		for (int i = 0; i < events.size(); i++) {
			events.get(i).apply(l);
		}
		
	}
}
