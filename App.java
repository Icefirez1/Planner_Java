import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class App extends Application
{
    //Variables
    private GridPane gridPane;
    private TextField planInput;
    private ObservableList items = FXCollections.observableArrayList(); 
    private ListView<Task> toDoList; 

    @Override
    public void start(Stage primary)
    {

        primary.setTitle("TO DO LIST");
        gridPane = new GridPane();

        addBasic();
        extraKey();
        Scene scene = new Scene(gridPane, 250, 500);
        scene.getStylesheets().add("stylesheet.css");
        
        primary.setScene(scene);
        primary.show();
    }
    @SuppressWarnings("unchecked")
    public void extraKey()
    {
        planInput.setOnKeyPressed( e ->
        {
            if ( e.getCode() == KeyCode.ENTER)
            {
                items.add(new Task(planInput.getText()));
                toDoList.setItems(items);
            } 
        });
    }
    @SuppressWarnings("unchecked")
    public void addBasic()
    {
        planInput = new TextField();
        gridPane.add(planInput, 0,0,1,1);


        Button saveButton = new Button("Save");
        saveButton.setOnAction( e ->
        {
            items.add(new Task(planInput.getText()));
            toDoList.setItems(items);
        });
        gridPane.add(saveButton, 0, 1, 1, 1); 
        

        Button removeButton = new Button("Delete Task");
        removeButton.setOnAction( e ->
        {
            final int selectedIdx = toDoList.getSelectionModel().getSelectedIndex();
            if(items.size() > 0 && selectedIdx == -1)
            {
                items.remove(items.size() - 1);
            }
            else if(selectedIdx != -1)
            {
                items.remove(selectedIdx);
                toDoList.getSelectionModel().clearSelection(selectedIdx);
            }

        });
        gridPane.add(removeButton, 0, 2, 1, 1); 


        toDoList = new ListView<>();
        toDoList.setItems(items);
        gridPane.add(toDoList, 0, 3, 1, 1);

    }

    @Override
    public void stop()
    {
        Changer.writeToCSV(items);
    }
}
