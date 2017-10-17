package test;

import Logging.Utility;


public class runTest {
    public static void main(String[] args) {
        //String mac = Utility.getMac("192.168.1.44");
        String mac = Utility.getMac("192.168.1.1");
        
        String vendor = Utility.getVendorByMac(mac);
        System.out.println(mac);
        System.out.println(vendor);
    }
}
