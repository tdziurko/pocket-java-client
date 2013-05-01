package pl.tomaszdziurko.pocket_java_client.authorization;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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

}
