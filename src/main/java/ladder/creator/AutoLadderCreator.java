package ladder.creator;

import ladder.GreaterThanOne;
import ladder.Position;
import ladder.Row;
import java.util.Random;

public class AutoLadderCreator implements LadderCreator {
    private final BasicLadderCreator basicCreator;  //조합 사용을 위한 private class
    private int count;
    private final Random random = new Random();
    private final GreaterThanOne numberOfRow;
    private final GreaterThanOne numberOfPerson;

    public AutoLadderCreator(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        this.basicCreator = new BasicLadderCreator(numberOfRow, numberOfPerson);
        this.count = (int) (numberOfRow.getNumber() * numberOfPerson.getNumber() * 0.3 + 1);
        this.numberOfRow = numberOfRow;
        this.numberOfPerson = numberOfPerson;
        createLadder();
    }

    private void createLadder() {
        while (count > 0) {
            try {
                int x = random.nextInt(numberOfRow.getNumber());
                int y = random.nextInt(numberOfPerson.getNumber() - 1);
                drawLine(Position.from(x), Position.from(y));
                count--;
            } catch (IllegalArgumentException e) {}
        }
    }

    @Override
    public void drawLine(Position row, Position col) {
        basicCreator.drawLine(row, col);
    }

    @Override
    public Row[] getRows() {
        return basicCreator.getRows();
    }
}