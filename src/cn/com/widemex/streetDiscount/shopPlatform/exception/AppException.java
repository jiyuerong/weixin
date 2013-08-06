package cn.com.widemex.streetDiscount.shopPlatform.exception;

public class AppException extends RuntimeException {

	public AppException(){
		super();
	}
	
	public AppException(String message){
		super(message);
	}
}
