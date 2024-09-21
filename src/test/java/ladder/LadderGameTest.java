package ladder;

import ladder.creator.BasicLadderCreator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LadderGameTest {

    @Test
    void 사다리_생성_확인() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);

        //when
        BasicLadderCreator basicLadderCreator = new BasicLadderCreator(numberOfRow, numberOfPerson);

        //then
        assertThat(basicLadderCreator).isNotNull();
    }

    @Test
    void 사다리_사람_예외_처리_확인() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        BasicLadderCreator basicLadderCreator = new BasicLadderCreator(GreaterThanOne.from(2), numberOfPerson);
        LadderGame ladderGame = new LadderGame(basicLadderCreator);

        //given
        Position position = Position.from(4);

        //then
        assertThatThrownBy(() -> ladderGame.run(position))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사다리_결과_확인() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);
        GreaterThanOne row = GreaterThanOne.from(3);
        BasicLadderCreator basicLadderCreator = new BasicLadderCreator(row, numberOfPerson);
        LadderGame ladderGame = new LadderGame(basicLadderCreator);

        basicLadderCreator.drawLine(Position.from(0),Position.from(0));
        basicLadderCreator.drawLine(Position.from(1),Position.from(1));
        basicLadderCreator.drawLine(Position.from(2),Position.from(0));

        //given
        Position position = Position.from(0);

        //then
        assertThat(ladderGame.run(position)).isEqualTo(2);

        //given
        position = Position.from(1);

        //then
        assertThat(ladderGame.run(position)).isEqualTo(1);

        //given
        position = Position.from(2);

        //then
        assertThat(ladderGame.run(position)).isEqualTo(0);
    }
}