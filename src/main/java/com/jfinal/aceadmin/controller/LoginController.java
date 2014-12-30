package com.jfinal.aceadmin.controller;

import com.jfinal.core.Controller;
import com.jfinal.ext.route.ControllerBind;

@ControllerBind(controllerKey = "/admin/user",viewPath = "/admin/")
public class LoginController extends Controller{

	public void login(){
		render("more_pages/login.html");
	}
}
