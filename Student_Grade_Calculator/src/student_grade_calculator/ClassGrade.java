/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_grade_calculator;

import java.io.File;

/**
 *
 * @author Seth
 */
public class ClassGrade extends File{
        public String courseName;
        public Categories [] categories;
        private String filetype;
        
        public ClassGrade(String pathname) {
            super(pathname);
            this.courseName = pathname;
        }

        // Display the current entries of the grades and the current final grade
        public void displayGrades(){
            
        }
        
        // Add editing functions
        public void edit(){
            
        }
        
        public void setFileType(String type){
            this.filetype = type;
        }
        public String getFileType(){
            return this.filetype;
        }
        
}