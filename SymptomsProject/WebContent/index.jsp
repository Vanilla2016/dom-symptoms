<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-W3CDTD HTML 4.01 TransitionalEN" "http:www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="/SymptomsProject/scripts/jquery/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/SymptomsProject/scripts/jquery-ui-1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="/SymptomsProject/scripts/jquery-ui-1.12.1/jquery-ui.css">
<script type="text/javascript">
$.ajax({
	url:"query",
	    type: "GET",
	success:function(data){
		$("#menu").html(data);
	}});

	   $( function() {
	    	$( "#menu" ).selectmenu();
	    	
	    	$( "#menu" ).selectmenu({
	    		  change: function( event, ui ) { alert($( "#menu" ).val()) ;}
	    		});
	  } );
  </script>
 
</head>	
<body>

<!-- <div align="center" id="contentDiv""></div> -->

 <select id="menu"></select>
 
 <form action="setup">
      <label for="name">Please enter your name</label><br/>
      <input type="text" name="name"/>
      <input type="submit" value="Say Hello"/>
   </form>
	 
</body>
</html>