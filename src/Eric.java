import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Eric {

	// The name of the image representing the Eric.
	// This file must be in the same folder as the Java source files.
	private String imgName = "ship.png";
	private Image image;

	// Movement variables
	private int x;
	private int y;
	private int dx, dy;

	// Represents the width and height of the Eric. This will be
	// used later...
	private int width;
	private int height;

	// Constructor for the Eric.
	public Eric() {
		// Creates the image representing the Eric.
		ImageIcon ii = new ImageIcon(this.getClass().getResource(imgName));
		this.image = ii.getImage();

		// Calculates the size of the Eric based on the image.
		this.width = this.image.getWidth(null);
		this.height = this.image.getHeight(null);

		// Sets the initial position of the Eric.
		this.x = 0;
		this.y = 0;
	}


	// Moves the Eric. 
	// The width and height of the screen must be passed so that it cannot go out of bounds.
	public void move() {
		// Updates the Eric's location based on its dx and dy values.
		this.x = this.x + 1;

	}

	// Returns the x-coordinate of the Eric.
	// This is primarily so that the content pane knows where to draw it on screen.
	public int getX() {
		return this.x;
	}

	// Returns the y-coordinate of the Eric.
	public int getY() {
		return this.y;
	}

	// Returns the image of the Eric.
	public Image getImage() {
		return this.image;
	}


	// Returns the hitbox associated with the Eric.
	public Rectangle getHitbox() {
		return new Rectangle(this.x, this.y, this.width, this.height);
	}
}
