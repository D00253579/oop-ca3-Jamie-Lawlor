import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Name: Jamie Lawlor
 * Class Group: SD2B
 */

public class CA3_Question3 {
    public static void readFile(String fileName) throws FileNotFoundException {
        File f = new File(fileName);
        //Reading in file
        Scanner in = new Scanner(f);
        in.useDelimiter("[^A-Za-z0-9_]+");
        //Creating map
        Map<String, Integer> Lines = new HashMap<String, Integer>();
        String aLine = "";
        int count = 0;
/*Taking in user input and using a count to count how many lines, it ended up counting each occurrence of the
   words and I couldn't figure out how to get it to read in each line*/
            while (in.hasNext()) {
                aLine = in.next();
                count++;
                Lines.put(aLine, count);
            }


        //Creating arrayList to store the occurrence of the words
        ArrayList<Integer> words = new ArrayList<>();
            //Going through each word in the file
        for (String key : Lines.keySet()) {
            /*Storing the "count" that was stored in the Lines map into the value variable
            We can identify each word using the Lines.get(key)
            */
            Integer value = Lines.get(key);
            //Adding to the arrayList
            words.add(value);
            System.out.println(key + " occurs at line " + value);

        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        readFile("src/CA3_Question1.java");
    }
}
