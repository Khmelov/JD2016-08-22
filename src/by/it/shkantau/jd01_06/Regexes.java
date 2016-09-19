package by.it.shkantau.jd01_06;

/**
 * Created by user on 15.09.2016.
 */
public class Regexes {
    public static final String vowel = "аэиоуыяеёюАЭИОУЫЯЕЁЮ";
    public static final String consonant = "бвгджзклмнпрстфхцчшщъыьБВГДЖЗКЛМНПРСТФХЦЧШЩЪЫЬ";
    public static final String regexVowel = "\\b["+vowel+"]+([а-яА-ЯёЁ]*["+vowel+"])*\\b";
    public static final String regexRussianWord = "\\b[а-яА-ЯёЁ]+\\b";
    public static final String regexEnglishWord = "\\b[a-zA-Z]+\\b";
    public static String regexEndOfTheSentence = "[.!?]+\\s*";
}
