import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class Main extends Application {
	
	public static void main(String[] args) { 
	launch(args);
	}


@Override 
	public void start(Stage primaryStage) {
	
	// Creating a window
	Pane root = new Pane();
	
	// Adding Text to the screen + positioning
	Text text = new Text(225, 250, "Drag Me");
	root.getChildren().add(text);
	
	// Make the text able to be dragged
	text.setOnMouseDragged(new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			text.setX(event.getX());
			text.setY(event.getY());
			text.setText("X: " + text.getX() + " Y: " + text.getY()); // Indicates current exact location
		}	
			
	});
	
	// Make the text able to be clicked
	text.setOnMouseClicked(new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			// Indicates mouse location with left button
			if(event.getButton() == MouseButton.PRIMARY) {
				text.setText("X: " + text.getX() + " Y: " + text.getY() + "\nDragged with: Left Button"); 
			} 
			// Indicates mouse location with right button
			if(event.getButton() == MouseButton.SECONDARY) {
				text.setText("X: " + text.getX() + " Y: " + text.getY() + "\nDragged with: Right Button");
			}
			
		}	
	});
	
	primaryStage.setScene(new Scene(root, 500, 500));
	primaryStage.show();
	
	}

}