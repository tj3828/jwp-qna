package qna.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import qna.NotFoundException;
import qna.UnAuthorizedException;

public class AnswerTest {

    public static final Answer A1 = new Answer(UserTest.JAVAJIGI, QuestionTest.Q1, "Answers Contents1");
    public static final Answer A2 = new Answer(UserTest.SANJIGI, QuestionTest.Q1, "Answers Contents2");

    @Test
    @DisplayName("생성자 실패 케이스")
    void Answer_create_fail() {
        assertThatExceptionOfType(UnAuthorizedException.class)
            .isThrownBy(() -> new Answer(null, QuestionTest.Q1, "test"));
        assertThatExceptionOfType(NotFoundException.class)
            .isThrownBy(() -> new Answer(UserTest.JAVAJIGI, null, "test"));
    }

    @Test
    @DisplayName("생성자 테스트")
    void Answer_create() {
        assertThat(A1).isEqualTo(new Answer(UserTest.JAVAJIGI, QuestionTest.Q1, "Answers Contents1"));
    }

    @Test
    @DisplayName("작성자가 본인인지 확인")
    void Answer_isOwner() {
        assertThat(A1.isOwner(UserTest.JAVAJIGI)).isTrue();
    }

}
