import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import javafx.collections.ObservableList;

public class Changer 
{
    private static final String CSV_SEPARATOR = ",";
    Changer()
    {

    }   
    public static void CSVToTask()
    {
        
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
