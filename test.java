import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class test {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        String word = reader.readLine().replace("[^\\w\\s]", "");
        String[] splitedWords;
        String delimeter = " ";
        splitedWords = word.split(delimeter);

        HashMap<String, Integer> counter = new HashMap<>();

        while (reader.readLine() != null)
        {

            if (word.contains(".") || word.contains(";") || word.contains(",") || word.contains(":") || word.contains("...") || word.contains("!") || word.contains("?")) {
                word.replaceAll("\\p{Punct}", " ");

                for (String x : splitedWords) {

                    int newValue = counter.getOrDefault(x, 0) + 1;
                    counter.put(x, newValue);
                }
            }
        }

        counter.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);

    }


}



