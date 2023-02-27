package src.ContactManagerApp;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Contact  {
    Scanner sc = new Scanner(System.in);

    final static String outputFilePath = "/Users/songjuoh/Desktop/CodeUp/IdeaProjects/contactManagerProject/src/ContactManagerApp/contacts.txt";



    public static void main(String[] args) {

//        ContactFunctions functions = new ContactFunctions();



        Path pathToDirectory = Paths.get("src/ContactManagerApp");
        Path pathToTxtfile = Paths.get("src/ContactManagerApp/contacts.txt");

        createTxtFile(pathToDirectory, "contacts");




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


        HashMap<String,String> clientTest = new HashMap<>();
        clientTest.put("Songju Oh", "1112223333");
        clientTest.put("Alex Young", "1112223333");
        clientTest.put("Jane Oh", "1112223333");

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






//        System.out.printf("%s %s", clientTest.get());


//        putArrayInText(pathToTxtfile,clientTest);












//        System.out.printf("Name: %s - GitHub Username: %s\nCurrent Average: %s\n" , students.get(key).getName(), key, students.get(key).getGradeAverage() );



//        HashMap<String,Object> clientInfo = new HashMap<>();
//        clientInfo.put("Songju",clients);
//        System.out.println(clientInfo);













//        Map<String, Student> students = new HashMap<>();
//
//
//        Student alex = new Student("Alex");
//        alex.addGrade(90);
//        alex.addGrade(80);
//        alex.addGrade(70);
//        System.out.printf("%s's average grade is: %s\n", alex.getName(), alex.getGradeAverage());
//
//        Student angela = new Student("Angela");
//        angela.addGrade(80);
//        angela.addGrade(85);
//        angela.addGrade(70);
//        System.out.println(angela);
//        System.out.printf("%s's average grade is: %s\n", angela.getName(), angela.getGradeAverage());
//
//        Student jack = new Student("Jack");
//        jack.addGrade(75);
//        jack.addGrade(88);
//        jack.addGrade(80);
//        System.out.printf("%s's average grade is: %s\n", jack.getName(), jack.getGradeAverage());
//
//        Student song = new Student("Songju");
//        song.addGrade(85);
//        song.addGrade(98);
//        song.addGrade(83);
//        System.out.printf("%s's average grade is: %s\n", song.getName(), song.getGradeAverage());
//
////        Student alex = new Student("Alex", new ArrayList<>(Arrays.asList(90, 85, 70)));
////        Student angela = new Student("Angela", new ArrayList<>(Arrays.asList(90, 85, 70)));
////        Student jack = new Student("Jack", new ArrayList<>(Arrays.asList(80, 70, 85)));
////        Student song = new Student("Songju", new ArrayList<>(Arrays.asList(98, 85, 80)));
//
//
//
//        students.put("alexander01", alex );
//        students.put("angelino777", angela );
//        students.put("jackolantern", jack );
//        students.put("ossong", song );
//
//        System.out.println(students.keySet());



    }




    public static void addInfo(Path pathToFile){
        Scanner sc = new Scanner(System.in);



        System.out.println("Enter your client information.");
        System.out.println("First name");
        String firstName = sc.nextLine();

        System.out.println("Last name");
        String lastName = sc.nextLine();

        System.out.println("Phone number");
        int phoneNum =  Integer.parseInt( sc.nextLine() );

        Clients[] clients = new Clients[1];
        clients[clients.length-1] = new Clients(firstName, lastName, phoneNum);




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
        System.out.println("-------New-------");

        for (String spice : currentList){  // print out the spice
            System.out.println(spice);
        }
    }



//    public static void putArrayInText (Path pathToFile, Arrays<String> array){
//        try{
//            Files.write(pathToFile, array);
//        }catch (IOException iox){
//            iox.printStackTrace();
//        }
//    }

    public static void addToList(Path pathToFile, String input){
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
            if (item.equals(input)){
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
        System.out.println("-------New-------");
        /* * Print out the list file located in the 'pathToFile' input  */
        for (String spice : currentList){  // print out the spice
            System.out.println(spice);
        }
    }
}
