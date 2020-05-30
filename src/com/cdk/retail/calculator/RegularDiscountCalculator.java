package com.cdk.retail.calculator;

import com.cdk.retail.user.CustomerType;

import java.util.ArrayList;
import java.util.List;

public class RegularDiscountCalculator extends DiscountCalculator {

    List<DiscountSlab> discountSlabs = null;

    public RegularDiscountCalculator() {
        discountSlabs = new ArrayList<DiscountSlab>();
        discountSlabs.add(new DiscountSlab(0, 5000, 0));
        discountSlabs.add(new DiscountSlab(5000, 10000, 10));
        discountSlabs.add(new DiscountSlab(10000, Double.MAX_VALUE, 20));
    }

    @Override
    public String getCustomerType() {
        return CustomerType.Regular.toString();
    }

    @Override
    List<DiscountSlab> getDiscountSlabs() {
        return discountSlabs;
    }

}
