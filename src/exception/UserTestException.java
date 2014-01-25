package exception;

public class UserTestException extends RuntimeException {
	public UserTestException() {
		super("这是一个测试用的用户自定义异常");
	}
}
