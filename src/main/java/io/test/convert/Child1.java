package io.test.convert;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@XmlRootElement(name = "Child1")
@XmlType(
        name = "Child1",
        propOrder = {
                "name",
                "age",
                "originalName"
        },
        factoryClass = ObjectFactory.class,
        factoryMethod = "createChild1")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@XmlAccessorType(XmlAccessType.FIELD)
public class Child1 extends Parent {
    private String originalName;
}
