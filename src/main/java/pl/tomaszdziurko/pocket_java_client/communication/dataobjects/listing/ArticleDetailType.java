package pl.tomaszdziurko.pocket_java_client.communication.dataobjects.listing;

public enum ArticleDetailType {

    SIMPLE,
    COMPLETE;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
