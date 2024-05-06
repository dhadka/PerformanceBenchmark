# Configure the platform-specific settings
ifeq ($(OS),Windows_NT)
    SEPARATOR := ;
else
    SEPARATOR := :
endif

CLASSPATH := lib/*$(SEPARATOR)native/NativeC/*$(SEPARATOR)native/NativeCpp/*$(SEPARATOR)native/NativeFortran/*$(SEPARATOR)bin

# Configure benchmark settings
SAMPLES ?= 10
NFE ?= 100000

build:
	make -C c
	make -C native/NativeC
	make -C native/NativeCpp
	make -C native/NativeFortran
	
	mkdir -p bin
	javac -d bin -classpath "$(CLASSPATH)" src/*.java
	javac -d bin -classpath "$(CLASSPATH)" src/org/moeaframework/performance/*.java
	
run:
	java -classpath "$(CLASSPATH)" Benchmark $(SAMPLES) $(NFE)

clean:
	make -C c clean
	make -C native/NativeC clean
	make -C native/NativeCpp clean
	make -C native/NativeFortran clean
	rm -rf bin