import java.util.concurrent.atomic.AtomicLong;

import com.sun.btrace.annotations.*;
import static com.sun.btrace.BTraceUtils.*;

@BTrace
public class MonitorTokenValidationService {
	private final  static int PrintInterval_ms = 10000;

    // Print the log titles
    static{
        println("Print interval: 10000 (ms)");
		println("Time Stamp, Display Name, Execute Count, RunTime (ms), Execute per Second, Max runtime(ms), Min runtime(ms), Avarage runtime (ms)");
	}

    // Print Interval, to show the monitored count info
    @OnTimer(PrintInterval_ms)
    public static void PrintInterval(){
        // 1. Save the monitored info locally.
        // -----------------------------------------------
        // Get values for generateCode
        long countgenerateCode = getAndSet(totalExecuteCountgenerateCode, 0);
        long timesgenerateCode = getAndSet(totalExecuteTimesgenerateCode, 0);
        long maxTimesgenerateCode = getAndSet(maxExecuteTimesgenerateCode, 0);
        long minTimesgenerateCode = getAndSet(minExecuteTimesgenerateCode, 100000);
        
        // 1. Save the monitored info locally.
        // -----------------------------------------------
        // Get values for validateRequest
        long countvalidateRequest = getAndSet(totalExecuteCountvalidateRequest, 0);
        long timesvalidateRequest = getAndSet(totalExecuteTimesvalidateRequest, 0);
        long maxTimesvalidateRequest = getAndSet(maxExecuteTimesvalidateRequest, 0);
        long minTimesvalidateRequest = getAndSet(minExecuteTimesvalidateRequest, 100000);
        
        // 1. Save the monitored info locally.
        // -----------------------------------------------
        // Get values for validateRedirectUri
        long countvalidateRedirectUri = getAndSet(totalExecuteCountvalidateRedirectUri, 0);
        long timesvalidateRedirectUri = getAndSet(totalExecuteTimesvalidateRedirectUri, 0);
        long maxTimesvalidateRedirectUri = getAndSet(maxExecuteTimesvalidateRedirectUri, 0);
        long minTimesvalidateRedirectUri = getAndSet(minExecuteTimesvalidateRedirectUri, 100000);
        
        // 2. Display the monitored info
        // -----------------------------------------------
        // Display info for generateCode
        print(Time.timestamp("yy-MM-dd hh:mm:ss"));
        print(", ");
        print(displayNamegenerateCode);
        print(", ");
        print(Strings.str(countgenerateCode));
        print(", ");
        print(Strings.str(timesgenerateCode));
        print(", ");
        print(Strings.str(countgenerateCode*1000/PrintInterval_ms));
        print(", ");
        print(Strings.str(maxTimesgenerateCode));
        print(", ");
        print(Strings.str(minTimesgenerateCode));
        print(", ");
        if (countgenerateCode == 0)
            println("0");
        else
            println(Strings.str(timesgenerateCode/countgenerateCode));
        // 2. Display the monitored info
        // -----------------------------------------------
        // Display info for validateRequest
        print(Time.timestamp("yy-MM-dd hh:mm:ss"));
        print(", ");
        print(displayNamevalidateRequest);
        print(", ");
        print(Strings.str(countvalidateRequest));
        print(", ");
        print(Strings.str(timesvalidateRequest));
        print(", ");
        print(Strings.str(countvalidateRequest*1000/PrintInterval_ms));
        print(", ");
        print(Strings.str(maxTimesvalidateRequest));
        print(", ");
        print(Strings.str(minTimesvalidateRequest));
        print(", ");
        if (countvalidateRequest == 0)
            println("0");
        else
            println(Strings.str(timesvalidateRequest/countvalidateRequest));
        // 2. Display the monitored info
        // -----------------------------------------------
        // Display info for validateRedirectUri
        print(Time.timestamp("yy-MM-dd hh:mm:ss"));
        print(", ");
        print(displayNamevalidateRedirectUri);
        print(", ");
        print(Strings.str(countvalidateRedirectUri));
        print(", ");
        print(Strings.str(timesvalidateRedirectUri));
        print(", ");
        print(Strings.str(countvalidateRedirectUri*1000/PrintInterval_ms));
        print(", ");
        print(Strings.str(maxTimesvalidateRedirectUri));
        print(", ");
        print(Strings.str(minTimesvalidateRedirectUri));
        print(", ");
        if (countvalidateRedirectUri == 0)
            println("0");
        else
            println(Strings.str(timesvalidateRedirectUri/countvalidateRedirectUri));
    }

