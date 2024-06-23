package extensions.io.qameta.allure;

import io.qameta.allure.LabelAnnotation;

import java.lang.annotation.*;

/**
 * //<a href=
 * "https://javadoc.io/doc/io.qameta.allure/allure-java-commons/2.14.0/io/qameta/allure/LabelAnnotation.html"
 * >Label Annotation Docs</a>
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@LabelAnnotation(name = "ALLURE_MANUAL", value = "true")
public @interface Manual {
}
