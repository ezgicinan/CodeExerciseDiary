/* 
Java Arraylist: https://www.hackerrank.com/challenges/java-arraylist/problem
*/ 

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowSize = Integer.parseInt(scanner.nextLine());
        
        List <List<Integer>> matrixList = new ArrayList<>();
        int rowCounter = 0;
        
        while(scanner.hasNextLine() && rowCounter<rowSize){
            String input = scanner.nextLine();
            String [] row = input.split(" ");
            
            List<Integer> list = new ArrayList<>();
            int colSize = Integer.parseInt(row[0]);
            int colCounter = 0;
            if(colSize != 0){
                for(int i=1; i<=colSize; i++)
                {
                    list.add(Integer.parseInt(row[i]));
                }
            }
            
            matrixList.add(rowCounter, list);
            rowCounter++;  
        }
        
        int inputSize = Integer.parseInt(scanner.nextLine());
        while(scanner.hasNextLine()){
            String input = scanner.nextLine();
            String [] row = input.split(" ");
            
            int first = Integer.parseInt(row[0]);
            int second = Integer.parseInt(row[1]);
            
            if(matrixList.size() >= first && (matrixList.get(first-1)).size() >= second){
                int value = (matrixList.get(first-1)).get(second-1);
                System.out.println(value);
                
            } else{
                System.out.println("ERROR!");
            }
            
        }
        
    }
}
