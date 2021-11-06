import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Lab5 {

    public static String display(String text) {
        if (text.length() == 1) {
            return "Seem's like your text is blank";
        }

        String[] sentences = text.split("(?<=(?<![A-Z])[\\.!?])");

        String newText = " ";

        for(var sentence : sentences)
        {
            newText = newText + prepareOneSentence(sentence);
        }

        System.out.println("New text");
        return newText;

    }

    public static String prepareOneSentence(String sentence)
    {
        Pattern p = Pattern.compile("\\b[eyuioaEYUIOA]\\w+");

        sentence = sentence.trim();
        System.out.println(sentence);

        String[] words = sentence.split("[!?,.;\\s+]+");

        String longest = Arrays.asList(words).stream().max(Comparator.comparingInt(String::length)).get();
        System.out.println("Longest: " + longest);


        String firstVowel = Arrays.asList(words).stream().filter(word -> p.matcher(word).matches()).findFirst().orElse(null);

        System.out.println("Vowel: " + firstVowel);

        if(firstVowel == null) {
            return sentence;
        }

        String temp = longest;
        words[findInArray(words, longest)] = firstVowel;
        words[findInArray(words, firstVowel)] = temp;

        String output;
        StringBuilder sb = new StringBuilder();
        sb.append(words[0]);
        for (int i = 1; i < words.length; i++) {
            sb.append(" ");
            sb.append(words[i]);
        }

        sb.append(". ");
        output = sb.toString();
        System.out.println(output);
        return  output;
    }

    public static int findInArray(String[] array, String findWord) {
        for (var i = 0; i < array.length; i++) {
            if (findWord == array[i]) {
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner  in    = new Scanner(System.in);

        System.out.println("Please specify how many lines in the text: ");
        String[] input = new String[in.nextInt()];
        in.nextLine();

        System.out.println("Enter text: ");
        String text = " ";
        for (int i = 0; i < input.length; i++) {
             text = text + in.nextLine();
        }

        System.out.println(display(text));
    }
}
