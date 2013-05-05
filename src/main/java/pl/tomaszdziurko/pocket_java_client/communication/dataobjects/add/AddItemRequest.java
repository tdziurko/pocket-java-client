package pl.tomaszdziurko.pocket_java_client.communication.dataobjects.add;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import pl.tomaszdziurko.pocket_java_client.communication.dataobjects.AbstractPocketRequest;

public class AddItemRequest extends AbstractPocketRequest {

    private String url;

    public AddItemRequest(String consumer_key, String access_token, String url) {
        super(consumer_key, access_token);
        Preconditions.checkArgument(StringUtils.isNotBlank(url), "Article url must be provided");

        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}
