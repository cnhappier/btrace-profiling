import java.util.concurrent.atomic.AtomicLong;

import com.sun.btrace.annotations.*;
import static com.sun.btrace.BTraceUtils.*;

@BTrace
public class MonitorGenerateCode {
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
        
        // 1. Save the monitored info locally.
        // -----------------------------------------------
        // Get values for validate in manager
        long countvalidateinmanager = getAndSet(totalExecuteCountvalidateinmanager, 0);
        long timesvalidateinmanager = getAndSet(totalExecuteTimesvalidateinmanager, 0);
        long maxTimesvalidateinmanager = getAndSet(maxExecuteTimesvalidateinmanager, 0);
        long minTimesvalidateinmanager = getAndSet(minExecuteTimesvalidateinmanager, 100000);
        
        // 1. Save the monitored info locally.
        // -----------------------------------------------
        // Get values for validateScope in manager
        long countvalidateScopeinmanager = getAndSet(totalExecuteCountvalidateScopeinmanager, 0);
        long timesvalidateScopeinmanager = getAndSet(totalExecuteTimesvalidateScopeinmanager, 0);
        long maxTimesvalidateScopeinmanager = getAndSet(maxExecuteTimesvalidateScopeinmanager, 0);
        long minTimesvalidateScopeinmanager = getAndSet(minExecuteTimesvalidateScopeinmanager, 100000);
        
        // 1. Save the monitored info locally.
        // -----------------------------------------------
        // Get values for getScopes in store
        long countgetScopesinstore = getAndSet(totalExecuteCountgetScopesinstore, 0);
        long timesgetScopesinstore = getAndSet(totalExecuteTimesgetScopesinstore, 0);
        long maxTimesgetScopesinstore = getAndSet(maxExecuteTimesgetScopesinstore, 0);
        long minTimesgetScopesinstore = getAndSet(minExecuteTimesgetScopesinstore, 100000);
        
        // 1. Save the monitored info locally.
        // -----------------------------------------------
        // Get values for validateScopeDuplicate in manager
        long countvalidateScopeDuplicateinmanager = getAndSet(totalExecuteCountvalidateScopeDuplicateinmanager, 0);
        long timesvalidateScopeDuplicateinmanager = getAndSet(totalExecuteTimesvalidateScopeDuplicateinmanager, 0);
        long maxTimesvalidateScopeDuplicateinmanager = getAndSet(maxExecuteTimesvalidateScopeDuplicateinmanager, 0);
        long minTimesvalidateScopeDuplicateinmanager = getAndSet(minExecuteTimesvalidateScopeDuplicateinmanager, 100000);
        
