package pl.tomaszdziurko.pocket_java_client.communication;

public enum ResponseStatus {

    OK(0),
    MISSING_CONSUMER_KEY(138),
    MISSING_REDIRECT_URL(140),
    INVALID_CONSUMER_KEY(152),
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
