package pl.tomaszdziurko.pocket_java_client.communication;

import com.google.gson.Gson;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.with;

public class RequestSender {

    private ResponseStatusExtractor responseStatusExtractor;
    private Gson gson;

    public RequestSender() {
        responseStatusExtractor = new ResponseStatusExtractor();
        gson = new Gson();
    }

    public RawJsonResponse sendRequest(Object data, String url) {
        Response response = with().body(gson.toJson(data))
                .header("Content-Type", "application/json; charset=UTF8")
                .header("X-Accept", "application/json")
                .post(url);
        ResponseStatus status = responseStatusExtractor.getStatus(response.getHeaders());

        if (status.isOk()) {
            return RawJsonResponse.ok(response.asString());
        } else {
            return RawJsonResponse.invalid(status);
        }

    }
}
