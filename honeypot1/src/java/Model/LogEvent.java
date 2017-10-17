package Model;

import java.text.SimpleDateFormat;

public class LogEvent {
//This class is only saved to database , this class is never selected from db
    String ip;
    String mac;
    String vendor;
    String action;
    String timeOfEvent;
    String requestString;
    SimpleDateFormat time_formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");

    public LogEvent(String ip, String mac, String vendor, String action,String requestString) {
        this.ip = ip;
        this.mac = mac;
        this.vendor = vendor;
        this.action = action;
        this.requestString = requestString;
        this.timeOfEvent = time_formatter.format(System.currentTimeMillis());
    }
    

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTimeOfEvent() {
        return timeOfEvent;
    }

    public void setTimeOfEvent(String timeOfEvent) {
        this.timeOfEvent = timeOfEvent;
    }

    public String getRequestString() {
        return requestString;
    }

    public void setRequestString(String requestString) {
        this.requestString = requestString;
    }

    @Override
    public String toString() {
        return "LogEvent{" + "ip=" + ip + ", mac=" + mac + ", vendor=" + vendor + ", action=" + action + ", timeOfEvent=" + timeOfEvent + ", requestString=" + requestString + ", time_formatter=" + time_formatter + '}';
    }

    
    
}
