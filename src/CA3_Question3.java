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
        Scanner in = new Scanner(f);

        in.useDelimiter("[^A-Za-z0-9_]+");
        Map<String, Integer> Lines = new HashMap<String, Integer>();
        String aLine = "";
        int count = 0;
        while (in.hasNext()) {
            count++;
            aLine = in.next();
            Lines.put(aLine, count);
        }

        ArrayList<Integer> words = new ArrayList<>();
        for (String key : Lines.keySet()) {
            Integer value = Lines.get(key);
            words.add(value);

            System.out.println(key + " occurs at line " + words);

        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        readFile("src/CA3_Question1.java");
    }
}
