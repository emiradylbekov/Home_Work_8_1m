package kg.geeks.game.players;

import kg.geeks.game.logic.RpgGame;

public class Boss extends GameEntity {
    private SuperAbility defence;

    public Boss(int health, int damage, String name) {
        super(health, damage, name);
    }

    public void chooseDefence() {
        SuperAbility[] variants = SuperAbility.values();
        int randIndex = RpgGame.random.nextInt(variants.length);
        this.defence = variants[randIndex];
    }

    public void attack(Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                if (heroes[i] instanceof Berserk &&
                        this.getDefence() != SuperAbility.BLOCK_DAMAGE_REVERT) {
                    int coeff = RpgGame.random.nextInt(2) + 1; // 1, 2
                    ((Berserk) heroes[i]).setBlockedDamage(this.getDamage() / (5 * coeff)); // 10, 5
                    heroes[i].setHealth(heroes[i].getHealth() -
                            (this.getDamage() - ((Berserk) heroes[i]).getBlockedDamage()));
                } else {
                    heroes[i].setHealth(heroes[i].getHealth() - this.getDamage());
                }
            }
        }
    }

    public SuperAbility getDefence() {
        return defence;
    }

    @Override
    public String toString() {
        return "BOSS " + super.toString() + " defence: " + this.defence;
    }
}