        // 1. Save the monitored info locally.
        // -----------------------------------------------
        // Get values for validateScopeInvalid in manager
        long countvalidateScopeInvalidinmanager = getAndSet(totalExecuteCountvalidateScopeInvalidinmanager, 0);
        long timesvalidateScopeInvalidinmanager = getAndSet(totalExecuteTimesvalidateScopeInvalidinmanager, 0);
        long maxTimesvalidateScopeInvalidinmanager = getAndSet(maxExecuteTimesvalidateScopeInvalidinmanager, 0);
        long minTimesvalidateScopeInvalidinmanager = getAndSet(minExecuteTimesvalidateScopeInvalidinmanager, 100000);
        
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
        // 2. Display the monitored info
        // -----------------------------------------------
        // Display info for validate in manager
        print(Time.timestamp("yy-MM-dd hh:mm:ss"));
        print(", ");
        print(displayNamevalidateinmanager);
        print(", ");
        print(Strings.str(countvalidateinmanager));
        print(", ");
        print(Strings.str(timesvalidateinmanager));
        print(", ");
        print(Strings.str(countvalidateinmanager*1000/PrintInterval_ms));
        print(", ");
        print(Strings.str(maxTimesvalidateinmanager));
        print(", ");
        print(Strings.str(minTimesvalidateinmanager));
        print(", ");
        if (countvalidateinmanager == 0)
            println("0");
        else
            println(Strings.str(timesvalidateinmanager/countvalidateinmanager));
        // 2. Display the monitored info
        // -----------------------------------------------
        // Display info for validateScope in manager
        print(Time.timestamp("yy-MM-dd hh:mm:ss"));
        print(", ");
        print(displayNamevalidateScopeinmanager);
        print(", ");
        print(Strings.str(countvalidateScopeinmanager));
        print(", ");
        print(Strings.str(timesvalidateScopeinmanager));
        print(", ");
        print(Strings.str(countvalidateScopeinmanager*1000/PrintInterval_ms));
        print(", ");
        print(Strings.str(maxTimesvalidateScopeinmanager));
        print(", ");
        print(Strings.str(minTimesvalidateScopeinmanager));
        print(", ");
        if (countvalidateScopeinmanager == 0)
            println("0");
        else
            println(Strings.str(timesvalidateScopeinmanager/countvalidateScopeinmanager));
        // 2. Display the monitored info
        // -----------------------------------------------
        // Display info for getScopes in store
        print(Time.timestamp("yy-MM-dd hh:mm:ss"));
        print(", ");
        print(displayNamegetScopesinstore);
        print(", ");
        print(Strings.str(countgetScopesinstore));
        print(", ");
        print(Strings.str(timesgetScopesinstore));
        print(", ");
        print(Strings.str(countgetScopesinstore*1000/PrintInterval_ms));
        print(", ");
        print(Strings.str(maxTimesgetScopesinstore));
        print(", ");
        print(Strings.str(minTimesgetScopesinstore));
        print(", ");
        if (countgetScopesinstore == 0)
            println("0");
        else
            println(Strings.str(timesgetScopesinstore/countgetScopesinstore));
        // 2. Display the monitored info
        // -----------------------------------------------
        // Display info for validateScopeDuplicate in manager
        print(Time.timestamp("yy-MM-dd hh:mm:ss"));
        print(", ");
        print(displayNamevalidateScopeDuplicateinmanager);
        print(", ");
        print(Strings.str(countvalidateScopeDuplicateinmanager));
        print(", ");
        print(Strings.str(timesvalidateScopeDuplicateinmanager));
        print(", ");
        print(Strings.str(countvalidateScopeDuplicateinmanager*1000/PrintInterval_ms));
        print(", ");
        print(Strings.str(maxTimesvalidateScopeDuplicateinmanager));
        print(", ");
        print(Strings.str(minTimesvalidateScopeDuplicateinmanager));
        print(", ");
        if (countvalidateScopeDuplicateinmanager == 0)
            println("0");
        else
            println(Strings.str(timesvalidateScopeDuplicateinmanager/countvalidateScopeDuplicateinmanager));
        // 2. Display the monitored info
        // -----------------------------------------------
        // Display info for validateScopeInvalid in manager
        print(Time.timestamp("yy-MM-dd hh:mm:ss"));
        print(", ");
        print(displayNamevalidateScopeInvalidinmanager);
        print(", ");
        print(Strings.str(countvalidateScopeInvalidinmanager));
        print(", ");
        print(Strings.str(timesvalidateScopeInvalidinmanager));
        print(", ");
        print(Strings.str(countvalidateScopeInvalidinmanager*1000/PrintInterval_ms));
        print(", ");
        print(Strings.str(maxTimesvalidateScopeInvalidinmanager));
        print(", ");
        print(Strings.str(minTimesvalidateScopeInvalidinmanager));
        print(", ");
        if (countvalidateScopeInvalidinmanager == 0)
            println("0");
        else
            println(Strings.str(timesvalidateScopeInvalidinmanager/countvalidateScopeInvalidinmanager));
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

	// ================================================================
	// Trace Method for validate in manager
	@TLS private   static long 		  starttimevalidateinmanager         = 0;
	@TLS private   static boolean 	  isStartedvalidateinmanager         = false;
	private        static AtomicLong  maxExecuteTimesvalidateinmanager   = newAtomicLong(0);;
	private        static AtomicLong  minExecuteTimesvalidateinmanager   = newAtomicLong(100000);;
	private        static AtomicLong  totalExecuteTimesvalidateinmanager = newAtomicLong(0);  
	private        static AtomicLong  totalExecuteCountvalidateinmanager = newAtomicLong(0);
	private        static String      displayNamevalidateinmanager       = "validate in manager";
	private final  static String      clazzvalidateinmanager             = "com.ericsson.ngin.oauthserver.business.AuthorizationManager";
	private final  static String      methodvalidateinmanager            = "validate";
	
