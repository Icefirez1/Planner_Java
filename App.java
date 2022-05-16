import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Screen;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import java.util.ArrayList;

public class App extends Application
{
    //Variables
    private GridPane gridPane;
    private TextField planInput;
    private  ObservableList items = FXCollections.observableArrayList(); 
    private ListView<Task> toDoList; 

    @Override
    public void start(Stage primary)
    {
        primary.setTitle("Planner");
        gridPane = new GridPane();

        addBasic();





        Scene scene = new Scene(gridPane, 500, 500);
        
        primary.setScene(scene);
        primary.show();
    }
    public void addBasic()
    {
        planInput = new TextField();
        gridPane.add(planInput, 1,0,1,1);
        Button saveButton = new Button("Save");
        saveButton.setOnAction( e ->
        {
            System.out.println(planInput.getText());
            items.add(new Task(planInput.getText()));
            toDoList.setItems(items);
        });
        gridPane.add(saveButton, 0, 0, 1, 1); 
        toDoList = new ListView<>();
        toDoList.setItems(items);
        gridPane.add(toDoList, 0, 1, 1, 1);
    }
}
