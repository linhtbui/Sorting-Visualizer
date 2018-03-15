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
	
	public void apply(T[] arr) {
	}

	
	public List<Integer> getAffectedIndices() {
		List<Integer> ret = new ArrayList<Integer>();
		ret.add(this.indexa);
		ret.add(this.indexb);
		return ret;
	}

	
	public boolean isEmphasized() {
		return false;
	}

}
