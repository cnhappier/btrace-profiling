import java.util.concurrent.atomic.AtomicLong;

import com.sun.btrace.annotations.*;
import static com.sun.btrace.BTraceUtils.*;

@BTrace
public class MonitorListClass {
	private final  static int PrintInterval_ms = 4000;

    // Print the log titles
    static{
        println("Print interval: 4000 (ms)");
		println("Time Stamp, Display Name, Execute Count, RunTime (ms), Execute per Second, Max runtime(ms), Min runtime(ms), Avarage runtime (ms)");
	}

    // Print Interval, to show the monitored count info
    @OnTimer(PrintInterval_ms)
    public static void PrintInterval(){
        // 1. Save the monitored info locally.
        // -----------------------------------------------
        // Get values for LinkedList Get
        long countLinkedListGet = getAndSet(totalExecuteCountLinkedListGet, 0);
        long timesLinkedListGet = getAndSet(totalExecuteTimesLinkedListGet, 0);
        long maxTimesLinkedListGet = getAndSet(maxExecuteTimesLinkedListGet, 0);
        long minTimesLinkedListGet = getAndSet(minExecuteTimesLinkedListGet, 100000);
        
        // 1. Save the monitored info locally.
        // -----------------------------------------------
        // Get values for LinkedList Contains
        long countLinkedListContains = getAndSet(totalExecuteCountLinkedListContains, 0);
        long timesLinkedListContains = getAndSet(totalExecuteTimesLinkedListContains, 0);
        long maxTimesLinkedListContains = getAndSet(maxExecuteTimesLinkedListContains, 0);
        long minTimesLinkedListContains = getAndSet(minExecuteTimesLinkedListContains, 100000);
        
        // 2. Display the monitored info
        // -----------------------------------------------
        // Display info for LinkedList Get
        print(Time.timestamp("yy-MM-dd hh:mm:ss"));
        print(", ");
        print(displayNameLinkedListGet);
        print(", ");
        print(Strings.str(countLinkedListGet));
        print(", ");
        print(Strings.str(timesLinkedListGet));
        print(", ");
        print(Strings.str(countLinkedListGet*1000/PrintInterval_ms));
        print(", ");
        print(Strings.str(maxTimesLinkedListGet));
        print(", ");
        print(Strings.str(minTimesLinkedListGet));
        print(", ");
        if (countLinkedListGet == 0)
            println("0");
        else
            println(Strings.str(timesLinkedListGet/countLinkedListGet));
        // 2. Display the monitored info
        // -----------------------------------------------
        // Display info for LinkedList Contains
        print(Time.timestamp("yy-MM-dd hh:mm:ss"));
        print(", ");
        print(displayNameLinkedListContains);
        print(", ");
        print(Strings.str(countLinkedListContains));
        print(", ");
        print(Strings.str(timesLinkedListContains));
        print(", ");
        print(Strings.str(countLinkedListContains*1000/PrintInterval_ms));
        print(", ");
        print(Strings.str(maxTimesLinkedListContains));
        print(", ");
        print(Strings.str(minTimesLinkedListContains));
        print(", ");
        if (countLinkedListContains == 0)
            println("0");
        else
            println(Strings.str(timesLinkedListContains/countLinkedListContains));
    }

	// ================================================================
	// Trace Method for LinkedList Get
	@TLS private   static long 		  starttimeLinkedListGet         = 0;
	@TLS private   static boolean 	  isStartedLinkedListGet         = false;
	private        static AtomicLong  maxExecuteTimesLinkedListGet   = newAtomicLong(0);;
	private        static AtomicLong  minExecuteTimesLinkedListGet   = newAtomicLong(100000);;
	private        static AtomicLong  totalExecuteTimesLinkedListGet = newAtomicLong(0);  
	private        static AtomicLong  totalExecuteCountLinkedListGet = newAtomicLong(0);
	private        static String      displayNameLinkedListGet       = "LinkedList Get";
	private final  static String      clazzLinkedListGet             = "java.util.LinkedList";
	private final  static String      methodLinkedListGet            = "get";
	
	// 1. Trace the input
    @OnMethod(
            clazz=clazzLinkedListGet,
            method=methodLinkedListGet
        )
      public static void calledLinkedListGet() {
    		starttimeLinkedListGet = timeNanos();	
    		isStartedLinkedListGet  = true;
        }

