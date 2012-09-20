import java.util.concurrent.atomic.AtomicLong;

import com.sun.btrace.AnyType;
import com.sun.btrace.annotations.*;
import static com.sun.btrace.BTraceUtils.*;

@BTrace
public class TraceListClassMonitorInvoking {

	// ================================================================
	// Trace Method for Linked List Get
	@TLS private   static long 		  starttimeLinkedListGet         = 0;
	@TLS private   static boolean 	  isStartedLinkedListGet         = false;
	private        static String      displayNameLinkedListGet       = "Linked List Get";
	private final  static String      clazzLinkedListGet             = "java.util.LinkedList";
	private final  static String      methodLinkedListGet            = "get";
	
	// 1. Trace the input
    @OnMethod(
            clazz=clazzLinkedListGet,
            method=methodLinkedListGet
        )
      public static void calledLinkedListGet(AnyType[] args) {
    		starttimeLinkedListGet = timeNanos();	
    		isStartedLinkedListGet  = true;
    		print(Strings.strcat(Time.timestamp("yy-MM-dd hh:mm:ss"), ": "));
    	    println(Strings.strcat(displayNameLinkedListGet, " called, parms are: "));
    	    printArray(args);
    	    println("");
    }

    @OnMethod(
            clazz=clazzLinkedListGet,
            method=methodLinkedListGet,
            location=@Location(Kind.RETURN)
          )  
    public static void returnFromLinkedListGet(@Return String cl) {
    	if (isStartedLinkedListGet){
    		long secs = (timeNanos()- starttimeLinkedListGet)/1000000;
    		isStartedLinkedListGet = false;
    		print(Strings.strcat(Time.timestamp("yy-MM-dd hh:mm:ss"), ": "));
    		println(Strings.strcat(displayNameLinkedListGet, " returns: "));
    		println(cl);
            Threads.jstack();
    		println(Strings.strcat("Execute Time (Nanos):", str(secs)) );
        	println("");
    	}
    }
	// ----------------------------------------------------------------
}
