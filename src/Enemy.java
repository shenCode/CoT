
public class Enemy {

    private int skill;
    private int stamina;

    public Enemy(String n, int sk, int st) {
        skill = sk;
        stamina = st;
    }

    public void setDead() {
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
        int rollPoint = Tools.rollDice(diceNum);
        return rollPoint;
    }
}

