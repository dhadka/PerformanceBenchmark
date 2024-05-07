package org.moeaframework.benchmark;

import org.moeaframework.core.FrameworkException;
import org.moeaframework.core.spi.RegisteredProblemProvider;

public class NativeCProvider extends RegisteredProblemProvider {

	public NativeCProvider() {
		super();
		
		register("NativeC", this::createNativeC, null);
		registerDiagnosticToolProblems(getRegisteredProblems());
	}
	
	private NativeC createNativeC() {
		try {
			return new NativeC();
		} catch (Exception e) {
			throw new FrameworkException("Failed to create instance of NativeC", e);
		}
	}
	
}
