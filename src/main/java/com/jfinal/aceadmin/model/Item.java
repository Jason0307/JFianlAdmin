package com.jfinal.aceadmin.model;

import com.jfinal.ext.plugin.tablebind.TableBind;

@TableBind(tableName = "Item",pkName = "id")
public class Item extends BaseModel<Item> {
	private static final long serialVersionUID = 1L;

	public static Item dao = new Item();
}
