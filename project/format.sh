#!/bin/sh
JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.7.0_72.jdk/Contents/Home
#ECLIPSE_HOME=/Applications/jbdevstudio-8.0.0-GA/studio/JBoss Developer Studio-8.1.0-GA.app/Contents/MacOS
ECLIPSE_HOME=/Users/Shared/java/Eclipse-RCP-4.4/eclipse
${ECLIPSE_HOME}/eclipse -nosplash -vm ${JAVA_HOME}/bin/java -application org.eclipse.jdt.core.JavaCodeFormatter -config `pwd`/org.eclipse.jdt.core.prefs $*
