package com.big0soft.testdeploy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws SocketException {
//        String ipAddress = InetAddress.getLocalHost().getHostAddress();
//        String ipAddress2 = InetAddress.getLocalHost().getHostName();
//        String ipAddress3 = InetAddress.getLocalHost().getCanonicalHostName();
//
//        // Set the IP address as a system property
//        System.out.println("ipAddress: " + ipAddress);
//        System.out.println("ipAddress2: " + ipAddress2);
//        System.out.println("ipAddress3: " + ipAddress3);
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface networkInterface = networkInterfaces.nextElement();
            Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
            while (inetAddresses.hasMoreElements()) {
                InetAddress inetAddress = inetAddresses.nextElement();
                if (!inetAddress.isLoopbackAddress() && inetAddress.getHostAddress().contains(":")) {
                    // IPv6 address, skip
                    continue;
                }
                String ipAddress = inetAddress.getHostAddress();
//                System.out.println("IPv4 Address: " + ipAddress);
                System.setProperty("spring-boot-ip", ipAddress);
            }
        }
        String property = System.getProperty("spring-boot-ip");
        System.out.println("IPv4 Address: "+property);


        SpringApplication.run(Application.class, args);
    }

}
