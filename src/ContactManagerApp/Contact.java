package src.ContactManagerApp;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

import static src.ContactManagerApp.ContactFunctions.*;

public class Contact  {
    Scanner sc = new Scanner(System.in);

    final static String outputFilePath = "/Users/songjuoh/Desktop/CodeUp/IdeaProjects/contactManagerProject/src/ContactManagerApp/contacts.txt";



    public static void main(String[] args) {
//        Path pathToDirectory = Paths.get("src/ContactManagerApp");
//        Path pathToTxtfile = Paths.get("src/ContactManagerApp/contacts.txt");
//        createTxtFile(pathToDirectory, "contacts");
//
//        String[] clients = { "John Doe | 561-422-3333", "Marry Jane | 321-222-3420", "Axaxander King | 211-322-3444"};
//        putArrayInText(pathToTxtfile, List.of(clients));
         askUser();
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
}
