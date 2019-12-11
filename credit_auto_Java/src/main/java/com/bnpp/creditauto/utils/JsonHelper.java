package com.bnpp.creditauto.utils;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JsonHelper {

    private ObjectMapper objectMapper;

    public JsonHelper() {
        this.objectMapper = new ObjectMapper();
    }

    /**
     * Serialize and object to a JSON String representation
     *
     * @param o The object to serialize
     * @return The JSON String representation
     */
    public String serialize(Object o) {
        OutputStream baOutputStream = new ByteArrayOutputStream();
        try {
            objectMapper.writeValue(baOutputStream, o);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return baOutputStream.toString();
    }

    /**
     * Deserialize a JSON string
     *
     * @param content The JSON String object representation
     * @param type    The type of the deserialized object instance
     * @return The deserialized object instance
     */
    public <T> T deserialize(String content, Class<T> type) {
        try {
            return objectMapper.readValue(content, type);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

}