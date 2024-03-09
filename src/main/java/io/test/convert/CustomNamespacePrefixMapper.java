package io.test.convert;

import org.glassfish.jaxb.runtime.marshaller.NamespacePrefixMapper;

import java.util.HashMap;
import java.util.Map;

public class CustomNamespacePrefixMapper extends NamespacePrefixMapper {
    public static final Map<String, String> NAMESPACE_MAP = Map.of(
            "http://www.w3.org/2001/XMLSchema-instance", "xsi",
            "https://example1.com/", "example1",
            "https://example2.com/", "example2");

    private Map<String, String> namespaceMap;
    public CustomNamespacePrefixMapper(final Map<String, String> namespaceMap) {
        this.namespaceMap = namespaceMap;
    }
    public CustomNamespacePrefixMapper() {
        this(new HashMap<>(NAMESPACE_MAP));
    }
    @Override
    public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
        return namespaceMap.getOrDefault(namespaceUri, suggestion);
    }
}