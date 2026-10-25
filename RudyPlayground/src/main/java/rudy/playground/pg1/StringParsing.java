package rudy.playground.pg1;

import java.util.*;
import java.util.stream.Collectors;

public class StringParsing {

    private static List<String> doNormalise(String document){
        String[] splitString = document.split(" "); //"This is a test. This te;;;;st is simple."
        List<String> list = new ArrayList<>();
        int n = splitString.length;
        for (String s : splitString) {
            String currentWord = s.toLowerCase(); //This
            //We check if all are character
            //No special character
            char[] wordChar = currentWord.toCharArray(); //97 - 122 //[t ,h,:,s]
            StringBuilder sb = new StringBuilder();

            for (char currentChar : wordChar) {
                if (currentChar >= 97 && currentChar <= 122) {
                    sb.append(currentChar);
                }
            }
            if (!sb.isEmpty()) {
                String trimedString = sb.toString();
                list.add(trimedString);
            }

        }
        return list;

    }
    public static void performTasks(String document){
        //Normalise

        List<String> normalisedWords =doNormalise(document);
        //get frequencyMap
        Map<String, Integer> frequencyMap = new HashMap<String, Integer>();

        for(String word : normalisedWords){
            frequencyMap.put(word, frequencyMap.getOrDefault(word ,0 )+1);
        }

        //sort frequencyMap

        Map<String, Integer> sortedMap = frequencyMap.entrySet()
                .stream()
                .sorted((a,b)-> a.getValue().equals(b.getValue())? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e2, // merge function (not needed here)
                        LinkedHashMap::new // maintain order
                ));



        System.out.println("Sorted Map :: "+ sortedMap);
    }
    public static void main(String[] args) {
        System.out.println("Hello, World");

        performTasks("This i&&&&&&&&s a ?%%%%% test. This te;;;;st is simple.");
    }
}
