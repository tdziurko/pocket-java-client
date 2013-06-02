package pl.tomaszdziurko.pocket_java_client.integration;

import org.testng.annotations.Test;
import pl.tomaszdziurko.pocket_java_client.communication.dataobjects.add.AddArticleResponse;
import pl.tomaszdziurko.pocket_java_client.communication.dataobjects.listing.Article;
import pl.tomaszdziurko.pocket_java_client.communication.dataobjects.listing.ListArticlesResponse;

import static org.fest.assertions.Assertions.assertThat;
import static pl.tomaszdziurko.pocket_java_client.integration.ExampleLinks.*;

public class AddArticleITestIT extends BasePocketIntegrationTest {

    @Test
    public void shouldAddArticle() {
        // When
        AddArticleResponse response = pocket.addArticle().with(ANGULARJS_STARTER);

        // Then
        assertThat(response.getStatus().isOk()).isTrue();
        ListArticlesResponse listArticlesResponse = pocket.listArticles().allUnread();

        assertThat(listArticlesResponse.getList()).hasSize(1);
        Article article = listArticlesResponse.getList().get(0);
        assertThat(article.getResolvedUrl()).isEqualTo(ANGULARJS_STARTER);
    }

    @Test
    public void shouldAddArticleWithTitle() {
        // When
        AddArticleResponse response = pocket.addArticle().with(GEB_REUSING_BROWSER, "Example title");

        // Then
        assertThat(response.getStatus().isOk()).isTrue();
        ListArticlesResponse listArticlesResponse = pocket.listArticles().allUnread();

        assertThat(listArticlesResponse.getList()).hasSize(1);
        Article article = listArticlesResponse.getList().get(0);
        assertThat(article.getResolvedUrl()).isEqualTo(GEB_REUSING_BROWSER);
        assertThat(article.getGivenTitle()).isEqualTo("Example title");
        assertThat(article.getResolvedTitle()).contains("Reusing browser");

    }



}
