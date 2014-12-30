package com.jfinal.aceadmin.controller;

import com.jfinal.aceadmin.model.Item;
import com.jfinal.core.Controller;
import com.jfinal.ext.route.ControllerBind;
@ControllerBind(controllerKey = "/admin/item")
public class ItemController extends Controller{

	public void list(){
		renderJson(Item.dao.findByPagination(1, 10, null, null, null, null, null));
	}
}
