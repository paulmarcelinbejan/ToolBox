package com.paulmarcelinbejan.toolbox.base.functional_interfaces.function;

public interface FunctionUtils {

	@FunctionalInterface
	public interface TriFunction<P1, P2, P3, R> {
		R apply(P1 p1, P2 p2, P3 p3);
	}

	@FunctionalInterface
	public interface QuadriFunction<P1, P2, P3, P4, R> {
		R apply(P1 p1, P2 p2, P3 p3, P4 p4);
	}

	@FunctionalInterface
	public interface PentaFunction<P1, P2, P3, P4, P5, R> {
		R apply(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5);
	}
	
}
