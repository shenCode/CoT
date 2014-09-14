
public class Enemy {

    private String name;
    private int skill;
    private int stamina;
    private boolean alive;
    private Tools creatureTools;

    public Enemy(String n, int sk, int st) {
        name = n;
        skill = sk;
        stamina = st;
        alive = true;
    }

    public void setDead() {
        alive = false;
        stamina = 0;
    }

    public void setStamina(int change) {
        stamina += change;
    }

    public int getStamina() {
        return stamina;
    }

    public int getSkill() {
        return skill;
    }

    public int creatureRoll(int diceNum) {
        int rollPoint = creatureTools.rollDice(diceNum);
        return rollPoint;
    }
}

