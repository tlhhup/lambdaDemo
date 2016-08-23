package com.lambdaDemo.lambda;

public interface Carriage {

	default void rock(){
		System.out.println("Carriage--->rock");
	}
	
}
