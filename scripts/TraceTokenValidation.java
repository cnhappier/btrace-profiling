import java.util.concurrent.atomic.AtomicLong;

import com.sun.btrace.AnyType;
import com.sun.btrace.annotations.*;
import static com.sun.btrace.BTraceUtils.*;

@BTrace
public class TraceTokenValidation {

	// ================================================================
	// Trace Method for OAuth Token validate
	@TLS private   static long 		  starttimeOAuthTokenvalidate         = 0;
	@TLS private   static boolean 	  isStartedOAuthTokenvalidate         = false;
	private        static String      displayNameOAuthTokenvalidate       = "OAuth Token validate";
	private final  static String      clazzOAuthTokenvalidate             = "com.ericsson.ngin.oauthserver.service.TokenValidationService";
	private final  static String      methodOAuthTokenvalidate            = "validate";
	
	// 1. Trace the input
    @OnMethod(
            clazz=clazzOAuthTokenvalidate,
            method=methodOAuthTokenvalidate
        )
      public static void calledOAuthTokenvalidate(AnyType[] args) {
    		starttimeOAuthTokenvalidate = timeNanos();	
    		isStartedOAuthTokenvalidate  = true;
    		print(Strings.strcat(Time.timestamp("yy-MM-dd hh:mm:ss"), ": "));
    	    println(Strings.strcat(displayNameOAuthTokenvalidate, " called, parms are: "));
    	    printArray(args);
    	    println("");
    }

    @OnMethod(
            clazz=clazzOAuthTokenvalidate,
            method=methodOAuthTokenvalidate,
            location=@Location(Kind.RETURN)
          )  
    public static void returnFromOAuthTokenvalidate(@Return String cl) {
    	if (isStartedOAuthTokenvalidate){
    		long secs = (timeNanos()- starttimeOAuthTokenvalidate)/1000000;
    		isStartedOAuthTokenvalidate = false;
    		print(Strings.strcat(Time.timestamp("yy-MM-dd hh:mm:ss"), ": "));
    		println(Strings.strcat(displayNameOAuthTokenvalidate, " returns: "));
    		println(cl);
            Threads.jstack();
    		println(Strings.strcat("Execute Time (Nanos):", str(secs)) );
        	println("");
    	}
    }
	// ----------------------------------------------------------------

	// ================================================================
	// Trace Method for OAuth Get Authorization Info
	@TLS private   static long 		  starttimeOAuthGetAuthorizationInfo         = 0;
	@TLS private   static boolean 	  isStartedOAuthGetAuthorizationInfo         = false;
	private        static String      displayNameOAuthGetAuthorizationInfo       = "OAuth Get Authorization Info";
	private final  static String      clazzOAuthGetAuthorizationInfo             = "com.ericsson.ngin.oauthserver.service.TokenValidationService";
	private final  static String      methodOAuthGetAuthorizationInfo            = "getAuthorizationInfo";
	
	// 1. Trace the input
    @OnMethod(
            clazz=clazzOAuthGetAuthorizationInfo,
            method=methodOAuthGetAuthorizationInfo
        )
      public static void calledOAuthGetAuthorizationInfo(AnyType[] args) {
    		starttimeOAuthGetAuthorizationInfo = timeNanos();	
    		isStartedOAuthGetAuthorizationInfo  = true;
    		print(Strings.strcat(Time.timestamp("yy-MM-dd hh:mm:ss"), ": "));
    	    println(Strings.strcat(displayNameOAuthGetAuthorizationInfo, " called, parms are: "));
    	    printArray(args);
    	    println("");
    }

    @OnMethod(
            clazz=clazzOAuthGetAuthorizationInfo,
            method=methodOAuthGetAuthorizationInfo,
            location=@Location(Kind.RETURN)
          )  
    public static void returnFromOAuthGetAuthorizationInfo(@Return String cl) {
    	if (isStartedOAuthGetAuthorizationInfo){
    		long secs = (timeNanos()- starttimeOAuthGetAuthorizationInfo)/1000000;
    		isStartedOAuthGetAuthorizationInfo = false;
    		print(Strings.strcat(Time.timestamp("yy-MM-dd hh:mm:ss"), ": "));
    		println(Strings.strcat(displayNameOAuthGetAuthorizationInfo, " returns: "));
    		println(cl);
            Threads.jstack();
    		println(Strings.strcat("Execute Time (Nanos):", str(secs)) );
        	println("");
    	}
    }
	// ----------------------------------------------------------------
}
