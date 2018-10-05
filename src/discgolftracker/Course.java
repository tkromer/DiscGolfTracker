/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discgolftracker;

import java.io.Serializable;
import java.util.Scanner;


/**
 *
 * @author Jim
 */
public class Course implements Serializable{
    private String courseName;
    private String courseLocation;
    private int courseLength;
    private int courseAvg;
    private int courseBest;
    //Information about the holes is stored in an array of hole objects
     hole[] holeInfo = new hole[18];
    
    public Course() {
        this.setCourseAvg(0);
        this.setCourseBest(0);
         
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseLocation() {
        return courseLocation;
    }

    public int getCourseLength() {
        return courseLength;
    }

    public int getCourseAvg() {
        return courseAvg;
    }

    public int getCourseBest() {
        return courseBest;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseLocation(String courseLocation) {
        this.courseLocation = courseLocation;
    }

    public void setCourseLength(int courseLength) {
        this.courseLength = courseLength;
    }

    public void setCourseAvg(int courseAvg) {
        this.courseAvg = courseAvg;
    }

    public void setCourseBest(int courseBest) {
        this.courseBest = courseBest;
    }
    
    public void setCourse() {
        int usrPar;
        int usrDist;
        Scanner in = new Scanner(System.in);
        String input;
        hole test;
        
        System.out.print("Name of the course: ");
        input = in.nextLine();
        this.setCourseName(input);
        System.out.print("\nNumber of holes: ");
        input = in.nextLine();
        this.setCourseLength(Integer.parseInt(input));
        
        for (int i = 0; i < this.getCourseLength(); i++){
            
            // Get course info from user
            System.out.print("Hole " + (i+1) + " par: ");
            usrPar = Integer.parseInt(in.next());            
            System.out.print("Hole " + (i+1) + " distance in ft: ");
            usrDist = Integer.parseInt(in.next());
            
            test = new hole(usrPar, usrDist);
            holeInfo[i] = new hole(usrPar, usrDist);            
            
            System.out.println("Hole " + (i+1) + " saved successfully!\n");
        }
        

    }
    
    public void printCourse() {
        int count;
        int i;
        
        this.displayName();
        
        //Print Column Headers
        System.out.println("| Hole #  | Par  | Distance |");
        
        System.out.print("|");
        for (count = 0; count < 27; count++) {
            System.out.print("-");
        }
        
        System.out.print("|\n");
        
        for (count = 0; count < this.getCourseLength(); count++) {
            System.out.print("|   ");
            //Print Hole Number
            if ((count + 1) < 10) {
                System.out.print(" " + (count + 1) + "    |");
            }
            else {
                System.out.print((count + 1) + "    |");
            }
            
            // Print par
            if (holeInfo[count].getPar() < 10) {
                System.out.print("  " + holeInfo[count].getPar() + "   |");
            }
            else {
                System.out.print(" " + holeInfo[count].getPar() + "   |");
            }
            
            // Print distance
            if (holeInfo[count].getDistance() < 999) {
                System.out.print("   " + holeInfo[count].getDistance() + "ft  |");
            }
            else {
                System.out.print("  " + holeInfo[count].getDistance() + "ft  |");
            }

            System.out.print("\n|");
            for (i = 0; i < 27; i++) {
                System.out.print("-");
            }
            System.out.print("|\n");
        }
        
    }
    
    public void displayName() {
        int count;
        int spacing = 27 - this.getCourseName().length();
        
        // Prints formatted course name
        System.out.print("|");
        for (count = 0; count < 27; count++) {
            System.out.print("-");
        }
        System.out.print("|\n");
        
        System.out.print("|");
        
        if(spacing % 2 == 0) {
            for (count = 0; count < spacing / 2; count++) {
                System.out.print(" ");
            }
            System.out.print(this.getCourseName());
            for (count = 0; count < spacing / 2; count++) {
                System.out.print(" ");
            }
        }
        
        else {
            for (count = 0; count < spacing / 2; count++) {
                System.out.print(" ");
            }
            System.out.print(this.getCourseName());
            for (count = 0; count <= spacing / 2; count++) {
                System.out.print(" ");
            }
        }
        System.out.print("|\n");
        
        System.out.print("|");
        for (count = 0; count < 27; count++) {
            System.out.print("-");
        }
        System.out.print("|\n");
    }
    
    
    
    
    
}
