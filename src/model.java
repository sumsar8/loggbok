
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class model{
    private String message;
    private int currentnumber = 0;
    private ArrayList<String> messageList = new ArrayList<>();

    public model(){
    }

    public void saveInput(String input,String authorInput){
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);

        String inputauthor = input + "    " + authorInput + "   " + formattedDate;
        messageList.add(currentnumber,inputauthor);
        currentnumber++;
    }
    public String getList(){
        String ListString = "";
        for(int i = 0;i < messageList.toArray().length;i++){
            ListString += messageList.get(i) + "\n";
        }
        return ListString;
    }

    public void setMessageList(ArrayList<String> messageList) {
        this.messageList = messageList;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}