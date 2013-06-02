package pl.tomaszdziurko.pocket_java_client.parsers;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;
import pl.tomaszdziurko.pocket_java_client.communication.dataobjects.listing.Article;
import pl.tomaszdziurko.pocket_java_client.communication.gson.GsonProducer;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public class ArticlesListFromJsonExtractorTest {

    ArticlesListFromJsonExtractor extractor = new ArticlesListFromJsonExtractor(GsonProducer.create());
    public static final String TWO_ARTICLES_JSON = "{\"status\":1,\"complete\":1,\"list\":{\"347365938\":{\"item_id\":\"347365938\",\"resolved_id\":\"347365938\",\"given_url\":\"http:\\/\\/tomaszdziurko.pl\\/2013\\/04\\/scalatra-html-js-json-escaping\\/\",\"given_title\":\"title\",\"favorite\":\"0\",\"status\":\"0\",\"time_added\":\"1369604499\",\"time_updated\":\"1369604499\",\"time_read\":\"0\",\"time_favorited\":\"0\",\"sort_id\":0,\"resolved_title\":\"Easy Html\\/Javascript JSON escaping in Scalatra\",\"resolved_url\":\"http:\\/\\/tomaszdziurko.pl\\/2013\\/04\\/scalatra-html-js-json-escaping\\/\",\"excerpt\":\"Scalatra is a small web-framework that allows to easily build Rest API for web applications. We are using it in two projects to serve JSON data consumed by AngularJS based front-ends. And in one of this project we had a problem with text messages that could contain Html\\/Javascript elements.\",\"is_article\":\"1\",\"is_index\":\"0\",\"has_video\":\"0\",\"has_image\":\"1\",\"word_count\":\"1019\"},\"365988410\":{\"item_id\":\"365988410\",\"resolved_id\":\"365988410\",\"given_url\":\"http:\\/\\/tomaszdziurko.pl\\/2013\\/05\\/reusing-browser-instance-geb-ui-tests\\/\",\"given_title\":\"title2\",\"favorite\":\"0\",\"status\":\"0\",\"time_added\":\"1369604454\",\"time_updated\":\"1369604454\",\"time_read\":\"0\",\"time_favorited\":\"0\",\"sort_id\":1,\"resolved_title\":\"Reusing browser instance in Geb UI tests\",\"resolved_url\":\"http:\\/\\/tomaszdziurko.pl\\/2013\\/05\\/reusing-browser-instance-geb-ui-tests\\/\",\"excerpt\":\"UPDATE When I originally wrote this post, I was Geb newbie. Despite the fact that approach presented below is valid and works, there is a much simpler solution to this problem incorporated by Geb itself and I strongly suggest using it instead of mine, home-crafted hack.\",\"is_article\":\"1\",\"is_index\":\"0\",\"has_video\":\"0\",\"has_image\":\"0\",\"word_count\":\"643\"}},\"since\":1369774187}";

    @Test
    public void shouldExtractTwoArticles() {
        // When
        List<Article> articles = extractor.extractArticlesData(TWO_ARTICLES_JSON);

        // Then
        assertThat(articles.size() == 2);

        Article articleOne = articles.get(0);
        assertThat(articleOne.getItemId()).isEqualTo(347365938L);
        assertThat(articleOne.getGivenUrl()).isEqualTo("http://tomaszdziurko.pl/2013/04/scalatra-html-js-json-escaping/");
        assertThat(articleOne.getResolvedTitle()).isEqualTo("Easy Html/Javascript JSON escaping in Scalatra");

        Article articleTwo = articles.get(1);
        assertThat(articleTwo.getItemId()).isEqualTo(365988410L);
        assertThat(articleTwo.getGivenUrl()).isEqualTo("http://tomaszdziurko.pl/2013/05/reusing-browser-instance-geb-ui-tests/");
        assertThat(articleTwo.getResolvedTitle()).isEqualTo("Reusing browser instance in Geb UI tests");
    }

    @Test
    public void shouldExtractStartIndexes() {
        // When
        List<Integer> indexes = extractor.getArticlesStartIndexes(TWO_ARTICLES_JSON);

        // Then
        assertThat(indexes.size() == 2);
        assertThat(indexes).containsExactly(45,887);
    }

    @Test
    public void shouldNotExtractAnythingOnStringWithoutPatternMatch() {
        // Given
        String jsonString = "{\"status\":1,\"complete\":1}";

        // When
        List<Integer> indexes = extractor.getArticlesStartIndexes(jsonString);

        // Then
        assertThat(indexes).isEmpty();
    }

    @Test
    public void shouldExtractTwoStringsWithArticles() {
        // When
        List<String> articleStrings = extractor.extractArticleStrings(TWO_ARTICLES_JSON, Lists.newArrayList(45, 887));

        // Then
        assertThat(articleStrings).hasSize(2);
        assertThat(articleStrings.get(0)).contains("\"item_id\":\"347365938\""); // item_id value
        assertThat(articleStrings.get(0)).contains("\"word_count\":\"1019\""); // word count value
        assertThat(articleStrings.get(1)).contains("\"item_id\":\"365988410\""); // item_id value
        assertThat(articleStrings.get(1)).contains("\"word_count\":\"643\""); // word count value
    }
}
