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
	
	public void apply(T[] arr) {
		arr[this.index] = this.data;
	}

	
	public List<Integer> getAffectedIndices() {
		List<Integer> ret = new ArrayList<Integer>();
		ret.add(this.index);
		return ret;
	}

	
	public boolean isEmphasized() {
		return true;
	}

}
