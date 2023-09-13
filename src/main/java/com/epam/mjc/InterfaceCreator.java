package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
         Predicate<List<String>> valuePredicate = x -> {
        	boolean result = true;
        	for (Iterator<String> iterator = x.iterator(); iterator.hasNext();) {
				String stringFromList = iterator.next();
				if (stringFromList.matches("^[^A-Z].+")) {
					result = false;
				}
			}
        	return result;
        };
         return valuePredicate;
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
    	Consumer<List<Integer>> findEvenValuesConsumer = x -> {
    		List<Integer> addIntegers = new ArrayList<>();
    		for (Iterator iterator = x.iterator(); iterator.hasNext();) {
				Integer integer = (Integer) iterator.next();
				if (integer % 2 == 0) {
					addIntegers.add(integer);
				}
			}
    		x.addAll(addIntegers);
    	};
    	return findEvenValuesConsumer;
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
    
       Supplier<List<String>> fitlterSupplier = () -> {
    	   List<String> resultList = new ArrayList<>();
    	   for (Iterator iterator = values.iterator(); iterator.hasNext();) {
    		   String string = (String) iterator.next();
    		   if (string.matches("[A-Z](\\w+\\s+){3,}(\\w+\\.){1}")) {
				resultList.add(string);
			}
		}
    	   return resultList;
       };
       return fitlterSupplier;
   }
 

    public Function<List<String>, Map<String, Integer>> stringSize() {
        Function<List<String>, Map<String, Integer>> functionSizeFunction = x -> {
        	Map<String, Integer> resultMap = new HashMap<>();
        	for (Iterator iterator = x.iterator(); iterator.hasNext();) {
				String listString = (String) iterator.next();
				resultMap.put(listString, listString.length());
			}
        	return resultMap;
        };
    	return functionSizeFunction;
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        BiFunction<List<Integer>, List<Integer>, List<Integer>> concatListBiFunction = (x,y) -> {
        	List<Integer> resultList = new ArrayList<>(x);
        	resultList.addAll(y);
        	return resultList;
        };
        return concatListBiFunction;
    }
}
