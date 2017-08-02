/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_grade_calculator;

import java.util.TreeMap;

/**
 *
 * @author Seth
 */
public class Categories{
        public double percentage;
        public TreeMap<String, Student_Grade_Calculator.Assignment> entries;
        public String name;
        
        public Categories(String name){
            this.name = name;
        }
        
        public void add(String name, Student_Grade_Calculator.Assignment assignment){
            entries.put(name, assignment);
        }
    }
