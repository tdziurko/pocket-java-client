package pl.tomaszdziurko.pocket_java_client;

import com.google.common.base.Preconditions;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import pl.tomaszdziurko.pocket_java_client.communication.GsonProducer;
import pl.tomaszdziurko.pocket_java_client.communication.RawJsonResponse;
import pl.tomaszdziurko.pocket_java_client.communication.RequestSender;
import pl.tomaszdziurko.pocket_java_client.communication.dataobjects.add.AddItemRequest;
import pl.tomaszdziurko.pocket_java_client.communication.dataobjects.add.AddItemResponse;

public class Pocket {

    private String consumerKey;
    private String accessToken;
    private Gson gson;
    private RequestSender requestSender;

    public Pocket(String consumerKey, String accessToken) {
        Preconditions.checkArgument(StringUtils.isNotBlank(consumerKey), "Consumer Key must be provided");
        Preconditions.checkArgument(StringUtils.isNotBlank(accessToken), "Access Token must be provided");

        this.consumerKey = consumerKey;
        this.accessToken = accessToken;
        gson = GsonProducer.create();
        requestSender = new RequestSender();
    }

    public AddItemResponse addArticle(String url) {
        AddItemRequest addItem = new AddItemRequest(consumerKey, accessToken, url);

        RawJsonResponse response = requestSender.sendRequest(addItem, "https://getpocket.com/v3/add");

        if (response.statusIsOk()) {
            return gson.fromJson(response.getResponse().get(), AddItemResponse.class);
        } else {
            return new AddItemResponse(response.getStatus());
        }
    }
}
