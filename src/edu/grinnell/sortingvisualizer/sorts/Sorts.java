package edu.grinnell.sortingvisualizer.sorts;
import java.util.ArrayList;

public class Sorts {

	public static <T extends Comparable<T>> void selectionSort(T[] arr) {
		
	}
	
	public static <T extends Comparable<T>> void insertionSort(T[] arr) {
		
	}
	
	public static <T extends Comparable<T>> void BubbleSort(T[] arr) {
		
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
}
