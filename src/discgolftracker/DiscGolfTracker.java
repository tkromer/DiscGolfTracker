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
     
    public static void main(String[] args) {
        // TODO code application logic here
        
        DiscGolfTracker test = new DiscGolfTracker();
        String response;
        Scanner in = new Scanner(System.in); 
        Course testCourse;

        System.out.print("Do you want to add a new course? (Y/N):  ");
        response = in.next();

        if (response.equals("y") || response.equals("Y")) {
            test.addCourse();
        }
        
        test.viewCourses();
        
        /*try {
            FileInputStream openCourse = new FileInputStream("./Courses/testCourse.dat");
            ObjectInputStream cObject = new ObjectInputStream(openCourse);
            
            testCourse = (Course)cObject.readObject();
            
            for (int i = 0; i < testCourse.getCourseLength();i++) {
                System.out.println("Par: " + testCourse.holeInfo[i].getPar());
            }
        } catch(Exception e){System.out.println(e);}*/

    }// end main
    
    /*
    * Creates course file in ./Courses directory and prompts the user to add
    * another
    */
    public void addCourse() {
        Course course = new Course();
        course.createCourse();
        Scanner usrIn = new Scanner(System.in);
        String response;
        // Saves course as .dat file in /Courses/ folder
        String courseFileName = "./Courses/" + course.getCourseName() + ".dat";
         
        // Serialize course object to "course name".dat
        try {
            FileOutputStream courseFile = new FileOutputStream(courseFileName);
            ObjectOutputStream courseOut = new ObjectOutputStream(courseFile);

            //Write newly created course object to file
            courseOut.writeObject(course);
            courseFile.close();
        }
        catch (IOException ex) {
            System.out.println("IO Exception Caught Write" + ex);
        }

        System.out.print("Would you like to add another course? (Y/N): ");
        response = usrIn.next();

        System.out.println("Course Saved Successfully!");

        if (response.equals("Y") || response.equals("y")) {
            addCourse();
        }          
    } // end addCourse
    
    /*
    * Reads list of course files present in the ./Courses dircectory and prints
    * them to the screen.
    *                       TO DO
    * 1. Print par
    * 2. Print best score
    * 3. Make it look pretty
    */
    public void viewCourses() {
        File folder = new File("./Courses");
        File[] listOfCourses = folder.listFiles();
        String file;
        
        for (int i = 0; i < listOfCourses.length; i++) {
            file = listOfCourses[i].getName();
            System.out.println((i + 1) + ". " + file.replace(".dat", "")); 
        }
    }
} // end class
