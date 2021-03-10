package com.xingray.beyondjson;


import org.junit.Test;

public class ObjectTest {
    @Test
    public void customerObjectTest() {
        Customer customer = new Customer();
        customer.setName("alex");

        System.out.println(customer.hasAge());
        customer.setAge(18);
        System.out.println(customer.hasAge());
        System.out.println(customer.getAge());

        System.out.println(customer.hasIsVip());
        customer.setVip(true);
        System.out.println(customer.hasIsVip());
        System.out.println(customer.isVip());

        System.out.println(customer);
    }
}
