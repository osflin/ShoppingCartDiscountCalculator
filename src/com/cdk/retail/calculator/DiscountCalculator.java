package com.cdk.retail.calculator;

import com.cdk.retail.cart.ShoppingCart;
import com.cdk.retail.cart.ShoppingItem;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This abstract class Discount Calculator calculates the discount for a aprticular customer type
 * The child class needs to provide the Discount slabs and customertype
 */

public abstract class DiscountCalculator {

    DiscountCalculator nextDiscountCalculator;

    public double getBillAmountAfterDiscount(ShoppingCart shoppingCart) {
        double finalAmount = this.getBillAmount(shoppingCart);
        if (shoppingCart.getCustomer().getCustomerType().equalsIgnoreCase(getCustomerType())) {
            finalAmount = this.calculateDiscount(finalAmount);
        } else if (nextDiscountCalculator != null) {
            finalAmount = nextDiscountCalculator.getBillAmountAfterDiscount(shoppingCart);
        }
        return finalAmount;
    }

    private double getBillAmount(ShoppingCart shoppingCart) {
        return shoppingCart.getShoppingItems().stream().collect(Collectors.summingDouble(ShoppingItem::getAmount));
    }

    private double calculateDiscount(double finalAmount) {

        double finalDiscountedAmount = 0;
        for (DiscountSlab discountSlab : getDiscountSlabs()) {
            if (finalAmount < discountSlab.getMaxSlab()) {
                finalDiscountedAmount = finalDiscountedAmount + ((finalAmount - discountSlab.getMinSlab()) * (discountSlab.getPercentDiscount() / 100));
                break;
            } else {
                finalDiscountedAmount = finalDiscountedAmount + ((discountSlab.getMaxSlab() - discountSlab.getMinSlab()) * (discountSlab.getPercentDiscount() / 100));
            }
        }
        return (finalAmount - finalDiscountedAmount);
    }

    public void setNextCalculator(DiscountCalculator discountCalculator) {
        nextDiscountCalculator = discountCalculator;
    }

    abstract String getCustomerType();

    abstract List<DiscountSlab>  getDiscountSlabs();

}
