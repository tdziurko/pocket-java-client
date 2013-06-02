package pl.tomaszdziurko.pocket_java_client.communication.dataobjects.add;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.joda.time.DateTime;
import pl.tomaszdziurko.pocket_java_client.communication.dataobjects.AbstractArticle;

public class AddedArticle extends AbstractArticle {

    private String normalUrl;
    private Long domainId;
    private Long originDomainId;
    private Long responseCode;
    private String mimeType;
    private Long contentLength;
    private String encoding;
    private DateTime dateResolved;
    private DateTime datePublished;
    private String title;
    private Boolean isIndex;


    public String getNormalUrl() {
        return normalUrl;
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

    public Boolean isIndex() {
        return isIndex;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
