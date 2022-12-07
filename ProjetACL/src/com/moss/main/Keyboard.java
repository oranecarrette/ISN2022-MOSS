package com.moss.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

	public boolean upPressed, downPressed, leftPressed, rightPressed;

	@Override
	public void keyTyped(KeyEvent e) { // when you press an alphanumeric key

	}

	@Override
	public void keyPressed(KeyEvent e) { // when you press any kind of key
		int code = e.getKeyCode(); // retrieve the key pressed
		if (code == KeyEvent.VK_Z) { // if you press the Z key
			upPressed = true; // the character goes up
		}
		if (code == KeyEvent.VK_S) { // if you press the S key
			downPressed = true; // the character goes down
		}
		if (code == KeyEvent.VK_Q) { // if you press the Q key
			leftPressed = true; // the character goes left
		}
		if (code == KeyEvent.VK_D) { // if you press the D key
			rightPressed = true; // the character goes right
		}
	}

	@Override
	public void keyReleased(KeyEvent e) { // when you release any kind of key
		int code = e.getKeyCode(); // retrieve the key released
		if (code == KeyEvent.VK_Z) { // if you release the Z key
			upPressed = false; // the character stops
		}
		if (code == KeyEvent.VK_S) { // if you release the S key
			downPressed = false; // the character stops
		}
		if (code == KeyEvent.VK_Q) { // if you release the Q key
			leftPressed = false; // the character stops
		}
		if (code == KeyEvent.VK_D) { // if you release the D key
			rightPressed = false; // the character stops
		}

	}

}