	// 1. Trace the input
    @OnMethod(
            clazz=clazzvalidateinmanager,
            method=methodvalidateinmanager
        )
      public static void calledvalidateinmanager() {
    		starttimevalidateinmanager = timeNanos();	
    		isStartedvalidateinmanager  = true;
        }

    @OnMethod(
            clazz=clazzvalidateinmanager,
            method=methodvalidateinmanager,
            location=@Location(Kind.RETURN)
          )  
    public static void returnFromvalidateinmanager() {
    	if (isStartedvalidateinmanager){
    	    long executeTimesvalidateinmanager = (timeNanos()- starttimevalidateinmanager)/1000000;
    		addAndGet(totalExecuteTimesvalidateinmanager, executeTimesvalidateinmanager );
         	incrementAndGet(totalExecuteCountvalidateinmanager);
         	//add min max here
         	long currentMax = get(maxExecuteTimesvalidateinmanager);
         	if(executeTimesvalidateinmanager > currentMax){
         	   boolean updated = compareAndSet(maxExecuteTimesvalidateinmanager,currentMax,executeTimesvalidateinmanager);
         	   if(!updated){
         	      currentMax = get(maxExecuteTimesvalidateinmanager);
         	      if(executeTimesvalidateinmanager > currentMax){
         	         updated = compareAndSet(maxExecuteTimesvalidateinmanager,currentMax,executeTimesvalidateinmanager);
         	      }
         	   }
         	}
         	//
            long currentMin = get(minExecuteTimesvalidateinmanager);
            if(executeTimesvalidateinmanager < currentMin){
               boolean updated = compareAndSet(minExecuteTimesvalidateinmanager,currentMin,executeTimesvalidateinmanager);
               if(!updated){
                  currentMin = get(minExecuteTimesvalidateinmanager);
                  if(executeTimesvalidateinmanager < currentMin){
                     updated = compareAndSet(minExecuteTimesvalidateinmanager,currentMin,executeTimesvalidateinmanager);
                  }
               }
            }
    		isStartedvalidateinmanager = false;
    	}
    }
	// ----------------------------------------------------------------

	// ================================================================
	// Trace Method for validateScope in manager
	@TLS private   static long 		  starttimevalidateScopeinmanager         = 0;
	@TLS private   static boolean 	  isStartedvalidateScopeinmanager         = false;
	private        static AtomicLong  maxExecuteTimesvalidateScopeinmanager   = newAtomicLong(0);;
	private        static AtomicLong  minExecuteTimesvalidateScopeinmanager   = newAtomicLong(100000);;
	private        static AtomicLong  totalExecuteTimesvalidateScopeinmanager = newAtomicLong(0);  
	private        static AtomicLong  totalExecuteCountvalidateScopeinmanager = newAtomicLong(0);
	private        static String      displayNamevalidateScopeinmanager       = "validateScope in manager";
	private final  static String      clazzvalidateScopeinmanager             = "com.ericsson.ngin.oauthserver.business.AuthorizationManager";
	private final  static String      methodvalidateScopeinmanager            = "validateScope";
	
	// 1. Trace the input
    @OnMethod(
            clazz=clazzvalidateScopeinmanager,
            method=methodvalidateScopeinmanager
        )
      public static void calledvalidateScopeinmanager() {
    		starttimevalidateScopeinmanager = timeNanos();	
    		isStartedvalidateScopeinmanager  = true;
        }

