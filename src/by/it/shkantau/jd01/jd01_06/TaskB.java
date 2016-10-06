package by.it.shkantau.jd01.jd01_06;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    private static Pattern pattern;
    private static Matcher matcher;

//1.   Из текста удалить все слова длины 5, начинающиеся на согласную букву.
    public static void b1(String text) {
        System.out.println("\nTaskB1");
        Pattern p = Pattern.compile("\\b["+Regexes.consonant+"][а-яА-ЯёЁ]{4}\\b");
        StringBuilder sbText = new StringBuilder(text);
        Matcher m = p.matcher(text);

        int deletedChar = 0;
        while(m.find()) {
            sbText.delete(m.start()-deletedChar, m.end()-deletedChar);
            deletedChar += m.end() - m.start();
        }
        System.out.println(sbText);
    }

//2.    Вывести все предложения заданного текста в порядке возрастания количества слов в каждом
//    из них. В предложениях убрать переносы строк.
    public static void b2(String text){
        System.out.println("\nTaskB2");
        text = text.replaceAll("\n", " ");
        String [] sentences = text.split(Regexes.regexEndOfTheSentence);
        Map<Integer, String> sentencesMap = new TreeMap<>();
        for (String sentence:sentences) {
            sentencesMap.put(getWordsCountInSentence(sentence) , sentence);
        }
        for(Map.Entry<Integer, String> pair: sentencesMap.entrySet()) {
            System.out.println(pair.getValue());
        }
    }

//3.    Отсортировать слова в тексте по убыванию количества вхождений заданного символа, а в
//    случае равенства — по алфавиту.
    public static void b3(String text){
        System.out.println("\nTaskB3");
        System.out.print("Type a symbol:");
        String string = new Scanner(System.in).nextLine();
        char symbol = string.charAt(0);
        List <String > words = new ArrayList<>(200);
        Map <Integer, List<String>> repeatByWord = new HashMap<>();

        pattern = Pattern.compile(Regexes.regexRussianWord);
        matcher = pattern.matcher(text);
        while(matcher.find()){
            words.add(matcher.group());
        }
        sortListOfString(words);

        for (String word : words ) {
            pattern =  Pattern.compile(String.valueOf(symbol));
            matcher = pattern.matcher(word);
            int n = 0;
            while(matcher.find()){
                n++;
            }

            if (repeatByWord.get(n) == null){
                repeatByWord.put(n, new ArrayList<String>());
            }
            repeatByWord.get(n).add(word);
        }

        System.out.println(repeatByWord);
    }

    private static void sortListOfString(List<String> aItems){
        Collections.sort(aItems, String.CASE_INSENSITIVE_ORDER);
    }

    private static int getWordsCountInSentence(String sentence){
        String [] words = sentence.split("[\\p{Punct}\\s]+");
        return words.length;
    }
}
