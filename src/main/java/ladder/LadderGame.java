package ladder;

import ladder.creator.LadderCreator;

public class LadderGame {

    private final LadderCreator ladderCreator;

    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    // todo LadderRunner 분리
    public int run(Position position) {
        new LadderRunner(ladderCreator.getRows()).run(position);
        return position.getPosition();
    }
}