    @OnMethod(
            clazz=clazzvalidateScopeinmanager,
            method=methodvalidateScopeinmanager,
            location=@Location(Kind.RETURN)
          )  
    public static void returnFromvalidateScopeinmanager() {
    	if (isStartedvalidateScopeinmanager){
    	    long executeTimesvalidateScopeinmanager = (timeNanos()- starttimevalidateScopeinmanager)/1000000;
    		addAndGet(totalExecuteTimesvalidateScopeinmanager, executeTimesvalidateScopeinmanager );
         	incrementAndGet(totalExecuteCountvalidateScopeinmanager);
         	//add min max here
         	long currentMax = get(maxExecuteTimesvalidateScopeinmanager);
         	if(executeTimesvalidateScopeinmanager > currentMax){
         	   boolean updated = compareAndSet(maxExecuteTimesvalidateScopeinmanager,currentMax,executeTimesvalidateScopeinmanager);
         	   if(!updated){
         	      currentMax = get(maxExecuteTimesvalidateScopeinmanager);
         	      if(executeTimesvalidateScopeinmanager > currentMax){
         	         updated = compareAndSet(maxExecuteTimesvalidateScopeinmanager,currentMax,executeTimesvalidateScopeinmanager);
         	      }
         	   }
         	}
         	//
            long currentMin = get(minExecuteTimesvalidateScopeinmanager);
            if(executeTimesvalidateScopeinmanager < currentMin){
               boolean updated = compareAndSet(minExecuteTimesvalidateScopeinmanager,currentMin,executeTimesvalidateScopeinmanager);
               if(!updated){
                  currentMin = get(minExecuteTimesvalidateScopeinmanager);
                  if(executeTimesvalidateScopeinmanager < currentMin){
                     updated = compareAndSet(minExecuteTimesvalidateScopeinmanager,currentMin,executeTimesvalidateScopeinmanager);
                  }
               }
            }
    		isStartedvalidateScopeinmanager = false;
    	}
    }
	// ----------------------------------------------------------------

	// ================================================================
	// Trace Method for getScopes in store
	@TLS private   static long 		  starttimegetScopesinstore         = 0;
	@TLS private   static boolean 	  isStartedgetScopesinstore         = false;
	private        static AtomicLong  maxExecuteTimesgetScopesinstore   = newAtomicLong(0);;
	private        static AtomicLong  minExecuteTimesgetScopesinstore   = newAtomicLong(100000);;
	private        static AtomicLong  totalExecuteTimesgetScopesinstore = newAtomicLong(0);  
	private        static AtomicLong  totalExecuteCountgetScopesinstore = newAtomicLong(0);
	private        static String      displayNamegetScopesinstore       = "getScopes in store";
	private final  static String      clazzgetScopesinstore             = "com.ericsson.ngin.oauthserver.store.impl.ScopeStoreJpaImpl";
	private final  static String      methodgetScopesinstore            = "getScopes";
	
	// 1. Trace the input
    @OnMethod(
            clazz=clazzgetScopesinstore,
            method=methodgetScopesinstore
        )
      public static void calledgetScopesinstore() {
    		starttimegetScopesinstore = timeNanos();	
    		isStartedgetScopesinstore  = true;
        }

    @OnMethod(
            clazz=clazzgetScopesinstore,
            method=methodgetScopesinstore,
            location=@Location(Kind.RETURN)
          )  
    public static void returnFromgetScopesinstore() {
    	if (isStartedgetScopesinstore){
    	    long executeTimesgetScopesinstore = (timeNanos()- starttimegetScopesinstore)/1000000;
    		addAndGet(totalExecuteTimesgetScopesinstore, executeTimesgetScopesinstore );
         	incrementAndGet(totalExecuteCountgetScopesinstore);
         	//add min max here
         	long currentMax = get(maxExecuteTimesgetScopesinstore);
         	if(executeTimesgetScopesinstore > currentMax){
         	   boolean updated = compareAndSet(maxExecuteTimesgetScopesinstore,currentMax,executeTimesgetScopesinstore);
         	   if(!updated){
         	      currentMax = get(maxExecuteTimesgetScopesinstore);
         	      if(executeTimesgetScopesinstore > currentMax){
         	         updated = compareAndSet(maxExecuteTimesgetScopesinstore,currentMax,executeTimesgetScopesinstore);
         	      }
         	   }
         	}
         	//
            long currentMin = get(minExecuteTimesgetScopesinstore);
            if(executeTimesgetScopesinstore < currentMin){
               boolean updated = compareAndSet(minExecuteTimesgetScopesinstore,currentMin,executeTimesgetScopesinstore);
               if(!updated){
                  currentMin = get(minExecuteTimesgetScopesinstore);
                  if(executeTimesgetScopesinstore < currentMin){
                     updated = compareAndSet(minExecuteTimesgetScopesinstore,currentMin,executeTimesgetScopesinstore);
                  }
               }
            }
    		isStartedgetScopesinstore = false;
    	}
    }
	// ----------------------------------------------------------------

