package com.jfinal.aceadmin.model;

import com.jfinal.ext.plugin.tablebind.TableBind;

@TableBind(pkName = "id", tableName = "CommodityRecord")
public class CommodityRecord extends BaseModel<CommodityRecord>{

	private static final long serialVersionUID = 1L;
	public static CommodityRecord dao = new CommodityRecord();
}
