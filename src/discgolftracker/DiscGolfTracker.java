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
 * @author Tim Kromer
 */
public class DiscGolfTracker{

    /**
     * @param args the command line arguments
     */
    private List<String> courseList = new ArrayList();
     
    public static void main(String[] args) {
        // TODO code application logic here
        
        DiscGolfTracker test = new DiscGolfTracker();
        String response;
        Scanner in = new Scanner(System.in); 

        System.out.print("Do you want to add a new course? (Y/N):  ");
        response = in.next();

        if (response.equals("y") || response.equals("Y")) {
            test.addCourse();
            System.out.println("Course Saved Successfully!");   
        }
           
        test.printList();   
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
           openList();
           courseList.add(course.getCourseName());
               
           FileOutputStream courseListFile = new FileOutputStream("Course List.dat");
           ObjectOutputStream courseListOut = new ObjectOutputStream(courseListFile);
               
           courseListOut.writeObject(getList());
               
           courseListFile.close();

           courseFile.close();
          }
          catch (IOException ex) {
               System.out.println("IO Exception Caught Write" + ex);
          }
    }
        
    public void openList() {
        try{
            FileInputStream readList = new FileInputStream("Course List.dat");
            ObjectInputStream courseListObject = new ObjectInputStream(readList);
               
            setCourseList((List)courseListObject.readObject());
           
            readList.close();
        }catch (Exception e) {}
    }
    
    public void setCourseList(List<String> newList) {
        courseList = newList;
    }
    
    public List<String> getList() {
        return courseList;
    }
    
    public void printList() {
        System.out.println(getList());
    }
}
