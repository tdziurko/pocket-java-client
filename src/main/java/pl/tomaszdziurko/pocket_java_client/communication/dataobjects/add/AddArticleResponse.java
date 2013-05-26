package pl.tomaszdziurko.pocket_java_client.communication.dataobjects.add;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import pl.tomaszdziurko.pocket_java_client.communication.ResponseStatus;
import pl.tomaszdziurko.pocket_java_client.communication.dataobjects.AbstractPocketResponse;

public class AddArticleResponse extends AbstractPocketResponse {

    private AddedArticle item;

    public AddArticleResponse(ResponseStatus status) {
        super(status);
    }

    public AddedArticle getArticle() {
        return item;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
