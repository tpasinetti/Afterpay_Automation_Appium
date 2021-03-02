package com.afterpay.app.appium.models.data_providers;

import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.junit.jupiter.params.aggregator.AggregateWith;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@AggregateWith(CreateAccountDataProvider.class)
public @interface CsvToCreateAccountData {
    
}
