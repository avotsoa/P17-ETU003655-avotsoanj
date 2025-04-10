@echo off
setlocal

:: Definition des variables
set APP_NAME=ETU003655
set SRC_DIR=Src\main\java
set WEB_DIR=Src\main\webapp
set BUILD_DIR=build
set LIB_DIR=lib
set TOMCAT_WEBAPPS=C:\Users\msimi\Documents\apache-tomcat-10.1.28\webapps
set SERVLET_API_JAR=%LIB_DIR%\servlet-api.jar

:: Nettoyage et creation du repertoire temporaire
if exist %BUILD_DIR% rmdir /s /q %BUILD_DIR%
mkdir %BUILD_DIR%\WEB-INF\classes

:: Compilation des fichiers java avec jar des servlets
dir /s /b %SRC_DIR%\*.java > source.txt
javac -cp %SERVLET_API_JAR% -d %BUILD_DIR%\WEB-INF\classes @source.txt
del source.txt

:: Copier les fichiers .war (Web.xml, JSP, etc.)
xcopy %WEB_DIR%\* %BUILD_DIR%\ /E /H /C /I

:: Gerer les fichiers .war dans le dossier build
cd %BUILD_DIR% || exit /b
jar -cvf %APP_NAME%.war *
cd ..

:: Deploiement dans tomcat
copy /Y %BUILD_DIR%\%APP_NAME%.war %TOMCAT_WEBAPPS%\

echo.
echo Deploiement termine. Redemarrez Tomcat si necessaire.
echo.

endlocal










