package ru.mrchebik;

import ru.mrchebik.socket.Ports;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by mrchebik on 7/18/17.
 */
public class Main {
    private static Ports  ports;

    public static void main(String[] args) throws IOException {
        ports = new Ports();

        System.out.println("Input:");
        String[] input = new Scanner(System.in).nextLine().trim().split(" ");
        String ipAddress = input[0];

        System.out.println("\nOutput:");
        if (input.length == 1) {
            System.out.println(ports.tryConnect(ipAddress));
        } else if (input[1].indexOf('-') == -1) {
            System.out.println(ports.tryConnect(ipAddress, Integer.parseInt(input[1])));
        } else {
            int deliver = input[1].indexOf('-');
            int start = Integer.parseInt(input[1].substring(0, deliver));
            int end = Integer.parseInt(input[1].substring(deliver + 1, input[1].length()));

            System.out.println(ports.tryConnect(ipAddress, start, end));
        }
    }
}
