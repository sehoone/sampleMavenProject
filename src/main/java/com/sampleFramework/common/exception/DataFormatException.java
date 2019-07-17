package com.sampleFramework.common.exception;

@SuppressWarnings("serial")
public class DataFormatException extends Exception {

	public DataFormatException() {
		super();
	}

	public DataFormatException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public DataFormatException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public DataFormatException(String arg0) {
		super(arg0);
	}

	public DataFormatException(Throwable arg0) {
		super(arg0);
	}

}
