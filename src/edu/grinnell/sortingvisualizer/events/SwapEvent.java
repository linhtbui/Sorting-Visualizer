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
	
	public void apply(T[] arr) {
		T temp = arr[this.indexa];
		arr[this.indexa] = arr[this.indexb];
		arr[this.indexb] = temp;
		
	}

	
	public List<Integer> getAffectedIndices() {
		List<Integer> ret = new ArrayList<Integer>();
		ret.add(this.indexa);
		ret.add(this.indexb);
		return ret;
	}

	
	public boolean isEmphasized() {
		return true;
	}
	
}
