# Configure the platform-specific settings
ifeq ($(OS),Windows_NT)
    SEPARATOR := ;
else
    SEPARATOR := :
endif

build:
	make -C c
	make -C native/NativeC
	make -C native/NativeCpp
	make -C native/NativeFortran
	javac -classpath "lib/*$(SEPARATOR)native/NativeC/*$(SEPARATOR)native/NativeCpp/*$(SEPARATOR)native/NativeFortran/*" src/org/moeaframework/performance/*.java
	
run:
	java -classpath "lib/*$(SEPARATOR)native/NativeC/*$(SEPARATOR)native/NativeCpp/*$(SEPARATOR)native/NativeFortran/*$(SEPARATOR)src" src/Benchmark.java

clean:
	make -C c clean
	make -C native/NativeC clean
	make -C native/NativeCpp clean
	make -C native/NativeFortran clean