package com.jfinal.aceadmin.tables;

import com.jfinal.core.Controller;

public class TablesController extends Controller{

	public void simpleDynamic(){
		
		render("simple_dynamic.html");
	}
	
	public void jqGridPlugin(){
		
		render("jqgrid_plugin.html");
	}
}
