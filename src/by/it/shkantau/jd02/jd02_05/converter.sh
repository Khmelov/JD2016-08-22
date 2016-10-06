#!/bin/sh

$JAVA_HOME/bin/native2ascii -encoding utf-8 ./languages/words.txt ./languages/words.properties
$JAVA_HOME/bin/native2ascii -encoding utf-8 ./languages/words_be_BY.txt ./languages/words_be_BY.properties
$JAVA_HOME/bin/native2ascii -encoding utf-8 ./languages/words_ru_RU.txt ./languages/words_ru_RU.properties

#for i in $( ls ); do
#            echo $i
#        done
