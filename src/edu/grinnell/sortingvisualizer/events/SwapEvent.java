package edu.grinnell.sortingvisualizer.events;

import java.util.List;
import java.util.ArrayList;

public class SwapEvent <T>  implements SortEvent<T> {

	private int indexa;
	private int indexb;
	
	public SwapEvent(int a, int b) {
		this.indexa = a;
		this.indexb = b;
	}
	
	/**Swaps the values of two specified indices in the parameter array
	 * @param arr, an array that we are swapping on
	 */
	public void apply(T[] arr) {
		T temp = arr[this.indexa];
		arr[this.indexa] = arr[this.indexb];
		arr[this.indexb] = temp;
		
	}

	//gets the indices that were swapped
	public List<Integer> getAffectedIndices() {
		List<Integer> ret = new ArrayList<Integer>();
		ret.add(this.indexa);
		ret.add(this.indexb);
		return ret;
	}

	//swap events are emphasized
	public boolean isEmphasized() {
		return true;
	}
	
}
