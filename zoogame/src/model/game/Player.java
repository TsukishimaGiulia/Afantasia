package model.game;

public class Player {
	private String name;
	private int lifePoints;
	private Bag bag;

	public Player(String name, int lifePoints) {
		this.name = name;
		this.lifePoints = lifePoints;
	}

	public Player(String name, int lifePoints, Bag bag) {
		this.name = name;
		this.lifePoints = lifePoints;
		this.bag = bag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLifePoints() {
		return lifePoints;
	}

	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}

	public Bag getBag() {
		return bag;
	}

	public void setBag(Bag bag) {
		this.bag = bag;
	}
}
