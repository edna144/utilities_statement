package com.utilities_statement.client;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

/**
 * Defines main window layout
 * 
 * @author Edna
 *
 */

public class MainFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public MainFrame(String title) {
		super(title);
		
		// layout
		setLayout(new BorderLayout());
		
		// components
		DetailsPanel detailPanel = new DetailsPanel();
		// add components to pane
		Container pane = getContentPane();
		
		pane.add(detailPanel, BorderLayout.WEST);

	}

}