	// ================================================================
	// Trace Method for generateCode
	@TLS private   static long 		  starttimegenerateCode         = 0;
	@TLS private   static boolean 	  isStartedgenerateCode         = false;
	private        static AtomicLong  maxExecuteTimesgenerateCode   = newAtomicLong(0);;
	private        static AtomicLong  minExecuteTimesgenerateCode   = newAtomicLong(100000);;
	private        static AtomicLong  totalExecuteTimesgenerateCode = newAtomicLong(0);  
	private        static AtomicLong  totalExecuteCountgenerateCode = newAtomicLong(0);
	private        static String      displayNamegenerateCode       = "generateCode";
	private final  static String      clazzgenerateCode             = "com.ericsson.ngin.oauthserver.service.OAuthServerService";
	private final  static String      methodgenerateCode            = "generateCode";
	
	// 1. Trace the input
    @OnMethod(
            clazz=clazzgenerateCode,
            method=methodgenerateCode
        )
      public static void calledgenerateCode() {
    		starttimegenerateCode = timeNanos();	
    		isStartedgenerateCode  = true;
        }

    @OnMethod(
            clazz=clazzgenerateCode,
            method=methodgenerateCode,
            location=@Location(Kind.RETURN)
          )  
    public static void returnFromgenerateCode() {
    	if (isStartedgenerateCode){
    	    long executeTimesgenerateCode = (timeNanos()- starttimegenerateCode)/1000000;
    		addAndGet(totalExecuteTimesgenerateCode, executeTimesgenerateCode );
         	incrementAndGet(totalExecuteCountgenerateCode);
         	//add min max here
         	long currentMax = get(maxExecuteTimesgenerateCode);
         	if(executeTimesgenerateCode > currentMax){
         	   boolean updated = compareAndSet(maxExecuteTimesgenerateCode,currentMax,executeTimesgenerateCode);
         	   if(!updated){
         	      currentMax = get(maxExecuteTimesgenerateCode);
         	      if(executeTimesgenerateCode > currentMax){
         	         updated = compareAndSet(maxExecuteTimesgenerateCode,currentMax,executeTimesgenerateCode);
         	      }
         	   }
         	}
         	//
            long currentMin = get(minExecuteTimesgenerateCode);
            if(executeTimesgenerateCode < currentMin){
               boolean updated = compareAndSet(minExecuteTimesgenerateCode,currentMin,executeTimesgenerateCode);
               if(!updated){
                  currentMin = get(minExecuteTimesgenerateCode);
                  if(executeTimesgenerateCode < currentMin){
                     updated = compareAndSet(minExecuteTimesgenerateCode,currentMin,executeTimesgenerateCode);
                  }
               }
            }
    		isStartedgenerateCode = false;
    	}
    }
	// ----------------------------------------------------------------

	// ================================================================
	// Trace Method for validateRequest
	@TLS private   static long 		  starttimevalidateRequest         = 0;
	@TLS private   static boolean 	  isStartedvalidateRequest         = false;
	private        static AtomicLong  maxExecuteTimesvalidateRequest   = newAtomicLong(0);;
	private        static AtomicLong  minExecuteTimesvalidateRequest   = newAtomicLong(100000);;
	private        static AtomicLong  totalExecuteTimesvalidateRequest = newAtomicLong(0);  
	private        static AtomicLong  totalExecuteCountvalidateRequest = newAtomicLong(0);
	private        static String      displayNamevalidateRequest       = "validateRequest";
	private final  static String      clazzvalidateRequest             = "com.ericsson.ngin.oauthserver.service.OAuthServerService";
	private final  static String      methodvalidateRequest            = "validateRequest";
	
	// 1. Trace the input
    @OnMethod(
            clazz=clazzvalidateRequest,
            method=methodvalidateRequest
        )
      public static void calledvalidateRequest() {
    		starttimevalidateRequest = timeNanos();	
    		isStartedvalidateRequest  = true;
        }

