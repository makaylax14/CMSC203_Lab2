


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	Button bt1;
	Button bt2;
	Button bt3;
	Button bt4;
	Button bt5;
	TextField text;
	Label label;
	HBox hbox1;
	HBox hbox2;
	
	//student Task #4:
	//  declare an instance of DataManager
	DataManager manager;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		bt1 = new Button("Hello");
		bt2 = new Button("Howdy");
		bt3 = new Button("Chinese");
		bt4 = new Button("Clear");
		bt5 = new Button("Exit");
		label = new Label("Feedback:");
		text = new TextField();
		
		bt1.setOnAction(new ButtonHandler());
		bt2.setOnAction(new ButtonHandler());
		bt3.setOnAction(new ButtonHandler());
		bt4.setOnAction(new ButtonHandler());
		bt5.setOnAction(new ButtonHandler());
		//  instantiate the HBoxes
		hbox1 = new HBox();
		hbox2 = new HBox();
		
		//student Task #4:
		//  instantiate the DataManager instance
		manager=new DataManager();
		//  set margins and set alignment of the components
		Insets inset = new Insets(10);
		hbox2.setMargin(bt1,inset);
		hbox2.setMargin(bt2,inset);
		hbox2.setMargin(bt3,inset);
		hbox2.setMargin(bt4,inset);
		hbox2.setMargin(bt5,inset);
		
		hbox1.setAlignment(Pos.CENTER);
		
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		hbox1.getChildren().addAll(label, text);
		//  add the buttons to the other HBox
		hbox2.getChildren().addAll(bt1, bt2, bt3, bt4, bt5);
		//  add the HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll(hbox1, hbox2);
		
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			if (event.getTarget()==bt1) {
				text.setText(manager.getHello());
			}
			else if (event.getTarget()==bt2) {
				text.setText(manager.getHowdy());
			}
			else if (event.getTarget()==bt3) {
				text.setText(manager.getChinese());
			}
			else if (event.getTarget()==bt4) {
				text.setText("");
			}
			else {
				Platform.exit();
				System.exit(0);
			}
		}
	}
}
	
