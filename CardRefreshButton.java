package application;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;

// Create a class named CardRefreshButton extends Application
public class CardRefreshButton extends Application {
	
	

	public void start(Stage primaryStage) {
		// Create a new array list
		// ArrayList<ImageView> imageList = new ArrayList<>();
		ArrayList<Image> imageList = new ArrayList<>();
		
		// the folder  the card image files are stored
		String path = "C:\\Users\\meiyu\\eclipse-workspace\\TESTTEST\\src\\application\\image\\card\\";
		
		// use a for loop and add() method to add 52 cards to the list
		for (int i=0; i< 52; i++) {
			// String imageFileName = path + (i+1) + ".png";
			String imageFileName = path+ (i+1) + ".png";
			// System.out.println(imageFileName);
			
			// ImageView imageView = new ImageView(imageFileName);
			// imageList.add(imageView);
			Image image = new Image(imageFileName);
			imageList.add(image);
			
		}
		
		// Revoke shuffle() method for the list to shuffle the cards. 
		java.util.Collections.shuffle(imageList);
		
		// Create an instance of HBox and add four card images by using getChildren().add() method.
		HBox hBox = new HBox(20);		
		for (int j=0; j<4; j++) {
		    hBox.getChildren().add(new ImageView(imageList.get(j)));
		}
		
		// Create a Button and labeled with “Refresh” 
		Button bt = new Button("Refresh");
		// Create and register an event handler. 
		bt.setOnAction(new EventHandler<ActionEvent>() {
			
			// To handle event: once the button is clicked, call shuffle() method to shuffle the cards, 
			// then clear previous images by using getChildren.clear() method, 
			// and use add() to add four card images. 
			public void handle(ActionEvent e) {
				java.util.Collections.shuffle(imageList);
				hBox.getChildren().clear();
				for (int j=0; j<4; j++) {
				    hBox.getChildren().add(new ImageView(imageList.get(j)));
				}
			}
			
		});
		
		hBox.setAlignment(Pos.CENTER);
	
		// Create a new BorderPane to set up layout for the images and button.
		BorderPane bPane = new BorderPane();
		bPane.setPadding(new Insets(10,10,10,10));

	    bPane.setCenter(hBox);
	    
	    BorderPane.setAlignment(hBox, Pos.CENTER);
	    
	    bPane.setBottom(bt);
	    BorderPane.setAlignment(bt, Pos.CENTER);
	    
	    // Create a scene with a specific size.
		Scene scene = new Scene(bPane, 400, 200);
		primaryStage.setScene(scene);
		
		// Set title to “Shuffling cards” and display the stage.
		primaryStage.setTitle("Shuffle Cards");
		primaryStage.show();
	}
	


	public static void main(String[] args) {
		
		launch(args);
	}
}
