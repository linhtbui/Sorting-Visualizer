package edu.grinnell.sortingvisualizer.audio;

import java.util.Random;


/**
 * A collection of indices into a Scale object.
 * These indices are the subject of the various sorting algorithms
 * in the program.
 */
public class NoteIndices {
	private Integer[] indices;
	private boolean[] highlightNotes;

    /**
     * @param n the size of the scale object that these indices map into
     */
    public NoteIndices(int n) {
        initializeAndShuffle(n); 
    }
  
    /**
     * Reinitialize this collection of indices to map into a new scale object
     * of the given size.  The collection is also shuffled to provide an
     * initial starting point for the sorting process.
     * @param n the size of the scale object that these indices map into
     */
    public void initializeAndShuffle(int n) {
    	indices = new Integer[n];
    	for (int i = 0; i < indices.length; i++) {
    		indices[i] = i;
    	}
    	Random rand = new Random();
    	int j;
    	int temp;
    	for (int i = indices.length -1; i>=0; i--) {
    		j = rand.nextInt(i+1);
    		temp = indices[j];
    		indices[j] = indices[i];
    		indices[i] = temp;
    	}
    	highlightNotes = new boolean[indices.length];
    }
    
    
    
    /** @return the indices of this NoteIndices object */
    public Integer[] getNotes() { 
        return indices;
    }
    
    /**
     * Highlights the given index of the note array
     * @param index the index to highlight
     */
    public void highlightNote(int index) {
        highlightNotes[index] = true;
    }
    
    /** @return true if the given index is highlighted */
    public boolean isHighlighted(int index) {
        return highlightNotes[index];
    }
    
    /** Clears all highlighted indices from this collection */
    public void clearAllHighlighted() {
        for (int i = 0; i < highlightNotes.length; i++) {
        	highlightNotes[i] = false;
        }
    }
    
    public int length() {
    	return indices.length;
    }
}
