package domain.generator;

import domain.ball.Balls;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator {

    private final Random random = new Random();
    private final NumberBox box;

    public RandomNumberGenerator(int size) {
        this.box = new NumberBox(size);
    }

    public Balls generate() {

        List<Integer> result = new ArrayList<>();
        int count = 3;

        while (count > 0) {
            int randomIndex = random.nextInt(box.getBoxSize());
            result.add(box.popNumberAndRemove(randomIndex));
            count--;
        }

        return new Balls(result);
    }


}
