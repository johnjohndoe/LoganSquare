package com.bluelinelabs.logansquare.processor;

import com.bluelinelabs.logansquare.LoganSquare;
import com.bluelinelabs.logansquare.processor.model.OptionalModel;
import com.google.testing.compile.JavaFileObjects;
import org.junit.Test;

import java.io.IOException;

import static com.google.common.truth.Truth.ASSERT;
import static com.google.testing.compile.JavaSourceSubjectFactory.javaSource;

public class OptionalModelTest {

    @Test
    public void generatedSource() {
        ASSERT.about(javaSource())
                .that(JavaFileObjects.forResource("model/good/OptionalModel.java"))
                .processedWith(new JsonAnnotationProcessor())
                .compilesWithoutError()
                .and()
                .generatesSources(JavaFileObjects.forResource("generated/OptionalModel$$JsonObjectMapper.java"));
    }

    @Test
    public void reserialization1() {
        String json = "{\"simpleField\":true}";

        String reserialized = null;
        try {
            OptionalModel model = LoganSquare.parse(json, OptionalModel.class);
            reserialized = LoganSquare.serialize(model);
        } catch (final IOException ignored) {
        }

        ASSERT.that(json.equals(reserialized)).isTrue();
    }

    @Test
    public void reserialization2() {
        String json = "{\"jsonOptional\":null,\"simpleField\":true}";

        String reserialized = null;
        try {
            OptionalModel model = LoganSquare.parse(json, OptionalModel.class);
            reserialized = LoganSquare.serialize(model);
        } catch (final IOException ignored) {
        }

        ASSERT.that(json.equals(reserialized)).isTrue();
    }

    @Test
    public void reserialization3() {
        String json = "{\"jsonOptional\":null,\"nonNullJsonOptional\":true,\"simpleField\":true}";

        String reserialized = null;
        try {
            OptionalModel model = LoganSquare.parse(json, OptionalModel.class);
            reserialized = LoganSquare.serialize(model);
        } catch (final IOException ignored) {
        }

        ASSERT.that(json.equals(reserialized)).isTrue();
    }

}
