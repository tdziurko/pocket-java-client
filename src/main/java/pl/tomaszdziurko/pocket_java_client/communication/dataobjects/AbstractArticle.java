package pl.tomaszdziurko.pocket_java_client.communication.dataobjects;

public class AbstractArticle {

    private Long itemId;
    private Long resolvedId;
    private String resolvedUrl;
    private String excerpt;
    private Boolean isArticle;
    private Boolean hasImage;
    private Boolean hasVideo;
    private Long wordCount;

    // TODO Not yet implemented
    // private List authors;
    // private List images;
    // private List videos;


    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getResolvedId() {
        return resolvedId;
    }

    public void setResolvedId(Long resolvedId) {
        this.resolvedId = resolvedId;
    }

    public String getResolvedUrl() {
        return resolvedUrl;
    }

    public void setResolvedUrl(String resolvedUrl) {
        this.resolvedUrl = resolvedUrl;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public Boolean getArticle() {
        return isArticle;
    }

    public void setArticle(Boolean article) {
        isArticle = article;
    }

    public Boolean getHasImage() {
        return hasImage;
    }

    public void setHasImage(Boolean hasImage) {
        this.hasImage = hasImage;
    }

    public Boolean getHasVideo() {
        return hasVideo;
    }

    public void setHasVideo(Boolean hasVideo) {
        this.hasVideo = hasVideo;
    }

    public Long getWordCount() {
        return wordCount;
    }

    public void setWordCount(Long wordCount) {
        this.wordCount = wordCount;
    }
}
