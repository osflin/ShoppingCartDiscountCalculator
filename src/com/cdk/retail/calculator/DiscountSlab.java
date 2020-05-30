package com.cdk.retail.calculator;

public class DiscountSlab {
    double minSlab;
    double maxSlab;
    double percentDiscount;

    public DiscountSlab(double minSlab, double maxSlab, double percentDiscount) {
        this.minSlab = minSlab;
        this.maxSlab = maxSlab;
        this.percentDiscount = percentDiscount;
    }

    public double getMinSlab() {
        return minSlab;
    }

    public void setMinSlab(double minSlab) {
        this.minSlab = minSlab;
    }

    public double getMaxSlab() {
        return maxSlab;
    }

    public void setMaxSlab(double maxSlab) {
        this.maxSlab = maxSlab;
    }

    public double getPercentDiscount() {
        return percentDiscount;
    }

    public void setPercentDiscount(double percentDiscount) {
        this.percentDiscount = percentDiscount;
    }
}
