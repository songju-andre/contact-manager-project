package src.ContactManagerApp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;


public class ContactFunctions extends Clients {

    static Scanner sc = new Scanner(System.in);
    static Path pathToTxtfile = Paths.get("src/ContactManagerApp/contacts.txt");



    public ContactFunctions(String firstName, String lastName, int phoneNum) {
        super(firstName, lastName, phoneNum);
    }





    public static void askUser(){
        boolean wantMore = true;
        do{
            System.out.println("\n" +
                    "1. View contacts.\n" +
                    "2. Add a new contact.\n" +
                    "3. Search a contact by name.\n" +
                    "4. Delete an existing contact.\n" +
                    "5. Exit.\n" +
                    "Enter an option (1, 2, 3, 4 or 5):");



            int answerMain =  Integer.parseInt(sc.nextLine());


            if(answerMain== 1){
                readFileAndOutput();

            }else if(answerMain == 2){

                addToList2();

            }else if(answerMain == 3){
                System.out.println("Please enter name");
                String userInput = sc.nextLine();

                readFileAndFilter(userInput);


            }else if(answerMain == 4){
                readFileAndOutput();
                System.out.println("Please enter contact that you want to delete");
                String userInput = sc.nextLine();
                removeFromList(userInput);


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




    public static void readFileAndOutput (){
        /* * Reading through the list file located in the 'pathToFile' input and put them into new Array 'currentList'  */
        List<String> currentList = new ArrayList<>();
        try{
            currentList = Files.readAllLines(pathToTxtfile);  // going to read all of my list
        }catch (IOException iox){
            iox.printStackTrace();
        }
        printList( currentList);

    }


    public static void readFileAndFilter (String input){
        /* * Reading through the list file located in the 'pathToTxtfile' input and put them into new Array 'currentList'  */
        List<String> currentList = new ArrayList<>();
        try{
            currentList = Files.readAllLines(pathToTxtfile);  // going to read all of my list
        }catch (IOException iox){
            iox.printStackTrace();
        }

        List<String> filteredList = new ArrayList<>();
        for(String user : currentList){
            if (user.toLowerCase().contains(input.toLowerCase())){
                filteredList.add(user);
            }
        }
        printList( filteredList);

    }



    public static void putArrayInText (Path pathToFile, List<String> array){
        try{
            Files.write(pathToFile, array);
        }catch (IOException iox){
            iox.printStackTrace();
        }
    }


    public static void addToList2(){

        /* * Reading through the list file located in the 'pathToFile' input  */
        List<String> ititalList = new ArrayList<>();
        try{
            ititalList = Files.readAllLines(pathToTxtfile);  // going to read all of my list
        }catch (IOException iox){
            iox.printStackTrace();
        }

        System.out.println("Please enter the name");
        String name = sc.nextLine();


        boolean overwrite = false;


        for(String user : ititalList){
            if (user.toLowerCase().contains(name.toLowerCase())){
                System.out.printf("There's already a contact named %s. Do you want to overwrite it? y / n\n", name);
                String answer = sc.nextLine();
                if (answer.equalsIgnoreCase("y")){
                    removeFromList(name);
                    overwrite = true;
                }else{
                    addToList2();
                }
            }else{
                overwrite = true;
            }
        }

        System.out.println("Please enter the number");
        String number = sc.nextLine();
        int i = 0;
        while (overwrite == true && i<1){
            /* * Writing(Appending) on the list file located in the 'pathToFile' input  */
            String phoneNum = number.replaceFirst("(\\d{3})(\\d{3})(\\d+)","$1-$2-$3 ");
            String joined = String.join("\n" ,name+" | "+phoneNum+"\n");
            System.out.println(joined);

            try{
                Files.writeString(pathToTxtfile, joined, StandardOpenOption.APPEND);
            } catch (IOException iox){
                iox.printStackTrace();
            }

            /* * Reading through the list file located in the 'pathToFile' input  */
            List<String> currentList = new ArrayList<>();
            try{
                currentList = Files.readAllLines(pathToTxtfile);  // going to read all of my list
            }catch (IOException iox){
                iox.printStackTrace();
            }
            printList( currentList);
            i++;

        }


    }

    public static void addToList( String input){
        /* * Writing(Appending) on the list file located in the 'pathToFile' input  */
        String[] splitContact =   input.split("[|]");
        String name = splitContact[0];
        String phoneNum = splitContact[1];
        phoneNum = input.replaceFirst("(\\d{3})(\\d{3})(\\d+)","$1-$2-$3 ");
        String joined = String.join("\n" ,name, phoneNum);
        System.out.println(joined);

        //                System.out.printf("%-6d | %-7d | %-5d",incre,squared,cubed);
        try{
            Files.writeString(pathToTxtfile, joined, StandardOpenOption.APPEND);
        } catch (IOException iox){
            iox.printStackTrace();
        }
        /* * Reading through the list file located in the 'pathToTxtfile' input  */
        List<String> currentList = new ArrayList<>();
        try{
            currentList = Files.readAllLines(pathToTxtfile);  // going to read all of my list
        }catch (IOException iox){
            iox.printStackTrace();
        }
        printList( currentList);

    }

    public static void removeFromList ( String input){
        /* * Reading through the list file located in the 'pathToFile' input  */
        List<String> currentList = new ArrayList<>();
        try{
            currentList = Files.readAllLines(pathToTxtfile);  // going to read all of my list
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
            Files.write(pathToTxtfile, currentList);
        }catch (IOException iox){
            iox.printStackTrace();
        }
    }

    public static void printList(List<String> arrays){
        /* * Print out the list file located in the 'pathToFile' input  */
        System.out.println("| Name            |  Phone number |\n-----------------------------------");

        for (String list : arrays){  // print out the spice
            String[] splitList = list.split("[|]");
            System.out.printf("| %-15s | %s |\n", splitList[0], splitList[1]);
        }

    }

}
