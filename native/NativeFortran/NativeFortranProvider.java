import org.moeaframework.core.FrameworkException;
import org.moeaframework.core.spi.RegisteredProblemProvider;

public class NativeFortranProvider extends RegisteredProblemProvider {

	public NativeFortranProvider() {
		super();
		
		register("NativeFortran", this::createNativeFortran, null);
		registerDiagnosticToolProblems(getRegisteredProblems());
	}
	
	private NativeFortran createNativeFortran() {
		try {
			return new NativeFortran();
		} catch (Exception e) {
			throw new FrameworkException("Failed to create instance of NativeFortran", e);
		}
	}
	
}
