package io.github.paulmarcelinbejan.toolbox.base.functional_interfaces.function;

public final class FunctionUtilsExceptionable {

	@FunctionalInterface
	public interface FunctionWithException<P1, R, E extends Exception> {
		R apply(P1 p1) throws E;
	}

	@FunctionalInterface
	public interface BiFunctionWithException<P1, P2, R, E extends Exception> {
		R apply(P1 p1, P2 p2) throws E;
	}

	@FunctionalInterface
	public interface TriFunctionWithException<P1, P2, P3, R, E extends Exception> {
		R apply(P1 p1, P2 p2, P3 p3) throws E;
	}

	@FunctionalInterface
	public interface QuadriFunctionWithException<P1, P2, P3, P4, R, E extends Exception> {
		R apply(P1 p1, P2 p2, P3 p3, P4 p4) throws E;
	}

	@FunctionalInterface
	public interface PentaFunctionWithException<P1, P2, P3, P4, P5, R, E extends Exception> {
		R apply(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5) throws E;
	}

}
