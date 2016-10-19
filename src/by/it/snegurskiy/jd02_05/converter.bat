cd .
del *.properties
For %%I In ("*.txt") Do (
"C:\Program Files (x86)\Java\jdk1.8.0_102\bin\native2ascii.exe" -encoding utf-8 %%I %%~nI.properties
)

