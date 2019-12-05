import java.util.ArrayList;
import java.util.Scanner;

public class Arena {

	private static Monster createMonster(String mName, String mType) {
		Monster m = null;

		if (mName != null && mType != null && !"".equals(mName) && !"".contentEquals(mType)) {
			switch (mType) {
			case "fire":
				m = new FireMonster(mName);
				break;
			case "water":
				m = new WaterMonster(mName);
				break;
			case "grass":
				m = new GrassMonster(mName);
				break;
			}
		} else {
			throw new IllegalArgumentException(
					"IllegalArgumentException: Name und Typ eines Monsters müssen angegeben werden!");
		}

		return m;

	}

	public static void main(String[] args) {

		// Init ArrayList with Monstertypes available
		ArrayList<String> mTypes = new ArrayList<String>(3);
		mTypes.add("fire");
		mTypes.add("water");
		mTypes.add("grass");

		// Request type of players monster
		Scanner sc = new Scanner(System.in);
		System.out.println("Which Monster would you like to have?");
		System.out.println("fire, grass, or water");
		String mType = sc.nextLine();

		// Request name of Players monster
		System.out.println("Which name should the monster have?");
		String mName = sc.nextLine();
		sc.close();

		Monster pMon = null;

		try {
			pMon = createMonster(mName, mType);
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}

		if (pMon != null) {

			System.out.println();

			// Remove players monster type from the list of available types
			mTypes.remove(mType);
			// Randomly create computer monster
			Monster cMon = createMonster("Computer-Monster", mTypes.get((int) (Math.random() * mTypes.size())));

			// while both monsters live
			while (pMon.getLife() > 0 && cMon.getLife() > 0) {
				System.out.println("Vor Angriff:");
				System.out.println(pMon);
				System.out.println(cMon);
				System.out.println();

				System.out.println(pMon.getName() + " greift " + cMon.getName() + " an.");
				cMon.takeHit(pMon);

				if (cMon.getLife() > 0) {
					System.out.println(cMon.getName() + " greift " + pMon.getName() + " an.");
					pMon.takeHit(cMon);
					System.out.println();
				}
			}
		}

	}

}
