package de.andrena.xpdays2017.testsetup.pojobuilder;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import net.karneim.pojobuilder.GeneratePojoBuilder;

@GeneratePojoBuilder(withFactoryMethod = "a*", withCopyMethod = true)
@Target({ ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.ANNOTATION_TYPE })
public @interface GenerateBuilder {

}
