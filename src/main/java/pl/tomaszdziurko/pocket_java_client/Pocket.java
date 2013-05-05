package pl.tomaszdziurko.pocket_java_client;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import pl.tomaszdziurko.pocket_java_client.communication.RequestSender;
import pl.tomaszdziurko.pocket_java_client.communication.dataobjects.AddItemRequest;

public class Pocket {

    private String consumer_key;
    private String access_token;
    private RequestSender requestSender;

    public Pocket(String consumer_key, String access_token) {
        Preconditions.checkArgument(StringUtils.isNotBlank(consumer_key), "Consumer Key must be provided");
        Preconditions.checkArgument(StringUtils.isNotBlank(access_token), "Access Token must be provided");

        this.consumer_key = consumer_key;
        this.access_token = access_token;
        requestSender = new RequestSender();
    }

    public void addArticle(String url) {
        AddItemRequest addItem = new AddItemRequest(consumer_key, access_token, url);

        requestSender.sendRequest(addItem, "https://getpocket.com/v3/add");
    }
}
