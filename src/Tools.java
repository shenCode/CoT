import java.util.Random;

public class Tools {

    public static int rollDice(int num) {
        int total = 0;
        Random rand = new Random();

        for (int i = 0; i < num; i++) {
            total += rand.nextInt(6) + 1;
        }
        return total;
    }
}
