package pl.tomaszdziurko.pocket_java_client.communication.dataobjects.listing;

import pl.tomaszdziurko.pocket_java_client.communication.dataobjects.AbstractPocketRequest;

public class ListArticlesRequest extends AbstractPocketRequest {

    public ListArticlesRequest(String consumer_key, String access_token) {
        super(consumer_key, access_token);
    }
}
