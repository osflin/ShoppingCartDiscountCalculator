package com.cdk.retail.calculator;

import com.cdk.retail.user.CustomerType;

import java.util.ArrayList;
import java.util.List;

public class PremiumDiscountCalculator extends DiscountCalculator {

    List<DiscountSlab> discountSlabs = null;

    @Override
    String getCustomerType() {
        return CustomerType.Premium.toString();
    }

    public PremiumDiscountCalculator() {
        discountSlabs = new ArrayList<DiscountSlab>();
        discountSlabs.add(new DiscountSlab(0, 4000, 10));
        discountSlabs.add(new DiscountSlab(4000, 8000, 15));
        discountSlabs.add(new DiscountSlab(8000, 12000, 20));
        discountSlabs.add(new DiscountSlab(12000, Double.MAX_VALUE, 30));
    }

    @Override
    List<DiscountSlab> getDiscountSlabs() {
        return discountSlabs;
    }
}
