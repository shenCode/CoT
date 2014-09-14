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

    private Scanner scan;
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

    public void setStamina(int change) {

        this.stamina += change;
    }

    public void setGold(int change) {
        this.gold += change;
    }

    public void setProvisions(int change) {
        provisions += change;
    }

    public boolean textLuck() {
        int luckPoint = this.playerRoll(2);
        this.setLuck(-1);

        if (luckPoint <= this.getLuck()) {
            System.out.println("This is your lucky day...:)");
            return true;
        } else {
            System.out.println("This is NOT your lucky day...");
            return false;
        }
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

    public int playerRoll(int diceNum) {
        int rollPoint = Tools.rollDice(diceNum);
        return rollPoint;
    }

    public void battle(Enemy e) {
        // If lost, set area to 401.
        System.out.println("The Battle is Begin...");
        Enemy enemy = null;
        if (getCurrentArea().getEnemy() != null) {
            enemy = getCurrentArea().getEnemy();
        }

        // int playerStamina = this.getStamina();
        // int enemyStamina = enemy.getStamina();

        System.out.println("player: " + this.getStamina() + "\n" + "creature: "
                + enemy.getStamina());

        int playerPoints = 0;
        int creaturePoints = 0;

        // battling when both stamina not 0
        while (this.getStamina() > 0 && enemy.getStamina() > 0) {

            System.out.println("Let's roll the dice...");

            playerPoints = this.playerRoll(2) + this.getSkill();
            creaturePoints = enemy.creatureRoll(2) + enemy.getSkill();

            System.out.println("Player's point is: " + playerPoints + "\n"
                    + "Creature's point is: " + creaturePoints);

            if (playerPoints > creaturePoints) {
                System.out.println("Congras...player has higher point to beat "
                        + "the creature. Would you like to use luck [Y/N]?");
                String input = scan.nextLine();
                if (input.equals("Y")) {
                    if (this.textLuck()) {
                        System.out.println("Extra 2 point damage to creature.");
                        enemy.setStamina(-4);
                    } else {
                        enemy.setStamina(-2);
                    }
                } else if (input.equals("N")) {
                    enemy.setStamina(-2);
                }
                System.out.println("playerStamina: " + this.getStamina());
                System.out.println("enemyStamina: " + enemy.getStamina());

            } else if (playerPoints < creaturePoints) {
                System.out.println("oops...creature has higher point to beat "
                        + "player. Would you like to use luck [Y/N]?");
                String input = scan.nextLine();
                if (input.equals("Y")) {
                    if (this.textLuck()) {
                        System.out.println("restore 1 point back to player.");
                        this.setStamina(-1);
                    } else {
                        this.setStamina(-2);
                    }
                } else if (input.equals("N")) {
                    this.setStamina(-2);
                }
                System.out.println("playerStamina: " + this.getStamina());
                System.out.println("enemyStamina: " + enemy.getStamina());
            }

        }

        if (this.getStamina() <= 0) {
            System.out.println("current stamina is: " + this.getStamina());
            System.out.println("GG...");
            // this.setArea(new Area(401));
        } else if (enemy.getStamina() <= 0) {
            // set the player next area
            System.out.println("Creature dead! Well play!!");
            enemy.setDead();
        }
    }
}