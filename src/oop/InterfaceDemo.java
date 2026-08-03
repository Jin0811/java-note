package oop;

public class InterfaceDemo {
    public static void main(String[] args) {
        Payment alipay = new AlipayPayment();
        Payment wechat = new WechatPayment();

        alipay.pay(100);
        wechat.pay(200);
    }
}

interface Payment {
    void pay(double amount);
}

class AlipayPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Alipay paid " + amount);
    }
}

class WechatPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Wechat paid " + amount);
    }
}

