/*
Java Hashset: https://www.hackerrank.com/challenges/java-hashset/problem
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        HashSet<String> inputSet = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int var = Integer.parseInt(input);
        for(int i=1; i<=var; i++){
            String str = scanner.nextLine();
            inputSet.add(str);
            System.out.println(inputSet.size());
              
        }
        
    }
}
