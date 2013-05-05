package pl.tomaszdziurko.pocket_java_client.authorization;

import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.testng.AssertJUnit.fail;

public class AccessTokenRequestObjectTest {

    @Test
    public void shouldThrowExceptionOnMissingConsumerKey() {
        // When
        try {
            new AccessTokenRequestObject("", "token");
            fail("Should throw exception");
        } catch (Exception e) {
            assertThat(e).isExactlyInstanceOf(IllegalArgumentException.class);
            assertThat(e.getMessage()).contains("Consumer Key");
        }
    }

    @Test
    public void shouldThrowExceptionOnMissingRequestToken() {
        // When
        try {
            new AccessTokenRequestObject("consumerkey", "");
            fail("Should throw exception");
        } catch (Exception e) {
            assertThat(e).isExactlyInstanceOf(IllegalArgumentException.class);
            assertThat(e.getMessage()).contains("Request Token");
        }
    }
}
