package pl.tomaszdziurko.pocket_java_client;

import com.google.common.base.Preconditions;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import pl.tomaszdziurko.pocket_java_client.communication.RequestSender;

public class Pocket {

    private String consumerKey;
    private String accessToken;
    private Gson gson;
    private RequestSender requestSender;

    private AddService addService;
    private ListingService listingService;

    public Pocket(String consumerKey, String accessToken) {
        Preconditions.checkArgument(StringUtils.isNotBlank(consumerKey), "Consumer Key must be provided");
        Preconditions.checkArgument(StringUtils.isNotBlank(accessToken), "Access Token must be provided");

        this.consumerKey = consumerKey;
        this.accessToken = accessToken;

        addService = new AddService(this);
        listingService = new ListingService(this);
    }

    public AddService addArticle() {
        return addService;
    }

    public ListingService listArticles() {
        return listingService;
    }

    public String getConsumerKey() {
        return consumerKey;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
