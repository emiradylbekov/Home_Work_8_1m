package kg.geeks.game.players;

import kg.geeks.game.logic.RpgGame;

public class Warrior extends Hero {
    public Warrior(int health, int damage, String name) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int coeff = RpgGame.random.nextInt(8) + 2;
        boss.setHealth(boss.getHealth() - this.getDamage() * coeff);
        System.out.println("Warrior " + this.getName()
                + " hits critically " + this.getDamage() * coeff);
    }
}
