package pl.tomaszdziurko.pocket_java_client.communication.gson;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.joda.time.DateTime;

public class GsonProducer {

    private static GsonBuilder builder = new GsonBuilder()
            .registerTypeAdapter(DateTime.class, new DateTimeAdapter())
            .registerTypeAdapter(Boolean.class, new BooleanAdapter())
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);

    public static Gson create() {
        return builder.create();
    }
}
