package edu.grinnell.sortingvisualizer.sorts;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.List;

import edu.grinnell.sortingvisualizer.events.SortEvent;

public class SortsTest {
	
	private static void isSorted(Integer[] arr) {
		for (int i = 1; i < arr.length; i++) {
			assertTrue(arr[i-1] <= arr[i]);
		}
	}
	
	@Test
	public void mergeTest() {
		Integer[] arr = {3, 2, 7, 0, 7, -1, 6, 9};
		Sorts.mergeSort(arr);
		isSorted(arr);
		Integer[] arr0 = {};
		Sorts.mergeSort(arr0);
		isSorted(arr0);
		Integer[] arr1 = {1};
		Sorts.mergeSort(arr1);
		isSorted(arr1);
		Integer[] sorted = {1, 2, 3, 4, 5};
		Sorts.mergeSort(sorted);
		isSorted(sorted);
		Integer[] reverse = {5, 4, 3, 2, 1};
		Sorts.mergeSort(reverse);
		isSorted(reverse);
	}
	
	@Test
	public void selectionTest() {
		Integer[] arr = {3, 2, 7, 0, 7, -1, 6, 9};
		Sorts.selectionSort(arr);
		isSorted(arr);
		Integer[] arr0 = {};
		Sorts.selectionSort(arr0);
		isSorted(arr0);
		Integer[] arr1 = {1};
		Sorts.selectionSort(arr1);
		isSorted(arr1);
		Integer[] sorted = {1, 2, 3, 4, 5};
		Sorts.selectionSort(sorted);
		isSorted(sorted);
		Integer[] reverse = {5, 4, 3, 2, 1};
		Sorts.selectionSort(reverse);
		isSorted(reverse);
		
	}
	
	@Test
	public void bubbleTest() {
		Integer[] arr = {3, 2, 7, 0, 7, -1, 6, 9};
		Sorts.bubbleSort(arr);
		isSorted(arr);
		Integer[] arr0 = {};
		Sorts.bubbleSort(arr0);
		isSorted(arr0);
		Integer[] arr1 = {1};
		Sorts.bubbleSort(arr1);
		isSorted(arr1);
		Integer[] sorted = {1, 2, 3, 4, 5};
		Sorts.bubbleSort(sorted);
		isSorted(sorted);
		Integer[] reverse = {5, 4, 3, 2, 1};
		Sorts.bubbleSort(reverse);
		isSorted(reverse);
		
	}
	
	@Test
	public void insertionTest() {
		Integer[] arr = {3, 2, 7, 0, 7, -1, 6, 9};
		Sorts.insertionSort(arr);
		isSorted(arr);
		Integer[] arr0 = {};
		Sorts.insertionSort(arr0);
		isSorted(arr0);
		Integer[] arr1 = {1};
		Sorts.insertionSort(arr1);
		isSorted(arr1);
		Integer[] sorted = {1, 2, 3, 4, 5};
		Sorts.insertionSort(sorted);
		isSorted(sorted);
		Integer[] reverse = {5, 4, 3, 2, 1};
		Sorts.insertionSort(reverse);
		isSorted(reverse);
		
	}
	
	@Test
	public void quickTest() {
		Integer[] arr = {3, 2, 7, 0, 7, -1, 6, 9};
		Sorts.quickSort(arr);
		isSorted(arr);
		Integer[] arr0 = {};
		Sorts.quickSort(arr0);
		isSorted(arr0);
		Integer[] arr1 = {1};
		Sorts.quickSort(arr1);
		isSorted(arr1);
		Integer[] sorted = {1, 2, 3, 4, 5};
		Sorts.quickSort(sorted);
		isSorted(sorted);
		Integer[] reverse = {5, 4, 3, 2, 1};
		Sorts.quickSort(reverse);
		isSorted(reverse);
		
	}
	
	@Test
	public void bogoTest() {
		Integer[] arr = {3, 2, 7, 0, 7, -1, 6, 9};
		Sorts.bogoSort(arr);
		isSorted(arr);
		Integer[] arr0 = {};
		Sorts.bogoSort(arr0);
		isSorted(arr0);
		Integer[] arr1 = {1};
		Sorts.bogoSort(arr1);
		isSorted(arr1);
		Integer[] sorted = {1, 2, 3, 4, 5};
		Sorts.bogoSort(sorted);
		isSorted(sorted);
		Integer[] reverse = {5, 4, 3, 2, 1};
		Sorts.bogoSort(reverse);
		isSorted(reverse);
		
	}
	
	@Test
	public void eventTest() {
		Integer[] arr = {3, 2, 7, 0, 7, -1, 6, 9};
		List<SortEvent<Integer>> events = Sorts.mergeSort(arr);
		isSorted(arr);
		Integer[] arragain = {3, 2, 7, 0, 7, -1, 6, 9};
		Sorts.eventSort(arragain, events);
		isSorted(arragain);
		
		Integer[] arr2 = {3, 2, 7, 0, 7, -1, 6, 9};
		List<SortEvent<Integer>> events2 = Sorts.selectionSort(arr2);
		isSorted(arr2);
		Integer[] arragain2 = {3, 2, 7, 0, 7, -1, 6, 9};
		Sorts.eventSort(arragain2, events2);
		isSorted(arragain2);
		
		Integer[] arr3 = {3, 2, 7, 0, 7, -1, 6, 9};
		List<SortEvent<Integer>> events3 = Sorts.bubbleSort(arr3);
		isSorted(arr3);
		Integer[] arragain3 = {3, 2, 7, 0, 7, -1, 6, 9};
		Sorts.eventSort(arragain3, events3);
		isSorted(arragain3);

		Integer[] arr4 = {3, 2, 7, 0, 7, -1, 6, 9};
		List<SortEvent<Integer>> events4 = Sorts.insertionSort(arr4);
		isSorted(arr4);
		Integer[] arragain4 = {3, 2, 7, 0, 7, -1, 6, 9};
		Sorts.eventSort(arragain4, events4);
		isSorted(arragain4);

		Integer[] arr5 = {3, 2, 7, 0, 7, -1, 6, 9};
		List<SortEvent<Integer>> events5 = Sorts.quickSort(arr5);
		isSorted(arr5);
		Integer[] arragain5 = {3, 2, 7, 0, 7, -1, 6, 9};
		Sorts.eventSort(arragain5, events5);
		isSorted(arragain5);
		
		Integer[] arr6 = {3, 2, 7, 0, 7, -1, 6, 9};
		List<SortEvent<Integer>> events6 = Sorts.bogoSort(arr6);
		isSorted(arr6);
		Integer[] arragain6 = {3, 2, 7, 0, 7, -1, 6, 9};
		Sorts.eventSort(arragain6, events6);
		isSorted(arragain6);
	}
}
