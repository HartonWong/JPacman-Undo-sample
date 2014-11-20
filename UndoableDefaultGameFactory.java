package model;

import org.jpacman.framework.factory.DefaultGameFactory;

/**
 * Extends DefaultGameFactory by creating a new undoable game. 
 * 
 * @author Helen Wong, Leonardo Souza, Ryan Dutt 
 */

public class UndoableDefaultGameFactory extends DefaultGameFactory {

	private transient UndoableGame theGame;

	@Override
	public UndoableGame makeGame() {
		theGame = new UndoableGame();
		return theGame;
	}

	@Override
	protected UndoableGame getGame() {
		assert theGame != null;
		return theGame;
	}

}
