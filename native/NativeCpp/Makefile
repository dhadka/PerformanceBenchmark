# Edit the following to configure the compiler and required libraries
CC = g++
LIBS =
CFLAGS = -O3

# Configure the platform-specific settings
ifeq ($(OS),Windows_NT)
    SEPARATOR := ;
else
    SEPARATOR := :
endif

CLASSPATH := ../../lib/*$(SEPARATOR)NativeCpp.jar$(SEPARATOR).
SYSARCH := $(shell java -classpath "$(CLASSPATH)" org.moeaframework.builder.JNAInfo --sysArch)
LIBNAME := $(shell java -classpath "$(CLASSPATH)" org.moeaframework.builder.JNAInfo --libName --problem NativeCpp)

# Compile the shared library
build:
	mkdir -p $(SYSARCH)
	$(CC) $(CFLAGS) -c -fPIC NativeCpp.cpp $(LIBS)
	$(CC) -shared -o $(SYSARCH)/$(LIBNAME) NativeCpp.o
	javac -classpath "$(CLASSPATH)" NativeCpp.java NativeCppProvider.java
	
	jar cf NativeCpp.jar *.class $(SYSARCH) META-INF
	
	rm -f *.o *.class
	java -classpath "$(CLASSPATH)" org.moeaframework.builder.JNAInfo --test --problem NativeCpp

clean:
	rm -rf $(SYSARCH) NativeCpp.jar
	
run:
	java -classpath "$(CLASSPATH)" Example.java
