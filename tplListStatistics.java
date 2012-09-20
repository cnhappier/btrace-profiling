// This Template is used to moniter the below info for specified methods:
//      Execute Count, RunTime (ms), Execute per Second, Avarage runtime (ms)
//
// Please using btraceGenerator.py to generate the actula scripts.
/* ====================================================================
//              Configuration File Format (in JSON)
{
    "template-file-name"    : "tplListStatistics.java",
    "gen-script-class-name" : "ListGetContainsMonitor",         *
    "print-interval"        : 4000,                             *

    "monitor-targets"       : [
        {
            "display-name"          : "LinkedList Get",         *
            "target-class-name"     : "java.util.LinkedList",   *
            "target-method-name"    : "get"                     *
        },
        ... ...                                                 *
    ],

    "replacement-map-list" :
        {
            "gen-script-class-name" : "Template__BtraceScriptClass__",
            "print-interval"        : "Template__PrintInterval_ms__",
            "display-name"          : "Template__MethodDisplayName__",
            "naming-suffix"         : "Template_MonitorMethodName__",
            "target-class-name"     : "Template_ClassPathAndName__",
            "target-method-name"    : "Template_MethodName__"
        }
}
// Note: * means this line should be modified per your requirement.
==================================================================== */
// <<--Class Definition Head BEGIN-->>
import java.util.concurrent.atomic.AtomicLong;

import com.sun.btrace.annotations.*;
import static com.sun.btrace.BTraceUtils.*;

@BTrace
public class Template__BtraceScriptClass__ {
	private final  static int PrintInterval_ms = Template__PrintInterval_ms__;

    // Print the log titles
    static{
        println("Print interval: Template__PrintInterval_ms__ (ms)");
		println("Time Stamp, Display Name, Execute Count, RunTime (ms), Execute per Second, Max runtime(ms), Min runtime(ms), Avarage runtime (ms)");
	}

// <<--Class Definition Head END-->>

// ===========================================================================================================================
// <<--Display Interval Head BEGIN-->>
    // Print Interval, to show the monitored count info
    @OnTimer(PrintInterval_ms)
    public static void PrintInterval(){
// <<--Display Interval Head END-->>

// <<--Display Interval Save Value BEGIN-->>
        // 1. Save the monitored info locally.
        // -----------------------------------------------
        // Get values for Template__MethodDisplayName__
        long countTemplate_MonitorMethodName__ = getAndSet(totalExecuteCountTemplate_MonitorMethodName__, 0);
        long timesTemplate_MonitorMethodName__ = getAndSet(totalExecuteTimesTemplate_MonitorMethodName__, 0);
        long maxTimesTemplate_MonitorMethodName__ = getAndSet(maxExecuteTimesTemplate_MonitorMethodName__, 0);
        long minTimesTemplate_MonitorMethodName__ = getAndSet(minExecuteTimesTemplate_MonitorMethodName__, 100000);
        
// <<--Display Interval Save Value END-->>

// <<--Display Interval Print Value BEGIN-->>
        // 2. Display the monitored info
        // -----------------------------------------------
        // Display info for Template__MethodDisplayName__
        print(Time.timestamp("yy-MM-dd hh:mm:ss"));
        print(", ");
        print(displayNameTemplate_MonitorMethodName__);
        print(", ");
        print(Strings.str(countTemplate_MonitorMethodName__));
        print(", ");
        print(Strings.str(timesTemplate_MonitorMethodName__));
        print(", ");
        print(Strings.str(countTemplate_MonitorMethodName__*1000/PrintInterval_ms));
        print(", ");
        print(Strings.str(maxTimesTemplate_MonitorMethodName__));
        print(", ");
        print(Strings.str(minTimesTemplate_MonitorMethodName__));
        print(", ");
        if (countTemplate_MonitorMethodName__ == 0)
            println("0");
        else
            println(Strings.str(timesTemplate_MonitorMethodName__/countTemplate_MonitorMethodName__));
// <<--Display Interval Print Value END-->>

// <<--Display Interval Tail BEGIN-->>
    }
// <<--Display Interval Tail END-->>

// ===========================================================================================================================

// <<--Trace Method Body BEGIN-->>

