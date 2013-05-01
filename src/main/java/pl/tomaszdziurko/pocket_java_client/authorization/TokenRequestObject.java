package pl.tomaszdziurko.pocket_java_client.authorization;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class TokenRequestObject {

    private String consumer_key;
    private String redirect_uri;
    private String state;

    public TokenRequestObject(String consumerKey, String redirectUri, String state) {
        Preconditions.checkArgument(StringUtils.isNotBlank(consumerKey), "Consumer key must be provided");
        Preconditions.checkArgument(StringUtils.isNotBlank(redirectUri), "Redirect uri must be provided");

        this.consumer_key = consumerKey;
        this.redirect_uri = redirectUri;
        this.state = state;
    }

    public String getConsumerKey() {
        return consumer_key;
    }

    public String getRedirectUri() {
        return redirect_uri;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
