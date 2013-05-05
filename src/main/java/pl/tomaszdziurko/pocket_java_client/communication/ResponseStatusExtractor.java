package pl.tomaszdziurko.pocket_java_client.communication;

import com.jayway.restassured.response.Headers;

public class ResponseStatusExtractor {

    public ResponseStatus getStatus(Headers headers) {
        boolean hasErrorCode = headers.hasHeaderWithName("X-Error-Code");

        if (hasErrorCode == false) {
            return ResponseStatus.OK;
        } else {
            String errorCode = headers.getValue("X-Error-Code");
            return ResponseStatus.findByCode(Integer.valueOf(errorCode));
        }
    }

}
