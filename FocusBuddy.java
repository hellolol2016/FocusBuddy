import java.io.*;
import java.util.*;

public class FocusBuddy {
    private static ArrayList<String> Topics = new ArrayList<String>();
    private static ArrayList<ArrayList<String>> todos = new ArrayList<ArrayList<String>>();
    private static ArrayList<int[]> distractionList = new ArrayList<int[]>();
    public static void main(String[] args) throws Exception{
       //WELCOME MENU BAR
       Scanner fsc = new Scanner(new File("focusbuddy.out")); // file scanner
        while(fsc.hasNext()){
            Topics.add(fsc.next());
        }

        Scanner csc = new Scanner(System.in); //console scanner         
        
        
        while(1<2){//repeats over and over until user exits
            //USER ADDS NEW TOPIC, OR CHECKS TOPIC, OR EXIT
            String response = Welcome(csc);
            if(response.equals("a")){
                System.out.println("What topic would you like to add?");//ADD
                Topics.add(csc.next());
                todos.add(new ArrayList<String>());
            } else if(response.equals("b")){
                System.out.println("What topic would you like to delete?");//DELETE
                String topic = csc.next();
                for(int i = 0; i < Topics.size(); i++){
                    if(Topics.get(i).equals(topic)){
                        Topics.remove(i);
                    }
                }
            } else if(response.equals("c")){
                TopicsUtil(csc);
            } else if(response.equals("d")){                
                distractionChart();
                System.out.println("Your distraction chart has been updated in \"distraction.out\"");
            } else if(response.equals("e")){
                PrintWriter save = new PrintWriter("focusbuddy.out");
                for(int i = 0; i < Topics.size(); i++){
                    save.print(Topics.get(i) + " ");
                }
                save.close();
                System.exit(0);
            }else {
                System.out.println("Incorrect input, try again");
                System.out.println();
            }
        }
    }

    public static void distractionChart()throws Exception{
        PrintWriter pwo = new PrintWriter("distraction.out");
        for(int i = 0; i < distractionList.size(); i++){
            int distractionCount = 0;
            String topic = "";
            for(int j = 0; j < Topics.size(); j++){
                if(distractionList.get(i)[0]==j){
                    distractionCount += distractionList.get(i)[1];
                    topic = Topics.get(j);
                }
            }
            pwo.print(topic + ": ");
            for(int k = 0; k < distractionCount; k++){
                pwo.print("-");
            }
            pwo.println();
        }
        pwo.close();
    }

    public static String Welcome(Scanner csc){
        System.out.println("Welcome to the FocusBuddy?");
        System.out.println("What would you like to do?");
        System.out.println("(a) Create a new topic");
        System.out.println("(b) Delete a topic");
        System.out.println("(c) Check your topics");
        System.out.println("(d) Check your distraction chart");
        System.out.println("(e) Quit");
        return csc.next().substring(0,1);
    }

    //LIST OF TOPICS USER CHOOSES FROM IN CATEGORY
    public static void TopicsUtil(Scanner csc) throws Exception{
        if(Topics.isEmpty()){
            createTopics(csc);
        }
        System.out.println("Welcome to your topics, which one would you like to access? (Enter a number)");
        
        for(int i = 1; i <= Topics.size(); i++){
            System.out.println(i + " " + Topics.get(i-1));
        }
        int wantedTopicIndex = csc.nextInt()-1;
        String wantedTopic = Topics.get(wantedTopicIndex);
        
        checkTopicsTodos(csc, wantedTopic, wantedTopicIndex);
    }   

    public static void createTopics(Scanner csc){
        System.out.println("Looks like you need to add some topics, list them out and type \"quit\" to quit (Note: topics can only be 1 word)");
        int i = 1;
        while(1<2){
            System.out.print("Topic " + i + ": ");
            String s = csc.next();
            if(!s.toLowerCase().equals("quit")){
                Topics.add(s);
                todos.add(new ArrayList<String>());
                i++;
            } else {
                break;
            }
        }
    }

