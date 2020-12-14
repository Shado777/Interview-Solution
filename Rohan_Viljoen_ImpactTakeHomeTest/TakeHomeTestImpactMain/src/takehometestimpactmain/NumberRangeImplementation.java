/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package takehometestimpactmain;

import java.util.*;
import java.util.stream.*;
/**
 *
 * @author viljo
 * 
 * 
 * Class for implementing the given NumberRangeSummarizer interface
 * 
 * 
 * 
 */
public class NumberRangeImplementation implements NumberRangeSummarizer{

    @Override
    public Collection<Integer> collect(String input) {
        
        List<Integer> numberList = new ArrayList<>();
        String[] numString = input.split(",");
        
        for(int x=0; x < numString.length; x++){
            numberList.add(Integer.parseInt(numString[x]));
        }
        //Added a sorting method for the arraylist if the numbers are not sorted
        Collections.sort(numberList);
        
        return numberList;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        
       List<Integer> numShowList = new ArrayList<Integer>(input);
       Object[] numObject = numShowList.toArray();
       int[] commaNumbers = new int[numObject.length];
       
       for(int x=0; x < numObject.length; x++){
           commaNumbers[x] = Integer.parseInt(numObject[x].toString());
       }
        
       //algortithm to get the range of the numbers in the list using java 8 stream
        List<String> rangeOfNumbers = IntStream.of(commaNumbers)
            .boxed()
            .collect(Collector.of(
                    () -> {
                        List<List<Integer>> list = new ArrayList<>();
                        list.add(new ArrayList<>());
                        return list;
                    },
                    (list, x) -> {
                        List<Integer> inner = list.get(list.size()-1);
                        if (inner.isEmpty()) {
                            inner.add(x);
                        } 
                        else {
                            int lastElement = inner.get(inner.size()-1);
                            if (lastElement == x-1) {
                                inner.add(x);
                            } 
                            else {
                                List<Integer> notRange = new ArrayList<>();
                                notRange.add(x);
                                list.add(notRange);
                            }
                        }
                    },
                    (left, right) -> {
                        throw new IllegalArgumentException("Not aligned");
                    },

                    list -> {
                        return list.stream()
                                .map(inner -> {
                                    if (inner.size() > 1) {
                                        return " "+inner.get(0) + "-" + inner.get(inner.size() - 1)+",";
                                    }
                                    return " " + inner.get(0)+",";
                                }).collect(Collectors.toList());
                    }));
        
        //Iterating through the list and building the String that is going to be output
        StringBuilder outSb = new StringBuilder();
        Iterator<String> iterate = rangeOfNumbers.iterator();
        
        while(iterate.hasNext()) {
            outSb.append(iterate.next());
        }
        
        String outputRange = outSb.toString();
        return outputRange;
    }  
    
}
