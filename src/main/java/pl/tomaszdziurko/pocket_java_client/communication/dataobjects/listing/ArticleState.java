package pl.tomaszdziurko.pocket_java_client.communication.dataobjects.listing;

public enum ArticleState {

    UNREAD,
    ARCHIVE,
    ALL;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
