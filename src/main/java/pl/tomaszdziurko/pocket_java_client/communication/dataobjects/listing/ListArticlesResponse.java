package pl.tomaszdziurko.pocket_java_client.communication.dataobjects.listing;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import pl.tomaszdziurko.pocket_java_client.communication.ResponseStatus;
import pl.tomaszdziurko.pocket_java_client.communication.dataobjects.AbstractPocketResponse;

import java.util.List;

public class ListArticlesResponse extends AbstractPocketResponse {

    private Integer complete;
    private List<Article> list;
    private Long since;

    public ListArticlesResponse(ResponseStatus status) {
        super(status);
    }

    public ListArticlesResponse(ResponseStatus status, Integer complete, Long since, List<Article> list) {
        super(status);
        this.complete = complete;
        this.since = since;
        this.list = list;
    }

    public Integer getComplete() {
        return complete;
    }

    public List<Article> getList() {
        return list;
    }

    public boolean hasArticles() {
        return list != null && list.size() > 0;
    }

    public Long getSince() {
        return since;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
