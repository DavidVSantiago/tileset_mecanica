package game;

import java.awt.Graphics;

import engine.game.GameLoop;
import engine.scene.Level;
import engine.utils.KeyState;
import engine.utils.Recursos;

public class Game extends GameLoop{
	private Level level;
	
	public Game() {
		super(426,240);
		level = new Fase("/assets/cenario_01.tmj","/assets/");	
		iniciarJogo("Jogo Tiled");
	}

	
	// GAMELOOP -------------------------------
	@Override
	public void handlerEvents() {
		level.handlerEvents();
	}
	@Override
	public void update() {
		level.update();
	}
	@Override
	public void render(Graphics g) {
		level.render(g);
		
	}
	
	// OUTROS METODOS -------------------------
	public static void main(String[] args) {
		new Game(); // dispara a aplica��o
	}
}