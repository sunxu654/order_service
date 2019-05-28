package net.xdclass.order_service.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static JsonNode str2JsonNode(String string) {
        try {
            return objectMapper.readTree(string);
        } catch (IOException e) {
            e.printStackTrace();
            return  null;
        }
    }
}
