package pl.tomaszdziurko.pocket_java_client.communication.dataobjects.add;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.joda.time.DateTime;

public class AddedArticle {

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
    private DateTime dateResolved;
    private DateTime datePublished;
    private String title;
    private String excerpt;
    private Long wordCount;
    private Boolean hasImage;
    private Boolean hasVideo;
    private Boolean isIndex;
    private Boolean isArticle;

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

    public DateTime getDateResolved() {
        return dateResolved;
    }

    public DateTime getDatePublished() {
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

    public Boolean hasImage() {
        return hasImage;
    }

    public Boolean hasVideo() {
        return hasVideo;
    }

    public Boolean isIndex() {
        return isIndex;
    }

    public Boolean isArticle() {
        return isArticle;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
