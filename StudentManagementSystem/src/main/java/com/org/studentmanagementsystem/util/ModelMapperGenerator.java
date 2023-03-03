package com.org.studentmanagementsystem.util;

import org.modelmapper.ModelMapper;

public class ModelMapperGenerator {
	
	public static ModelMapper mapper;
	
	private ModelMapperGenerator() {
		
	}
	
	public ModelMapper getMapper() {
		
		if(mapper==null)
			return new ModelMapper();
		
		return mapper;
	}

}
