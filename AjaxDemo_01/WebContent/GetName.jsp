<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%
   Map<Integer, String> names = new HashMap<>();
   names.put(101, "bhavana");
   names.put(102, "ravi");
   names.put(103, "devi");
   names.put(104, "teja");
   names.put(105, "pavan");
   names.put(106, "jamuna");
   int slno = Integer.parseInt(request.getParameter("slno"));
   out.print(names.get(slno));
%>      