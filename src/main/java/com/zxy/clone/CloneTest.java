package com.zxy.clone;

import org.junit.Test;

import java.io.IOException;

public class CloneTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Order order = new Order();
        order.setId(1);
        order.setName("zxy");
        order.setDesc("111111");
        System.out.println(order.toString());
        Order clone = CloneUtil.clone(order);
        clone.setDesc("222");
        System.out.println(clone.toString());
        System.out.println(order.toString());
    }

    @Test
    public void testClone() throws CloneNotSupportedException {
        Order2 order2 = new Order2();
        order2.setId(1);
        order2.setName("zxy");
        order2.setDesc("111111");
        Order order = new Order();
        order.setId(2);
        order2.setOrder(order);
        System.out.println(order2.toString());
        Order2 clone = (Order2) order2.clone();
        clone.setDesc("222");
        clone.getOrder().setId(111);
        System.out.println(clone.toString());
        System.out.println(order2.toString());
    }

    @Test
    public void testFinally() {
        System.out.println(getInt1());
        System.out.println(getInt2());
        System.out.println(getInt3());
    }

    public static int getInt1() {
        int a = 10;
        try {
            System.out.println(a / 0);
            a = 20;
        } catch (ArithmeticException e) {
            a = 30;
            return a;
            /*
             * return a 在程序执行到这一步的时候，这里不是return a 而是 return 30；这个返回路径就形成了
             * 但是呢，它发现后面还有finally，所以继续执行finally的内容，a=40
             * 再次回到以前的路径,继续走return 30，形成返回路径之后，这里的a就不是a变量了，而是常量30
             */
        } finally {
            a = 40;
            return a; //如果这样，就又重新形成了一条返回路径，由于只能通过1个return返回，所以这里直接返回40
        }

//      return a;
    }

    public static int getInt2() {
        int a = 10;
        try {
            a = 20;
            return a;
        } catch (ArithmeticException e) {
            a = 30;
            return a;
            /*
             * return a 在程序执行到这一步的时候，这里不是return a 而是 return 30；这个返回路径就形成了
             * 但是呢，它发现后面还有finally，所以继续执行finally的内容，a=40
             * 再次回到以前的路径,继续走return 30，形成返回路径之后，这里的a就不是a变量了，而是常量30
             */
        } finally {
            a = 40;
            return a; //如果这样，就又重新形成了一条返回路径，由于只能通过1个return返回，所以这里直接返回40
        }

//      return a;
    }

    public static int getInt3() {
        int a = 10;
        try {
            System.out.println(a / 0);
            a = 20;
            return a;
        } catch (ArithmeticException e) {
            a = 30;
            return a;
            /*
             * return a 在程序执行到这一步的时候，这里不是return a 而是 return 30；这个返回路径就形成了
             * 但是呢，它发现后面还有finally，所以继续执行finally的内容，a=40
             * 再次回到以前的路径,继续走return 30，形成返回路径之后，这里的a就不是a变量了，而是常量30
             */
        } finally {
            a = 40;
            return a; //如果这样，就又重新形成了一条返回路径，由于只能通过1个return返回，所以这里直接返回40
        }

//      return a;
    }
}
