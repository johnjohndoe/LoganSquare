package com.bluelinelabs.logansquare.processor.type.field;

import com.bluelinelabs.logansquare.OptionalField;
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

public class OptionalFieldType extends FieldType {

    public static FieldType typeFor(TypeMirror typeMirror, TypeMirror genericClassTypeMirror, Elements elements, Types types) {
        return null;
    }

    @Override
    public TypeName getTypeName() {
        return ClassName.get(OptionalField.class);
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
    public void parse(MethodSpec.Builder builder, int depth, String setter, Object... setterFormatArgs) {

    }

    @Override
    public void serialize(MethodSpec.Builder builder, int depth, String fieldName, List<String> processedFieldNames, String getter, boolean isObjectProperty, boolean checkIfNull, boolean writeIfNull, boolean writeCollectionElementIfNull) {
        final Type parameterType = parameterTypes.get(0);

    }

}
