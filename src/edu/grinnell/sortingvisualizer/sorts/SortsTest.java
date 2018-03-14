package edu.grinnell.sortingvisualizer.sorts;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortsTest {
	
	@Test
	public void mergeTest() {
		Integer[] arr = {3, 2, 7, 0, 7, -1, 6, 9};
		Sorts.mergeSort(arr);
		for (int i = 1; i < arr.length; i++) {
			assertTrue(arr[i-1] <= arr[i]);
		}
		
		
	}
	@Test
	public void selectionTest() {
		Integer[] arr = {3, 2, 7, 0, 7, -1, 6, 9};
		Sorts.selectionSort(arr);
		for (int i = 1; i < arr.length; i++) {
			assertTrue(arr[i-1] <= arr[i]);
		}
		
	}
	
	@Test
	public void bubbleTest() {
		Integer[] arr = {3, 2, 7, 0, 7, -1, 6, 9};
		Sorts.bubbleSort(arr);
		for (int i = 1; i < arr.length; i++) {
			assertTrue(arr[i-1] <= arr[i]);
		}
		
	}
	
	@Test
	public void insertionTest() {
		Integer[] arr = {3, 2, 7, 0, 7, -1, 6, 9};
		Sorts.insertionSort(arr);
		for (int i = 1; i < arr.length; i++) {
			assertTrue(arr[i-1] <= arr[i]);
		}
		
	}
	
	@Test
	public void bogoTest() {
		Integer[] arr = {3, 2, 7, 0, 7, -1, 6, 9};
		Sorts.bogoSort(arr);
		for (int i = 1; i < arr.length; i++) {
			assertTrue(arr[i-1] <= arr[i]);
		}
		
	}
}
