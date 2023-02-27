package src.ContactManagerApp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

import static java.util.Arrays.asList;


public class ContactFunctions extends Clients {


    public ContactFunctions(String firstName, String lastName, int phoneNum) {
        super(firstName, lastName, phoneNum);
    }





    public static void askUser(){
        Path pathToTxtfile = Paths.get("src/ContactManagerApp/contacts.txt");
        boolean wantMore = true;
        do{
            System.out.println("" +
                    "\n1. View contacts.\n" +
                    "2. Add a new contact.\n" +
                    "3. Search a contact by name.\n" +
                    "4. Delete an existing contact.\n" +
                    "5. Exit.\n" +
                    "Enter an option (1, 2, 3, 4 or 5):");


            Scanner sc = new Scanner(System.in);

            int answerMain =  Integer.parseInt(sc.nextLine());


            if(answerMain== 1){
                readFileAndOutput(pathToTxtfile);

            }else if(answerMain == 2){
                System.out.println("Please enter the name");
                String name = sc.nextLine();
                System.out.println("Please enter the number");
                String number = sc.nextLine();
                addToList2(pathToTxtfile, name, number);

            }else if(answerMain == 3){
                System.out.println("Please enter name");
                String userInput = sc.nextLine();

                readFileAndFilter(pathToTxtfile, userInput);


            }else if(answerMain == 4){
                readFileAndOutput(pathToTxtfile);
                System.out.println("Please enter contact that you want to delete");
                String userInput = sc.nextLine();
                removeFromList(pathToTxtfile, userInput);


            }else if(answerMain == 5) {
                System.out.println("Thank you. Have a good one.");
                break;
            }
        }while (wantMore = true);

    }




    /* * Create new file directory in the file path */
    /* * (ex) src/data       */
    public static void createDirectory (Path pathToFile, String name){
        Path dataDir = Paths.get(""+pathToFile+"/"+name); // create file directory
        try{
            if (Files.notExists(dataDir)){
                Files.createDirectories(dataDir);
            }else{
                System.out.println("That directory already exists!");
            }
        }catch (IOException iox){
            System.out.println("Couldn't create the directory!");
            iox.printStackTrace();
        }
    }


    /* * Create new txt file in the file path */
    /* * (ex) src/data       */
    public static void createTxtFile (Path pathToFile, String name){
        Path pathToMyList = Paths.get(""+pathToFile+"/"+name+".txt"); // create txt file
        try{
            if (Files.notExists(pathToMyList)){
                Files.createFile(pathToMyList);
            }else{
                System.out.println("That file already exists!");
            }
        }catch (IOException iox){
            System.out.println("Couldn't create the file!");
            iox.printStackTrace();
        }
    }




    public static void readFileAndOutput (Path pathToFile){
        /* * Reading through the list file located in the 'pathToFile' input and put them into new Array 'currentList'  */
        List<String> currentList = new ArrayList<>();
        try{
            currentList = Files.readAllLines(pathToFile);  // going to read all of my list
        }catch (IOException iox){
            iox.printStackTrace();
        }
        /* * Print out the list file located in the 'pathToFile' input  */
        System.out.println("Name | Phone number\n-------------------");

        for (String list : currentList){  // print out the spice
            System.out.println(list);
        }
    }


    public static void readFileAndFilter (Path pathToFile, String input){
        /* * Reading through the list file located in the 'pathToFile' input and put them into new Array 'currentList'  */
        List<String> currentList = new ArrayList<>();
        try{
            currentList = Files.readAllLines(pathToFile);  // going to read all of my list
        }catch (IOException iox){
            iox.printStackTrace();
        }

        List<String> filteredList = new ArrayList<>();
        for(String user : currentList){
            if (user.toLowerCase().contains(input.toLowerCase())){
                filteredList.add(user);
            }
        }

        /* * Print out the list file located in the 'pathToFile' input  */
        System.out.println("Name | Phone number\n-------------------");

        for (String spice : filteredList){  // print out the spice
            System.out.println(spice);
        }
    }



    public static void putArrayInText (Path pathToFile, List<String> array){
        try{
            Files.write(pathToFile, array);
        }catch (IOException iox){
            iox.printStackTrace();
        }
    }


    public static void addToList2(Path pathToFile, String name, String number){
        /* * Writing(Appending) on the list file located in the 'pathToFile' input  */
        String phoneNum = number.replaceFirst("(\\d{3})(\\d{3})(\\d+)","$1-$2-$3 ");
        String joined = String.join("\n" ,name+" | "+phoneNum);
        System.out.println(joined);

        try{
            Files.writeString(pathToFile, joined, StandardOpenOption.APPEND);
        } catch (IOException iox){
            iox.printStackTrace();
        }
        /* * Reading through the list file located in the 'pathToFile' input  */
        List<String> currentList = new ArrayList<>();
        try{
            currentList = Files.readAllLines(pathToFile);  // going to read all of my list
        }catch (IOException iox){
            iox.printStackTrace();
        }
        System.out.println("Name | Phone number\n-------------------");
        /* * Print out the list file located in the 'pathToFile' input  */
        for (String list : currentList){  // print out the spice
            System.out.println(list);
        }
    }

    public static void addToList(Path pathToFile, String input){
        /* * Writing(Appending) on the list file located in the 'pathToFile' input  */
        String[] splitContact =   input.split("|", 2);
        String name = splitContact[0];
        String phoneNum = splitContact[1];
        phoneNum = input.replaceFirst("(\\d{3})(\\d{3})(\\d+)","$1-$2-$3 ");
        String joined = String.join("\n" ,name, phoneNum);
        System.out.println(joined);

        try{
            Files.writeString(pathToFile, joined, StandardOpenOption.APPEND);
        } catch (IOException iox){
            iox.printStackTrace();
        }
        /* * Reading through the list file located in the 'pathToFile' input  */
        List<String> currentList = new ArrayList<>();
        try{
            currentList = Files.readAllLines(pathToFile);  // going to read all of my list
        }catch (IOException iox){
            iox.printStackTrace();
        }
        System.out.println("Name | Phone number\n-------------------");
        /* * Print out the list file located in the 'pathToFile' input  */
        for (String list : currentList){  // print out the spice
            System.out.println(list);
        }
    }

    public static void removeFromList (Path pathToFile, String input){
        /* * Reading through the list file located in the 'pathToFile' input  */
        List<String> currentList = new ArrayList<>();
        try{
            currentList = Files.readAllLines(pathToFile);  // going to read all of my list
        }catch (IOException iox){
            iox.printStackTrace();
        }
        /* * Sort through the list file and compare if it matches the String input   */
        Iterator<String> listIterate = currentList.iterator();
        while (listIterate.hasNext()){
            String item = listIterate.next();
            if (item.toLowerCase(). contains(input.toLowerCase())){
                /* * Removes the list that matches the String input  */
                listIterate.remove();
            }
        }
        /* * Reading through the list file located in the 'pathToFile' input and put them into new Array 'currentList'  */
        try{
            Files.write(pathToFile, currentList);
        }catch (IOException iox){
            iox.printStackTrace();
        }
        System.out.println("Name | Phone number\n-------------------");
        /* * Print out the list file located in the 'pathToFile' input  */
        for (String spice : currentList){  // print out the spice
            System.out.println(spice);
        }
    }

}
