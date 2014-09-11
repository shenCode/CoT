/**
 *
 * @author Lenovo
 *
 */
public class Player {

    private static final int STARTING_PROVISIONS = 10;
    private static final int STARTING_GOLD = 30;

    private int skill;
    private int stamina;
    private int luck;
    private int provisions;
    private int gold;
    public Player() {
        initSkill();
        initStamina();
        initLuck();
        initProvisions();
        initGold();
    }

    private void initSkill() {
        skill = Tools.rollDice(1);
        skill += 6;
    }

    private void initStamina() {
        stamina = Tools.rollDice(2);
        stamina += 12;
    }

    private void initLuck() {
        luck = Tools.rollDice(1);
        luck += 6;
    }

    private void initProvisions() {
        provisions = STARTING_PROVISIONS;
    }

    private void initGold() {
        gold = STARTING_GOLD;
    }

    public int getSkill() {
        return skill;
    }

    public int getStamina() {
        return stamina;
    }

    public int getLuck() {
        return luck;
    }

    public int getProvisions() {
        return provisions;
    }

    public int getGold() {
        return gold;
    }
}
