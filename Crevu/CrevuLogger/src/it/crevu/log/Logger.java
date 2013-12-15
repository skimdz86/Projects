package it.crevu.log;

import java.io.CharArrayWriter;
import java.io.PrintWriter;

public class Logger {

	private static org.apache.log4j.Logger logger;

	private static Logger log = null;
	
	private static boolean isInitializated = false;

	public static void init() {
	}

	private static int sDeep = 0;

	/**
	 * Init del logger senza file di configurazione
	 */

	private Logger(Class clazz) {
		logger = org.apache.log4j.LogManager.getLogger(clazz);
	}
	
	public static Logger getInstance(Class clazz){
		if(log==null){
			log = new Logger(clazz);
		}
		return log;
	}

	public static void init(boolean ok) {
		if (!isInitializated) {

		}
	}

	private static void log(Class cl, String smet, String msg, String lev) {
		StringBuffer sb = new StringBuffer("| | | | | | | | | | | | | | |");
		try {
			/*
			 * org.apache.log4j.Logger locLog = logger.getLogger(cl); Method met
			 * = locLog.getClass().getDeclaredMethod(lev,new Class[]
			 * {Object.class});
			 */
			if ((sDeep * 2) < sb.length()) {
				sb.setLength(sDeep * 2);
			} else {
				sb.append("--");
			}
			msg = sb + "[" + msg + "] " + "<" + smet + "> ";
			// met.invoke(locLog,new Object[] {msg});

			if (lev.equals("info")) {
				logger.info(msg);
			} else if (lev.equals("debug")) {
				logger.debug(msg);
			} else if (lev.equals("warning")) {
				logger.warn(msg);
			} else if (lev.equals("error")) {
				logger.error(msg);
			}

			else if (lev.equals("exception")) {
				logger.error(msg);
			}

			else if (lev.equals("fatal")) {
				logger.fatal(msg);
			}

		} catch (Exception ex) {
			System.out.println("logger exception " + ex);
		}

	}

	public static void info(Class cl, String methodName, String msg) {
		// logger.getLogger(cl).info("->met[" + methodName + "]" + msg);
		log(cl, methodName, msg, "info");

	}

	public static void warning(Class cl, String methodName, String msg) {
		// logger.getLogger(cl).error("->met[" + methodName + "]" + msg);
		log(cl, methodName, msg, "warning");

	}

	public static void error(Class cl, String methodName, String msg) {
		// logger.getLogger(cl).error("->met[" + methodName + "]" + msg);
		log(cl, methodName, msg, "error");

	}

	public static void debug(Class cl, String methodName, String... msgs) {
		// logger.getLogger(cl).debug("=>" + methodName + "<= " + msg);
   		for (String msg : msgs)
   			log(cl, methodName, msg, "debug");                  
	}

	public static void exception(Class cl, String methodName, Throwable e,
			String msg) {
		// logger.getLogger(cl).error("met["+methodName+"] "+"exception "+e+" "+msg);
		CharArrayWriter cw = new CharArrayWriter();
		e.printStackTrace(new PrintWriter(cw, true));
		log(cl, methodName, "StackTrace:" + cw + " -- " + msg, "exception");
	}

	public static void enter(Class cl, String methodName, String msg) {
		sDeep++;
		// logger.getLogger(cl).info("Entering =>" + methodName + "<= " + msg);
		log(cl, methodName, "Entering: " + msg, "info");
	}

	public static void exit(Class cl, String methodName, String msg) {
		// logger.getLogger(cl).info("Exiting =>" + methodName + "<= " + msg);
		log(cl, methodName, "Exiting:  " + msg, "info");
		sDeep = sDeep > 0 ? --sDeep : sDeep;
	}
	
	public void debug(String msg){
		if(logger.isDebugEnabled()) logger.debug(msg);
	}
	
	public void info(String msg){
		if(logger.isInfoEnabled()) logger.info(msg);
	}
	
	public void warn(String msg){
		logger.warn(msg);
	}
	
	public void error(String msg){
		logger.error(msg);
	}
	
	public void error(String msg, Throwable e){
		logger.error(msg, e);
	}

	public static String getCurrentMethodName() {
		StackTraceElement stackTraceElements[] = (new Throwable())
				.getStackTrace();
		return stackTraceElements[1].toString();
	}

}
