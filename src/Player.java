import java.util.ArrayList;
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

    private Scanner scan = new Scanner(System.in);
    private int skill;
    private int stamina;
    private int luck;
    private int provisions;
    private int gold;
    private Area currentArea;
    private boolean[] goneTo = new boolean[402];
    private ArrayList<String> inventory = new ArrayList<String>();
    private int count;

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
        stamina += change;
    }

    public void setGold(int change) {
        gold += change;
    }

    public void setProvisions(int change) {
        provisions += change;
    }

    public boolean testLuck() {
        int luckPoint = playerRoll(2);
        setLuck(-1);

        if (luckPoint <= getLuck()) {
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
        area.showText();
        switch (area.getId()) {
        case 5:
            for (int i = 0; i < area.getEnemy().size(); i++) {
                battle(area.getEnemy().get(i));
            }
            break;
        case 7:
            setLuck(2);
            if (goneTo[232]) {
                area.removeNext(232);
            }
        case 8:
            setLuck(2);
        case 10:
            for (int i = 0; i < area.getEnemy().size(); i++) {
                battle(area.getEnemy().get(i));
            }
            if (count > 6) {
                area.removeNext(212);
            } else if (count <= 6) {
                area.removeNext(130);
            }
            break;
        case 54:
            setGold(2);
            inventory.add("merchantPass");
        case 94:
            setStamina(6);
        case 96:
            if (goneTo[319]) {
                area.removeNext(319);
            }
        case 351:
            setGold(-10);
            for (int i = 0; i < area.getEnemy().size(); i++) {
                battle(area.getEnemy().get(i));
            }
            break;
        default:
            break;
        }
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

        // int playerStamina = getStamina();
        // int enemyStamina = enemy.getStamina();

        System.out.println("player: " + getStamina() + "\n" + "creature: "
                + e.getStamina());

        int playerPoints = 0;
        int creaturePoints = 0;
        count = 0;
        // battling when both stamina not 0
        while (getStamina() > 0 && e.getStamina() > 0) {

            System.out.println("Let's roll the dice...");

            playerPoints = playerRoll(2) + getSkill();
            creaturePoints = e.creatureRoll(2) + e.getSkill();

            System.out.println("Player's point is: " + playerPoints + "\n"
                    + "Creature's point is: " + creaturePoints);

            if (playerPoints > creaturePoints) {
                System.out.println("Congras...player has higher point to beat "
                        + "the creature. Would you like to use luck [Y/N]?");
                String input = scan.nextLine();
                if (input.equals("Y")) {
                    if (testLuck()) {
                        System.out.println("Extra 2 point damage to creature.");
                        e.setStamina(-4);
                    } else {
                        System.out.println("Unlucky, only deals 1 damage.");
                        e.setStamina(-1);
                    }
                } else if (input.equals("N")) {
                    e.setStamina(-2);
                }
                System.out.println("playerStamina: " + getStamina());
                System.out.println("enemyStamina: " + e.getStamina());

            } else if (playerPoints < creaturePoints) {
                System.out.println("oops...creature has higher point to beat "
                        + "player. Would you like to use luck [Y/N]?");
                String input = scan.nextLine();
                if (input.equals("Y")) {
                    if (testLuck()) {
                        System.out.println("restore 1 point back to player.");
                        setStamina(-1);
                    } else {
                        System.out.println("Unlucky. Extra damage on player.");
                        setStamina(-3);
                    }
                } else if (input.equals("N")) {
                    setStamina(-2);
                }
                System.out.println("playerStamina: " + getStamina());
                System.out.println("enemyStamina: " + e.getStamina());
            }
            count++;
        }

        System.out.println("Your battle lasted for " + count + "rounds.");
        if (getStamina() <= 0) {
            System.out.println("current stamina is: " + getStamina());
            System.out.println("GG...");
            Main.endGame();
        } else if (e.getStamina() <= 0) {
            // set the player next area
            System.out.println("Creature dead! Well played!!" + "\n");
            e.setDead();
            System.out.println("==================="
                    + "===============================================" + "\n");
            System.out.println("Enter 1 to continue.");
        }
    }
}
