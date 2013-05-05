package pl.tomaszdziurko.pocket_java_client.communication;

import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

public class ResponseStatusTest {

    @Test
    public void shouldFindStatusByCode() {
        // When
        ResponseStatus status = ResponseStatus.findByCode(138);

        // Then
        assertThat(status).isEqualTo(ResponseStatus.MISSING_CONSUMER_KEY);
    }

    @Test
    public void shouldReturnUnknownErrorStatus() {
        // When
        ResponseStatus status = ResponseStatus.findByCode(Integer.MAX_VALUE);

        // Then
        assertThat(status).isEqualTo(ResponseStatus.UNKNOWN_ERROR);
    }
}
