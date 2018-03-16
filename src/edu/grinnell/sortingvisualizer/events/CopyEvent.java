package edu.grinnell.sortingvisualizer.events;

import java.util.ArrayList;
import java.util.List;

public class CopyEvent <T> implements SortEvent<T> {

	private int index;
	private T data;
	
	public CopyEvent(int dex, T dat) {
		this.index = dex;
		this.data = dat;
	}
	
	/** Copies the specified data into the specified index of an array
	 * @param arr, the array to apply the action on
	 */
	public void apply(T[] arr) {
		arr[index] = data;
	}

	//returns the affected indices of the action, stored in the object
	public List<Integer> getAffectedIndices() {
		List<Integer> ret = new ArrayList<Integer>();
		ret.add(index);
		return ret;
	}

	//copy actions are emphasized
	public boolean isEmphasized() {
		return true;
	}

}
