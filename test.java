import java.util.*;
public class test {
    public static void main(String[] args){
        Scanner csc = new Scanner(System.in);
        String response = Welcome(csc);
        System.out.println("You chose " + response);

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
}
