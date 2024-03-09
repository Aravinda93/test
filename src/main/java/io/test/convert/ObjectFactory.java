package io.test.convert;

import jakarta.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public final class ObjectFactory {
    private ObjectFactory() {}
    public static Child1 createChild1() {
        return new Child1();
    }
}
