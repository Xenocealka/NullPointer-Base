package com.xenoceal.cristalix.utility.reflection;

import com.xenoceal.cristalix.utility.SneakyThrow;
import lombok.AccessLevel;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.experimental.UtilityClass;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@UtilityClass
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Reflection {

    MethodHandles.Lookup lookup = MethodHandles.lookup();

    Map<String, MethodHandle> handles = new HashMap<>();
    Map<String, Class<?>> classes = new HashMap<>();

    @SneakyThrows(Exception.class)
    public void initialize() {
        addClass("World", "aej");
        addClass("Entity", "NN");
        addClass("CPacketUseEntity", "XR");

        addHandle("playerEntities", lookup.findGetter(getClass("World"), "c", List.class));
        addHandle("CPacketUseEntity", lookup.findConstructor(getClass("CPacketUseEntity"), MethodType.methodType(Void.TYPE, getClass("Entity"))));
    }

    @SuppressWarnings("unchecked")
    public <T> T invokeMethod(String name, Object... args) {
        try {
            return (T) handles.get(name).invokeWithArguments(args);
        } catch (Throwable t) {
            throw SneakyThrow.sneaky(t);
        }
    }

    @SneakyThrows(ClassNotFoundException.class)
    public Class<?> findClass(String name) {
        return Class.forName(name, true, ClassLoader.getSystemClassLoader());
    }

    public Class<?> getClass(String name) {
        return classes.get(name);
    }

    void addClass(String s1, String s2) {
        classes.put(s1, findClass(s2));
    }

    void addHandle(String name, MethodHandle handle) {
        handles.put(name, handle);
    }

}
