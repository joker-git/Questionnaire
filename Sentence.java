import java.io.File;
import java.io.IOException;
import java.text.BreakIterator;
import java.util.*;
public class Sentence {

    public static HashMap<String, TreeSet<Integer>> countWords( ArrayList<String> sentences, Locale locale) {
        HashMap<String, TreeSet<Integer>> wordCounts = new HashMap<>();
        int size = sentences.size();

        for(int i = 0 ;i<size;i++) {
            String text = sentences.get(i);
            BreakIterator breakIterator = BreakIterator.getWordInstance(locale);
            breakIterator.setText(text);
            int start = breakIterator.first();
            for (int end = breakIterator.next();
                 end != BreakIterator.DONE;
                 start = end, end = breakIterator.next()) {

                String word = text.substring(start, end).toLowerCase();
                if (isWord(word)) {
                    TreeSet<Integer> val =  new TreeSet<>();
                    if(wordCounts.containsKey(word)){
                        val = wordCounts.get(word);
                    }
                    val.add(i+1);
                    wordCounts.put(word,val);

                }

            }
        }

        return wordCounts;
    }

    private static boolean isWord(String word) {
        if(word.length() == 1){
            return Character.isLetterOrDigit(word.charAt(0));
        }
        return !"".equals(word.trim());
    }




    public static void main(String[] args)  {
        Locale locale = Locale.UK;
        BreakIterator breakIterator =  BreakIterator.getSentenceInstance(locale);
        String str = "";

        int start = breakIterator.first();

        String fileName = System.getProperty("user.dir")+"\\resources\\input.txt";
        if(args.length == 1)
         fileName = args[0];
        try {
            str = new Scanner(new File(fileName))
                    .useDelimiter("\\A").next();
        } catch (IOException e) {
            e.printStackTrace();
        }
        breakIterator.setText(str);
        ArrayList<String> arrayList = new ArrayList<>();
        for (int end = breakIterator.next(); end != BreakIterator.DONE; start = end, end = breakIterator.next()) {

            String sentence = str.substring(start, end).trim();
            arrayList.add(sentence);

        }
        HashMap<String, TreeSet<Integer>> result = countWords(arrayList,locale);
        for(Map.Entry<String,TreeSet<Integer>> entry:result.entrySet()){
            System.out.print(entry.getKey()+":");
            int i = 0;
            Iterator<Integer> itr = entry.getValue().iterator();
            while(itr.hasNext()){
                if(i>0) System.out.print(",");
                System.out.print(" "+itr.next());
                i++;
            }
            System.out.println();

        }


    }


}
