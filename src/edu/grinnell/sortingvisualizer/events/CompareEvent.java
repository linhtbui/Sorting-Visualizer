package edu.grinnell.sortingvisualizer.events;

import java.util.ArrayList;
import java.util.List;

public class CompareEvent<T>  implements SortEvent<T> {

	private int indexa;
	private int indexb;
	
	public CompareEvent(int a, int b) {
		this.indexa = a;
		this.indexb = b;
	}
	
	/**
	 * @param arr
	 * apply a comparison to an array, doesn't actually affect the array
	 */
	public void apply(T[] arr) {
	}

	/** return the indices that were compared
	 * 
	 */
	public List<Integer> getAffectedIndices() {
		List<Integer> ret = new ArrayList<Integer>();
		ret.add(this.indexa);
		ret.add(this.indexb);
		return ret;
	}

	//compare events are not emphasized
	public boolean isEmphasized() {
		return false;
	}

}
