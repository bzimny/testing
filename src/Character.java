import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Character {

	// The name of the image representing the character.
	// This file must be in the same folder as the Java source files.
	private String imgName = "ship.png";
	private Image image;

	// Movement variables
	private int x;
	private int y;
	private int dx, dy;

	// Represents the width and height of the character. This will be
	// used later...
	private int width;
	private int height;

	// Constructor for the character.
	public Character() {
		// Creates the image representing the character.
		ImageIcon ii = new ImageIcon(this.getClass().getResource(imgName));
		this.image = ii.getImage();

		// Calculates the size of the character based on the image.
		this.width = this.image.getWidth(null);
		this.height = this.image.getHeight(null);

		// Sets the initial position of the character.
		this.x = 0;
		this.y = 0;
	}


	// Moves the character. 
	// The width and height of the screen must be passed so that it cannot go out of bounds.
	public void move() {
		// Updates the character's location based on its dx and dy values.
		this.x = this.x + this.dx;
		this.y = this.y + this.dy;

		// Ensures that it can't move out of bounds.
		if (this.x < 1) {
			this.x = 1;
		}

		if (this.y < 1) {
			this.y = 1;
		}

		if (this.x > Game.W_WIDTH) {
			this.x = Game.W_WIDTH;
		}

		if (this.y > Game.W_HEIGHT) {
			this.y = Game.W_HEIGHT;
		}
	}

	// Returns the x-coordinate of the character.
	// This is primarily so that the content pane knows where to draw it on screen.
	public int getX() {
		return this.x;
	}

	// Returns the y-coordinate of the character.
	public int getY() {
		return this.y;
	}

	// Returns the image of the character.
	public Image getImage() {
		return this.image;
	}


	// How to react to keys for movement purposes
	public void keyPressed(KeyEvent e) {
		// Grabs a code that represents the key that was pressed.
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			this.dx = -1;
		}

		if (key == KeyEvent.VK_RIGHT) {
			this.dx = 1;
		}

		if (key == KeyEvent.VK_UP) {
			this.dy = -1;
		}

		if (key == KeyEvent.VK_DOWN) {
			this.dy = 1;
		}
	}

	// The following code runs when a key is released.
	// It resets the dx and dy variables.
	public void keyReleased(KeyEvent e) {
		// Grabs a code that represents the key that was pressed.
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			this.dx = 0;
		}

		if (key == KeyEvent.VK_RIGHT) {
			this.dx = 0;
		}

		if (key == KeyEvent.VK_UP) {
			this.dy = 0;
		}

		if (key == KeyEvent.VK_DOWN) {
			this.dy = 0;
		}
	}

	// Returns the hitbox associated with the Character.
	public Rectangle getHitbox() {
		return new Rectangle(this.x, this.y, this.width, this.height);
	}
}
