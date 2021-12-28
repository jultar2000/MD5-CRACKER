package App.Helpers;

public class Helper {

    public static String convertToFirstCapital(String word) {
        String firstLetter = word.substring(0, 1).toUpperCase();
        String otherLetters = word.substring(1).toLowerCase();
        word = firstLetter + otherLetters;
        return word;
    }

    public static String convertToNumWordNum(String word, int num) {
        return num + word + num;
    }

    public static String convertToWordNumWord(String first_word, String second_word, int num) {
        return first_word + num + second_word;
    }

    public static String convertToWordSignWord(String first_word, String second_word, char sign){
        return first_word + sign + second_word;
    }


}
