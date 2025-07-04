package com.fawry.Ecommerce.models;

public class CheckoutResult {
    private final double subtotal;
    private final double shippingFee;
    private final double totalAmount;
    private final double customerBalanceAfter;
    private final boolean success;
    private final String errorMessage;

    public CheckoutResult(double subtotal, double shippingFee, double totalAmount,
                          double customerBalanceAfter, boolean success, String errorMessage) {
        this.subtotal = subtotal;
        this.shippingFee = shippingFee;
        this.totalAmount = totalAmount;
        this.customerBalanceAfter = customerBalanceAfter;
        this.success = success;
        this.errorMessage = errorMessage;
    }


    public double getSubtotal() { return subtotal; }
    public double getShippingFee() { return shippingFee; }
    public double getTotalAmount() { return totalAmount; }
    public double getCustomerBalanceAfter() { return customerBalanceAfter; }
    public boolean isSuccess() { return success; }
    public String getErrorMessage() { return errorMessage; }
}