package com.example.test.klevu.services;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SearchImpl implements Search {
//    Input:
//    partialSearchTerms = ["s", "sh", "sho", "shoe", "shoes", "b", "ba", "baa", "ba", "bag"]
//
//    Output:
//            ["shoes", "bag"]


    //Old Solution
//    @Override
//    public Set<String> findTerms(List<String> searchStrings){
//        if (searchStrings.isEmpty()) {
//            return Collections.emptySet();
//        }
//        Set<String> searchedList = new HashSet<>();
//        String previousString = searchStrings.get(0);
//
//        for(String searchString : searchStrings){
//            if(searchString.startsWith(previousString) || previousString.startsWith(searchString)){ //check for the current possibility
//                previousString = searchString;
//            }
//            else if(!searchString.equals(previousString)){ // they don't match then store and move on
//                searchedList.add(previousString);
//                previousString = searchString;
//            }
//        }
//        searchedList.add(previousString);
//        return searchedList;
//    }

    @Override
    public Set<String> findTerms(List<String> searchStrings){
        if (searchStrings.isEmpty()) {
            return Collections.emptySet();
        }
        Set<String> searchedList = new HashSet<>();

        searchStrings.stream().reduce((previousTerm,currentTerm) -> {
            if(!currentTerm.startsWith(previousTerm) && !previousTerm.startsWith(currentTerm)){
                searchedList.add(previousTerm);
            }
            return currentTerm;
        }).ifPresent(searchedList::add);

        return searchedList;
    }

}
