package ladder;

import ladder.creator.*;

public class LadderGameFactory {
    public static LadderGame createBasicLadderGame(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        LadderCreator creator = new BasicLadderCreator(numberOfRow, numberOfPerson);
        return new LadderGame(creator);
    }

    public static LadderGame createRandomLadderGame(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        LadderCreator creator = new AutoLadderCreator(numberOfRow, numberOfPerson);
        return new LadderGame(creator);
    }
}
