// This Template is used to moniter the below info for specified methods:
//      Execute Count, RunTime (ms), Execute per Second, Avarage runtime (ms)
//
// Please using btraceGenerator.py to generate the actula scripts.
/* ====================================================================
//              Configuration File Format (in JSON)
{
    "template-file-name"    : "tplMethodInvoking.java",
    "gen-script-class-name" : "ListGetInvokingMonitor",         *

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

import com.sun.btrace.AnyType;
import com.sun.btrace.annotations.*;
import static com.sun.btrace.BTraceUtils.*;

@BTrace
public class Template__BtraceScriptClass__ {
// <<--Class Definition Head END-->>

// ===========================================================================================================================

// <<--Trace Method Body BEGIN-->>

	// ================================================================
	// Trace Method for Template__MethodDisplayName__
	@TLS private   static long 		  starttimeTemplate_MonitorMethodName__         = 0;
	@TLS private   static boolean 	  isStartedTemplate_MonitorMethodName__         = false;
	private        static String      displayNameTemplate_MonitorMethodName__       = "Template__MethodDisplayName__";
	private final  static String      clazzTemplate_MonitorMethodName__             = "Template_ClassPathAndName__";
	private final  static String      methodTemplate_MonitorMethodName__            = "Template_MethodName__";
	
	// 1. Trace the input
    @OnMethod(
            clazz=clazzTemplate_MonitorMethodName__,
            method=methodTemplate_MonitorMethodName__
        )
      public static void calledTemplate_MonitorMethodName__(AnyType[] args) {
    		starttimeTemplate_MonitorMethodName__ = timeNanos();	
    		isStartedTemplate_MonitorMethodName__  = true;
    		print(Strings.strcat(Time.timestamp("yy-MM-dd hh:mm:ss"), ": "));
    	    println(Strings.strcat(displayNameTemplate_MonitorMethodName__, " called, parms are: "));
    	    printArray(args);
    	    println("");
    }

    @OnMethod(
            clazz=clazzTemplate_MonitorMethodName__,
            method=methodTemplate_MonitorMethodName__,
            location=@Location(Kind.RETURN)
          )  
    public static void returnFromTemplate_MonitorMethodName__(@Return String cl) {
    	if (isStartedTemplate_MonitorMethodName__){
    		long secs = (timeNanos()- starttimeTemplate_MonitorMethodName__)/1000000;
    		isStartedTemplate_MonitorMethodName__ = false;
    		print(Strings.strcat(Time.timestamp("yy-MM-dd hh:mm:ss"), ": "));
    		println(Strings.strcat(displayNameTemplate_MonitorMethodName__, " returns: "));
    		println(cl);
            Threads.jstack();
    		println(Strings.strcat("Execute Time (Nanos):", str(secs)) );
        	println("");
    	}
    }
	// ----------------------------------------------------------------
// <<--Trace Method Body END-->>

// ===========================================================================================================================

// <<--Class Definition Tail BEGIN-->>
}
// <<--Class Definition Tail END-->>
