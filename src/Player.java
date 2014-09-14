import java.util.Scanner;

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
    
    private Tools playerTools;
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

    public void setLuck(int change) {
        luck += change;
    }
    
    public void setStamina(int change){

    	this.stamina += change;
    	System.out.println("set stamina。。。。。。。。。。。。。。。:" +this.stamina);
    }

    public void setGold(int change) {
        this.gold += change;
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
    
    public int playerRoll(int diceNum){
 		int rollPoint = playerTools.rollDice(diceNum);
 		return rollPoint;
 	}

    public void battle(Enemy e) {
        // If lost, set area to 401.
    	System.out.println("The Battle is Begin...");
    	Enemy enemy = null;
    	if(getCurrentArea().getEnemy() != null){
        	enemy = getCurrentArea().getEnemy();    		
    	}
    	
    	Scanner scan = new Scanner(System.in);
    	String state;
    	int currLuck = this.getLuck();
    	int playerStamina = this.getStamina();
    	int enemyStamina = enemy.getStamina();
    	int playerPoints = 0;
    	int creaturePoints = 0;
  	
    	//battling when both stamina not 0
    	while(playerStamina != 0 || enemyStamina != 0){
    		System.out.println("Let's roll the dice...");
    		
    		playerPoints = this.playerRoll(2) + this.getSkill();
    		creaturePoints = enemy.creatureRoll(2) + enemy.getSkill();
    		
    		System.out.println("Player's point is: " + playerPoints + "\n"
    				+ "Creature's point is: " + creaturePoints);
    		
    		if(this.getStamina() > enemy.getStamina()){
    			System.out.println("Congras...player has higher point to beat the creature. would you like to use luck【Y/N】?");
    			//state = scan.nextLine();
    			enemy.setStamina(-2);
    			System.out.println("playerStamina： " + this.getStamina());
    			System.out.println("enemyStamina: " + enemyStamina);

    		}
    		else if(this.getStamina() < enemy.getStamina()){
    			System.out.println("Oops...creature has higher point, player has wounded.");
    			setStamina(new Integer(-2));
    			System.out.println("playerStamina： " + playerStamina);
    			System.out.println("enemyStamina: " + enemyStamina);
    		}
    		
    	}
    	
    	if(this.getStamina() <= 0){
    		System.out.println("current stamina is: " + playerStamina);
    		this.setArea(new Area(401));
    	}else if(enemy.getStamina() <= 0){
    		// set the player next area
    		System.out.println("Creature dead! Well play!!");
    		enemy.setDead();
    	}
    }
}