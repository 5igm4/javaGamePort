import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 * This class extends the Menu class and will act as the main menu, otherwise known as the
 * title screen. The init() function is responsible for rendering all the details of the 
 * menu.
 * @author Robert
 *
 */
public class MainMenu extends Menu {
	
	/**
	 * Reference to the Menu base class constructor
	 * @param gameContext
	 */
	MainMenu(GraphicsContext gameContext) {
		super(gameContext);
	}
	
	public void init() {
		this.gameContext.setTextAlign(TextAlignment.CENTER);
		this.gameContext.setFont(Font.font(30));
		this.gameContext.fillText("THIS IS A TEST TITLE", 407, 100);


	}

}
