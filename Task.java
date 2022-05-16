
import java.util.Date;
import java.io.Serializable;
public class Task implements Serializable
{
    //default serialVersion id
    private static final long serialVersionUID = 1L;
    
    //Chore and due date of task
    private String chore; 
    private Date dueDate;
    /**
     * Constructors
     */
    public Task()
    {
        this.chore = "none";
        this.dueDate = new Date();
    }
    public Task(String toDo)
    {
        this.chore = toDo;
        this.dueDate = new Date();
    }
    //figure this out some other day
    // Im trying to implement so that they can add the task to another day
    // mabye instead of them typing I have them do it through like a wheel
    public Task(String toDo, Date dateDue)
    {
        this.chore = toDo;
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
        this.dueDate = newDate;
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