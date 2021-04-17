import java.io.*;
import java.util.*;

public class TaskManager {
    private static ArrayList<String> Topics = new ArrayList<String>();
    private static ArrayList<String>[] todos = new ArrayList[Topics.size()];
    public static void main(String[] args) throws Exception{
       //WELCOME MENU BAR
        Scanner csc = new Scanner(System.in); //console scanner 
        Scanner fsc = new Scanner(new File("taskmanager.in")); // file scanner
        PrintWriter pw = new PrintWriter("taskmanager.out");
        
        String response = Welcome(csc);
        while(1<2){//repeats over and over until user exits
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
            } else if(response.equals("d")){                
                System.exit(0);
            }else {
                System.out.println("Incorrect input, try again");
                Welcome(csc);
            }
        }
    } 

    public static String Welcome(Scanner csc){
        System.out.println("Welcome to the Task Manager?");
        System.out.println("What would you like to do?");
        System.out.println("(a) Create a new topic");
        System.out.println("(b) Delete a topic");
        System.out.println("(c) Check your topics");
        System.out.println("(d) Quit");
        return csc.next().substring(0,1);
    }

    //LIST OF TOPICS USER CHOOSES FROM IN CATEGORY
    public static void TopicsUtil(String topic, Scanner csc, PrintWriter pw, ArrayList<String> Topics) throws Exception{
        if()
        System.out.println("Welcome to your topics, which one would you like to access? (Enter a number)");
        for(int i = 0; i < Topics.size(); i++){
            System.out.println(i + " " + Topics.get(i));
        }
        int wantedTopicIndex = csc.nextInt();
        String wantedTopic = Topics.get(wantedTopicIndex);
        
        checkTopicsTodos(csc, wantedTopic, wantedTopicIndex);
    }   



    public static void checkTopicsTodos(Scanner csc, String wantedTopic, int wantedTopicIndex){
        //
        if(todos[wantedTopicIndex].isEmpty()){
            do{
                System.out.println("Your todo list for "+wantedTopic+" is empty, what would you like to add? (Type \"quit\" to exit");
                String s = csc.nextLine();
                if(!s.equals("quit")){
                    todos[wantedTopicIndex].add(s);
                } else {
                    break;
                }
            } while(1 > 2);
        }else {
            System.out.println("What would you like to do now?");
            System.out.println("(a) Add new todos");
            System.out.println("(b) Delete todos");
            System.out.println("(c) Start todo");

            String s = csc.next();
        }
    }


}
