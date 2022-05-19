
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Task
{
    
    //Chore and due date of task
    private String chore; 
    private String dueDate;
    /**
     * Constructors
     */
    public Task()
    {
        this.chore = "none";
        this.dueDate = new Date().toString();
    }
    public Task(String toDo)
    {
        this.chore = toDo;
        this.dueDate = new Date().toString();
    }
    //figure this out some other day
    // Im trying to implement so that they can add the task to another day
    // mabye instead of them typing I have them do it through like a wheel
    public Task(String toDo, String dateDue) throws ParseException
    {
        this.chore = toDo;
        // fix this
        // this.dueDate = DateFormat.parse(dateDue);
        this.dueDate = dateDue;
    }
    /**
     * Changes task
     * @param newTask
     */
    public void changeTask(String newTask)
    {
        this.chore = newTask;
    }
    /**
     * Changes Due Date
     * @param newDate
     */
    public void changeDate(Date newDate)
    {
        this.dueDate = newDate.toString();
    }
    public String getTask()
    {
        return this.chore;
    }
    public String getDate()
    {
        return this.dueDate.toString();
    }


    public String toString()
    {
        return chore.concat(" ").concat(dueDate.toString());
    }
    public static void main(String[] args)
    {
        
        Task stuff = new Task("yuh"); 
        System.out.println(stuff);

    }
}