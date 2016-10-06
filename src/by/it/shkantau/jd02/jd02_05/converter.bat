cd  languages/
REM"%JAVA_HOME%\bin\native2ascii.exe" -encoding utf-8 words.txt words.properties
REM"%JAVA_HOME%\bin\native2ascii.exe" -encoding utf-8 words_be_BY.txt words_be_BY.properties
REM"%JAVA_HOME%\bin\native2ascii.exe" -encoding utf-8 words_ru_RU.txt words_en_US.properties

del *.properties
For %%I In ("*.txt") Do (
"%JAVA_HOME%\bin\native2ascii.exe" -encoding utf-8 %%I %%~nI.properties
)