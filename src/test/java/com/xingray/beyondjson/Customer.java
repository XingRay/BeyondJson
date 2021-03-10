package com.xingray.beyondjson;

public class Customer {
    private static final int FLAG_AGE_MARK = 1;
    private static final int FLAG_IS_VIP_MARK = 2;

    private int flag;
    private String name;
    private int age;
    private boolean isVip;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean hasAge() {
        return (flag & FLAG_AGE_MARK) != 0;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        flag |= FLAG_AGE_MARK;
    }

    public boolean hasIsVip() {
        return (flag & FLAG_IS_VIP_MARK) != 0;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
        flag |= FLAG_IS_VIP_MARK;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "flag=" + flag +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", isVip=" + isVip +
                '}';
    }
}
