package com.lambdaDemo.lambda;

public interface Jukebox {

	default void rock(){
		System.out.println("Jukebox--->rock");
	}
	
}
