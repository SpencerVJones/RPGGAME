import java.util.Random;

public class RandomNumberGenerator {
    Random random = new Random();

    public int getRandomNumber() {
        // Generates random number between one and 10
        return random.nextInt(10) + 1;
    }
}
