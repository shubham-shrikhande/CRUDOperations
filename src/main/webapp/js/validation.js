function validation(frm){
	//empty the error messages
	document.getElementById("enameErr").innerHTML="";
    document.getElementById("jobErr").innerHTML="";
    document.getElementById("salErr").innerHTML="";
    alert("ala ith");
	//read form data
	let ename=frm.ename.value;
	let job=frm.job.value;
	let sal=frm.sal.value;
	
	let flag=true;
	//form validations (client side)

	if(ename=="" || ename==null){
		document.getElementById("enameErr").innerHTML="employee name is mandatory";
		flag=false;
	}
	else if(ename.length>10){
		document.getElementById("enameErr").innerHTML="employee name must have max 10 chars";
		flag=false;
	}
	
	if(job=="" || job==null){
		document.getElementById("jobErr").innerHTML="employee job is mandatory";
	   flag=false;
	}
	else if(job.length>10){
		document.getElementById("jobErr").innerHTML="employee job must have max 10 chars";
		flag=false;
	}
	
	if(sal==""){
		document.getElementById("salErr").innerHTML="employee salary is required";
		flag=false;
	}
	else if(isNaN(sal)){
		document.getElementById("salErr").innerHTML="employee salary must numeric value";
		flag=false;
	}
	else if(sal<0 || sal>1000000){
		document.getElementById("salErr").innerHTML="employee salary must be in range 1 to 1000000";
		flag=false;
	}

	frm.vflag.value="yes";
	return flag;
}