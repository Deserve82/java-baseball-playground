package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator {

    private int numberLimit = 9;
    private final List<Integer> numberBox = new ArrayList<>();
    private final Random random = new Random();

    public RandomNumberGenerator() {
        for (int i = 0; i < numberLimit; i++) {
            numberBox.add(i + 1);
        }
    }

    public String generateRandomNumber() {
        int size = 3;
        StringBuilder returnNumber = new StringBuilder();
        while (size > 0) {
            int randomNumber = getRandomNumberFromABox();
            returnNumber.append(randomNumber);
            size -= 1;
        }
        return returnNumber.toString();
    }

    private int getRandomNumberFromABox() {
        int randomIndex = getRandomIndex(numberLimit);
        int randomNumber = numberBox.get(randomIndex);
        deductNumberFromBox(randomIndex);
        return randomNumber;
    }

    private int getRandomIndex(int limit) {
        return random.nextInt(limit);
    }

    private void deductNumberFromBox(int index) {
        numberBox.remove(index);
        numberLimit -= 1;
    }
}
