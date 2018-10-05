/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discgolftracker;

import java.io.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


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
     private List<String> courseList = new ArrayList();
     DiscGolfTracker test = new DiscGolfTracker();
     

     
    public static void main(String[] args) {
        // TODO code application logic here
        
        DiscGolfTracker test = new DiscGolfTracker();
           String response;
           Scanner in = new Scanner(System.in);
           
           List<String> fullList = new ArrayList();
           
           try{
           FileInputStream readList = new FileInputStream("Course List.dat");
           ObjectInputStream courseListObject = new ObjectInputStream(readList);
               
           test.courseList = (List)courseListObject.readObject();
           
           readList.close();
           } catch (Exception e) {}
         
          System.out.print("Do you want to add a new course? (Y/N):  ");
           response = in.next();

           if (response.equals("y") || response.equals("Y")) {
               test.addCourse();
               System.out.println("Course Saved Successfully!");   
           }
           
           System.out.println(fullList);
                    
                
           

           System.out.println("\nDone!");
    }
    
    public void addCourse() {
         Course course = new Course();
         course.setCourse();
         // Saves course as .dat file in /Courses/ folder
         String courseFileName = "./Courses/" + course.getCourseName() + ".dat";
         
         
         
         // Serialize Object
           try {
               FileOutputStream courseFile = new FileOutputStream(courseFileName);
               ObjectOutputStream courseOut = new ObjectOutputStream(courseFile);
               
               //Write newly created course object to file
               
               courseOut.writeObject(course);
               
               // Add name of course to master list
               courseList.add(course.getCourseName());
               
               FileOutputStream courseListFile = new FileOutputStream("Course List.dat");
               ObjectOutputStream courseListOut = new ObjectOutputStream(courseListFile);
               
               courseListOut.writeObject(courseList);
               
               courseListFile.close();

              // out.close();
               courseFile.close();
          }
          catch (IOException ex) {
               System.out.println("IO Exception Caught Write");
          }
    }
        
    public void openCourse(String courseName) {
         
         Course readCourse;
         String filePath = "./Courses/" + courseName + ".dat";
         //Deserialize Object
          try {
               // Read object from file
               FileInputStream file = new FileInputStream(filePath);
               ObjectInputStream fileIn = new ObjectInputStream(file);
               
               // Deserialize Object\
               readCourse = (Course)fileIn.readObject();
               
               fileIn.close();
               readCourse.printCourse();               
          }
          catch(IOException ex) {
               System.out.println("Caught IO Exception Read");
          }
          
          catch(ClassNotFoundException es) {
               System.out.println("Class Not found Exception Read");
          }
    }
    
}
