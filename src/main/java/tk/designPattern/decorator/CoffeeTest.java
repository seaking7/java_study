package tk.designPattern.decorator;

import tk.designPattern.decorator.coffee.Coffee;
import tk.designPattern.decorator.coffee.EtiopiaCoffee;
import tk.designPattern.decorator.coffee.KeyaCoffee;
import tk.designPattern.decorator.coffee.deco.Latte;
import tk.designPattern.decorator.coffee.deco.MochaCoffee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class CoffeeTest {
    public static void main(String[] args) throws IOException {
        Coffee keyaCoffee = new KeyaCoffee();
        keyaCoffee.brewing();
        System.out.println("-----");

        Coffee keyaLattee = new Latte(keyaCoffee);
        keyaLattee.brewing();
        System.out.println("-----");

        Coffee mochaKeya = new MochaCoffee(new Latte(new KeyaCoffee()));
        mochaKeya.brewing();
        System.out.println("-----");

        Coffee etiopiaCoffee = new MochaCoffee(new Latte(new EtiopiaCoffee()));
        etiopiaCoffee.brewing();

        //Decorator 다른 예
        Socket socket = new Socket();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
    }
}
