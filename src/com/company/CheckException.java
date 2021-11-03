package com.company;

import static com.company.Checker.*;

public class CheckException extends Throwable{
    public CheckException(String s) {
        print("Your value is not type of - "+s);
    }
    public CheckException() {
        print("Your value is correct ");
    }
}
