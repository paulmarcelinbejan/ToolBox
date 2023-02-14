package com.paulmarcelinbejan.architecture.base.functional_interfaces.consumer;

public interface ConsumerUtils {

	@FunctionalInterface
	public interface TriConsumer<P1, P2, P3> {
		void accept(P1 p1, P2 p2, P3 p3);
	}

	@FunctionalInterface
	public interface QuadriConsumer<P1, P2, P3, P4> {
		void accept(P1 p1, P2 p2, P3 p3, P4 p4);
	}

	@FunctionalInterface
	public interface PentaConsumer<P1, P2, P3, P4, P5> {
		void accept(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5);
	}
	
}
