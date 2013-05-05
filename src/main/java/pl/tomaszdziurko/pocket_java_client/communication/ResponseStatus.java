package pl.tomaszdziurko.pocket_java_client.communication;

public enum ResponseStatus {

    OK(1),
    INVALID_REQUEST(130),
    CONSUMER_KEY_DOES_NOT_MATCH_ACCESS_CODE(137),
    MISSING_CONSUMER_KEY(138),
    MISSING_REDIRECT_URL(140),
    INVALID_CONSUMER_KEY(152),
    USER_REJECTED_CODE(158),
    ALREADY_USED_CODE(159),
    INVALID_REDIRECT_URI(181),
    MISSING_CODE(182),
    CODE_NOT_FOUND(185),
    SERVER_ERROR(199),

    UNKNOWN_ERROR(-9999);

    private final int code;

    ResponseStatus(int code) {
        this.code = code;
    }

    public boolean isOk() {
        return OK == this;
    }

    public static ResponseStatus findByCode(int code) {
        for (ResponseStatus status : ResponseStatus.values()) {
            if (status.code == code) {
                return status;
            }
        }

        return UNKNOWN_ERROR;
    }

}
