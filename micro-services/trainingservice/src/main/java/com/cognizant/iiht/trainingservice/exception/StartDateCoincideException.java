package com.cognizant.iiht.trainingservice.exception;

public class StartDateCoincideException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public StartDateCoincideException(){
		super("Start Date Coincides with an existing approved training of Mentor");
	}
}
