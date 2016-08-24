package com.lambdaDemo.mode;

public class Open implements Action {
	
	private Editor editor;

	public Open(Editor editor) {
		this.editor = editor;
	}

	@Override
	public void perform() {
		this.editor.open();
	}

}
