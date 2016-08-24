package com.lambdaDemo.mode;

public class Close implements Action {

	private Editor editor;

	public Close(Editor editor) {
		this.editor = editor;
	}
	
	@Override
	public void perform() {
		this.editor.close();
	}

}