    public static void checkTopicsTodos(Scanner csc, String wantedTopic, int wantedTopicIndex)throws Exception{
        
        if(todos.isEmpty()){
            do{
                System.out.println("Your todo list for "+wantedTopic+" is empty, what would you like to add? (Type \"quit\" to exit)");
                String s = csc.nextLine();
                if(!s.equals("quit")){
                    todos.get(wantedTopicIndex).add(s);
                } else {
                    break;
                }
            } while(1 < 2);
        }else {
            System.out.println("*---* YOUR TODO LIST FOR " + wantedTopic.toUpperCase() + " *---*");
            for(int i = 0 ; i < todos.get(wantedTopicIndex).size(); i++){
                System.out.println((i+1) + " : " + todos.get(wantedTopicIndex).get(i));
            }
            System.out.println();
            System.out.println("What would you like to do now?");
            System.out.println("(a) Add new todos");
            System.out.println("(b) Delete todos");
            System.out.println("(c) Start todo");

            String s = csc.next().substring(0,1);
            if(s.toLowerCase().equals("a")){
                createTodo(csc, wantedTopicIndex);
            } else if(s.toLowerCase().equals("b")){
                deleteTodo(csc, wantedTopicIndex);
            } else if(s.toLowerCase().equals("c")){
                startTodo(csc, wantedTopicIndex, wantedTopic);
            }
        }
    }

    public static void createTodo(Scanner csc, int wti){
        while(1<2){
            System.out.print("What would you like to add? (Type \"quit\" to exit) \n");
            String s = csc.nextLine();
            if(!s.equals("quit")){
                if(!s.equals("\n")){
                    todos.get(wti).add(s);
                }
            } else {
                break;
            }
        }
    }
    
    public static void deleteTodo(Scanner csc, int wti){
        do{
            System.out.println("What would you like to delete? (Type \"quit\" to exit");
            String s = csc.nextLine().toLowerCase();
            while(1<2){
                if(!s.equals("quit")){
                    for(int i = 0; i < todos.get(wti).size(); i++){
                        if(todos.get(wti).get(i).toLowerCase().equals(s)){
                            todos.get(wti).remove(i);
                        }
                    }
                } else {
                    break;
                }
            }
        } while(1 < 2);
    }

    public static void deleteTodo(int wti, int tdi){
        todos.get(wti).remove(tdi);
    }

    public static void startTodo(Scanner csc, int wti, String wt){
        System.out.println("Lets get started! What do you want to do?");
        for(int i = 0; i < todos.get(wti).size(); i++){
            System.out.println((i+1) + " " + todos.get(wti).get(i));
        }
        int tdi = csc.nextInt()-1;
        String todoNow = todos.get(wti).get(tdi);
        long start = System.currentTimeMillis();
        System.out.println("CURRENTLY DOING TASK : " + todoNow.toUpperCase() + ", TYPE \"DONE\" TO EXIT");
        while( 1 < 2){
            String s = csc.next();
            if(s.toLowerCase().equals("done")){
                deleteTodo(wti, tdi);
                long finish = System.currentTimeMillis();
                double timeElapsed = (finish - start)/1000;
                double timeElapsedSeconds = Math.round(timeElapsed * 100.0) / 100.0;
                int p1 = (int)timeElapsedSeconds % 60;
                int p2 = (int)timeElapsedSeconds / 60;
                int p3 = p2 % 60;
                System.out.println( "This activity took " + p3 + " hours " + p2 + " minutes and " + p1+" seconds");
                int[] distraction = {wti, distraction(csc,wti,todoNow)};
                distractionList.add(distraction);
                break;
            }
        }
    }

    public static int distraction(Scanner csc, int wti, String todoNow){
        System.out.println("How many distractions did you encounter during task: " + todoNow + "?");
        return csc.nextInt();
    }
}
