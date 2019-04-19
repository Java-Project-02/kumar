function validate(frm){
	
	alert(11);
	//read form data
	var cno=frm.cno.value;
	var cname=frm.cname.value;
	var caddr=frm.caddr.value;
	var cmblNo=frm.cmblNo.value;
	var billAmt=frm.billAmt.value;
	alert(22);
	//empty error messages
	document.getElementById("cno.err").innerHTML="";
	document.getElementById("cname.err").innerHTML="";
	document.getElementById("caddr.err").innerHTML="";
	document.getElementById("cmblNo.err").innerHTML="";
	document.getElementById("billAmt.err").innerHTML="";
	alert(33);
	
	if(document.getElementById("cno.errors")!=null)
     	document.getElementById("cno.errors").innerHTML="";
	alert(44);
	
	if(document.getElementById("cname.errors")!=null)
     	document.getElementById("cname.errors").innerHTML="";
     	alert(55);
	
	
	if(document.getElementById("caddr.errors")!=null)
	   document.getElementById("caddr.errors").innerHTML="";
	alert(66);
	if(document.getElementById("cmblNo.errors")!=null)
	    document.getElementById("cmblNo.errors").innerHTML="";
	alert(77);
	if(document.getElementById("billAmt.errors")!=null)
     	document.getElementById("billAmt.errors").innerHTML="";
	alert(88);
	//set vflag value "yes" indicating client side form validations are performed
	frm.vflag.value="yes";
	alert(881);
	//perform form validations
	
	if(cno==""){
		alert(99);
		document.getElementById("cno.err").innerHTML="no is mandatory";
		frm.sno.focus();
		return false;
	}
	else if(cno.length<0){
		alert(111);
		document.getElementById("cno.err").innerHTML="number must be positive number";
		frm.cno.focus();
		return false;
	}
	
	if(cname==""){
		alert(222);
		document.getElementById("cname.err").innerHTML="name is mandatory";
		frm.sno.focus();
		return false;
	}
	if(caddr=""){
		alert(333);
		document.getElementById("caddr.err").innerHTML="caddr is mandatory";
		frm.caddr.focus();
		return false;
	}
	/*else if(caddr.length<10){
		alert(444);
		document.getElementById("caddr.err").innerHTML="cadd must have min 10 chars";
		frm.caddr.focus();
		return false;
	}*/
	
	if(cmblNo==""){
		alert(555);
		document.getElementById("cmblNo.err").innerHTML="mobile no is mandatory";
		frm.cmblNo.focus();
		return false;
	}
	if(billAmt==""){
		alert(666);
		document.getElementById("billAmt.err").innerHTML="BillAmount is mandatory";
		frm.billAmt.focus();
		return false;
	}
	return true;
}//function
