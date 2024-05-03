# Edit the following to configure the compiler and required libraries
CC = gcc
LIBS =
CFLAGS = -O3

# Configure the platform-specific settings
ifeq ($(OS),Windows_NT)
    SEPARATOR := ;
else
    SEPARATOR := :
endif

CLASSPATH := ..\..\target\*$(SEPARATOR)..\..\target\deps\*$(SEPARATOR)NativeC.jar$(SEPARATOR).
SYSARCH := $(shell java -classpath "$(CLASSPATH)" org.moeaframework.builder.JNAInfo --sysArch)
LIBNAME := $(shell java -classpath "$(CLASSPATH)" org.moeaframework.builder.JNAInfo --libName --problem NativeC)

# Compile the shared library
build:
	mkdir -p $(SYSARCH)
	$(CC) $(CFLAGS) -c -fPIC NativeC.c $(LIBS)
	$(CC) -shared -o $(SYSARCH)/$(LIBNAME) NativeC.o
	javac -classpath "$(CLASSPATH)" NativeC.java NativeCProvider.java
	
	jar cf NativeC.jar *.class $(SYSARCH) META-INF
	
	rm -f *.o *.class
	java -classpath "$(CLASSPATH)" org.moeaframework.builder.JNAInfo --test --problem NativeC

clean:
	rm -rf $(SYSARCH) NativeC.jar
	
run:
	java -classpath "$(CLASSPATH)" Example.java
