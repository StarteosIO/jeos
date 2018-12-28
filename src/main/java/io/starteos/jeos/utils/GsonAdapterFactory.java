package io.starteos.jeos.utils;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import io.starteos.jeos.Name;
import io.starteos.jeos.Symbol;

public class GsonAdapterFactory implements TypeAdapterFactory {

    private HashMap<Class<?>, TypeAdapter<?>> adapters = new HashMap<>();

    public GsonAdapterFactory() {
        adapters.put(Name.class, new NameAdapter<Name>(Name.class));
        adapters.put(Symbol.class, new NameAdapter<Symbol>(Symbol.class));
    }

    @Override

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        TypeAdapter<T> adapter = null;
        Class<?> currentType = Object.class;
        for (Class<?> aClass : adapters.keySet()) {
            if (aClass.isAssignableFrom(type.getRawType())) {
                if (currentType.isAssignableFrom(aClass)) {
                    currentType = aClass;
                    adapter = (TypeAdapter<T>) adapters.get(aClass);
                }
            }
        }
        return adapter;
    }

    class NameAdapter<C> extends TypeAdapter<C> {
        private Class<C> clazz;

        NameAdapter(Class<C> clazz) {
            this.clazz = clazz;
        }

        @Override
        public void write(JsonWriter out, C value) throws IOException {
            if (value == null) {
                out.nullValue();
                return;
            }
            out.value(value.toString());
        }

        @Override
        public C read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }

            try {
                Constructor<C> constructor = clazz.getConstructor();
                return constructor.newInstance(in.nextString());
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
