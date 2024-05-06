import org.moeaframework.core.Solution;
import org.moeaframework.core.variable.EncodingUtils;
import org.moeaframework.core.variable.RealVariable;
import org.moeaframework.problem.AbstractProblem;

import com.sun.jna.Library;
import com.sun.jna.Native;

public class NativeCpp extends AbstractProblem {

	public interface NativeCppImpl extends Library {
		void evaluate(double[] vars, double[] objs, double[] constrs);
	}
	
	private final NativeCppImpl INSTANCE = (NativeCppImpl)Native.load("NativeCpp", NativeCppImpl.class);

	public NativeCpp() {
		super(11, 2, 0);
	}
	
	public String getName() {
		return "C++ (Native)";
	}

	public void evaluate(Solution solution) {
		double[] vars = EncodingUtils.getReal(solution);
		double[] objs = new double[numberOfObjectives];
		double[] constrs = new double[numberOfConstraints];

		INSTANCE.evaluate(vars, objs, constrs);

		solution.setObjectives(objs);
		solution.setConstraints(constrs);
	}

	public Solution newSolution() {
		Solution solution = new Solution(numberOfVariables, numberOfObjectives, numberOfConstraints);

		for (int i = 0; i < numberOfVariables; i++) {
			solution.setVariable(i, new RealVariable(0.0, 1.0));
		}

		return solution;
	}

}