    @OnMethod(
            clazz=clazzvalidateRequest,
            method=methodvalidateRequest,
            location=@Location(Kind.RETURN)
          )  
    public static void returnFromvalidateRequest() {
    	if (isStartedvalidateRequest){
    	    long executeTimesvalidateRequest = (timeNanos()- starttimevalidateRequest)/1000000;
    		addAndGet(totalExecuteTimesvalidateRequest, executeTimesvalidateRequest );
         	incrementAndGet(totalExecuteCountvalidateRequest);
         	//add min max here
         	long currentMax = get(maxExecuteTimesvalidateRequest);
         	if(executeTimesvalidateRequest > currentMax){
         	   boolean updated = compareAndSet(maxExecuteTimesvalidateRequest,currentMax,executeTimesvalidateRequest);
         	   if(!updated){
         	      currentMax = get(maxExecuteTimesvalidateRequest);
         	      if(executeTimesvalidateRequest > currentMax){
         	         updated = compareAndSet(maxExecuteTimesvalidateRequest,currentMax,executeTimesvalidateRequest);
         	      }
         	   }
         	}
         	//
            long currentMin = get(minExecuteTimesvalidateRequest);
            if(executeTimesvalidateRequest < currentMin){
               boolean updated = compareAndSet(minExecuteTimesvalidateRequest,currentMin,executeTimesvalidateRequest);
               if(!updated){
                  currentMin = get(minExecuteTimesvalidateRequest);
                  if(executeTimesvalidateRequest < currentMin){
                     updated = compareAndSet(minExecuteTimesvalidateRequest,currentMin,executeTimesvalidateRequest);
                  }
               }
            }
    		isStartedvalidateRequest = false;
    	}
    }
	// ----------------------------------------------------------------

	// ================================================================
	// Trace Method for validateRedirectUri
	@TLS private   static long 		  starttimevalidateRedirectUri         = 0;
	@TLS private   static boolean 	  isStartedvalidateRedirectUri         = false;
	private        static AtomicLong  maxExecuteTimesvalidateRedirectUri   = newAtomicLong(0);;
	private        static AtomicLong  minExecuteTimesvalidateRedirectUri   = newAtomicLong(100000);;
	private        static AtomicLong  totalExecuteTimesvalidateRedirectUri = newAtomicLong(0);  
	private        static AtomicLong  totalExecuteCountvalidateRedirectUri = newAtomicLong(0);
	private        static String      displayNamevalidateRedirectUri       = "validateRedirectUri";
	private final  static String      clazzvalidateRedirectUri             = "com.ericsson.ngin.oauthserver.service.OAuthServerService";
	private final  static String      methodvalidateRedirectUri            = "validateRedirectUri";
	
	// 1. Trace the input
    @OnMethod(
            clazz=clazzvalidateRedirectUri,
            method=methodvalidateRedirectUri
        )
      public static void calledvalidateRedirectUri() {
    		starttimevalidateRedirectUri = timeNanos();	
    		isStartedvalidateRedirectUri  = true;
        }

    @OnMethod(
            clazz=clazzvalidateRedirectUri,
            method=methodvalidateRedirectUri,
            location=@Location(Kind.RETURN)
          )  
    public static void returnFromvalidateRedirectUri() {
    	if (isStartedvalidateRedirectUri){
    	    long executeTimesvalidateRedirectUri = (timeNanos()- starttimevalidateRedirectUri)/1000000;
    		addAndGet(totalExecuteTimesvalidateRedirectUri, executeTimesvalidateRedirectUri );
         	incrementAndGet(totalExecuteCountvalidateRedirectUri);
         	//add min max here
         	long currentMax = get(maxExecuteTimesvalidateRedirectUri);
         	if(executeTimesvalidateRedirectUri > currentMax){
         	   boolean updated = compareAndSet(maxExecuteTimesvalidateRedirectUri,currentMax,executeTimesvalidateRedirectUri);
         	   if(!updated){
         	      currentMax = get(maxExecuteTimesvalidateRedirectUri);
         	      if(executeTimesvalidateRedirectUri > currentMax){
         	         updated = compareAndSet(maxExecuteTimesvalidateRedirectUri,currentMax,executeTimesvalidateRedirectUri);
         	      }
         	   }
         	}
         	//
            long currentMin = get(minExecuteTimesvalidateRedirectUri);
            if(executeTimesvalidateRedirectUri < currentMin){
               boolean updated = compareAndSet(minExecuteTimesvalidateRedirectUri,currentMin,executeTimesvalidateRedirectUri);
               if(!updated){
                  currentMin = get(minExecuteTimesvalidateRedirectUri);
                  if(executeTimesvalidateRedirectUri < currentMin){
                     updated = compareAndSet(minExecuteTimesvalidateRedirectUri,currentMin,executeTimesvalidateRedirectUri);
                  }
               }
            }
    		isStartedvalidateRedirectUri = false;
    	}
    }
	// ----------------------------------------------------------------
}
