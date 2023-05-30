
<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<script language="javaScript" src="js/validation.js">
    
</script>
<div align="center">
	<h1>Edit Details</h1>
	<table>
		<form:form action="./regi" modelAttribute="employee" onsubmit="return validation(this)">
		
		<tr>
		   <td>Employee No::</td>
		   <td><form:input path="empno" readonly="true"/></td>
		</tr>
		<tr>
		   <td>Employee Name::</td>
		   <td><form:input path="ename"/><form:errors path="ename"/><span id="enameErr"/></td>
		</tr>
		<tr>
		   <td>Employee Job::</td>
		   <td><form:input path="job"/><form:errors path="job"/><span id="jobErr"/></td>
		</tr>
		<tr>
		   <td>Employee Salary::</td>
		   <td><form:input path="sal"/><form:errors path="sal"/><span id="salErr"></td>
		</tr>
		<tr>
		   <td>Select Country::</td>
		   <td><form:select path="country">
		      <form:options items="${countries }"/>
		   </form:select></td>
		</tr>
		<tr>
		   		 <form:hidden path="vflag"/>
		   
		   <td><input type="submit" value="Edit Details"/></td>
		</tr>
           
		</form:form>
	</table>
</div>
