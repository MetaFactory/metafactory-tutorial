@echo off
rem Define the environment variables ECLIPSE_HOME and JAVA_HOME
rem Change commands if needed
rem The format.cmd is automatically called by win32 version of MetaFactory

rem %ECLIPSE_HOME%\eclipse\eclipse.exe -nosplash -vm %JAVA_HOME%\bin\javaw.exe -application org.eclipse.jdt.core.JavaCodeFormatter -config org.eclipse.jdt.core.prefs %*
%ECLIPSE_HOME%\jbdevstudio.exe -nosplash -vm %JAVA_HOME%\bin\javaw.exe -application org.eclipse.jdt.core.JavaCodeFormatter -config org.eclipse.jdt.core.prefs %*