	// ================================================================
	// Trace Method for validateScopeDuplicate in manager
	@TLS private   static long 		  starttimevalidateScopeDuplicateinmanager         = 0;
	@TLS private   static boolean 	  isStartedvalidateScopeDuplicateinmanager         = false;
	private        static AtomicLong  maxExecuteTimesvalidateScopeDuplicateinmanager   = newAtomicLong(0);;
	private        static AtomicLong  minExecuteTimesvalidateScopeDuplicateinmanager   = newAtomicLong(100000);;
	private        static AtomicLong  totalExecuteTimesvalidateScopeDuplicateinmanager = newAtomicLong(0);  
	private        static AtomicLong  totalExecuteCountvalidateScopeDuplicateinmanager = newAtomicLong(0);
	private        static String      displayNamevalidateScopeDuplicateinmanager       = "validateScopeDuplicate in manager";
	private final  static String      clazzvalidateScopeDuplicateinmanager             = "com.ericsson.ngin.oauthserver.business.AuthorizationManager";
	private final  static String      methodvalidateScopeDuplicateinmanager            = "validateScopeDuplicate";
	
	// 1. Trace the input
    @OnMethod(
            clazz=clazzvalidateScopeDuplicateinmanager,
            method=methodvalidateScopeDuplicateinmanager
        )
      public static void calledvalidateScopeDuplicateinmanager() {
    		starttimevalidateScopeDuplicateinmanager = timeNanos();	
    		isStartedvalidateScopeDuplicateinmanager  = true;
        }

    @OnMethod(
            clazz=clazzvalidateScopeDuplicateinmanager,
            method=methodvalidateScopeDuplicateinmanager,
            location=@Location(Kind.RETURN)
          )  
    public static void returnFromvalidateScopeDuplicateinmanager() {
    	if (isStartedvalidateScopeDuplicateinmanager){
    	    long executeTimesvalidateScopeDuplicateinmanager = (timeNanos()- starttimevalidateScopeDuplicateinmanager)/1000000;
    		addAndGet(totalExecuteTimesvalidateScopeDuplicateinmanager, executeTimesvalidateScopeDuplicateinmanager );
         	incrementAndGet(totalExecuteCountvalidateScopeDuplicateinmanager);
         	//add min max here
         	long currentMax = get(maxExecuteTimesvalidateScopeDuplicateinmanager);
         	if(executeTimesvalidateScopeDuplicateinmanager > currentMax){
         	   boolean updated = compareAndSet(maxExecuteTimesvalidateScopeDuplicateinmanager,currentMax,executeTimesvalidateScopeDuplicateinmanager);
         	   if(!updated){
         	      currentMax = get(maxExecuteTimesvalidateScopeDuplicateinmanager);
         	      if(executeTimesvalidateScopeDuplicateinmanager > currentMax){
         	         updated = compareAndSet(maxExecuteTimesvalidateScopeDuplicateinmanager,currentMax,executeTimesvalidateScopeDuplicateinmanager);
         	      }
         	   }
         	}
         	//
            long currentMin = get(minExecuteTimesvalidateScopeDuplicateinmanager);
            if(executeTimesvalidateScopeDuplicateinmanager < currentMin){
               boolean updated = compareAndSet(minExecuteTimesvalidateScopeDuplicateinmanager,currentMin,executeTimesvalidateScopeDuplicateinmanager);
               if(!updated){
                  currentMin = get(minExecuteTimesvalidateScopeDuplicateinmanager);
                  if(executeTimesvalidateScopeDuplicateinmanager < currentMin){
                     updated = compareAndSet(minExecuteTimesvalidateScopeDuplicateinmanager,currentMin,executeTimesvalidateScopeDuplicateinmanager);
                  }
               }
            }
    		isStartedvalidateScopeDuplicateinmanager = false;
    	}
    }
	// ----------------------------------------------------------------

