import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Changer 
{
    private static final String CSV_SEPARATOR = ",";
    Changer()
    {

    }   
    public static ObservableList<Task> CSVToTask() throws ParseException
    {
        ArrayList<String[]> data = null;
        try {
            File newFile = new File("stuff.csv");

            System.out.println(newFile.length());
            if (newFile.length() != 0) 
            {
                data = CSVLoader.loadCSV("stuff.csv");
            } 
            else
            {
                System.out.println("nothing there");
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        ObservableList<Task> items = FXCollections.observableArrayList(); 

        if (data != null) {
            for (String[] row : data) {
                items.add(new Task(row[0], row[1]));
            }
        }
        return items;
        

    }
    public static void writeToCSV(ObservableList<Task> productList)
    {
        try
        {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("stuff.csv"), "UTF-8"));
            for (Task product : productList)
            {
                StringBuffer oneLine = new StringBuffer();
                oneLine.append(product.getTask());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(product.getDate());
                bw.write(oneLine.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        }
        catch (UnsupportedEncodingException e) {}
        catch (FileNotFoundException e){}
        catch (IOException e){}
    }
    public static void main(String[] args)
    {

    }
}
