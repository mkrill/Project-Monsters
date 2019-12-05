
public class GrassMonster extends Monster {

	public GrassMonster(String name) {
		super(name, "grass");
	}

	@Override
	public void takeHit(Monster attacker) {

		if (attacker != null) {
			switch (attacker.getType()) {
			case "water":
				super.takeHit(attacker.getDamage() / 2);
				break;
			case "fire":
				super.takeHit(attacker.getDamage() * 2);
				break;
			default:
				super.takeHit(attacker.getDamage());
				break;
			}

		}
	}

}
