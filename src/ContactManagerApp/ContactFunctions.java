package src.ContactManagerApp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import static java.util.Arrays.asList;


public class ContactFunctions extends Clients {


    public ContactFunctions(String firstName, String lastName, int phoneNum) {
        super(firstName, lastName, phoneNum);
    }

    public class FileIoLecture {

        public static void main(String[] args) {
            Path path = Paths.get("src");
            System.out.printf("\nHere is the path: %s\n",path);
            Path pathToThisFile = Paths.get("src/lecturePackage.file_io","FileIoLecture.java");
            System.out.println(pathToThisFile);


//        /* * Create new file directory in the file path */
//        Path dataDir = Paths.get("src/data"); // create file directory
//        try{
//            if (Files.notExists(dataDir)){
//                Files.createDirectories(dataDir);
//            }else{
//                System.out.println("That directory already exists!");
//            }
//        }catch (IOException iox){
//            System.out.println("Couldn't create the directory!");
//            iox.printStackTrace();
//        }./


//        /* * Create new txt file in the file path */
//        Path pathToMyList = Paths.get("src/data/list.txt"); // create txt file
//        try{
//            if (Files.notExists(pathToMyList)){
//                Files.createFile(pathToMyList);
//            }else{
//                System.out.println("That file already exists!");
//            }
//        }catch (IOException iox){
//            System.out.println("Couldn't create the file!");
//            iox.printStackTrace();
//        }



            /* * Create an Array list named 'spices' */
//            List<String> spices = Arrays.asList("cardamom","ginger","saffron", "nutmeg", "black pepper", "salt");

            /* * Put the Array list into the text file in the path  */
//            Path pathToOtherFile = Paths.get("src/data/newFile.txt");
//            try{
//                Files.write(pathToOtherFile, spices);
//            }catch (IOException iox){
//                iox.printStackTrace();
//            }

//        List<String> currentList = new ArrayList<>();
//        try{
//            currentList = Files.readAllLines(pathToMyList);  // going to read all of my list
//        }catch (IOException iox){
//            iox.printStackTrace();
//        }
//        for (String spice : currentList){  // print out the spice
//            System.out.println(spice);
//        }
//        try{
//            Files.writeString(pathToMyList,"cumin\n", StandardOpenOption.APPEND);
//        } catch (IOException iox){
//            iox.printStackTrace();
//        }




//
//            readFileAndOutput(pathToOtherFile);
//
//
//            addToList(pathToOtherFile, "cumin\n");
//
//            readFileAndOutput(pathToOtherFile);
//
//            removeFromList(pathToOtherFile, "ginger");
//
//            addToList(pathToOtherFile, "ginger\n");
//
//            Path pathToTesting = Paths.get("src/data");
//
//
//            createDirectory( pathToTesting, "aTest");
//            createTxtFile( pathToOtherFile, "testing");

            Path pathToTestingTxt = Paths.get("src/data/testing.txt");
//            List <String> names = Arrays.asList("Songju", "Shah", "Alexia","Joe", "Chu", "Loonie","Luke", "Jona", "Fernando", "Aharown");

//            putArrayInText(pathToTestingTxt, names);
//            readFileAndOutput(pathToTestingTxt);


//            readFileAndOutput (pathToTestingTxt);









        }



        /* * Create new file directory in the file path */
        /* * (ex) src/data       */
        public void createDirectory (Path pathToFile, String name){
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
        public void createTxtFile (Path pathToFile, String name){
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




        public void readFileAndOutput (Path pathToFile){
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



        public void putArrayInText (Path pathToFile, List<String> array){
            try{
                Files.write(pathToFile, array);
            }catch (IOException iox){
                iox.printStackTrace();
            }
        }

        public void addToList(Path pathToFile, String input){
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

        public void removeFromList (Path pathToFile, String input){
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

}
