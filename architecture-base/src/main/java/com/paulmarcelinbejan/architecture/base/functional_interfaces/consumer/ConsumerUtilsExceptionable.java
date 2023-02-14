package com.paulmarcelinbejan.architecture.base.functional_interfaces.consumer;

public interface ConsumerUtilsExceptionable {

	@FunctionalInterface
	public interface ConsumerWithException<P1, E extends Exception> {
		void accept(P1 p1) throws E;
	}
	
	@FunctionalInterface
	public interface BiConsumerWithException<P1, P2, E extends Exception> {
		void accept(P1 p1, P2 p2) throws E;
	}

	@FunctionalInterface
	public interface TriConsumerWithException<P1, P2, P3, E extends Exception> {
		void accept(P1 p1, P2 p2, P3 p3) throws E;
	}
	
	@FunctionalInterface
	public interface QuadriConsumerWithException<P1, P2, P3, P4, E extends Exception> {
		void accept(P1 p1, P2 p2, P3 p3, P4 p4) throws E;
	}
		
	@FunctionalInterface
	public interface PentaConsumerWithException<P1, P2, P3, P4, P5, E extends Exception> {
		void accept(P1 p1, P2 p2, P3 p3, P4 p4, P5 p5) throws E;
	}
	
}
