package pl.tomaszdziurko.pocket_java_client.communication.dataobjects.add;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import pl.tomaszdziurko.pocket_java_client.communication.dataobjects.AbstractPocketRequest;

public class AddItemRequest extends AbstractPocketRequest {

    private String url;
    private String title;
    private Long tweetId;
    private String tags;

    public AddItemRequest(String consumer_key, String access_token, String url) {
        this(consumer_key, access_token, url, null, null, null);
    }

    public AddItemRequest(String consumer_key, String access_token, String url, String title, Long tweetId, String tags) {
        super(consumer_key, access_token);
        Preconditions.checkArgument(StringUtils.isNotBlank(url), "Article url must be provided");

        this.title = title;
        this.tweetId = tweetId;
        this.tags = tags;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public Long getTweetId() {
        return tweetId;
    }

    public String getTags() {
        return tags;
    }
}
