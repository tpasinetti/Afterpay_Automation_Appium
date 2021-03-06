package com.afterpay.app.appium.models.data_providers;

import com.afterpay.app.appium.models.data_models.CreateAccountData;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;

public class CreateAccountDataProvider implements ArgumentsAggregator {

    @Override
    public Object aggregateArguments(ArgumentsAccessor accessor, ParameterContext context)
            throws ArgumentsAggregationException {

        CreateAccountData accountData = new CreateAccountData();
        accountData.setEmail(accessor.getString(0));
        accountData.setPassword(accessor.getString(1));
        accountData.setMobileNumber(accessor.getString(2));
        accountData.setVerificationCode(accessor.getString(3));
        accountData.setFirstName(accessor.getString(4));
        accountData.setMiddleName(accessor.getString(5));
        accountData.setLastName(accessor.getString(6));
        accountData.setDOBYear(accessor.getString(7));
        accountData.setDOBDay(accessor.getString(8));
        accountData.setDOBString(accessor.getString(9));
        accountData.setAddress(accessor.getString(10));

        return accountData;
    }

}
