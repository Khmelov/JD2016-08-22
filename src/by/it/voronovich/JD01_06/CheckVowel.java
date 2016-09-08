package by.it.voronovich.JD01_06;

/**
 * Класс вспомогательный, для решения ззадачи 3A
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */

public class CheckVowel {

    /**
     *
     * @param word
     * @return
     */
    static boolean Vowel(String word){
        //паттерн для гласных букв
        String vow="яыуаиеоюэё";
        //добавим туда еще и большие
        vow=vow+vow.toUpperCase();
        char first=word.charAt(0);
        char last=word.charAt(word.length()-1);
        //вернем true если гласная в начале и в конце
        return (vow.indexOf(first)>=0 && vow.indexOf(last)>=0);
    }
}
