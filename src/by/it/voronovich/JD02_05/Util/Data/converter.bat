cd .
del ..\CodeData\*.properties
For %%I In ("*.txt") Do (
"C:\Program Files\Java\jdk1.8.0_73\bin\native2ascii.exe" -encoding utf-8 %%I ..\CodeData\%%~nI.properties
)