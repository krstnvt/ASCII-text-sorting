import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class test
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader  reader = new BufferedReader(new FileReader(args[0]));

        String word = reader.readLine().replaceAll("\\p{Punct}", "");
        String[] splitedWords;

        HashMap<String, Integer> counter = new HashMap<>();

        while (word != null)
        {
            splitedWords = word.split(" ");

            for (String x : splitedWords)
            {
                int newValue = counter.getOrDefault(x, 0) + 1;
                counter.put(x, newValue);
                word = word.replaceAll("\\p{Punct}", " ");
            }

            word = reader.readLine();

            if (word != null)
            {
                word = word.replaceAll("\\p{Punct}", " ");
            }

        }

        counter.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);
    }
}



