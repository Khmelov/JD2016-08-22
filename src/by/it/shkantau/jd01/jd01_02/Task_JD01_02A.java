package by.it.shkantau.jd01.jd01_02;

import java.util.*;
import java.util.regex.Pattern;

class Task_JD01_02A {
    private static final String regexVar = "((-?)([0-9])+)";
    private static Scanner sc = new Scanner(System.in);



    public static void a(){
//A1    Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
        System.out.print("Type the numbers via white spaces: ");
        List<String> stringList =  by.it.shkantau.mathlab.util.parser.Parser.parseToVarString(sc.nextLine(), Pattern.compile(Task_JD01_02A.regexVar));
        List <Integer> listOfIntegers = getIntegersArray(stringList);
        TreeSet<Integer> setDoubles = new TreeSet<>(listOfIntegers);

        System.out.println("Min number length = " + setDoubles.first().toString().length() + " is " + setDoubles.first());
        System.out.println("Max number length = " + setDoubles.last().toString().length() + " is " + setDoubles.last());
//A2    Вывести на консоль те числа, длина которых меньше среднего арифметического.
        Integer meanLength = getMean(listOfIntegers).toString().length();
        System.out.println("The numbers which length less then length of mean:");
        for (String strNumber : stringList) {
            if(meanLength > strNumber.length()){
                System.out.println(strNumber);
            }
        }

//A3   Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.
        int uniqueCount = 0;
        for (String str: stringList) {
            if  (getUnique (str)){
                uniqueCount++;
                System.out.println("First unique number is " + str);
                break;
            }
        }
        if (uniqueCount == 0){
            System.out.println("There is no unique numbers");
        }

    }

    private static boolean getUnique (String str){
        for (int i = 0; i <str.length() ; i++) {
            for (int j = i+1; j < str.length(); j++) {
                if(str.charAt(i) == str.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }

    private static Integer getMean(List <Integer> list){
        int mean = 0;
        for (Integer integer : list) {
            mean += integer;
        }
        mean /= list.size();

        System.out.println("maen = "+ mean);
        return mean;
    }

    private static List<Integer> getIntegersArray(List<String> stringList) {
        Iterator<String> iterator = stringList.iterator();
        while(iterator.hasNext()){
            try {
                 Integer.parseInt(iterator.next());
            }catch (NumberFormatException e){
                System.out.println(e.getMessage() + " " + iterator.next() +  " is not valid integer");
                iterator.remove();
            }
        }
        List <Integer> listOfIntger =  new ArrayList<>(stringList.size());
        for (String strIneger: stringList) {
           listOfIntger.add(Integer.valueOf(strIneger));
        }
        return listOfIntger;
    }


}
