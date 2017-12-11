package com.ldroid.kwei.common.entities;


import com.google.gson.annotations.Expose;

public  class OutputDataEntity<RetData> extends OutputEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8297238643328522856L;

	
	@Expose
	public RetData data ;

}