package io.test.convert;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

import java.util.HashMap;
import java.util.Map;

public class MainXML {
    public static void main(String[] args) throws Exception {
        final Map<String, String> myNamespaces = new HashMap<>();
        myNamespaces.put("test", "https://test.com");
        myNamespaces.put("test2", "https://test2.com");

        final JAXBContext jaxbContext = JAXBContext.newInstance("io.test.convert", Thread.currentThread().getContextClassLoader(),
                new HashMap<>() {
                    {
                        put(
                                "org.glassfish.jaxb.namespacePrefixMapper",
                                new CustomNamespacePrefixMapper());
                    }
                });
        //final JAXBContext jaxbContext = JAXBContext.newInstance("io.test.convert", Thread.currentThread().getContextClassLoader());

        final Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        marshaller.setProperty("org.glassfish.jaxb.namespacePrefixMapper", new CustomNamespacePrefixMapper());

        final Child1 child1 = new Child1();
        child1.setName("Batman");
        child1.setAge("30");
        child1.setType("Superhero");
        child1.setOriginalName("Bruce Wayne");

        marshaller.marshal(child1, System.out);
    }
}