	// ================================================================
	// Trace Method for validateScopeInvalid in manager
	@TLS private   static long 		  starttimevalidateScopeInvalidinmanager         = 0;
	@TLS private   static boolean 	  isStartedvalidateScopeInvalidinmanager         = false;
	private        static AtomicLong  maxExecuteTimesvalidateScopeInvalidinmanager   = newAtomicLong(0);;
	private        static AtomicLong  minExecuteTimesvalidateScopeInvalidinmanager   = newAtomicLong(100000);;
	private        static AtomicLong  totalExecuteTimesvalidateScopeInvalidinmanager = newAtomicLong(0);  
	private        static AtomicLong  totalExecuteCountvalidateScopeInvalidinmanager = newAtomicLong(0);
	private        static String      displayNamevalidateScopeInvalidinmanager       = "validateScopeInvalid in manager";
	private final  static String      clazzvalidateScopeInvalidinmanager             = "com.ericsson.ngin.oauthserver.business.AuthorizationManager";
	private final  static String      methodvalidateScopeInvalidinmanager            = "validateScopeInvalid";
	
	// 1. Trace the input
    @OnMethod(
            clazz=clazzvalidateScopeInvalidinmanager,
            method=methodvalidateScopeInvalidinmanager
        )
      public static void calledvalidateScopeInvalidinmanager() {
    		starttimevalidateScopeInvalidinmanager = timeNanos();	
    		isStartedvalidateScopeInvalidinmanager  = true;
        }

    @OnMethod(
            clazz=clazzvalidateScopeInvalidinmanager,
            method=methodvalidateScopeInvalidinmanager,
            location=@Location(Kind.RETURN)
          )  
    public static void returnFromvalidateScopeInvalidinmanager() {
    	if (isStartedvalidateScopeInvalidinmanager){
    	    long executeTimesvalidateScopeInvalidinmanager = (timeNanos()- starttimevalidateScopeInvalidinmanager)/1000000;
    		addAndGet(totalExecuteTimesvalidateScopeInvalidinmanager, executeTimesvalidateScopeInvalidinmanager );
         	incrementAndGet(totalExecuteCountvalidateScopeInvalidinmanager);
         	//add min max here
         	long currentMax = get(maxExecuteTimesvalidateScopeInvalidinmanager);
         	if(executeTimesvalidateScopeInvalidinmanager > currentMax){
         	   boolean updated = compareAndSet(maxExecuteTimesvalidateScopeInvalidinmanager,currentMax,executeTimesvalidateScopeInvalidinmanager);
         	   if(!updated){
         	      currentMax = get(maxExecuteTimesvalidateScopeInvalidinmanager);
         	      if(executeTimesvalidateScopeInvalidinmanager > currentMax){
         	         updated = compareAndSet(maxExecuteTimesvalidateScopeInvalidinmanager,currentMax,executeTimesvalidateScopeInvalidinmanager);
         	      }
         	   }
         	}
         	//
            long currentMin = get(minExecuteTimesvalidateScopeInvalidinmanager);
            if(executeTimesvalidateScopeInvalidinmanager < currentMin){
               boolean updated = compareAndSet(minExecuteTimesvalidateScopeInvalidinmanager,currentMin,executeTimesvalidateScopeInvalidinmanager);
               if(!updated){
                  currentMin = get(minExecuteTimesvalidateScopeInvalidinmanager);
                  if(executeTimesvalidateScopeInvalidinmanager < currentMin){
                     updated = compareAndSet(minExecuteTimesvalidateScopeInvalidinmanager,currentMin,executeTimesvalidateScopeInvalidinmanager);
                  }
               }
            }
    		isStartedvalidateScopeInvalidinmanager = false;
    	}
    }
	// ----------------------------------------------------------------
}
