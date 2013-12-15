<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="java.net.*"%>
<%@ page import="javax.net.ssl.*"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>TEST PAYPAL</p>
<%
	
	Enumeration en = request.getParameterNames();
	StringBuffer strBuffer = new StringBuffer("cmd=_notify-validate");
	String paramName;
	String paramValue;
	while (en.hasMoreElements()) {
		paramName = (String) en.nextElement();
		paramValue = request.getParameter(paramName);
		strBuffer.append("&").append(paramName).append("=")
				.append(URLEncoder.encode(paramValue));
	}
 

	URL u = new URL("https://www.paypal.com/cgi-bin/webscr");
	HttpsURLConnection uc = (HttpsURLConnection) u.openConnection();
	uc.setDoOutput(true);
	uc.setRequestProperty("Content-Type",
			"application/x-www-form-urlencoded");
	uc.setRequestProperty("Host", "www.paypal.com");
	PrintWriter pw = new PrintWriter(uc.getOutputStream());
	pw.println(strBuffer.toString());
	pw.close();
 
	BufferedReader in = new BufferedReader(new InputStreamReader(
			uc.getInputStream()));
	String res = in.readLine();
	in.close();
 
	// assign posted variables to local variables
	String itemName = request.getParameter("item_name");
	String itemNumber = request.getParameter("item_number");
	String paymentStatus = request.getParameter("payment_status");
	String paymentAmount = request.getParameter("mc_gross");
	String paymentCurrency = request.getParameter("mc_currency");
	String txnId = request.getParameter("txn_id");
	String receiverEmail = request.getParameter("receiver_email");
	String payerEmail = request.getParameter("payer_email");
 
	// check notification validation
	out.println(itemName);
	if (res.equals("VERIFIED")) {
		out.println("ok");
		// check that paymentStatus=Completed

	} else if (res.equals("INVALID")) {
		// log for investigation
	} else {
		// error
	}
%>
</body>
</html>