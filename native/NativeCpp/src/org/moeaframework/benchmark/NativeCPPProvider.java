package org.moeaframework.benchmark;

import org.moeaframework.core.FrameworkException;
import org.moeaframework.core.spi.RegisteredProblemProvider;

public class NativeCPPProvider extends RegisteredProblemProvider {

	public NativeCPPProvider() {
		super();
		
		register("NativeCPP", this::createNativeCPP, null);
		registerDiagnosticToolProblems(getRegisteredProblems());
	}
	
	private NativeCPP createNativeCPP() {
		try {
			return new NativeCPP();
		} catch (Exception e) {
			throw new FrameworkException("Failed to create instance of NativeCPP", e);
		}
	}
	
}
