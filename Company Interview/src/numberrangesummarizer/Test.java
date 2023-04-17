package numberrangesummarizer;

import org.junit.jupiter.api.Assertions;
import java.util.Arrays;
import java.util.Collection;

public class Test {

    @org.junit.jupiter.api.Test
    public void testCollect() {

        //This test cases assumes that the String inputs are provided in the format as provided in the interface
        // i.e Sample Input: "1,3,6,7,8,12" no space between the commas.

        // Create an instance of the StandardNumberRangeSummarizer
        NumberRangeSummarizer summarizer = new StandardNumberRangeSummarizer();

        // Test case 1: Input string
        String input1 = "1,2,3,4,5";
        Collection<Integer> expectedOutput1 = Arrays.asList(1,2,3,4,5);
        Assertions.assertEquals(expectedOutput1, summarizer.collect(input1));

        // Test case 2: Unsorted Input
        String input2 = "4,1,5,7,3";
        Collection<Integer> expectedOutput2 = Arrays.asList(1,3,4,5,7);
        Assertions.assertEquals(expectedOutput2, summarizer.collect(input2));

        // Test case 3: Input String with non-integer values
        String input3 = "1,2,Neo,5";
        try {
            summarizer.collect(input3);
            Assertions.fail("Expected IllegalArgument to be thrown");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Input java.lang.NumberFormatException: For input string: \"Neo\" is not valid", e.getMessage());
        }

        //Test case 4:  Empty input String
        String input4 = "";
        try {
            summarizer.collect(input4);
            Assertions.fail("Expected IllegalArgument to be thrown.");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Input is null or empty", e.getMessage());
        }

        //Test case 5: Null Input String
        String input5 = null;
        try {
            summarizer.collect(input5);
            Assertions.fail("Expect IllegalArgument to be thrown.");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Input is null or empty", e.getMessage());
        }
    }

    @org.junit.jupiter.api.Test
    public void testSummarizer() {

        // Create an instance of the StandardNumberRangeSummarizer
        NumberRangeSummarizer summarizer = new StandardNumberRangeSummarizer();

        // Sample input given in the interface
        Collection<Integer> sampleList = Arrays.asList(1,3,6,7,8,12,13,14,15,21,22,23,24,31);
        String expectedOutput = "1, 3, 6-8, 12-15, 21-24, 31";
        Assertions.assertEquals(expectedOutput, summarizer.summarizeCollection(sampleList));

        // Test case 1: Sorted ArrayList
        Collection<Integer> inputList1 = Arrays.asList(1,2,3,4,5);
        String expectedOutput1 = "1-5";
        Assertions.assertEquals(expectedOutput1, summarizer.summarizeCollection(inputList1));

        // Test case 2: Unsorted ArrayList
        Collection<Integer> inputList2 = Arrays.asList(2,3,5,1,6,11);
        String expectedOutput2 = "1-3, 5-6, 11";
        Assertions.assertEquals(expectedOutput2, summarizer.summarizeCollection(inputList2));

        // Test case 3: Null ArrayList
        Collection<Integer> inputList3 = null;
        try {
            summarizer.summarizeCollection(inputList3);
            Assertions.fail("Expected IllegalArgument to be thrown.");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Input collection is null", e.getMessage());
        }

        // Test case 4: Empty ArrayList
        Collection <Integer> inputList4 = Arrays.asList();
        try {
            summarizer.summarizeCollection(inputList4);
            Assertions.fail("Expected IllegalArgument to be thrown");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Input collection is empty", e.getMessage());
        }
    }
}

