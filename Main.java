/***************************************************************************************
* Lviv'2020 // ACM // Java functional programming(by quicksort implementation example) *
*    file: ACMHW26_1.java (renamed to Main.java) // using Java 8                       *
****************************************************************************************/
//// use default package // or use package: // package org.eom.acm; 

import java.util.stream.*;
import java.util.*;

public class Main{
    final static Integer[] INPUT_DATA = new Integer[]{ 5, 7, 3, 4, 1, 9, 2, 8, 10, 6 }; 

    public static List<Integer> quickSort(List<Integer> xs){
        if(xs.size() < 2){
            return xs;
        }

        int x = xs.get(0);

        List<Integer> lesserPart = xs.stream().skip(1).filter(i -> i <= x).collect(Collectors.toList());

        List<Integer> greaterPart = xs.stream().skip(1).filter(i -> i > x).collect(Collectors.toList());

        return Stream.concat(
		        Stream.concat(quickSort(lesserPart).stream(),Stream.of(x)), 
				quickSort(greaterPart).stream()).collect(Collectors.toList());
    }

    public static void print(List<Integer> xs){	      
        if(xs.size() == 0){
            return;
        }
        else{
            int x = xs.get(0);
            System.out.print(String.valueOf(x) + " ");            
            print(xs.stream().skip(1).collect(Collectors.toList())); // xs.remove(0); print(xs);
        }
    }    

    public static void main(String[] args) {
        //System.out.println(Main.quickSort(new ArrayList<Integer>(Arrays.asList(INPUT_DATA))));
        List<Integer> input = new ArrayList<Integer>(Arrays.asList(INPUT_DATA));
        List<Integer> output = Main.quickSort(input);
        System.out.println("input:");
        Main.print(input);
        System.out.println();
        System.out.println("output:");
        Main.print(output);
        System.out.println(); 	
	
    }
}
