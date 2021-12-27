package App.Helpers;

public class ToFirstCapitalConverter {

    public static String convert(String word) {
        String firstLetter = word.substring(0, 1).toUpperCase();
        String otherLetters = word.substring(1).toLowerCase();
        word = firstLetter + otherLetters;
        return word;
    }
}
