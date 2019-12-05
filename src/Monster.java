
public abstract class Monster {

	private String name;
	private int damage;
	private int life;

	// Protected, to be able to reset the type in constructors of subclasses
	protected String type;

	// constructor with values explicitly set
	public Monster(String name, int life, int damage) {
		super();
		this.damage = damage;
		this.life = life;
		this.type = "Normal";
	}

	// Constructor with randomly generated life and damage values
	public Monster(String name, String type) {
		super();

		int fileRange = 50;
		int damageRange = 5;

		this.name = name;
		this.life = (int) (Math.random() * fileRange) + 1;
		this.damage = (int) ((Math.random() * damageRange) + 1) * 2; // "*2" to get even values
		this.type = type;
	}

	protected void takeHit(int damage) {

		System.out.println("Schadensumfang bei Angriff: " + damage);
		if (this.life >= damage) {
			this.life -= damage;
		} else {
			this.life = 0;
		}

		if (this.life > 0) {
			System.out.println(this.name + " has " + this.life + " points remaining");
		} else {
			System.out.println(this.name + " is KO!");
		}

	}

	// To be implemented in clients
	public abstract void takeHit(Monster that);

	@Override
	public String toString() {
		return this.getName() + "=> Type: " + this.getType() + ", life: " + this.getLife() + ", damage: "
				+ this.getDamage();
	}

	// Getter and Setter 
	// *****************
	
	public int getDamage() {
		return damage;
	}

	public String getType() {
		return type;
	}

	protected int getLife() {
		return life;
	}

	public String getName() {
		return name;
	}

}
