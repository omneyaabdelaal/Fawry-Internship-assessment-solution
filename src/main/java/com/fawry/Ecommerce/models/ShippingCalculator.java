package com.fawry.Ecommerce.models;

import com.fawry.Ecommerce.utility.ValidationUtils;

public class ShippingCalculator {
    private final double baseShippingFee;
    private final double weightMultiplier;

    public ShippingCalculator(double baseShippingFee, double weightMultiplier) {
        ValidationUtils.validateNonNegative(baseShippingFee, "Base shipping fee");
        ValidationUtils.validateNonNegative(weightMultiplier, "Weight multiplier");
        this.baseShippingFee = baseShippingFee;
        this.weightMultiplier = weightMultiplier;
    }

    public double calculateShipping(double totalWeight) {
        if (totalWeight <= 0) {
            return 0.0;
        }
        return baseShippingFee + (totalWeight * weightMultiplier);
    }
}
