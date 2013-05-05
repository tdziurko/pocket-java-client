package pl.tomaszdziurko.pocket_java_client;

import org.testng.annotations.Test;

import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import static org.fest.assertions.Assertions.assertThat;

public class PocketTest {

    Pocket pocket = new Pocket("consumerKey", "accessToken");

    @Test
    public void shouldThrowExceptionOnMissingUrlForAddedItem() {
        // Given

        // When
        catchException(pocket).add(" ", "Title");

        // Then
        assertThat(caughtException()).isInstanceOf(IllegalArgumentException.class);
        assertThat(caughtException().getMessage()).contains("Article url");
    }

    @Test
    public void shouldThrowExceptionOnMissingTitleForAddedItem() {
        // When
        catchException(pocket).add("http://tomaszdziurko.pl", "");

        // Then
        assertThat(caughtException()).isInstanceOf(IllegalArgumentException.class);
        assertThat(caughtException().getMessage()).contains("Title");
    }
}
