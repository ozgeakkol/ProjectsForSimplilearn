package com.example.sportyShoes.constants;

public enum Result {
    CATEGORY_INSERTED("Category inserted successfully!"),
    CATEGORY_ALREADY_EXIST("Category is already exist!"),
    CATEGORY_ADD_ERROR("Something went wrong while adding new category!"),
    NO_PRODUCTS("There isn't any product in the system!"),
    PRODUCT_SUCCESSFULLY_INSERTED("Product inserted successfully!"),
    PRODUCT_ALREADY_EXIST("Product is already exist!"),
    PRODUCT_ADD_ERROR("Something went wrong while adding new product!"),
    ADMIN_ACCOUNT_CREATION_ERROR("Admin account could not be created!"),
    ACCOUNT_ALREADY_PRESENT("Account already present. Please sign in!"),
    ACCOUNT_CREATED_SUCCESSFULLY("Account created successfully!"),
    CUSTOMER_LOGIN_SUCCESSFULLY("Customer logged in successfully"),
    ADMIN_LOGIN_SUCCESSFULLY("Admin logged in successfully"),
    INVALID_EMAIL_OR_PASSWORD("Invalid email or password.Please try again!"),
    LOGIN_ERROR("Something went wrong while login!"),
    ORDER_SUCCESSFULLY("Order has been given successfully"),
    ORDER_ERROR("Something went wrong while ordering!")
    ;
    private String resultMessage;

    Result(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
}
