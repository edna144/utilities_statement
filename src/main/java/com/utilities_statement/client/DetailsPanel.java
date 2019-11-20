package com.utilities_statement.client;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DetailsPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public DetailsPanel() {
		Dimension size = getPreferredSize();
		size.width = 600;
		setPreferredSize(size);
		setBorder(BorderFactory.createTitledBorder("Wohnungsübersicht"));
		
		// layout
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		// components
		String[] columnNames = {"Wohnung", "Mieter", "Bewohner", "Wohnfläche", "Vorauszahlung"};
		Object[][] data = {
			    {"Wohnung 1", "Mieter 1", "2", "50.4", "250.0"},
			    {"Wohnung 2", "Mieter 2", "1", "32.0", "130.0"}};
				
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		JTable flatTable = new JTable(model);
		flatTable.setPreferredScrollableViewportSize(new Dimension(500,100));
		flatTable.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(flatTable);
		JButton button = new JButton("Wohnung hinzufügen");
	    
	    gc.gridx = 0;
	    gc.gridy = 0;
	    add(scrollPane, gc);

	    gc.gridx = 0;
	    gc.gridy = 1;
	    gc.anchor = GridBagConstraints.LINE_END;
	    add(button, gc);
	    
	    
	    
	    button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.addRow(new Object[] {"", "", "", "", ""});
			}
		});
	}
}
