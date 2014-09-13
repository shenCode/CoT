import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Map m = new Map();
        Player p = new Player();
        int state = 0;
        Scanner scan = new Scanner(System.in);
        p.setArea(m.getAreaLocation(state));
        while (state != 400) {
            System.out.print("Make your decision: ");
            System.out.println();
            state = scan.nextInt();
            System.out.println("==================="
                    + "=================================================");
            System.out.println();
            p.setArea(p.getCurrentArea().getNextById(state));
        }
    }
}
