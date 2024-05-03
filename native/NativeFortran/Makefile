# Edit the following to configure the compiler and required libraries
FORTRAN = gfortran

# Configure the platform-specific settings
ifeq ($(OS),Windows_NT)
    SEPARATOR := ;
else
    SEPARATOR := :
endif

CLASSPATH := ..\..\lib\*$(SEPARATOR)..\..\bin$(SEPARATOR)NativeFortran.jar$(SEPARATOR).
SYSARCH := $(shell java -classpath "$(CLASSPATH)" org.moeaframework.builder.JNAInfo --sysArch)
LIBNAME := $(shell java -classpath "$(CLASSPATH)" org.moeaframework.builder.JNAInfo --libName --problem NativeFortran)

# Compile the shared library
build:
	mkdir -p $(SYSARCH)
	$(FORTRAN) -shared -fPIC -o $(SYSARCH)/$(LIBNAME) NativeFortran.f90
	javac -classpath "$(CLASSPATH)" NativeFortran.java NativeFortranProvider.java
	
	jar cf NativeFortran.jar *.class $(SYSARCH) META-INF
	
	rm -f *.class
	java -classpath "$(CLASSPATH)" org.moeaframework.builder.JNAInfo --test --problem NativeFortran

clean:
	rm -rf $(SYSARCH) NativeFortran.jar
	
run:
	java -classpath "$(CLASSPATH)" Example.java
