package com.cognizant.iiht.trainingservice.exception;

public class EndDateCoincideException extends Exception {

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public EndDateCoincideException(){
			super("End Date Coincides with an existing approved training of Mentor");
		}
}
