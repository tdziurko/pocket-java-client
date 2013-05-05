package pl.tomaszdziurko.pocket_java_client.authorization;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class TokenRequestObject {

    private String consumerKey;
    private String redirectUri;
    private String state;

    public TokenRequestObject(String consumerKey, String redirectUri, String state) {
        Preconditions.checkArgument(StringUtils.isNotBlank(consumerKey), "Consumer key must be provided");
        Preconditions.checkArgument(StringUtils.isNotBlank(redirectUri), "Redirect uri must be provided");

        this.consumerKey = consumerKey;
        this.redirectUri = redirectUri;
        this.state = state;
    }

    public String getConsumerKey() {
        return consumerKey;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
