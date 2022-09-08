/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainmenu;


import java.io.File;
import java.io.IOException; 
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author w1734436
 */
public class TrainMenu {

    static final int NUMBER_OF_SEATS = 8;
    public static void main(String[] args) {
      
        
        String [] train = new String [NUMBER_OF_SEATS];
        for (int i=0; i<NUMBER_OF_SEATS; i++){
            train[i] = "e";
        }
        Scanner in = new Scanner(System.in);
        char choice;
        
        do {
            displayMenu();
            System.out.println("");
            System.out.println("::::::::::::::::::::::::::::::");
            System.out.println("Enter a choice (qQ) to exit");
            System.out.println("::::::::::::::::::::::::::::::");
            choice = in.next().toUpperCase().charAt(0);
            
            switch (choice){
                
                case 'E':
                    //System.out.println("You chose to display empty seats");
                    displayEmptySeats(train);
                    break;

                case 'Q':
                    break;

                case 'V':
                    viewSeats(train);
                    break;

                case 'A':
                    addCustomer(train);
                    break;

                case 'D':
                    deleteSeat(train);
                    break;

                case 'F':
                    findSeats(train);
                    break;

                case 'S':
                    saveFile(train);
                    break;

                case 'L':
                    loadFile(train);
                    break;
                case 'O':
                    orderSeats(train);
                    break;

                default:
                    System.out.println("You entered an invalid choice");
                    
            }
            
        }while (choice !='Q');
        System.out.println("Thank you for using out system. Good Bye!");
          
        }
    
        private static void displayMenu(){
            
            System.out.println("");
            System.out.println("::::::::::::::::::::::::::");
            System.out.println("Welcome to my Train Menu");
            System.out.println("::::::::::::::::::::::::::");
            System.out.println("");
            System.out.println("-------------------------");
            System.out.println("E:" + "|" + " Display Empty Seats" + " |");
            System.out.println("--------------------------");
            System.out.println("V:" + "|" + " View Available Seats" + " |");
            System.out.println("--------------------------");
            System.out.println("A:" + "|" + " Book your Seat" + " |");
            System.out.println("--------------------");
            System.out.println("F:" + "|" + " Find your Seat"+ " |");            
            System.out.println("--------------------");
            System.out.println("D:" + "|" + " Delete your Seat" + " |");
            System.out.println("----------------------");
            System.out.println("S:" + "|" + " Save your file" + " |");
            System.out.println("---------------------");
            System.out.println("L:" + "|" + " Load your file" + " |");
            System.out.println("-----------------------------------------------");
            System.out.println("O:" + "|" + " View Seats ordered alphabetically by name" + " |");
            System.out.println("-----------------------------------------------");
            System.out.println("");
        }
        
        
    private static void displayEmptySeats(String[] train) {
      
        for (int i = 0; i < NUMBER_OF_SEATS; i++){
            if ("e".equals(train[i])){
                System.out.println("Seat " + i + " is empty");
                
            }
        }
    }
    
    private static void viewSeats(String[] train) {
       for (int i = 0; i < NUMBER_OF_SEATS; i++){
           if("e".equals(train[i])){
               System.out.println("Seat " +  i  +  " is available");
           }
           else{
               System.out.println("Seat " + i +" has been booked by " + train[i]);
           }
       }
    }

    private static void addCustomer(String[] train) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the seat number that your would like to book in");
        int booking = input.nextInt();
        int i = 0;
        
        if (train[i] == "e") {
            System.out.println("Plase Enter your name");
            String yourName = input.next();
            train[booking]=yourName;
            System.out.println("Hello " + yourName + " Your Seat has been booked");
        } else {
            
        }
    }

    private static void deleteSeat(String[] train) {
        Scanner input = new Scanner (System.in);
        System.out.println("Enter your seat number");
        int seats = input.nextInt();
        
        switch (seats) {
            case 00:
                System.out.println("Your seat has been deleted");
                train[0] = "e";
                break;
                
            case 01:
                System.out.println("Your seat has been deleted");
                train[1] = "e";
                break;
            
            case 02:
                System.out.println("Your seat has been deleted");
                train[2] = "e";
                break;    
            
            case 03:
                System.out.println("Your seat has been deleted");
                train[3] = "e";
                break;
                
            case 04:
                System.out.println("Your seat has been deleted");
                train[4] = "e";
                break;
                
                
            case 05:
                System.out.println("Your seat has been deleted");
                train[5] = "e";
                break;
                
                
            case 06:
                System.out.println("Your seat has been deleted");
                train[6] = "e";
                break; 
                
            
            case 07:
                System.out.println("Your seat has been deleted");
                train[7] = "e";
                break;     
        }
    }

    private static void findSeats(String[] train) {
        Scanner input = new Scanner (System.in);
        System.out.println("Enter your Name");
        String fseat = input.next();
        boolean prnt = false;
        int trainSeat = -1;
        for (int x = 0; x <NUMBER_OF_SEATS; x++) {
            if (train[x].equals(fseat)){
                prnt = true;
                trainSeat = x;
                
            }else{
                
            }
        }
        if (prnt) {
            System.out.println("Hello " + fseat + ", Your seat number is " + trainSeat);
            
        }else {
            System.out.println("There aren't any bookings under your name");
        }
    }

    private static void saveFile(String[] train) {
        try{
            try (FileWriter myWriter = new FileWriter ("trainfile.txt")){
               for (int i = 0; i < NUMBER_OF_SEATS; i++) {
                   myWriter.write(train[i] + "\n");
                   
               }
            }
            System.out.println("Successfully saved the file");
        }
        catch (IOException e) {
            System.out.println("An Error Occured");
        }
        
    }
    
    private static void loadFile(String[] train) {
        try{
            try (Scanner fileinput = new Scanner(new File("trainfile.txt"))){
                while (fileinput.hasNextLine()){
                    for (int i = 0; i < NUMBER_OF_SEATS; i++) {
                        String data = fileinput.nextLine();
                        train[i] = data;
                    }
                }
            }
        }
        catch (IOException e) {
            System.out.println("I tried to load but couldn't find the file");
        }
    }

    private static void orderSeats(String[] train) {
       
    String[] TempArray = train.clone();
        for (int i = 0; i < NUMBER_OF_SEATS; i++) {
            for (int j = i +1 ; j < NUMBER_OF_SEATS; j++) {
                if (TempArray[i].compareToIgnoreCase(TempArray[j]) > 0) {
                    // all var changes here
                    String T;
                    T = TempArray[j];
                    TempArray[j] = TempArray[i];
                    TempArray[i] = T;
                }
            }
        }
        System.out.println(Arrays.toString(TempArray));

    }
}
