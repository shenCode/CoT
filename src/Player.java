
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

    public Player() {
        initSkill();
        initStamina();
        initLuck();
        initProvisions();
        initGold();
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
}
=======
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
    
    public int setSkill(int a){
    	return skill = skill + a;
    }
    
    public int setLuck(int a){
    	return luck = luck + a;
    }
    
    public int setStamina(int a){
    	return stamina = stamina + a;
    }
    
    public int setProvision(int a){
    	return provisions = provisions + a;
    }
}
>>>>>>> refs/remotes/origin/master
