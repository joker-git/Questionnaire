import java.io.File;
import java.io.IOException;
import java.text.BreakIterator;
import java.util.*;

/**
 * Created by Saurav on 07/13/2018
 */
public class Sentence {
    /**
     * Function to count the occurence of the words  along with sentence numbers as described in the problem 2.
     *
     * @param sentences the arrayList containing the sentences
     *
     * @param locale    the locale of the Language(here Locale.US)
     * @return HashMap containing the words with respective counts
     */
    public static HashMap<String, TreeSet<Integer>> countWords(ArrayList<String> sentences, Locale locale) {
        //initialize map with String(for words) and TreeSet(for sentence numbers)
        HashMap<String, TreeSet<Integer>> wordCounts = new HashMap<>();

        //number of sentences
        int size = sentences.size();

        for (int i = 0; i < size; i++) {
            String text = sentences.get(i);

            //BreakIterator is used to get the words from the sentences
            BreakIterator breakIterator = BreakIterator.getWordInstance(locale);
            breakIterator.setText(text);

            //loop through the words
            int start = breakIterator.first();
            for (int end = breakIterator.next(); end != BreakIterator.DONE;  start = end,
                    end = breakIterator.next()) {

                String word = text.substring(start, end).toLowerCase();
                //Checking if the substring is a word or not, basically to eliminate
                // special characters
                if (isWord(word)) {
                    //Adding the sentence numbers for the words
                    TreeSet<Integer> val = new TreeSet<>();
                    if (wordCounts.containsKey(word)) {
                        val = wordCounts.get(word);
                    }
                    val.add(i + 1);
                    wordCounts.put(word, val);

                }

            }
        }

        return wordCounts;
    }

    /**
     * Funtion to check if a word or special character like ',','.' etc
     * @param word the owrd to be checked
     * @return  true if it starts with letter or digit , false otherwise
     */
    private static boolean isWord(String word) {
        if (word.length() == 1) {
            return Character.isLetterOrDigit(word.charAt(0));
        }
        return !"".equals(word.trim());
    }

    /**
     * Driver function for the program
     * @param args args[0] may or maynot contain the file path
     */
    public static void main(String[] args) {
        //Language is englis and the chosen locale is UK
        Locale locale = Locale.UK;

        //BreakIterator is used to break the text into sentences.
        BreakIterator breakIterator = BreakIterator.getSentenceInstance(locale);

        //String to contain the file contents
        String str = "";

        int start = breakIterator.first();

        //default file path
        String fileName = System.getProperty("user.dir") + File.separator+"resources"+File.separator+"input2.txt";

        //get the file path if passed as argument
        if (args.length == 1)
            fileName = args[0];

        //scan the file
        try {
            str = new Scanner(new File(fileName))
                    .useDelimiter("\\A").next();
        } catch (IOException e) {
            e.printStackTrace();
        }


        breakIterator.setText(str);

        //ArrayList to contain sentences as interpreted by the BreakIterator
        ArrayList<String> arrayList = new ArrayList<>();

        //loop to add the sentences
        for (int end = breakIterator.next(); end != BreakIterator.DONE; start = end, end = breakIterator.next()) {

            String sentence = str.substring(start, end).trim();
            arrayList.add(sentence);

        }

        //get the result in the Map
        HashMap<String, TreeSet<Integer>> result = countWords(arrayList, locale);

        //Print the result containing the words and the # of sentence they appear in
        for (Map.Entry<String, TreeSet<Integer>> entry : result.entrySet()) {
            System.out.print(entry.getKey() + ":");
            int i = 0;
            Iterator<Integer> itr = entry.getValue().iterator();
            while (itr.hasNext()) {
                if (i > 0) System.out.print(",");
                System.out.print(" " + itr.next());
                i++;
            }
            System.out.println();

        }


    }


}
