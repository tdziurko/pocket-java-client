package pl.tomaszdziurko.pocket_java_client.authorization;

import com.google.gson.Gson;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.tomaszdziurko.pocket_java_client.communication.gson.GsonProducer;

import static org.fest.assertions.Assertions.assertThat;
import static org.testng.AssertJUnit.fail;

public class TokenRequestObjectTest {

    @DataProvider(name = "testData")
    public Object[][] createTestData() {
        return new Object[][]{
                {null, "uri", IllegalArgumentException.class, "Consumer key must be provided"},
                {"", "uri", IllegalArgumentException.class, "Consumer key must be provided"},
                {null, null, IllegalArgumentException.class, "Consumer key must be provided"},
                {"key", null, IllegalArgumentException.class, "Redirect uri must be provided"},
                {"key", "  ", IllegalArgumentException.class, "Redirect uri must be provided"},
        };
    }

    @Test(dataProvider = "testData")
    public void shouldValidateDataOnCreation(String consumerKey, String redirectUri,
                                             Class<? extends Exception> expectedException, String expectedMessage) {
        try {
            new TokenRequestObject(consumerKey, redirectUri, null);
            if(expectedException != null) {
                fail("Should throw exception");
            }
        } catch (Exception e) {
            assertThat(e).isExactlyInstanceOf(expectedException);
            assertThat(e).hasMessage(expectedMessage);
        }
    }

    @Test
    public void shouldConvertToJsonWhenStateIsNull() {
        // Given
        TokenRequestObject requestObject = new TokenRequestObject("1234-asdf-asdf", "http://localhost", null);

        // When
        Gson gson = GsonProducer.create();
        String json = gson.toJson(requestObject);

        // Then
        assertThat(json).isEqualTo("{\"consumer_key\":\"1234-asdf-asdf\",\"redirect_uri\":\"http://localhost\"}");
    }

}
