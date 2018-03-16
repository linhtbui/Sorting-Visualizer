package edu.grinnell.sortingvisualizer.rendering;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

import edu.grinnell.sortingvisualizer.audio.NoteIndices;

@SuppressWarnings("serial")
public class ArrayPanel extends JPanel {

    private NoteIndices notes;
    
    /**
     * Constructs a new ArrayPanel that renders the given note indices to
     * the screen.
     * @param notes the indices to render
     * @param width the width of the panel
     * @param height the height of the panel
     */
    public ArrayPanel(NoteIndices notes, int width, int height) {
        this.notes = notes;
        this.setPreferredSize(new Dimension(width, height));
    }

    /** recolors bars within the display
     * @param g, the graphics object
     */
    @Override
    public void paintComponent(Graphics g) {
    	g.setColor(Color.WHITE);
    	g.fillRect(0, 0, getWidth(), getHeight());
    	Color current;
    	for (int i = 0; i < notes.length(); i++) {
    		if (notes.isHighlighted(i)) {
    			current = new Color(0,10,200);
    		} else {
    			int blue = 150 + i * 3;
    			if ( blue > 255) { blue = 255;}
    			current = new Color(20,150,blue);
    			
    		}
    		double barWidth = this.getWidth() / notes.length();
    		int barHeight = (notes.getNotes()[i] + 1) * (this.getHeight()/ notes.length());
    		double x = barWidth * i;
    		g.setColor(current);
    		g.fillRect((int)x, this.getHeight() - barHeight, (int) barWidth, barHeight);
    	}
    	notes.clearAllHighlighted();
    }
}