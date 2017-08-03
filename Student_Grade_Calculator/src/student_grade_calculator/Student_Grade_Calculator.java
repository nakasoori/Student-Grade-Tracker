package student_grade_calculator;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Seth
 */
public class Student_Grade_Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cmd = -1;
        while(cmd != 3){
            //Display options
            display();
            
            //Receive input command
            cmd = input.nextInt();
            
            //Execute command
            /* Future TODO: Display current list of files
            *   Reformat files
            *   Compare numerous files
            *   Create Summary of multiple grades from separate files
            */
            switch(cmd){
                case 1: //Creates new file
                    try{
                        createFile();
                    }
                    catch(Exception e){
                        System.out.println("Could not create file");
                    }
                    break;
                    
                case 2: //Updates existing file
                    update();
                    break;
                    
                case 3: //Exits program
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Invalid option. Try again\n");
                    break;
                    
            }
        }        
    }
//==============================================================================
/* Helper function that displays the main menu
*   TODO: Update main menu options as more features are added
*/    
    public static void display(){
        System.out.println("Welcome to the grade calculator");
        System.out.println("-------------------------------");
        System.out.println("1) Create a new class spreadsheet");
        System.out.println("2) Update an existing class spreadsheet");
        System.out.println("3) Exit the program");
        System.out.print(">> ");
    }
//==============================================================================    
    public static void createFile(){ 
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter in the course Id: ");
        
            //Read in file name and create file with PrintWriter
            String courseName = in.nextLine();
            PrintWriter file = new PrintWriter(courseName + ".txt");
            file.println("Name: " + courseName + ".txt");

            
            //Initialize grade type (weighted or points based) <-- Future update to add points
            file.println("Type: Weighted");
            
            //Initialize number of categories
            Scanner numCategoriesScanner = new Scanner(System.in);
            System.out.print("How many weighted categories? ");
            int numCategories = numCategoriesScanner.nextInt();
            file.println("Number of Categories: " + numCategories);
            
            //Conclude file creation
            System.out.println(courseName + " spreadsheet has been created");
            file.close();
            System.out.print("File has been created. Continue adding assignments? (y/n)");
            String cont = in.next();
            if(cont == "y"){
                System.out.println("Calling update()");
                updateFile(courseName);
            }
            else{
                System.out.println("Returning to main menu\n");
            }
        }
        catch (Exception e){
            System.out.println("Could not be created");
        }
    }
//==============================================================================
    /* Want to be able to update:
        Name of file
        Number of Categories
        Edit any Categories
        Edit any Assignments
        Add or Remove any Assignments/Categories
    */
    public static void updateFile(String fileName){
        System.out.println("Continues to updateFile()");
        
    }
 //=============================================================================
/* Helper function for passing to updateFile()
*  Option 2 from main menu
*  @return No return unless user cancels updating file. Passes File Name to updateFile() if successful
*/
    public static void update(){
        System.out.print("What is the name of the file? ");
        Scanner input = new Scanner(System.in);
        String fileName = input.next();
        File file = new File(fileName + ".txt");
        while(!file.exists()){
            if(fileName.equals("exit"))
                return;
            else{
                System.out.println("File does not exist");
                System.out.print("Enter a valid file or enter 'exit' to return to main menu: ");
            }
            fileName = input.next();
            file = new File(fileName + ".txt");
        }
        updateFile(fileName);
    } 
    
    
    
    
//------------------------------------------------------------------------------    
    
    
    class Assignment{
        public double numPoints;
        public double pointsEarned;
        
        public Assignment(double numPoints, double pointsEarned){
            this.numPoints = numPoints;
            this.pointsEarned = pointsEarned;
        }
    }
}
