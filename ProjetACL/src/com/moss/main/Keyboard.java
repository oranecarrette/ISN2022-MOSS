package com.moss.main;

// USEFUL IMPORTS 
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//the class Keyboard creates a link between what the player enters with the keyboard and the movement of the hero

public class Keyboard implements KeyListener {

	// MEMBER VARIABLES
	public boolean upPressed, downPressed, leftPressed, rightPressed;

	// METHODS 
	@Override
	/* Method called when an alphanumeric key is pressed, left blanked because not useful in this game */
	public void keyTyped(KeyEvent e) { // 
		
	}

	@Override
	/* Method called when any kind of key is pressed */
	public void keyPressed(KeyEvent e) {
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
	/* Method called when any kind of key is released */
	public void keyReleased(KeyEvent e) {
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
