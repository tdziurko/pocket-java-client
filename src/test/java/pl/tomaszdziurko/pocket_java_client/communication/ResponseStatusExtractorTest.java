package pl.tomaszdziurko.pocket_java_client.communication;

import com.jayway.restassured.response.Headers;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ResponseStatusExtractorTest {

    private ResponseStatusExtractor extractor = new ResponseStatusExtractor();

    @Test
    public void shouldReturnOkStatus() {
        // Given
        Headers headers = mock(Headers.class);
        when(headers.hasHeaderWithName("X-Error-Code")).thenReturn(false);

        // When
        ResponseStatus status = extractor.getStatus(headers);

        // Then
        assertThat(status).isEqualTo(ResponseStatus.OK);
    }

    @Test
    public void shouldReturnCorrectErrorStatus() {
        // Given
        Headers headers = mock(Headers.class);
        when(headers.hasHeaderWithName("X-Error-Code")).thenReturn(true);
        when(headers.getValue("X-Error-Code")).thenReturn("152");

        // When
        ResponseStatus status = extractor.getStatus(headers);

        // Then
        assertThat(status).isEqualTo(ResponseStatus.INVALID_CONSUMER_KEY);
    }

}
