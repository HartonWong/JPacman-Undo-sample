package model;

import java.util.ArrayList;
import java.util.List;

import org.jpacman.framework.model.Direction;
import org.jpacman.framework.model.Ghost;
import org.jpacman.framework.model.Player;
import org.jpacman.framework.model.Tile;

/**
 * Takes a snapshot of the game every time a player makes a move.
 * 
 * @author Helen Wong, Leonardo Souza, Ryan Dutt 
 */

public class GameSnapshot {

	private int point = 0;
	private Direction playerDir;
	private Tile playerPosition;
	private List<Tile> ghostsPosition = new ArrayList<Tile>();
	private boolean playerAlive;

	public GameSnapshot(UndoableGame game) {

		setPlayerStats(game); 

		setGhostStats(game);

	}

	/**Initializes player fields of Gamesnapshot  in order to take first snapshot of the game.
	* 
	* @author Helen Wong, Leonardo Souza, Ryan Dutt 
	* 
	* @param UndoableGame Game object which keeps track of all activity that is going on during a game.
	* @return             Nothing.
	*/
	public void setPlayerStats(UndoableGame game) {
		Player player = game.getPlayer();
		this.point = player.getPoints();
		this.playerDir = player.getDirection();
		this.playerPosition = player.getTile();
		this.playerAlive = player.isAlive();
	}
	
   /**Initializes ghost fields of Gamesnapshot  in order to take first snapshot of the game.
	* 
	* @author Helen Wong, Leonardo Souza, Ryan Dutt 
	* 
	* @param UndoableGame Game object which keeps track of all activity that is going on during a game.
	* @return             Nothing.
	*/
	public void setGhostStats(UndoableGame game) {
		
		for (int i = 0; i < game.getGhosts().size(); i++) {
			Ghost ghost = game.getGhosts().get(i);
			this.ghostsPosition.add(i, ghost.getTile());
		}

	}
	
   /**Methods which return the fields of Gamesnapshot object.
	* 
	* @author Helen Wong, Leonardo Souza, Ryan Dutt 
	*  
	* @return Fields of Gamesnapshot object.
	*/
	
	
	public Tile getPlayerPosition() {
		return playerPosition;
	}

	public Direction getPlayerDirection() {
		return playerDir;
	}

	public List<Tile> getGhostPosition() {
		return ghostsPosition;
	}

	public int getPlayerPoint() {
		return point;
	}

	public boolean playerAlive() {
		return playerAlive;
	}

}
