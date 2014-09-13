/**
 * Player object for the game.
 *
 * @author Lenovo
 *
 */
public class Player {

    private final int startingProvisions = 10;
    private final int startingGold = 30;
    private final int baseSkill = 6;
    private final int baseStamina = 12;
    private final int baseLuck = 6;

    private int skill;
    private int stamina;
    private int luck;
    private int provisions;
    private int gold;
    private Area currentArea;
    private boolean[] goneTo = new boolean[402];

    public Player() {
        initSkill();
        initStamina();
        initLuck();
        initProvisions();
        initGold();
        for (int i = 0; i < goneTo.length; i++) {
            goneTo[i] = false;
        }
    }

    private void initSkill() {
        skill = Tools.rollDice(1);
        skill += baseSkill;
    }

    private void initStamina() {
        stamina = Tools.rollDice(2);
        stamina += baseStamina;
    }

    private void initLuck() {
        luck = Tools.rollDice(1);
        luck += baseLuck;
    }

    private void initProvisions() {
        provisions = startingProvisions;
    }

    private void initGold() {
        gold = startingGold;
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

    public void setGold(int change) {
        gold += change;
    }

    public void setProvisions(int change) {
        provisions += change;
    }

    public void setArea(Area area) {
        currentArea = area;
        goneTo[area.getId()] = true;
        if (area.getId() == 5) {
            battle(area.getEnemy());
        }
        if (area.getId() == 7) {
            setLuck(2);
            if (goneTo[232]) {
                area.removeNext(232);
            }
        }
        area.showText();
    }

    public Area getCurrentArea() {
        return currentArea;
    }

    public void setLuck(int change) {
        luck += change;
    }

    public void battle(Enemy e) {
        // If lost, set area to 401.
    }
}