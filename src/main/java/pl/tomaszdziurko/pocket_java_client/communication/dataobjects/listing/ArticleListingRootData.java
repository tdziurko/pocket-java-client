package pl.tomaszdziurko.pocket_java_client.communication.dataobjects.listing;

import pl.tomaszdziurko.pocket_java_client.communication.dataobjects.AbstractPocketResponse;

public class ArticleListingRootData extends AbstractPocketResponse {

    private int complete;
    private long since;

    public ArticleListingRootData() {
    }

    public int getComplete() {
        return complete;
    }

    public long getSince() {
        return since;
    }
}
