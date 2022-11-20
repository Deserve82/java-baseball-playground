package domain.generator;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class NumberBox {

    private List<Integer> box;

    public NumberBox(int size) {

        if (size > 9 || size < 1) {
            throw new InvalidParameterException("생성 되는 값은 0 이하 10 이상 일 수 없습니다.");
        }

        box = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            box.add(i + 1);
        }
    }


    public int popNumberAndRemove(int index) {
        if (index >= box.size() || index < 0) {
            throw new InvalidParameterException("잘못 된 index 값입니다.");
        }

        int returnValue = box.get(index);
        box.remove(index);
        return returnValue;
    }

    public int getBoxSize() {
       return box.size();
    }

}
