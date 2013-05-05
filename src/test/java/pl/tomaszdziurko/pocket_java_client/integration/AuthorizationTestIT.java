package pl.tomaszdziurko.pocket_java_client.integration;

import org.testng.annotations.Test;
import pl.tomaszdziurko.pocket_java_client.authorization.PocketAuthorizer;
import pl.tomaszdziurko.pocket_java_client.authorization.TokenRequestResponse;
import pl.tomaszdziurko.pocket_java_client.communication.ResponseStatus;

import static org.fest.assertions.Assertions.assertThat;

public class AuthorizationTestIT {

    PocketAuthorizer client = new PocketAuthorizer();

    @Test
    public void shouldReceiveRequestToken() {
        // Then
        TokenRequestResponse requestToken = client.getRequestToken(IntegrationTestsConfig.get().getConsumerKey(), "url", null);

        // When
        assertThat(requestToken.getResponseStatus().isOk()).isTrue();
        assertThat(requestToken.getCode()).isNotEmpty();
    }

    @Test
    public void shouldGetInvalidKeyStatus() {
        // When
        TokenRequestResponse requestToken = client.getRequestToken("invalid", "url", null);

        // Then
        assertThat(requestToken.getResponseStatus()).isEqualTo(ResponseStatus.INVALID_CONSUMER_KEY);
        assertThat(requestToken.getCode()).isNull();
    }

    @Test
    public void shouldReceiveStateWithRequestToken() {
        // Given
        String state = "example-state";

        // Then
        TokenRequestResponse requestToken = client.getRequestToken(IntegrationTestsConfig.get().getConsumerKey(), "url", state);

        // When
        assertThat(requestToken.getState()).isEqualTo(state);
    }
}
