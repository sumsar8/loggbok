import java.io.IOException;
import java.io.*;

public class controller {
    public model model;
    public view view;
    public static void main(String args[]){
            save();
            load();
    }
    private static void load(){
        try{
            ObjectInputStream obin = new ObjectInputStream(new FileInputStream(new File("log")));
            model l = (model) obin.readObject();
            obin.close();
            System.out.println(l.toString());
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();

        }

    }
    private static void save(){
        try{
            model l = new model("Test1","Rasmus");
            ObjectOutputStream obout=new ObjectOutputStream(new FileOutputStream(new File("log")));
            obout.writeObject(l);
            obout.flush();
            obout.close();
        }catch(IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}