package server.JSON;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.Date;

import static common.Constants.formatter;


/**
 * deserializer to parse java.util.Date from Json files
 */
public class CreationDateDeserializer implements JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        try {
            String dateString = jsonElement.getAsString();
            return formatter.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
