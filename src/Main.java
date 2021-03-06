import java.util.Scanner;


public class Main {

    private static Scanner scan;

    public static void main(String[] args) {

        Map m = new Map();
        Player p = new Player();
        int state = 0;
        scan = new Scanner(System.in);
        p.setAreaNoText(m.getAreaLocation(state));
        while (state != 400) {
            System.out.println("Current location: "
                    + p.getCurrentArea().getId());
            System.out.print("Make your decision: ");
            System.out.println();
            state = scan.nextInt();
            System.out.println("==================="
                    + "===============================================" + "\n");
            p.setArea(p.getCurrentArea().getNextById(state));
        }
    }

    // Not tested yet.
    public static void endGame() {
        System.out.println("You have died.");
        new Player().setArea(new Map().getAreaLocation(0));
    }
}
