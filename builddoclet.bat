@ echo off
set ANT_HOME=D:\B4J\Compiler\TUMMOC~2\B4J\TUMMOC~1\Objects\ant
set JAVA_HOME=null
set PATH=%JAVA_HOME%\bin;%ANT_HOME%\bin;%PATH%
: DEFAULT
call ant -f %1
	