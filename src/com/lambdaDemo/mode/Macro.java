package com.lambdaDemo.mode;

import java.util.ArrayList;
import java.util.List;

public class Macro {

	private final List<Action> actions;
	
	public Macro() {
		this.actions=new ArrayList<>();
	}
	
	public void record(Action action){
		this.actions.add(action);
	}
	
	public void run(){
//		this.actions.forEach(action->action.perform());
		//ʹ�÷������õ���
		this.actions.forEach(Action::perform);
	}
	
}
