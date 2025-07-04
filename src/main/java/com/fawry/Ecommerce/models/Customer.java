package com.fawry.Ecommerce.models;

import com.fawry.Ecommerce.utility.ValidationUtils;

public class Customer {

    private final String  name;
    private double balance;
    private  String email;
    private  String Phone;
    private  String Address;


    public Customer(String name, double balance, String email, String Phone, String Address) {
        ValidationUtils.validateNotEmpty(name, "Customer name");
        ValidationUtils.validateNotEmpty(email, "Customer email");
        ValidationUtils.validateNotEmpty(Phone, "Customer phone");
        ValidationUtils.validateNotEmpty(Address, "Customer address");
        ValidationUtils.validateNonNegative(balance, "Customer balance");

        this.name = name;
        this.email = email;
        this.Phone = Phone;
        this.Address = Address;
        this.balance = balance;
    }

    public Customer(String name, double balance) {
        ValidationUtils.validateNotEmpty(name, "Customer name");
        ValidationUtils.validateNonNegative(balance, "Customer balance");
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return Phone;
    }
    public String getAddress() {
        return Address;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Boolean insufficientBalance(double amount) {
        return balance < amount;
    }

    public void pay(double amount){
        ValidationUtils.validateNonNegative(amount, "Payment amount");
        if(insufficientBalance(amount)){
            throw new IllegalArgumentException("Insufficient balance");
        }
        this.balance -= amount;
    }




        }




