package gameoflife;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

import com.spun.util.Colors;
import com.spun.util.ThreadUtils;
import com.spun.util.WindowUtils;

public class GameOfLifeGui extends JPanel {

	private static final int CELL_SIZE = 20;
	private GameOfLife game;

	public GameOfLifeGui(GameOfLife game) {
		this.game = game;
		setPreferredSize(new Dimension(game.getWidth() * CELL_SIZE, game.getHeight() * CELL_SIZE));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Colors.Pinks.HotPink);
		game.renderCells((b, p) -> {
			if (b) {
				g.fillRect(p.x * CELL_SIZE, p.y * CELL_SIZE, CELL_SIZE - 1, CELL_SIZE - 1);
			}
		});
	}

	public static void main(String[] args) {
		GameOfLife game = new GameOfLife(30, 30);
		int x = 15;
		int y = 10;
		for (Point point : GameOfLife.getNeighbors(new Point(x, y))) {
			game.placeCell(point);
		}
		for (Point point : GameOfLife.getNeighbors(new Point(x, y + 3)).subList(0, 3)) {
			game.placeCell(point);
		}
		for (Point point : GameOfLife.getNeighbors(new Point(x, y + 4)).subList(0, 3)) {
			game.placeCell(point);
		}
		for (Point point : GameOfLife.getNeighbors(new Point(x, y + 5))) {
			game.placeCell(point);
		}
		GameOfLifeGui gui = new GameOfLifeGui(game);
		gui.start();
		WindowUtils.testPanel(gui);
	}

	private void start() {
		Runnable run = () -> {
			while (true) {
				ThreadUtils.sleep(750);
				this.advanceTurn();
			}
		};
		new Thread(run).start();
	}

	private void advanceTurn() {
		game.advanceTurn();
		repaint();
	}

}