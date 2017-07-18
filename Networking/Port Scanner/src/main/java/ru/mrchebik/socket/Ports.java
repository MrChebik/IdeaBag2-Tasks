package ru.mrchebik.socket;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by mrchebik on 7/18/17.
 */
public class Ports {
    public String checkConnect(String ip, int port) throws IOException {
        try {
            new Socket(InetAddress.getByName(ip), port);
        } catch (ConnectException ignored) {
            return "";
        }

        return "SUCCESS: " + port + "\n";
    }

    public String tryConnect(String ip) throws IOException {
        return doAround(ip, 0, 65535);
    }

    public String tryConnect(String ip, int port) throws IOException {
        return doAround(ip, port, port + 1);
    }

    public String tryConnect(String ip, int portStart, int portEnd) throws IOException {
        return doAround(ip, portStart, portEnd);
    }

    private String doAround(String ip, int portStart, int portEnd) throws IOException {
        StringBuilder output = new StringBuilder();
        for (int port = portStart; port < portEnd; port++) {
            output.append(checkConnect(ip, port));
        }

        if ("".equals(output.toString())) {
            return "Not found open ports.";
        }

        return output.toString();
    }
}
