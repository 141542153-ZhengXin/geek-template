@echo off

echo [INFO] --------------------------[ java configuration ]---------------------------
if exist "%JAVA_HOME%" (
  echo java home:"%JAVA_HOME%"
  java -version
)

echo [INFO] --------------------------[ maven configuration ]--------------------------
if exist "%M2_HOME%" (
  call mvn -version
)

echo [INFO] ---------------------------------[ build ]---------------------------------
::build
echo start building, please wait...
echo current instruction: call mvn clean compile package -Dmaven.test.skip=true
call mvn clean compile package -Dmaven.test.skip=true
echo.&echo build completed, Press any key to exit &pause>nul
exit