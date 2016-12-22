import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class GameContent extends JPanel implements ActionListener{

	// Timer for animation purposes
	private Timer timer;

	// Our main character
	private Character player;

	// The coin object.
	private Coin coin;

	// Constructor for the game content
	public GameContent(int width, int height) {
		// Common settings for JPanel
		this.setFocusable(true);
		this.setBackground(Color.WHITE);
		this.setDoubleBuffered(true);
		this.setSize(width, height);

		// Creates an instance of the player's character.
		this.player = new Character();

		// Creates the Coin object.
		this.coin = new Coin();

		// Adds a KeyListener to this JPanel object. 
		// A key listener is an object that intercepts keystrokes allowing
		// you to process them. The code for this key listener is at the 
		// bottom of this file.
		this.addKeyListener(new KeyListener());		

		// Creates a new Timer. The timer "goes off" every 5ms and calls
		// the actionPerformed() method. This allows us to update game content
		// rapidly.
		this.timer = new Timer(5, this);
		this.timer.start();
	}

	// The following method must be included so that the board is displayed on screen.
	// It's a required method that ensures the window is actively redrawn.
	public void addNotify() {
		super.addNotify(); 
	}

	// This method instructs Java how to "paint" the game content.
	// It uses the Graphics parameter g which is automatically sent to the method  
	// (don't worry about where it comes from) to draw on the screen.
	// The Graphics object is converted to a Graphics2d object which 
	// allows us to draw images.
	public void paint(Graphics g) {
		// Tells the JPanel class to paint itself. DO NOT MODIFY!
		super.paint(g);

		// Grabs the Graphics object to draw images. DO NOT MODIFY!
		Graphics2D g2d = (Graphics2D)g;

		// Draws the character. Below here is where you might want to
		// also draw other objects!	
		g2d.drawImage(this.player.getImage(),  this.player.getX(),  this.player.getY(), this);

		// Draw the coin.
		if (this.coin.getVisibility() == true) {
			g2d.drawImage(this.coin.getImage(),  this.coin.getX(),  this.coin.getY(), this);
		}

		// Synchronizes the graphics state. DO NOT MODIFY!
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}


	public void actionPerformed(ActionEvent e) {
		// This method is called every 5ms. We will use it to tell
		// classes that they should update their images, locations, and
		// other similar content. For now, it is empty.

		// Updates the player's position.
		this.player.move();

		//  Update the coin's location.
		this.coin.move();

		// Check for collisions
		checkForCollisions();

		// Tells the JPanel to repaint itself since object positions
		// may have changed.
		repaint();  
	}

	// Method that checks for collisions and reacts accordingly.
	private void checkForCollisions() {
		// Get the hitbox for the Character.
		Rectangle charHitbox = this.player.getHitbox();

		// Get the hitbox for the coin.
		Rectangle coinHitbox = this.coin.getHitbox();

		// Check to make sure the coin is visible.
		if (this.coin.getVisibility() == true) {
			// Check if the two objects collided.

			if (charHitbox.intersects(coinHitbox)) {

				// Set the coin to be invisible.
				this.coin.setVisible(false);
			}
		}
	}

	// Private class -- this is a class that outside Java files
	// cannot see. It's sole purpose is to intercept keystrokes
	// and send them to the player class for processing.
	// DO NOT MODIFY!
	private class KeyListener extends KeyAdapter {

		public void keyReleased(KeyEvent e) {
			player.keyReleased(e);
		}

		public void keyPressed(KeyEvent e) {
			player.keyPressed(e);
		}
	}

}
