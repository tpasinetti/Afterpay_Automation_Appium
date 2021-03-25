package com.afterpay.app.appium.models.data_providers;

import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;

public class CompleteYourProfileData extends ArgumentsAggregator{
    
    @Override
    public Object aggregateArguments(ArgumentsAccessor accessor, ParameterContext context)
            throws ArgumentsAggregationException {

        ANZ_CreateAccountData accountData = new ANZ_CreateAccountData();
        accountData.setEmail(accessor.getString(0));
        accountData.setPassword(accessor.getString(1));
        accountData.setMobileNumber(accessor.getString(2));

        return accountData;
    }
}
