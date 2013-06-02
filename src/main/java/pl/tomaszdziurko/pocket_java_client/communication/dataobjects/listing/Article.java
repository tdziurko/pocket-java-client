package pl.tomaszdziurko.pocket_java_client.communication.dataobjects.listing;

import pl.tomaszdziurko.pocket_java_client.communication.dataobjects.AbstractArticle;

public class Article extends AbstractArticle {

    private String givenUrl;
    private String givenTitle;
    private String resolvedTitle;
    private Boolean favorite;
    private Integer status;

    public String getGivenUrl() {
        return givenUrl;
    }

    public void setGivenUrl(String givenUrl) {
        this.givenUrl = givenUrl;
    }

    public String getGivenTitle() {
        return givenTitle;
    }

    public void setGivenTitle(String givenTitle) {
        this.givenTitle = givenTitle;
    }

    public String getResolvedTitle() {
        return resolvedTitle;
    }

    public void setResolvedTitle(String resolvedTitle) {
        this.resolvedTitle = resolvedTitle;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
