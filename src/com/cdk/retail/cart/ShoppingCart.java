package com.cdk.retail.cart;

import com.cdk.retail.calculator.DiscountCalculator;
import com.cdk.retail.user.Customer;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List <ShoppingItem> shoppingItems = new ArrayList<ShoppingItem>();
    Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<ShoppingItem> getShoppingItems() {
        return shoppingItems;
    }

    public void clearShoppingItems() {
        this.shoppingItems.clear();
    }

    public void createItem(String name, double amount){
        this.shoppingItems.add(new ShoppingItem(amount, name));
    }

    public double getBillAmountAfterDiscount(DiscountCalculator discountCalculator){
        return discountCalculator.getBillAmountAfterDiscount(this);
    }
}
