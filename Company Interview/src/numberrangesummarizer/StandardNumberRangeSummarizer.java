package numberrangesummarizer;

import java.util.*;

public class StandardNumberRangeSummarizer implements NumberRangeSummarizer {


    //collect the input
    @Override
    public Collection<Integer> collect(String input) {
        List<Integer> numList = new ArrayList<>(); // create a new ArrayList to store the integer values

        // checks if input array is empty or null
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input is null or empty");
        }

        String[] numbers = input.split(","); // split the input string by comma and store the resulting array of strings in 'numbers'

        for (String s: numbers) {  // loop over each string in value in 'numbers'
            try {
                int num = Integer.parseInt(s); // parse the string to an integer
                if (!numList.contains(num)) {  //check if integer is not yet in the ArrayList
                    numList.add(num);
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Input " + e + " is not valid");
            }
        }

        // sort the numList incase the input is unsorted
        Collections.sort(numList);

        return numList; // return the ArrayList containing the integer values
    }

    //get the summarized string
    @Override
    public String summarizeCollection(Collection<Integer> input) {

        if (input == null) { // check if input is null
            throw new IllegalArgumentException("Input collection is null");
        }

        if (input.isEmpty()) {
            throw new IllegalArgumentException("Input collection is empty");
        }
        // create an ArrayList from given input
        List<Integer> inputList = new ArrayList<>(input);

        // Checks if inputList is Empty otherwise it sorts in ascending
        if (inputList.isEmpty()) {
            throw new IllegalArgumentException("input collection is empty");
        } else {
            Collections.sort(inputList);
        }

        // Initializer the result string and variables to keep track of the range
        StringBuilder result = new StringBuilder();
        int start = inputList.get(0);
        int end = inputList.get(0);

        // Traverse through the inputList updating the start and end variables
        for (int j = 1; j < inputList.size(); j++) {
            if (inputList.get(j) == end + 1) { // check if the current number has a difference '1' from the first.
                end = inputList.get(j);       // update the end of the range
            } else {
                //Append the current range to the result string
                if (start == end) {
                    result.append(start).append(", ");
                } else {
                    result.append(start).append("-").append(end).append(", ");
                }

                start = inputList.get(j);
                end = inputList.get(j);
            }
        }

        // Append the final range to the result string
        if (start == end) {
            result.append(start);
        } else {
            result.append(start).append("-").append(end);
        }

        return result.toString(); // return the summarized string
    }
}

