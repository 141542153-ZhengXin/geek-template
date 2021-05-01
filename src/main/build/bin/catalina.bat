@echo off

:: <1>创建标题 <2>定义lib路径 <3>定义带xxx前缀的jar路径 <4> 定义要执行jar的路径
set TITLE="geek-template"
set APP_DIR=".\lib"
set APP_PATTERN="%APP_DIR%\geek-template*.jar"
set APP_RUN=""

:: 遍历查找要执行jar的路径
for /f "delims=" %%i in ('dir /b "%APP_PATTERN%"') do (
  set APP_RUN=%APP_DIR%\%%i
)

:: 根据 catalina 传参变量判断启动，结束脚本
if "%1" == "start" (
  if exist "%JAVA_HOME%" (
    echo java home:"%JAVA_HOME%"
    echo java version:
    java -version
  )
  echo start %TITLE%
  start "%TITLE%" java -jar "%APP_RUN%" --spring.conf.location = ./conf/
) else if "%1" == "stop" (
  echo stop %TITLE%
  taskkill /fi "windowtitle eq %TITLE%"
)