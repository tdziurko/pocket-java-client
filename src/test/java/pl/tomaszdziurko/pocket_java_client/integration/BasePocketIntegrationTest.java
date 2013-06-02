package pl.tomaszdziurko.pocket_java_client.integration;

import org.testng.annotations.BeforeMethod;
import pl.tomaszdziurko.pocket_java_client.Pocket;
import pl.tomaszdziurko.pocket_java_client.communication.dataobjects.listing.Article;
import pl.tomaszdziurko.pocket_java_client.communication.dataobjects.listing.ListArticlesResponse;

public class BasePocketIntegrationTest {

    Pocket pocket = new Pocket(IntegrationTestsConfig.get().getApprovedConsumerKey(),
            IntegrationTestsConfig.get().getAccessToken());

    @BeforeMethod
    public void clear() {
        ListArticlesResponse listArticlesResponse = pocket.listArticles().allOfThem();
        if (listArticlesResponse.hasArticles() == false) {
            return;
        }

        for (Article article : listArticlesResponse.getList()) {
            pocket.modifyArticles().deleteArticle(article.getItemId());
        }

        if (pocket.listArticles().allOfThem().hasArticles()) {
            throw new RuntimeException("Unable to clear articles before test method");
        }
    }
}
