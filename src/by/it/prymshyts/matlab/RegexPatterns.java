package by.it.prymshyts.matlab;

import java.util.regex.Pattern;

interface RegexPatterns {
    String regexSaveToVar = "([a-zA-Z]\\d*)?=";
    String regexLoadFromVar = "([a-zA-Z]\\d*?)";
    String regexFloatVar = "([\\d.]+)";
    String regexOperation = "([+\\-*/])";
    String regexBrackets = "([{(])";

    String regexMatrix = "(\\{[}{,.\\d]+\\})";
    String regexVector = "([.,\\d]+)\\}";

    Pattern patternMainLoop = Pattern.compile(regexSaveToVar + "|" + regexLoadFromVar + "|" + regexFloatVar + "|" + regexOperation + "|" + regexBrackets);
    Pattern patternMatrix = Pattern.compile(regexMatrix);
    Pattern patternVector = Pattern.compile(regexVector);
}
