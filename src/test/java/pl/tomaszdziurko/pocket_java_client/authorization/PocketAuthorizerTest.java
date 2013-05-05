package pl.tomaszdziurko.pocket_java_client.authorization;

import org.testng.annotations.Test;

import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import static org.fest.assertions.Assertions.assertThat;

public class PocketAuthorizerTest {

    private PocketAuthorizer pocketAuthorizer = new PocketAuthorizer();

    @Test
    public void shouldThrowExceptionOnMissingRequestToken() {
        // When
        catchException(pocketAuthorizer).getAuthorizationUrlFor(null, "http://tomaszdziurko.pl");

        // Then
        assertThat(caughtException()).isExactlyInstanceOf(IllegalArgumentException.class);
        assertThat(caughtException().getMessage()).contains("Request Token");
    }

    @Test
    public void shouldThrowExceptionOnMissingRedirectUrl() {
        // When
        catchException(pocketAuthorizer).getAuthorizationUrlFor("token", "");

        // Then
        assertThat(caughtException()).isExactlyInstanceOf(IllegalArgumentException.class);
        assertThat(caughtException().getMessage()).contains("Redirect Back Url");
    }


}
