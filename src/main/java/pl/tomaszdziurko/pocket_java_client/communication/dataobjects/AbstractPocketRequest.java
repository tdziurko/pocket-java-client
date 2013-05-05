package pl.tomaszdziurko.pocket_java_client.communication.dataobjects;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;

public class AbstractPocketRequest {

    private String consumer_key;
    private String access_token;

    public AbstractPocketRequest(String consumer_key, String access_token) {
        Preconditions.checkArgument(StringUtils.isNotBlank(consumer_key), "Consumer Key must be provided");
        Preconditions.checkArgument(StringUtils.isNotBlank(access_token), "Access Token must be provided");

        this.consumer_key = consumer_key;
        this.access_token = access_token;
    }

    public String getConsumerKey() {
        return consumer_key;
    }

    public String getAccessToken() {
        return access_token;
    }
}
