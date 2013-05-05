package pl.tomaszdziurko.pocket_java_client;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import pl.tomaszdziurko.pocket_java_client.communication.RequestSender;
import pl.tomaszdziurko.pocket_java_client.communication.dataobjects.add.AddItemRequest;

public class Pocket {

    private String consumerKey;
    private String accessToken;
    private RequestSender requestSender;

    public Pocket(String consumerKey, String accessToken) {
        Preconditions.checkArgument(StringUtils.isNotBlank(consumerKey), "Consumer Key must be provided");
        Preconditions.checkArgument(StringUtils.isNotBlank(accessToken), "Access Token must be provided");

        this.consumerKey = consumerKey;
        this.accessToken = accessToken;
        requestSender = new RequestSender();
    }

    public void addArticle(String url) {
        AddItemRequest addItem = new AddItemRequest(consumerKey, accessToken, url);

        requestSender.sendRequest(addItem, "https://getpocket.com/v3/add");
    }
}
