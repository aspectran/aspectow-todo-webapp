@echo off
rem Installs the application on a Windows environment.
rem This script clones/pulls the source code, builds the application, and deploys the files.

setlocal

rem Get the absolute path of the setup directory
set "SETUP_DIR=%~dp0"

rem Load environment variables
call "%SETUP_DIR%setenv.bat"

rem Run the full deployment process
call "%SETUP_DIR%scripts\windows\5-pull_build_deploy.bat"
if errorlevel 1 (
    echo Application installation failed.
    exit /b 1
)

rem Copy the operational scripts to the base directory
xcopy /s /e /i /q /y "%SETUP_DIR%scripts\windows\*.bat" "%BASE_DIR%"

echo.
echo --------------------------------------------------------------------------
echo Your application installation is complete in "%BASE_DIR%".
echo.
echo To run the application interactively, execute:
echo   %DEPLOY_DIR%\bin\shell.bat
echo.
echo To install the application as a Windows Service, execute the following
echo command in an Administrator Command Prompt:
echo   %DEPLOY_DIR%\bin\procrun\install.bat
echo --------------------------------------------------------------------------

endlocal