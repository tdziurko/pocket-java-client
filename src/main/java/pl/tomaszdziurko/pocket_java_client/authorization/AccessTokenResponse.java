package pl.tomaszdziurko.pocket_java_client.authorization;

import pl.tomaszdziurko.pocket_java_client.communication.ResponseStatus;

public class AccessTokenResponse extends AbstractPocketResponse {

    private String access_token;
    private String username;

    public AccessTokenResponse() {
    }

    public AccessTokenResponse(ResponseStatus status) {
        super(status);
    }

    public String getAccessToken() {
        return access_token;
    }

    public String getUsername() {
        return username;
    }
}
