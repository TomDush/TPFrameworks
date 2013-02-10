package net.yvesrocher.training.frameworks.exceptions;

@SuppressWarnings("serial")
public class BorrowingException extends Exception {

	public BorrowingException() {
		super();
	}

	public BorrowingException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public BorrowingException(String arg0) {
		super(arg0);
	}

	public BorrowingException(Throwable arg0) {
		super(arg0);
	}

}
