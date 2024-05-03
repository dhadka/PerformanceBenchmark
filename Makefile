# Configure the platform-specific settings
ifeq ($(OS),Windows_NT)
    SEPARATOR := ;
else
    SEPARATOR := :
endif

build:
	make -C c
	make -C native/NativeC
	javac -classpath "lib/*$(SEPARATOR)native/NativeC/*" src/org/moeaframework/performance/*.java
	
run:
	java -classpath "lib/*$(SEPARATOR)native/NativeC/*$(SEPARATOR)src" src/Benchmark.java

clean:
	make -C c clean
	make -C native/NativeC clean