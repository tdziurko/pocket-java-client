package pl.tomaszdziurko.pocket_java_client.authorization;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;

public class AccessTokenRequestObject {

    private String consumer_key;
    private String code;



    public AccessTokenRequestObject(String consumerKey, String requestToken) {
        Preconditions.checkArgument(StringUtils.isNotBlank(consumerKey), "Consumer Key must be provided");
        Preconditions.checkArgument(StringUtils.isNotBlank(requestToken), "Request Token must be provided");

        this.consumer_key = consumerKey;
        this.code = requestToken;
    }

    public String getConsumerKey() {
        return consumer_key;
    }

    public String getRequestToken() {
        return code;
    }

}