    @OnMethod(
            clazz=clazzLinkedListGet,
            method=methodLinkedListGet,
            location=@Location(Kind.RETURN)
          )  
    public static void returnFromLinkedListGet() {
    	if (isStartedLinkedListGet){
    	    long executeTimesLinkedListGet = (timeNanos()- starttimeLinkedListGet)/1000000;
    		addAndGet(totalExecuteTimesLinkedListGet, executeTimesLinkedListGet );
         	incrementAndGet(totalExecuteCountLinkedListGet);
         	//add min max here
         	long currentMax = get(maxExecuteTimesLinkedListGet);
         	if(executeTimesLinkedListGet > currentMax){
         	   boolean updated = compareAndSet(maxExecuteTimesLinkedListGet,currentMax,executeTimesLinkedListGet);
         	   if(!updated){
         	      currentMax = get(maxExecuteTimesLinkedListGet);
         	      if(executeTimesLinkedListGet > currentMax){
         	         updated = compareAndSet(maxExecuteTimesLinkedListGet,currentMax,executeTimesLinkedListGet);
         	      }
         	   }
         	}
         	//
            long currentMin = get(minExecuteTimesLinkedListGet);
            if(executeTimesLinkedListGet < currentMin){
               boolean updated = compareAndSet(minExecuteTimesLinkedListGet,currentMin,executeTimesLinkedListGet);
               if(!updated){
                  currentMin = get(minExecuteTimesLinkedListGet);
                  if(executeTimesLinkedListGet < currentMin){
                     updated = compareAndSet(minExecuteTimesLinkedListGet,currentMin,executeTimesLinkedListGet);
                  }
               }
            }
    		isStartedLinkedListGet = false;
    	}
    }
	// ----------------------------------------------------------------

	// ================================================================
	// Trace Method for LinkedList Contains
	@TLS private   static long 		  starttimeLinkedListContains         = 0;
	@TLS private   static boolean 	  isStartedLinkedListContains         = false;
	private        static AtomicLong  maxExecuteTimesLinkedListContains   = newAtomicLong(0);;
	private        static AtomicLong  minExecuteTimesLinkedListContains   = newAtomicLong(100000);;
	private        static AtomicLong  totalExecuteTimesLinkedListContains = newAtomicLong(0);  
	private        static AtomicLong  totalExecuteCountLinkedListContains = newAtomicLong(0);
	private        static String      displayNameLinkedListContains       = "LinkedList Contains";
	private final  static String      clazzLinkedListContains             = "java.util.LinkedList";
	private final  static String      methodLinkedListContains            = "contains";
	
	// 1. Trace the input
    @OnMethod(
            clazz=clazzLinkedListContains,
            method=methodLinkedListContains
        )
      public static void calledLinkedListContains() {
    		starttimeLinkedListContains = timeNanos();	
    		isStartedLinkedListContains  = true;
        }

    @OnMethod(
            clazz=clazzLinkedListContains,
            method=methodLinkedListContains,
            location=@Location(Kind.RETURN)
          )  
    public static void returnFromLinkedListContains() {
    	if (isStartedLinkedListContains){
    	    long executeTimesLinkedListContains = (timeNanos()- starttimeLinkedListContains)/1000000;
    		addAndGet(totalExecuteTimesLinkedListContains, executeTimesLinkedListContains );
         	incrementAndGet(totalExecuteCountLinkedListContains);
         	//add min max here
         	long currentMax = get(maxExecuteTimesLinkedListContains);
         	if(executeTimesLinkedListContains > currentMax){
         	   boolean updated = compareAndSet(maxExecuteTimesLinkedListContains,currentMax,executeTimesLinkedListContains);
         	   if(!updated){
         	      currentMax = get(maxExecuteTimesLinkedListContains);
         	      if(executeTimesLinkedListContains > currentMax){
         	         updated = compareAndSet(maxExecuteTimesLinkedListContains,currentMax,executeTimesLinkedListContains);
         	      }
         	   }
         	}
         	//
            long currentMin = get(minExecuteTimesLinkedListContains);
            if(executeTimesLinkedListContains < currentMin){
               boolean updated = compareAndSet(minExecuteTimesLinkedListContains,currentMin,executeTimesLinkedListContains);
               if(!updated){
                  currentMin = get(minExecuteTimesLinkedListContains);
                  if(executeTimesLinkedListContains < currentMin){
                     updated = compareAndSet(minExecuteTimesLinkedListContains,currentMin,executeTimesLinkedListContains);
                  }
               }
            }
    		isStartedLinkedListContains = false;
    	}
    }
	// ----------------------------------------------------------------
}
