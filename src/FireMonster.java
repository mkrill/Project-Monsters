
public class FireMonster extends Monster {

	public FireMonster(String name) {
		super(name, "fire");
	}
	

	@Override
	public void takeHit(Monster attacker) {

		if (attacker != null) {
			switch (attacker.getType()) {
			case "grass":
				super.takeHit(attacker.getDamage() / 2);
				break;
			case "water":
				super.takeHit(attacker.getDamage() * 2);
				break;
			default:
				super.takeHit(attacker.getDamage());
				break;
			}

		}
	}
}