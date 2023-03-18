package com.paulmarcelinbejan.architecture.base.builder;

public interface BuilderBase<CLASS, BUILDER extends BuilderBase<CLASS, BUILDER>> {
	
	/**
	 * Initialize with default values.
	 * @return this
	 */
	public BUILDER initialize();
	
}
