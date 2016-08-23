package com.lambdaDemo.lambda;

public interface MusicalCarriage extends Carriage, Jukebox {

	@Override
	default void rock() {
		Carriage.super.rock();
	}

}
