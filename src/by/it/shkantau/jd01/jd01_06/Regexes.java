package by.it.shkantau.jd01.jd01_06;

public class Regexes {
    private static final String vowel = "аэиоуыяеёюАЭИОУЫЯЕЁЮ";
    static final String consonant = "бвгджзклмнпрстфхцчшщъыьБВГДЖЗКЛМНПРСТФХЦЧШЩЪЫЬ";
    static final String regexVowel = "\\b["+vowel+"]+([а-яА-ЯёЁ]*["+vowel+"])*\\b";
    static final String regexRussianWord = "\\b[а-яА-ЯёЁ]+\\b";
    public static final String regexEnglishWord = "\\b[a-zA-Z]+\\b";
    static String regexEndOfTheSentence = "[.!?]+\\s*";
}
