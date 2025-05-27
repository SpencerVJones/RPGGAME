import java.util.Random;

public class RandomNumberGenerator {
    static Random random = new Random();

    // Generates a random number between min and max
    public static int NumberBetween(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }
}
