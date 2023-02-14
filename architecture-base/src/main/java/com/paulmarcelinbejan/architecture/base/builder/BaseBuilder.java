package com.paulmarcelinbejan.architecture.base.builder;

public interface BaseBuilder<CLASS, BUILDER extends BaseBuilder<CLASS, BUILDER>> {
	
	/**
	 * Initialize with default values.
	 * @return this
	 */
	public BUILDER initialize();
	
}
