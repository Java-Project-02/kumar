package com.nt.command;

import lombok.Data;

@Data
public class CustomerCommand {
private Integer cno;
private String cname;
private String caddr;
private Long cmblNo;
private String vflag="no";
private Float billAmt;
}
