package br.com.lanche.pedido.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

    private JsonUtils() {

    }

    public static String toJson(Object object) throws Exception {
        return new ObjectMapper().writeValueAsString(object);
    }
}
