import java.util.Date;

public class model{
    private String message;
    private String author;
    private Date date;

    public model(String message,String author){
        this.message = message;
        this.author = author;
        date = new Date();
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
    @Override
    public String toString() {
        return "LogEntry{" + "Author=" + author
                + ", Date=" + date + ", Message='" + message + '\'' + '}';
    }
}