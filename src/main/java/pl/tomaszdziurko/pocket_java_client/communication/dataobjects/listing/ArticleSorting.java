package pl.tomaszdziurko.pocket_java_client.communication.dataobjects.listing;

public enum ArticleSorting {

    NEWEST,
    OLDEST,
    TITLE,
    SITE;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
