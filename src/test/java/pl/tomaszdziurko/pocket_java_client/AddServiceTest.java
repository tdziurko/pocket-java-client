package pl.tomaszdziurko.pocket_java_client;

import org.testng.annotations.Test;

import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import static org.fest.assertions.Assertions.assertThat;

public class AddServiceTest {

    Pocket pocket = new Pocket("consumerKey", "accessToken");

    @Test
    public void shouldThrowExceptionOnMissingUrlForAddedItem() {
        // Given
        AddService addService = new AddService(new Pocket("consumerKey", "accessToken"));

        // When
        catchException(addService).with("  ");

        // Then
        assertThat(caughtException()).isInstanceOf(IllegalArgumentException.class);
        assertThat(caughtException().getMessage()).contains("Article url");
    }

}
