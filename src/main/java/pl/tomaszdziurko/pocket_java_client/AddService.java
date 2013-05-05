package pl.tomaszdziurko.pocket_java_client;

import com.google.gson.Gson;
import pl.tomaszdziurko.pocket_java_client.communication.GsonProducer;
import pl.tomaszdziurko.pocket_java_client.communication.RawJsonResponse;
import pl.tomaszdziurko.pocket_java_client.communication.RequestSender;
import pl.tomaszdziurko.pocket_java_client.communication.dataobjects.add.AddItemRequest;
import pl.tomaszdziurko.pocket_java_client.communication.dataobjects.add.AddItemResponse;

public class AddService {
    private Pocket pocket;
    private Gson gson;
    private RequestSender requestSender;

    public AddService(Pocket pocket) {
        this.pocket = pocket;
        gson = GsonProducer.create();
        requestSender = new RequestSender();
    }

    public AddItemResponse with(String url) {
        AddItemRequest addItem = new AddItemRequest(pocket.getConsumerKey(), pocket.getAccessToken(), url);
        return sendAndConvertResponse(addItem);
    }

    private AddItemResponse sendAndConvertResponse(AddItemRequest addItem) {
        RawJsonResponse response = requestSender.sendRequest(addItem, "https://getpocket.com/v3/add");

        if (response.statusIsOk()) {
            return gson.fromJson(response.getResponse().get(), AddItemResponse.class);
        } else {
            return new AddItemResponse(response.getStatus());
        }
    }

    public AddItemResponse with(String url, String title) {
        AddItemRequest addItem = new AddItemRequest(pocket.getConsumerKey(), pocket.getAccessToken(), url, title, null, null);
        return sendAndConvertResponse(addItem);
    }

    public AddItemResponse with(String url, String title, String tags, Long tweetId) {
        AddItemRequest addItem = new AddItemRequest(pocket.getConsumerKey(), pocket.getAccessToken(), url, title, tweetId, tags);
        return sendAndConvertResponse(addItem);
    }

    public AddItemResponse with(String url, String title, String tags) {
        AddItemRequest addItem = new AddItemRequest(pocket.getConsumerKey(), pocket.getAccessToken(), url, title, null, tags);
        return sendAndConvertResponse(addItem);
    }

}
