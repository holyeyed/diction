@echo off
echo 		HOLYEYED WORDLIST GENERAL COMMAND
echo Please select mode
echo 	1. auto mode
echo		2. manual mode
set /p mode=
if %mode%==1 goto end
echo.>salt.txt
:nhaptiep
echo 	please tell me some infos about him
echo 	Ex: name, nickname....
echo 	Types 'end' jumd next step

set /p info=
goto nhap

:nhap
if %info%==end goto end
echo %info%>>salt.txt
cls
echo 	HOLYEYED WORDLIST GENERAL COMMAND
echo 	Some thing more...
goto nhaptiep
:end
java -jar dist\diction.jar -help
echo 	Please types parameters
echo 	EX: proper bd:99
set /p para=
java -jar dist\diction.jar %para%
pause