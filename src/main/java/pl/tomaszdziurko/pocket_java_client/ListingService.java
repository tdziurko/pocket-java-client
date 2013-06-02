package pl.tomaszdziurko.pocket_java_client;

import com.google.common.base.Preconditions;
import org.joda.time.DateTime;
import pl.tomaszdziurko.pocket_java_client.communication.RawJsonResponse;
import pl.tomaszdziurko.pocket_java_client.communication.dataobjects.listing.Article;
import pl.tomaszdziurko.pocket_java_client.communication.dataobjects.listing.ArticleListingRootData;
import pl.tomaszdziurko.pocket_java_client.communication.dataobjects.listing.ArticleState;
import pl.tomaszdziurko.pocket_java_client.communication.dataobjects.listing.ListArticlesRequest;
import pl.tomaszdziurko.pocket_java_client.communication.dataobjects.listing.ListArticlesResponse;
import pl.tomaszdziurko.pocket_java_client.parsers.ArticlesListFromJsonExtractor;

import java.util.List;

public class ListingService extends AbstractService {

    private ArticlesListFromJsonExtractor articlesListFromJsonResponseExtractor;

    public ListingService(Pocket pocket) {
        super(pocket);
        articlesListFromJsonResponseExtractor = new ArticlesListFromJsonExtractor(gson);
    }

    public ListArticlesResponse allUnread() {
        ListArticlesRequest request = new ListArticlesRequest(pocket.getConsumerKey(), pocket.getAccessToken());
        return retrieveArticles(request);
    }

    public ListArticlesResponse allUnreadSince(DateTime since) {
        Preconditions.checkArgument(since != null, "Since value can not be null");

        ListArticlesRequest request = new ListArticlesRequest(pocket.getConsumerKey(), pocket.getAccessToken())
                .withSince(since);
        return retrieveArticles(request);
    }

    public ListArticlesResponse allOfThem() {
        ListArticlesRequest request = new ListArticlesRequest(pocket.getConsumerKey(), pocket.getAccessToken())
                .withState(ArticleState.ALL);
        return retrieveArticles(request);
    }

    public ListArticlesResponse allOfThemSince(DateTime since) {
        Preconditions.checkArgument(since != null, "Since value can not be null");

        ListArticlesRequest request = new ListArticlesRequest(pocket.getConsumerKey(), pocket.getAccessToken())
                .withState(ArticleState.ALL).withSince(since);
        return retrieveArticles(request);
    }

    private ListArticlesResponse retrieveArticles(ListArticlesRequest request) {
        RawJsonResponse rawJsonResponse = requestSender.sendRequest(request, "https://getpocket.com/v3/get");

        if (rawJsonResponse.statusIsOk()) {
            String json = rawJsonResponse.getResponse().get();
            ArticleListingRootData listingRootData = gson.fromJson(json, ArticleListingRootData.class);
            List<Article> articles = articlesListFromJsonResponseExtractor.extractArticlesData(json);
            return new ListArticlesResponse(listingRootData.getStatus(), listingRootData.getComplete(),
                    listingRootData.getSince(), articles);
        } else {
            return new ListArticlesResponse(rawJsonResponse.getStatus());
        }
    }


}
