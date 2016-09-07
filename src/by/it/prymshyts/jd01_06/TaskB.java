package by.it.prymshyts.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    protected static String t1(String txt) {

        Pattern pattern = Pattern.compile("\\b[бвгджзйклмнпрстфхцчшщБВГДЖЗЙКЛМНПРСТФХЦЧШЩ][а-яА-ЯёЁ]{4}\\b");
        Matcher matcher = pattern.matcher(txt);

        txt = matcher.replaceAll("").replaceAll(" +", " ");

        return txt;
    }

    protected static String t2(String txt) {

        String[] sentences = txt.split("\\n");

        for (int i = 0; i < sentences.length - 1; i++) {
            int wordsInSentence = countWordsInLine(sentences[i]);

            for (int j = i + 1; j < sentences.length; j++) {
                if (wordsInSentence > countWordsInLine(sentences[j])) {
                    String buffer = sentences[i];
                    sentences[i] = sentences[j];
                    sentences[j] = buffer;
                }
            }
        }

        StringBuilder result = new StringBuilder();

        for (String line : sentences) {
            result.append(line + " ");
        }

        return result.toString();
    }

    private static int countWordsInLine(String line) {

        int count = 0;

        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(line);

        while (matcher.find()) {
            count++;
        }

        return count;
    }

    protected static String t3(String txt, char letter) {

        String[] words = txt.split("[^а-яА-ЯёЁ]+");

        words = sortWordsByLetter(words, letter);
        words = sortWordsByAlphabetWithLetter(words, letter);

        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(word + " ");
        }

        return result.toString();
    }

    private static int countLetterInWord(String word, char letter) {

        int count = 0;

        for (char symbol : word.toCharArray()) {
            if (symbol == letter) {
                count++;
            }
        }

        return count;
    }

    private static String[] sortWordsByLetter(String[] words, char letter) {

        boolean swap;
        int first = 0;

        do {
            swap = false;

            for (int i = words.length - 1; i > first; i--) {
                if (countLetterInWord(words[i], letter) > countLetterInWord(words[i - 1], letter)) {
                    String buffer = words[i];
                    words[i] = words[i - 1];
                    words[i - 1] = buffer;
                    swap = true;
                }
            }

            first++;
        } while (swap);

        return words;
    }

    private static String[] sortWordsByAlphabetWithLetter(String[] words, char letter) {

        for (int i = 0; i < words.length - 1; i++) {
            int lettersInFirstWord = countLetterInWord(words[i], letter);

            for (int j = i + 1; j < words.length; j++) {
                int letterInSecondWord = countLetterInWord(words[j], letter);

                if ((lettersInFirstWord == letterInSecondWord) && (words[i].compareToIgnoreCase(words[j]) > 0)) {
                    if ((lettersInFirstWord > 0 && letterInSecondWord > 0) || (lettersInFirstWord == 0 && letterInSecondWord == 0)) {
                        String buffer = words[i];
                        words[i] = words[j];
                        words[j] = buffer;
                    }
                }
            }
        }

        return words;
    }
}