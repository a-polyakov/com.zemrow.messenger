package com.zemrow.messenger.json;

import com.dslplatform.json.DslJson;
import com.dslplatform.json.Nullable;
import com.dslplatform.json.runtime.Settings;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * Работа с JSON.
 *
 * @author Alexandr Polyakov on 2020.12.06
 */
public class JsonMapper {
    private final DslJson<Object> inner;

    public JsonMapper() {
        inner = new DslJson(Settings.basicSetup());
        inner.registerReader(long.class, LongAsHex.LONG_READER);
        inner.registerReader(Long.class, LongAsHex.NULLABLE_LONG_READER);
        inner.registerWriter(long.class, LongAsHex.LONG_WRITER);
        inner.registerWriter(Long.class, LongAsHex.LONG_WRITER);
        //TODO
//        json.registerReader(long[].class, LongAsHex.LONG_ARRAY_READER);
//        json.registerWriter(long[].class, LongAsHex.LONG_ARRAY_WRITER);

    }

    @Nullable
    public <TResult> TResult deserialize(Class<TResult> manifest, InputStream stream) throws IOException {
        return inner.deserialize(manifest, stream);
    }

    public Map deserialize(String json) throws IOException {
        // TODO устранить двойной размер (строка и байтовое представление)
        final byte jsonBytes[] = json.getBytes(StandardCharsets.UTF_8);
        return inner.deserialize(Map.class, jsonBytes, jsonBytes.length);
    }

    public void serialize(Object value, OutputStream stream) throws IOException {
        inner.serialize(value, stream);
    }

    public String serialize(Object value) throws IOException {
        final ByteArrayOutputStream stream = new ByteArrayOutputStream(); // stream with JSON in UTF-8
        inner.serialize(value, stream); //will use thread local writer
        return stream.toString();
        //TODO
//        final JsonWriter jsonWriter = inner.newWriter();
//        jsonWriter.serializeObject(value);
//        return jsonWriter.toString();
    }
}
