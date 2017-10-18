package Logging;

import Database.Repositories;
import static Logging.Utility.getMac;
import static Logging.Utility.getVendorByMac;
import Model.LogEvent;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

public class Logger {

    public static final String SQLI_ATTEMPT = "Tried to SQL inject";
    public static final String XSS_ATTEMPT = "Tried to XSS";

    public static void logSqli(ServletRequest Prequest) {
        log(Prequest, SQLI_ATTEMPT);
    }

    public static void logXss(ServletRequest Prequest) {
        log(Prequest, XSS_ATTEMPT);
    }

    public static void log(ServletRequest Prequest, String reason) {
        String ip = Prequest.getRemoteAddr();
        String mac = getMac(ip);
        String vendor = getVendorByMac(mac);
        HttpServletRequest request = (HttpServletRequest) Prequest;
        String uri = request.getScheme() + "://"
                + // "http" + "://
                request.getServerName()
                + // "myhost"
                ":"
                + // ":"
                request.getServerPort()
                + // "8080"
                request.getRequestURI()
                + // "/people"
                "?"
                + // "?"
                request.getQueryString();

        LogEvent logEvent = new LogEvent(ip, mac, vendor, reason, uri);
        System.out.println(logEvent.toString());
        Repositories.getLogEventRepository().insertLogEntry(logEvent);
    }
}
