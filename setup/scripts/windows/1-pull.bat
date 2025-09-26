@echo off
rem Pulls the latest source code from the Git repository.
rem If the repository is not cloned yet, it will be cloned.

rem Check if git is installed
where git >nul 2>nul
if %errorlevel% neq 0 (
    echo Error: git is not installed. Please install git and try again.
    exit /b 1
)

rem Load environment variables from the setup directory
pushd %~dp0..\..
call setenv.bat
popd

if not exist "%REPO_DIR%" (
  if not exist "%BUILD_DIR%" mkdir "%BUILD_DIR%"
  cd /d "%BUILD_DIR%"
  git clone "%REPO_URL%" "%APP_NAME%"
) else (
  cd /d "%REPO_DIR%"
  git pull
)