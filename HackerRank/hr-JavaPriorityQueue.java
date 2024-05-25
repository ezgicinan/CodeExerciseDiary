/*Java Priority Queue: https://www.hackerrank.com/challenges/java-priority-queue/problem
*/
//The student having the highest Cumulative Grade Point Average (CGPA) is served first.
//Any students having the same CGPA will be served by name in ascending case-sensitive alphabetical order.
//Any students having the same CGPA and name will be served in ascending order of the id.

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> events = new ArrayList<>();
        
        while(scanner.hasNext()){
            String input = scanner.nextLine();
            events.add(input);
        }
        
        List<Student> students = Priorities.getStudents(events);
        //System.out.println("Events: " + events);
        
        if(students.size() == 0){
             System.out.println("EMPTY");
        } else {
            for(Student st: students){
                System.out.println(st.getName());
            }
        } 
    }
}

class Student {
    private int id;
    private String name;
    private double cgpa;
    
    public Student(int id, String name, double cgpa){
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    
    public int getID(){
        return this.id;
    }
    
    public String getName(){
        return this.name;
    } 
    
    public double getCGPA(){
        return this.cgpa;
    } 
}

class Priorities{
    public Priorities(){}
    
    public static List<Student> getStudents(List<String> events){
        List<Student> remainedStudents = new ArrayList<Student>();
        int queueCapacity = Integer.parseInt(events.get(0));
        
        PriorityQueue<Student> pq = new PriorityQueue<Student>(queueCapacity, new StudentComparator());
        
        for(int i=0; i<events.size(); i++){
            if (i==0) continue;
            List<String> singleEvent = Arrays.asList((events.get(i)).split(" "));
            
            if(singleEvent.get(0).equals("ENTER")){
                Student st = new Student(Integer.parseInt(singleEvent.get(3)), singleEvent.get(1), Double.parseDouble(singleEvent.get(2)));
                pq.add(st);
            } else {
                if(!pq.isEmpty()) pq.remove();
            }
        }
        
        while (!pq.isEmpty()) {
            Student student = pq.poll();
            remainedStudents.add(student);
        }

        return remainedStudents;
    }
}

class StudentComparator implements Comparator<Student>{
    public int compare(Student s1, Student s2) {
        double result = (s2.getCGPA() - s1.getCGPA());
        
        if (result == 0.0){
            int nameResult = (s1.getName()).compareTo(s2.getName());
            if (nameResult == 0) {
                return s1.getID()-s2.getID();
            }
            return nameResult;
        }
        return result>0.0 ? 1:-1;
    
    };
}