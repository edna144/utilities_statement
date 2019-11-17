package com.utilities_statement.client;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Button;

/**
 * GUI in progress
 * 
 * @author Edna
 *
 */
public class GUI extends Application{
	
	Button button;
	
	public void launchGUI(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage window) throws Exception{
		window.setTitle("ssses");
		window.setWidth(800);
		window.setHeight(600);
		window.show();
		button = new Button();
		button.setText("click");
		// TODO button is missing
		
	}	
}
