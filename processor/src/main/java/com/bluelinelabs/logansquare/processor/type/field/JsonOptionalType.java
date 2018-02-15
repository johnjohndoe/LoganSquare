package com.bluelinelabs.logansquare.processor.type.field;

import com.bluelinelabs.logansquare.JsonOptional;
import com.bluelinelabs.logansquare.NonNullJsonOptional;
import com.bluelinelabs.logansquare.processor.ObjectMapperInjector;
import com.bluelinelabs.logansquare.processor.TypeUtils;
import com.bluelinelabs.logansquare.processor.type.Type;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;

import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import java.util.List;

public class JsonOptionalType<T extends Class<?>> extends FieldType {

    private static final String VARIABLE_NAME = "value";

    private final T optionalClass;

    public static FieldType typeFor(
            final TypeMirror typeMirror,
            final TypeMirror genericClassTypeMirror,
            final Elements elements,
            final Types types
    ) {
        final Class<? extends JsonOptional> cls;
        switch (genericClassTypeMirror.toString()) {
            case "com.bluelinelabs.logansquare.JsonOptional": {
                cls = JsonOptional.class;
                break;
            }
            case "com.bluelinelabs.logansquare.NonNullJsonOptional": {
                cls = NonNullJsonOptional.class;
                break;
            }
            default:
                return null;
        }
        @SuppressWarnings("unchecked") final JsonOptionalType jsonOptionalType = new JsonOptionalType(cls);
        jsonOptionalType.addParameterTypes(TypeUtils.getParameterizedTypes(typeMirror), elements, types);
        return jsonOptionalType;
    }

    public JsonOptionalType(final T optionalClass) {
        this.optionalClass = optionalClass;
    }

    @Override
    public TypeName getTypeName() {
        return ClassName.get(optionalClass);
    }

    @Override
    public TypeName getNonPrimitiveTypeName() {
        return getTypeName();
    }

    @Override
    public String getParameterizedTypeString() {
        return "$T<" + parameterTypes.get(0).getParameterizedTypeString() + ">";
    }

    @Override
    public void parse(
            final MethodSpec.Builder builder,
            final int depth,
            final String setter,
            final Object... setterFormatArgs
    ) {
        final Type parameterType = parameterTypes.get(0);
        builder.addStatement("final $T $L", parameterType.getTypeName(), VARIABLE_NAME);
        parameterType.parse(builder, depth + 1, "$L = $L", VARIABLE_NAME);
        final String newSetter = replaceLastLiteral(setter, "$T.value($L)");
        builder.addStatement(newSetter, expandStringArgs(setterFormatArgs, getTypeName(), VARIABLE_NAME));
    }

    @Override
    public void serialize(
            final MethodSpec.Builder builder,
            final int depth,
            final String fieldName,
            final List<String> processedFieldNames,
            final String getter,
            final boolean isObjectProperty,
            final boolean checkIfNull,
            final boolean writeIfNull,
            final boolean writeCollectionElementIfNull
    ) {
        final Type parameterType = parameterTypes.get(0);
        builder.beginControlFlow("if ($L != null && !$L.isEmpty())", getter, getter);
        if (isObjectProperty) {
            builder.addStatement("$L.writeFieldName($S)", ObjectMapperInjector.JSON_GENERATOR_VARIABLE_NAME, fieldName);
        }
        final String valueGetter = String.format("%s.getValue()", getter);
        builder.beginControlFlow("if ($L != null)", valueGetter);
        parameterType.serialize(builder, depth + 1, fieldName, processedFieldNames, valueGetter, false, false, false, writeCollectionElementIfNull);
        builder.nextControlFlow("else")
                .addStatement("$L.writeNull()", ObjectMapperInjector.JSON_GENERATOR_VARIABLE_NAME)
                .endControlFlow()
                .endControlFlow();
    }

}
