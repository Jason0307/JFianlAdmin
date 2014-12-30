package com.jfinal.aceadmin.controller;

import java.util.Date;

import com.jfinal.aceadmin.model.CommodityRecord;
import com.jfinal.core.Controller;
import com.jfinal.ext.route.ControllerBind;

@ControllerBind(controllerKey = "/admin/record")
public class RecordController extends Controller {

	public void list() {
		int page = getParaToInt("page", 0);
		int pagesize = getParaToInt("rows", 10);
		String qtype = getPara("qtype");
		String query = getPara("query");
		String filter = getPara("filters");
		String sortname = getPara("sidx");
		String sortorder = getPara("sord");
		renderJson(CommodityRecord.dao.findByPagination(page, pagesize, qtype,
				query, sortname, sortorder, filter));
	}

	public void oper() {
		String id = getPara("id");
		Date sdate = getParaToDate("sdate");
		String name = getPara("name");
		String note = getPara("note");
		String ship = getPara("ship");
		boolean stock = getParaToBoolean("stock",false);
		String oper = getPara("oper");
		CommodityRecord commodityRecord = new CommodityRecord();
		commodityRecord.set("sdate", sdate).set("name", name).set("note", note).set("ship", ship).set("stock", stock);
		CommodityRecord.dao.operateModel(id,oper,commodityRecord);
		renderJson(commodityRecord);
	}
}
