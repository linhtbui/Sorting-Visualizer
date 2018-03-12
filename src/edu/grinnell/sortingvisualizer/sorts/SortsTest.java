package edu.grinnell.sortingvisualizer.sorts;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortsTest {

	@Test
	public void test() {
		int[] arr = {3, 2, 7, 0, 7, -1, 6, 9};
		Sorts.mergeSort(arr);
		
	}

}
