<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>  
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
    function checkedIt(slno) {
		alert("Checked "+slno)
	}
    function getXmlHttpObject() {
		var xmlHttp;
		try{
			xmlHttp = new XMLHttpRequest();
		}
		catch(e){
			try{
				xmlHttp = new ActivexObject("Msxml12.XMLHTTP")
			}
			catch(e){
				xmlHttp = new ActivexObhect("Microsoft.XMLHTTP")
			}
		}
		return xmlHttp;
	}
    
    function fetchName(slno){
    	xmlHttp = getXmlHttpObject();
    	if (xmlHttp == null) {
			return;
		}
    	var url = "GetName.jsp?slno="+slno;
    	xmlHttp.onreadystatechange = function () {
			if(xmlHttp.readyState == 4){
				var res = (xmlHttp.responseText).trim();
				document.getElementById("name").value = res;
			}
		}
    	xmlHttp.open("GET", url, true)
    	xmlHttp.send(null)
    }
</script>
<meta charset="ISO-8859-1">
<title>home</title>
</head>
<body>
    <h2>Welcome to AJAX</h2>
    Sl.No :
    <select name="slno" onchange="fetchName(this.value)">
        <option value="0">-- select --</option>
        <option value="101">101</option>
        <option value="102">102</option>
        <option value="103">103</option>
        <option value="104">104</option>
        <option value="105">105</option>
        <option value="106">106</option>
    </select>
    <br><br>
    Name : <input type="text" name="name" id="name" readonly>
</body>
</html>