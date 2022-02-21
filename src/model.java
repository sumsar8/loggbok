import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class model{
    private String message;
    private String author;
    private Date date;
    private int currentnumber = 0;
    private ArrayList<String> messageList = new ArrayList<>();
    public model(){
    }

    public void saveInput(String input){
        messageList.add(currentnumber,input);
        System.out.println(messageList.get(currentnumber));

        currentnumber++;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public String getAuthor() {
        return author;
    }

    public String getMessage() {
        return message;
    }
}