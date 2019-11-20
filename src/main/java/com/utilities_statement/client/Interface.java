package com.utilities_statement.client;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Creates a Swing user interface
 * 
 * @author Edna
 *
 */

public class Interface {

	public void start() {
		
		// run in thread
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				JFrame frame = new MainFrame("Utilities Statement");
				
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(630, 400);
				frame.setVisible(true);
			}
		});
	}
}
