cd  .
del *.properties
For %%I In ("*.txt") Do (
"c:\Program Files\Java\jdk1.8.0_101\bin\native2ascii.exe" -encoding utf-8 %%I %%~nI.properties
)
