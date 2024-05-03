

import java.io.IOException;

import org.moeaframework.algorithm.NSGAII;
import org.moeaframework.core.Algorithm;
import org.moeaframework.core.Problem;
import org.moeaframework.performance.DTLZ2WithCSocket;
import org.moeaframework.performance.DTLZ2WithCStdio;
import org.moeaframework.performance.DTLZ2WithJava;
import org.moeaframework.performance.DTLZ2WithPythonSocket;
import org.moeaframework.performance.DTLZ2WithPythonStdio;
import org.moeaframework.util.Timing;

public class Benchmark {
	
	public static final int N = 10;
	
	public static void run(Problem problem) {
		Timing.startTimer(problem.getName());
		
		Algorithm algorithm = new NSGAII(problem);
		algorithm.run(10000);
		
		Timing.stopTimer(problem.getName());
	}
	
	public static void main(String[] args) throws IOException {
		for (int i = 0; i < N; i++) {
			try (Problem problem = new DTLZ2WithJava()) {
				run(problem);
			}
			
			try (Problem problem = new DTLZ2WithCStdio()) {
				run(problem);
			}
			
			try (Problem problem = new DTLZ2WithCSocket()) {
				run(problem);
			}
			
			try (Problem problem = new DTLZ2WithPythonStdio()) {
				run(problem);
			}
			
			try (Problem problem = new DTLZ2WithPythonSocket()) {
				run(problem);
			}
			
			try (Problem problem = new NativeC()) {
				run(problem);
			}
		}
		
		Timing.display();
	}

}
