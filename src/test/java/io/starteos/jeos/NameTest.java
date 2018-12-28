package io.starteos.jeos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Test;

import java.util.HashMap;

import io.starteos.jeos.exception.NameConversionException;
import io.starteos.jeos.utils.GsonAdapterFactory;

public class NameTest {

    @Test
    public void suffix() throws NameConversionException {
        Name name = Name.toName("starteos.io");
        System.out.println(name.suffix());
    }

    @Test
    public void length() throws NameConversionException {
        Name name = Name.toName("starteos.io");
        System.out.println(name.length());
    }

    @Test
    public void charToValue() {
    }

    @Test
    public void name_to_string() throws NameConversionException {
        Name name = Name.toName("starteos.io");
        System.out.println(name.name_long());
    }

    @Test
    public void toName() throws NameConversionException {
        Name name = Name.toName("starteos.io");
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("a", name);
        Gson gson = new GsonBuilder().registerTypeAdapterFactory(new GsonAdapterFactory())
                .serializeNulls()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        System.out.println(gson.toJson(hashMap));
    }
}