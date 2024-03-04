package kg.geeks.game.players;


import kg.geeks.game.logic.RpgGame;

public class Hacker extends Hero {
    public Hacker(int health, int damage , String name) {
        super(health, damage, SuperAbility.HACKER, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int damage =RpgGame.random.nextInt(35, 40);
        for (int i = 0; i < heroes.length; i++) {
            int randomIndex = RpgGame.random.nextInt(heroes.length);
            heroes[randomIndex].setHealth(heroes[randomIndex].getHealth() + damage);
            System.out.println("Hacker забрал здоровье у Босса: " + damage);
            break;
        }
    }
}

