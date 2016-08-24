package com.lambdaDemo.mode;

/**
 * 具体实现者
 * @author ping
 *
 */
public class Save implements Action {

	private Editor editor;

	public Save(Editor editor) {
		this.editor = editor;
	}

	@Override
	public void perform() {
		this.editor.save();
	}

}
