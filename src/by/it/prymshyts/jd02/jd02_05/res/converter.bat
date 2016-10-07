cd ./Languages
del ./Resource_Bundle/*.properties
For %%I In ("*.txt") Do (
"C:\Program Files (x86)\Java\jdk1.7.0_01\bin\native2ascii.exe" -encoding utf-8 %%I ../Resource_Bundle/%%~nI.properties
)