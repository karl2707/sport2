package jalgpall;

public class Player {
	private String name;
	private int number;
	
	public Player(String name, int number) {
		super();
		this.name = name;
		this.number = number;
	}
	
	protected Player(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return number + " " + name;
	}
	
}
