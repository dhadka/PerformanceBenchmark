import org.moeaframework.core.FrameworkException;
import org.moeaframework.core.spi.RegisteredProblemProvider;

public class NativeCppProvider extends RegisteredProblemProvider {

	public NativeCppProvider() {
		super();
		
		register("NativeCpp", this::createNativeCpp, null);
		registerDiagnosticToolProblems(getRegisteredProblems());
	}
	
	private NativeCpp createNativeCpp() {
		try {
			return new NativeCpp();
		} catch (Exception e) {
			throw new FrameworkException("Failed to create instance of NativeCpp", e);
		}
	}
	
}
