package src.ContactManagerApp;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Contact  {
    Scanner sc = new Scanner(System.in);

    final static String outputFilePath = "/Users/songjuoh/Desktop/CodeUp/IdeaProjects/contactManagerProject/src/ContactManagerApp/contacts.txt";



    public static void main(String[] args) {




//        Path pathToDirectory = Paths.get("src/ContactManagerApp");
//        Path pathToTxtfile = Paths.get("src/ContactManagerApp/contacts.txt");
//        createTxtFile(pathToDirectory, "contacts");

//        String[] clients = { "John Doe | 1112223333", "Marry Jane | 1112223420", "Axaxander King | 1112223444"};
//        putArrayInText(pathToTxtfile, List.of(clients));

        askUser();




//        Map<String, Student> students = new HashMap<>();


//        Clients[] clients = new Clients[3];
//        clients[0] = new Clients("Songju", "Oh", 1112223333);


//        HashMap<Clients,String> clientTest = new HashMap<>();
//        Clients songju = new Clients("Songju Oh");
//        clientTest.put(songju, "3335557777");
//
//        Clients andre = new Clients("Andre");
//        clientTest.put(andre, "1112223333");


//        System.out.println(clientTest.keySet());




//        /*! HashMap Approach */
//        HashMap<String,String> clientTest = new HashMap<>();
//        clientTest.put("Songju Oh", "1112223333");
//        clientTest.put("Alex Young", "1112223333");
//        clientTest.put("Jane Oh", "1112223333");
//
//        System.out.println(clientTest);
//
//
//        File file = new File(outputFilePath);
//
//
//        BufferedWriter bf = null;;
//
//        try{
//            //create new BufferedWriter for the output file
//            bf = new BufferedWriter( new FileWriter(file) );
//
//            //iterate map entries
//            for(Map.Entry<String, String> entry : clientTest.entrySet()){
//
//                //put key and value separated by a colon
//                bf.write( entry.getKey() + "|" + entry.getValue() );
//
//                //new line
//                bf.newLine();
//            }
//            bf.flush();
//
//        }catch(IOException e){
//            e.printStackTrace();
//        }finally{
//
//            try{
//                //always close the writer
//                bf.close();
//            }catch(Exception e){}
//        }













//        System.out.printf("%s %s", clientTest.get());


//        putArrayInText(pathToTxtfile,clientTest);












//        System.out.printf("Name: %s - GitHub Username: %s\nCurrent Average: %s\n" , students.get(key).getName(), key, students.get(key).getGradeAverage() );



//        HashMap<String,Object> clientInfo = new HashMap<>();
//        clientInfo.put("Songju",clients);
//        System.out.println(clientInfo);





    }



    public static void addToHashmap (){

        Scanner sc = new Scanner(System.in);



        System.out.println("Enter your client information.");
        System.out.println("Full name");
        String fullName = sc.nextLine();


        System.out.println("Phone number");
        String phoneNum =  sc.nextLine();


        HashMap<String,String> clientTest = new HashMap<>();
        clientTest.put(fullName, phoneNum);


        System.out.println(clientTest);

        File file = new File(outputFilePath);

        BufferedWriter bf = null;;

        try{
            //create new BufferedWriter for the output file
            bf = new BufferedWriter( new FileWriter(file) );

            //iterate map entries
            for(Map.Entry<String, String> entry : clientTest.entrySet()){

                //put key and value separated by a colon
                bf.write( entry.getKey() + "|" + entry.getValue() );

                //new line
                bf.newLine();
            }
            bf.flush();

        }catch(IOException e){
            e.printStackTrace();
        }finally{

            try{
                //always close the writer
                bf.close();
            }catch(Exception e){}
        }
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
                System.out.println("Please enter new contact");
                System.out.println("(ex) John Doe | 1112223333");
                String userInput = sc.nextLine();
                addToList(pathToTxtfile, userInput);

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
                wantMore = false;
                break;
            }

        }while (wantMore = true);





//        System.out.println("Enter your client information.");
//        System.out.println("First name");
//        String firstName = sc.nextLine();
//
//        System.out.println("Last name");
//        String lastName = sc.nextLine();
//
//        System.out.println("Phone number");
//        int phoneNum =  Integer.parseInt( sc.nextLine() );







//        try{
//            Files.writeString(pathToFile,firstName, StandardOpenOption.APPEND);
//            Files.writeString(pathToFile,lastName, StandardOpenOption.APPEND);
////            Files.writeString(pathToFile,phoneNum, StandardOpenOption.APPEND);
//
//        } catch (IOException iox){
//            iox.printStackTrace();
//        }


        /* * Reading through the list file located in the 'pathToFile' input  */
        List<String> currentList = new ArrayList<>();
        try{
            currentList = Files.readAllLines(pathToTxtfile);  // going to read all of my list
        }catch (IOException iox){
            iox.printStackTrace();
        }
        System.out.println("Name | Phone number\n-------------------");
        /* * Print out the list file located in the 'pathToFile' input  */
        for (String spice : currentList){  // print out the spice
            System.out.println(spice);
        }


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

    public static void addToList2(Path pathToFile, String input){
        /* * Writing(Appending) on the list file located in the 'pathToFile' input  */
        try{
            Files.writeString(pathToFile,input, StandardOpenOption.APPEND);
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
        System.out.println("-------New-------");
        /* * Print out the list file located in the 'pathToFile' input  */
        for (String spice : currentList){  // print out the spice
            System.out.println(spice);
        }
    }



    public static void addToList(Path pathToFile, String input){
        /* * Writing(Appending) on the list file located in the 'pathToFile' input  */
        String[] splitContact =   input.split("|", 2);
        String name = splitContact[0];
        String phoneNum = splitContact[1];
        phoneNum = input.replaceFirst("(\\d{3})(\\d{3})(\\d+)","$1-$2-$3 ");
        String joined = String.join(name, phoneNum);
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
