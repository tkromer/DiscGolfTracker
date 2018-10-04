/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discgolftracker;

import java.io.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import static javafx.scene.input.KeyCode.N;

/**
 *
 * @author Jim
 */
public class DiscGolfTracker{

    /**
     * @param args the command line arguments
     */
     
     private String workingCourse;
     private String openCourse;
     

     
    public static void main(String[] args) {
        // TODO code application logic here
           String response;
           Scanner in = new Scanner(System.in);
           
           
           System.out.print("Do you want to add a new course? (Y/N):  ");
           response = in.next();
           
           while (response.equals("y") || response.equals("Y")) {
                DiscGolfTracker test = new DiscGolfTracker();
                test.addCourse();
           }
           in.close();
           System.out.println("\nDone!");
         
         
    }
    
    public void addCourse() {
         Course course = new Course();
         course.setCourse();
         // Saves course as .dat file in /Courses/ folder
         String fileName = "./Courses/" + course.getCourseName() + ".dat";
         
         // Serialize Object
           try {
               FileOutputStream file = new FileOutputStream(fileName);
               ObjectOutputStream out = new ObjectOutputStream(file);
               
               //Write newly created course object to file
               
               out.writeObject(course);

              // out.close();
               file.close();
          }
          catch (IOException ex) {
               System.out.println("IO Exception Caught Write");
          }
    }
        
    public void openCourse(String courseName) {
         
         Course readCourse = null;
         String filePath = "./Courses/" + courseName + ".dat";
         //Deserialize Object
          try {
               // Read object from file
               FileInputStream file = new FileInputStream(filePath);
               ObjectInputStream in = new ObjectInputStream(file);
               
               // Deserialize Object\
               readCourse = (Course)in.readObject();
               
               //in.close();
               //readCourse.printCourse();               
          }
          catch(IOException ex) {
               System.out.println("Caught IO Exception Read");
          }
          
          catch(ClassNotFoundException es) {
               System.out.println("Class Not found Exception Read");
          }
    }
    
}
