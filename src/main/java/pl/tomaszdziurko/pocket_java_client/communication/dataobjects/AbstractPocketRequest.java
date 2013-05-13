package pl.tomaszdziurko.pocket_java_client.communication.dataobjects;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;

public class AbstractPocketRequest {

    private String consumerKey;
    private String accessToken;

    public AbstractPocketRequest(String consumerKey, String accessToken) {
        Preconditions.checkArgument(StringUtils.isNotBlank(consumerKey), "Consumer Key must be provided");
        Preconditions.checkArgument(StringUtils.isNotBlank(accessToken), "Access Token must be provided");

        this.consumerKey = consumerKey;
        this.accessToken = accessToken;
    }

    public String getConsumerKey() {
        return consumerKey;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
