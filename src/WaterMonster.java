
public class WaterMonster extends Monster {

	public WaterMonster(String name) {
		super(name);
		this.type = "water";
	}

	@Override
	public void takeHit(Monster attacker) {

		if (attacker != null) {
			switch (attacker.getType()) {
			case "fire":
				super.takeHit(attacker.getDamage() / 2);
				break;
			case "grass":
				super.takeHit(attacker.getDamage() * 2);
				break;
			default:
				super.takeHit(attacker.getDamage());
				break;
			}

		}
	}

}
