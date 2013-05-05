package pl.tomaszdziurko.pocket_java_client.communication.dataobjects.add;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class AddedItem {

    private Long itemId;
    private String normalUrl;
    private Long resolvedId;
    private String resolvedUrl;
    private Long domainId;
    private Long originDomainId;
    private Long responseCode;
    private String mimeType;
    private Long contentLength;
    private String encoding;
    private String dateResolved;
    private String datePublished;
    private String title;
    private String excerpt;
    private Long wordCount;
    private String hasImage;
    private String hasVideo;
    private String isIndex;
    private String isArticle;

    // TODO Not yet implemented
    // private List authors;
    // private List images;
    // private List videos;


    public Long getItemId() {
        return itemId;
    }

    public String getNormalUrl() {
        return normalUrl;
    }

    public Long getResolvedId() {
        return resolvedId;
    }

    public String getResolvedUrl() {
        return resolvedUrl;
    }

    public Long getDomainId() {
        return domainId;
    }

    public Long getOriginDomainId() {
        return originDomainId;
    }

    public Long getResponseCode() {
        return responseCode;
    }

    public String getMimeType() {
        return mimeType;
    }

    public Long getContentLength() {
        return contentLength;
    }

    public String getEncoding() {
        return encoding;
    }

    public String getDateResolved() {
        return dateResolved;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public String getTitle() {
        return title;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public Long getWordCount() {
        return wordCount;
    }

    public String getHasImage() {
        return hasImage;
    }

    public String getHasVideo() {
        return hasVideo;
    }

    public String getIndex() {
        return isIndex;
    }

    public String getArticle() {
        return isArticle;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
