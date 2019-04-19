package com.nt.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.command.CustomerCommand;


public class customerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz.isAssignableFrom(CustomerCommand.class);
	}

	@Override
	public void validate(Object command, Errors errors) {
		System.out.println("customerValidator.validate()");
	
		// typecasting

		CustomerCommand cmd=(CustomerCommand)command;

		if(cmd.getVflag().equalsIgnoreCase("no")) {
			System.out.println("server side form validations are taking place");
		}
		if(cmd.getCno()==null||cmd.getCno()<=0) {
			errors.rejectValue("cno","cno.invalid");
			
			System.out.println("server side form validations are taking place");
		if(cmd.getCname()==null ||cmd.getCname().length()==0 || cmd.getCname().equals(""))
			errors.rejectValue("cname","cname.required");
		
		if(cmd.getCaddr()==null || cmd.getCaddr().equals("") ||cmd.getCaddr().length()==0)
			errors.rejectValue("caddr","caddr.required");
		else if(cmd.getCaddr().length()<10)
			errors.rejectValue("caddr","caddr.minlength");

		
		if(cmd.getCmblNo()==null || cmd.getCmblNo().equals(""))
			errors.rejectValue("cmblNo","cmblNo.required");
		 
		if(cmd.getBillAmt()==null || cmd.getBillAmt().equals(""))
			errors.rejectValue("billAmt","billAmt.required");
			
		}

	}

}
