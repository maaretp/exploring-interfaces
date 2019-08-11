package gameoflife;

import java.awt.Point;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.lambda.actions.Action2;
import org.lambda.utils.Grid;

public class GameOfLife {

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	private int width;
	private int height;
	private HashSet<Point> board = new HashSet<>();

	public GameOfLife(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public String toString() {
		return Grid.print(width, height, this::printCell);
	}

	public String printCell(int x, int y) {
		return isCellAlive(new Point(x, y)) ? "*" : " ";
	}

	public void placeCell(int x, int y) {
		placeCell(new Point(x, y));
	}

	public void placeCell(Point point) {
		board.add(point);

	}

	public void advanceTurn() {
		HashSet<Point> newBoard = new HashSet<>();
		renderCells((b, p) -> {
			if (isAliveNextTurn(p)) {
				newBoard.add(p);
			}
		});
		board = newBoard;
	}

	private boolean isAliveNextTurn(Point point) {
		int count = getLivingNeighborsCount(point);
		return (count == 2 && isCellAlive(point)) || count == 3;
	}

	private int getLivingNeighborsCount(Point point) {
		List<Point> neighbors = getNeighbors(point);
		return (int) neighbors.stream().filter(this::isCellAlive).count();
	}

	private boolean isCellAlive(Point p) {
		return board.contains(p);
	}

	public static List<Point> getNeighbors(Point point) {
		return Arrays.asList(new Point(point.x - 1, point.y - 1), new Point(point.x - 0, point.y - 1),
				new Point(point.x + 1, point.y - 1), new Point(point.x - 1, point.y - 0),
				new Point(point.x + 1, point.y - 0), new Point(point.x - 1, point.y + 1),
				new Point(point.x - 0, point.y + 1), new Point(point.x + 1, point.y + 1));
	}

	public void renderCells(Action2<Boolean, Point> drawable) {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				Point point = new Point(x, y);
				drawable.call(isCellAlive(point), point);
			}
		}

	}

}