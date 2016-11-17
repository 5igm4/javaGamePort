import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;

/**
 * This is a base class for the various menu's our game will contain. Each specific menu will 
 * extend this class, and will build upon it as needed. The menus will display using the 
 * included GraphicsContext object.
 * @author Robert Torgov
 *
 */
public class Menu {
	protected GraphicsContext gameContext;
	protected Button buttonArray[];
	
	/**
	 * This is a constructor for our Menu object. Each Menu will be instantiated using
	 * this constructor.
	 * @param gameContext - A reference to the gameContext where our images will be displayed
	 */
	Menu(GraphicsContext gameContext){
		this.gameContext = gameContext;
	}
	
	/**
	 * Simple getter to retrieve the underlying GraphicsContext
	 * @return - returns the GraphicsContext of the menu
	 */
	public GraphicsContext getGameContext() {
		return this.gameContext;
		
	}
	
	
}
