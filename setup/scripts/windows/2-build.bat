@echo off
rem Builds the application using Maven and deploys the libraries.

rem Check if mvn is installed
where mvn >nul 2>nul
if %errorlevel% neq 0 echo Error: Maven (mvn) is not installed. Please install it and try again.
if %errorlevel% neq 0 exit /b 1

rem Load environment variables
call "%~dp0\setenv.bat"

cd /d "%REPO_DIR%"
mvn clean package -U -Dmaven.test.skip=true %1

echo Deploying libraries to %DEPLOY_DIR%\lib ...
if exist "%DEPLOY_DIR%\lib" rmdir /s /q "%DEPLOY_DIR%\lib"
mkdir "%DEPLOY_DIR%\lib"
if exist "%REPO_DIR%\app\lib" xcopy /s /e /i /q /y "%REPO_DIR%\app\lib\*" "%DEPLOY_DIR%\lib"