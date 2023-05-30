
<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style>
    span{
       color:red;
    }
    body{
       color:Green;
    }

</style>
<script language="javaScript" src="js/validation.js">
    
</script>
<div align="center" class="container">

	<h1>Register here</h1>
	<table>
		<form:form action="result1" modelAttribute="employee" onsubmit="return validation(this)" name="frm">
		<tr>
		   <td>Employee Name::</td>
		   <td><form:input path="ename"/><form:errors path="ename"/><span id="enameErr"></span></td>
		</tr>
		<tr>
		   <td>Employee Job::</td>
		   <td><form:input path="job"/><form:errors path="job"/><span id="jobErr"></span></td>
		</tr>
		<tr>
		   <td>Employee Salary::</td>
		   <td><form:input path="sal"/><form:errors path="sal"/><span id="salErr"></span></td>
		</tr>
		
		<script language="JavaScript">
		alert("1");
		function toState(frm){
			alert("2");
			frm.action="/state";
			alert("3");
			frm.submit();
			alert("4");
		}
		</script>
		<tr>
		   <td>Select Country::</td>
		   <td><form:select path="country" onchange="toState(this)">
		      <form:options items="${countries }"/>
		   </form:select></td>
		</tr>
		
		<tr>
		   <td>Select States::</td>
		   <td><form:select path="state">
		      <form:options items="${states}"/>
		   </form:select></td>
		</tr>
		<tr>
		   <form:hidden path="vflag"/>
		   <td><input type="submit"/></td>
		</tr>
           
		</form:form>
	</table>
</div>
