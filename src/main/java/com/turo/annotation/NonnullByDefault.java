package com.turo.annotation;

import javax.annotation.Nonnull;
import javax.annotation.meta.TypeQualifierDefault;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SuppressWarnings("unused")
@Documented
@Nonnull
@TypeQualifierDefault({ElementType.ANNOTATION_TYPE,
                       ElementType.CONSTRUCTOR,
                       ElementType.FIELD,
                       ElementType.METHOD,
                       ElementType.PACKAGE,
                       ElementType.PARAMETER,
                       ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME) // We only require RUNTIME for our integration test
public @interface NonnullByDefault {
}