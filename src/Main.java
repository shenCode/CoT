import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Map m = new Map();
        Player p = new Player();
        int state = 0;
        Scanner scan = new Scanner(System.in);
        while (state != 400) {
            p.setArea(m.getAreaLocation(state));
            System.out.print("Make your decision: ");
            System.out.println();
            state = scan.nextInt();
            System.out.println("==================="
                    + "=================================================");
            System.out.println();
        }
    }
}
