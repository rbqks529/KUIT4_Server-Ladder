package ladder;

import ladder.creator.BasicLadderCreator;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LandomGameTest {

    @Test
    void 사다리_생성_확인() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);

        //when
        LadderGame basicGame = LadderGameFactory.createBasicLadderGame(numberOfRow, numberOfPerson);
        LadderGame randomGame = LadderGameFactory.createRandomLadderGame(numberOfRow, numberOfPerson);

        //then
        assertThat(basicGame).isNotNull();
        assertThat(randomGame).isNotNull();
    }

    @Test
    void 기본사다리_사람_예외_처리_확인() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        LadderGame basicGame = LadderGameFactory.createBasicLadderGame(numberOfRow, numberOfPerson);

        //given
        Position position = Position.from(4);

        //then
        assertThatThrownBy(() -> basicGame.run(position))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 랜덤사다리_사람_예외_처리_확인() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        LadderGame randomGame = LadderGameFactory.createRandomLadderGame(numberOfRow, numberOfPerson);

        //given
        Position position = Position.from(4);

        //then
        assertThatThrownBy(() -> randomGame.run(position))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 랜덤사다리_결과_확인() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);
        GreaterThanOne numberOfRow = GreaterThanOne.from(6);
        LadderGame randomGame = LadderGameFactory.createRandomLadderGame(numberOfRow, numberOfPerson);

        //given
        Position position = Position.from(0);

        //then
        randomGame.run(position);

        //given
        position = Position.from(1);

        //then
        randomGame.run(position);

        //given
        position = Position.from(2);

        //then
        randomGame.run(position);

        //given
        position = Position.from(3);

        //then
        randomGame.run(position);

        //given
        position = Position.from(4);

        //then
        randomGame.run(position);
    }

}
