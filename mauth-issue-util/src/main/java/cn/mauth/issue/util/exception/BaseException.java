package cn.mauth.issue.util.exception;

/**
 * 业务异常基类
 */
public class BaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;

	public BaseException() {
		super();
	}

	public BaseException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
