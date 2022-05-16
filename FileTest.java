import java.io.FileOutputStream;
import java.io.ObjectOutputStream; 

// figure this shit out
public class FileTest {
    private static final String filepath="C:\\Users\\alpag\\OneDrive\\Documents\\Al\\Coding\\Projects\\Planner_Java";
 
    public static void main(String args[]) {
 
        FileTest objectIO = new FileTest();
 
        Task student = new Task("John");
        objectIO.WriteObjectToFile(student);
    }
 
    public void WriteObjectToFile(Object serObj) {
 
        try {
 
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