	// ================================================================
	// Trace Method for Template__MethodDisplayName__
	@TLS private   static long 		  starttimeTemplate_MonitorMethodName__         = 0;
	@TLS private   static boolean 	  isStartedTemplate_MonitorMethodName__         = false;
	private        static AtomicLong  maxExecuteTimesTemplate_MonitorMethodName__   = newAtomicLong(0);;
	private        static AtomicLong  minExecuteTimesTemplate_MonitorMethodName__   = newAtomicLong(100000);;
	private        static AtomicLong  totalExecuteTimesTemplate_MonitorMethodName__ = newAtomicLong(0);  
	private        static AtomicLong  totalExecuteCountTemplate_MonitorMethodName__ = newAtomicLong(0);
	private        static String      displayNameTemplate_MonitorMethodName__       = "Template__MethodDisplayName__";
	private final  static String      clazzTemplate_MonitorMethodName__             = "Template_ClassPathAndName__";
	private final  static String      methodTemplate_MonitorMethodName__            = "Template_MethodName__";
	
	// 1. Trace the input
    @OnMethod(
            clazz=clazzTemplate_MonitorMethodName__,
            method=methodTemplate_MonitorMethodName__
        )
      public static void calledTemplate_MonitorMethodName__() {
    		starttimeTemplate_MonitorMethodName__ = timeNanos();	
    		isStartedTemplate_MonitorMethodName__  = true;
        }

    @OnMethod(
            clazz=clazzTemplate_MonitorMethodName__,
            method=methodTemplate_MonitorMethodName__,
            location=@Location(Kind.RETURN)
          )  
    public static void returnFromTemplate_MonitorMethodName__() {
    	if (isStartedTemplate_MonitorMethodName__){
    	    long executeTimesTemplate_MonitorMethodName__ = (timeNanos()- starttimeTemplate_MonitorMethodName__)/1000000;
    		addAndGet(totalExecuteTimesTemplate_MonitorMethodName__, executeTimesTemplate_MonitorMethodName__ );
         	incrementAndGet(totalExecuteCountTemplate_MonitorMethodName__);
         	//add min max here
         	long currentMax = get(maxExecuteTimesTemplate_MonitorMethodName__);
         	if(executeTimesTemplate_MonitorMethodName__ > currentMax){
         	   boolean updated = compareAndSet(maxExecuteTimesTemplate_MonitorMethodName__,currentMax,executeTimesTemplate_MonitorMethodName__);
         	   if(!updated){
         	      currentMax = get(maxExecuteTimesTemplate_MonitorMethodName__);
         	      if(executeTimesTemplate_MonitorMethodName__ > currentMax){
         	         updated = compareAndSet(maxExecuteTimesTemplate_MonitorMethodName__,currentMax,executeTimesTemplate_MonitorMethodName__);
         	      }
         	   }
         	}
         	//
            long currentMin = get(minExecuteTimesTemplate_MonitorMethodName__);
            if(executeTimesTemplate_MonitorMethodName__ < currentMin){
               boolean updated = compareAndSet(minExecuteTimesTemplate_MonitorMethodName__,currentMin,executeTimesTemplate_MonitorMethodName__);
               if(!updated){
                  currentMin = get(minExecuteTimesTemplate_MonitorMethodName__);
                  if(executeTimesTemplate_MonitorMethodName__ < currentMin){
                     updated = compareAndSet(minExecuteTimesTemplate_MonitorMethodName__,currentMin,executeTimesTemplate_MonitorMethodName__);
                  }
               }
            }
    		isStartedTemplate_MonitorMethodName__ = false;
    	}
    }
	// ----------------------------------------------------------------
// <<--Trace Method Body END-->>

// ===========================================================================================================================

// <<--Class Definition Tail BEGIN-->>
}
// <<--Class Definition Tail END-->>
