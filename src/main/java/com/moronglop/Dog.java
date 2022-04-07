package com.moronglop;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Dog extends Animal{

    String name;
    @Override
    void bark() {
        System.out.println("go go ");
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Dog) {
            Dog dog = (Dog) o;
            if (dog.name.equals(name)) {
                return true;
            }
        }
        return false;
    }

}

class Meo extends Animal{

    @Override
    void bark() {
        System.out.println("meo meo");
    }
}
abstract class Animal{
    abstract void bark();


}
class MyAnimalList{

        static int fibonacci(int n) {
            if (n < 0)
                return -1;
            if (n == 0)
                return 4;
            if(n == 1)
                return 7;
            if(n == 2)
                return 5;
            return fibonacci(n - 1) + fibonacci(n - 2) + fibonacci(n-3);
        }

        static String chuanHoaHoTen(String s){
            // xóa khoảng trắng 2 đầu và chuyển về chữ thường
            s = s.toLowerCase().trim();
            /*
            *  \\s+ kí tự này là nhiều khoảng trắng
            * thay nhiều khoảng trắng = 1 khoảng trắng
            * */
            s = s.replaceAll("\\s+"," ");
            String[] temp = s.split(" ");
            // sau khi tách xong thì gán về chuỗi rỗng
            s = "";
            for (int i = 0; i < temp.length; i++) {
                s+= String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
                if(i < temp.length - 1){
                    s += " ";
                }
            }
            return s;
        }


        public static void main(String[] args) {
//            String s = "lE tUaN anh anh   ";
//            chuanHoaHoTen(s);
//            System.out.println(s);
            try {
                try {
                    System.out.println("Thuc hien phep chia");
                    int b = 39 / 0;
                } catch (ArithmeticException e) {
                    System.out.println(e);
                }

                try {
                    int a[] = new int[5];
                    a[5] = 4;
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(e);
                }

                int b = 39 / 0;
            } catch (Exception e) {
                System.out.println("xy ly ngoai le");
            }

            System.out.println("tiep tuc chuong trinh..");
        }

}
