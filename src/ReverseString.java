public class ReverseString {

    public static void main(String[] args) {

        String entryWord = args[0]; //cmd line entry here

        //System.out.println("Test Case to check entry: " + entryWord);

        String reverseWord = ""; //setting the start of the reverse

        for (int i = entryWord.length() - 1; i >= 0; i--) {
            //using length here to get the length so I can pull characters, then while its greater then 0 it keeps going
            //and it adds the last character here because the -1 ie grabbing the last one in line
            reverseWord += entryWord.charAt(i);
        }

        //printing out the reverse word here, yes it has a bit more to clean the program up it looks ugly otherwise
        System.out.println("Your entry word was " + entryWord + ". This is the word backwards: " + reverseWord);

    }
}
