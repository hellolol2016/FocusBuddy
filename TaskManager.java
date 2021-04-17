import java.io.*;
import java.util.*;

public class TaskManager {
    private static ArrayList<String> Topics = new ArrayList<String>();
    public static void main(String[] args) throws Exception{
       //WELCOME MENU BAR
        Scanner csc = new Scanner(System.in); //console scanner 
        Scanner fsc = new Scanner(new File("taskmanager.in")); // file scanner
        PrintWriter pw = new PrintWriter("taskmanager.out");
        System.out.println("Welcome to the Task Manager?");
        System.out.println("What would you like to do?");
        System.out.println("(a) Create a new topic");
        System.out.println("(b) Delete a topic");
        System.out.println("(c) Check your topics");
        System.out.println("(d) Quit");
        String response = csc.next();
        
        //USER ADDS NEW TOPIC, OR CHECKS TOPIC, OR EXIT
        if(response.equals("a")){
            System.out.println("What topic would you like to add?");//ADD
            Topics.add(csc.next());
        } else if(response.equals("b")){
            System.out.println("What topic would you like to delete?");//DELETE
            String topic = csc.next();
            for(int i = 0; i < Topics.size(); i++){
                if(Topics.get(i).equals(topic)){
                    Topics.remove(i);
                }
            }
        } else if(response.equals("c")){
            System.out.println("What topic would you like to access?");//CHECK
            String topic = csc.next();
            TopicsUtil(topic, csc, pw, Topics);
        } else {
            System.exit(0); //QUITS
        }
        
    } 
    //LIST OF TOPICS USER CHOOSES FROM IN CATEGORY
    public static void TopicsUtil(String topic, Scanner csc, PrintWriter pw, ArrayList<String> Topics) throws Exception{
        System.out.println("Welcome to your topics, which one would you like to access? (Enter a number)");
        for(int i = 0; i < Topics.size(); i++){
            System.out.println(i + " " + Topics.get(i));
        }
        int wantedTopicIndex = csc.nextInt();
        String wantedTopic = Topics.get(wantedTopicIndex);
    }   



    public static void checkTopics(Scanner fsc){
        //
    }
}
