package ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class NodeTest {

    @Test
    void 오른쪽_방향_위치_이동_확인() {
        Node node = Node.from(Direction.RIGHT);

        Position position = Position.from(0);

        node.move(position);

        assertThat(position.getPosition()).isEqualTo(1);
    }

    @Test
    void NONE_방향_위치_이동_확인() {
        Node node = Node.from(Direction.NONE);

        Position position = Position.from(0);

        node.move(position);

        assertThat(position.getPosition()).isEqualTo(0);
    }

    @Test
    void 왼쪽_방향_위치_이동_확인() {
        Node node = Node.from(Direction.LEFT);

        Position position = Position.from(1);

        node.move(position);

        assertThat(position.getPosition()).isEqualTo(0);
    }

}
