package com.cdk.retail;

import com.cdk.retail.calculator.DiscountCalculator;
import com.cdk.retail.calculator.PremiumDiscountCalculator;
import com.cdk.retail.calculator.RegularDiscountCalculator;
import com.cdk.retail.cart.ShoppingCart;
import com.cdk.retail.cart.ShoppingItem;
import com.cdk.retail.user.Customer;
import com.cdk.retail.user.CustomerType;

public class Main {

    /**
     * This Shopping cart demonstrates the use of 2 design patterns:
     * 1) Visitor
     * 2) Chain of Resposibility
     *
     * DiscountCalculator incorporates both the Visitor as well as chain of responsibility
     * DiscountCalculator is registered as a visitor to the shopping cart to calculates the final discount amount
     * additionally it uses the chain of responsibility principle so that the appropriate calculator class handles the discount calculation
     * for a particular customer type.
     *
     * The design is extensible as in the future it is easy to extend and add more discount calculators based on other customer types like Gold, Diamond, Platinum etc.
     * without any modifications to the core classes
     *
     */

    public static void main(String[] args) {
        DiscountCalculator discountCalculator = new RegularDiscountCalculator();
        discountCalculator.setNextCalculator(new PremiumDiscountCalculator());
        testCustomerDiscountCalculation(discountCalculator);
    }

    static void testCustomerDiscountCalculation(DiscountCalculator discountCalculator){
        Customer regularCustomer = new Customer();
        regularCustomer.setCustomerType(CustomerType.Regular.toString());

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setCustomer(regularCustomer);
        shoppingCart.createItem("Rolex Watch", 5000);
        int finalDiscountedAmount = (int) shoppingCart.getBillAmountAfterDiscount(discountCalculator);
        System.out.println("Regular Customer Discounted Bill for purchase of $5000 :: $" + finalDiscountedAmount);

        shoppingCart.clearShoppingItems();
        shoppingCart.createItem("Gold Chain", 10000);
        finalDiscountedAmount = (int) shoppingCart.getBillAmountAfterDiscount(discountCalculator);
        System.out.println("Regular Customer Discounted Bill for purchase of $10000 :: $" + finalDiscountedAmount);

        shoppingCart.clearShoppingItems();
        shoppingCart.createItem("Diamond ring", 15000);
        finalDiscountedAmount = (int) shoppingCart.getBillAmountAfterDiscount(discountCalculator);
        System.out.println("Regular Customer Discounted Bill for purchase of $15000 :: $" + finalDiscountedAmount);

        //Setting customer type to premium
        Customer premiumCustomer = new Customer();
        premiumCustomer.setCustomerType(CustomerType.Premium.toString());
        shoppingCart.setCustomer(premiumCustomer);

        shoppingCart.clearShoppingItems();
        shoppingCart.createItem("Watch", 4000);
        finalDiscountedAmount = (int) shoppingCart.getBillAmountAfterDiscount(discountCalculator);
        System.out.println("Premium Customer Discounted Bill for purchase of $4000 :: $" + finalDiscountedAmount);

        shoppingCart.clearShoppingItems();
        shoppingCart.createItem("Mobile", 8000);
        finalDiscountedAmount = (int) shoppingCart.getBillAmountAfterDiscount(discountCalculator);
        System.out.println("Premium Customer Discounted Bill for purchase of $8000 :: $" + finalDiscountedAmount);

        shoppingCart.clearShoppingItems();
        shoppingCart.createItem("TV set", 12000);
        finalDiscountedAmount = (int) shoppingCart.getBillAmountAfterDiscount(discountCalculator);
        System.out.println("Premium Customer Discounted Bill for purchase of $12000 :: $" + finalDiscountedAmount);

        shoppingCart.clearShoppingItems();
        shoppingCart.createItem("Air Conditioner", 10000);
        shoppingCart.createItem("Referigerator", 10000);
        finalDiscountedAmount = (int) shoppingCart.getBillAmountAfterDiscount(discountCalculator);
        System.out.println("Premium Customer Discounted Bill for purchase of $20000 :: $" + finalDiscountedAmount);
    }
}
