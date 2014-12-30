package com.jfinal.aceadmin.model;

import com.jfinal.aceadmin.util.ConstantKit;
import com.jfinal.ext.plugin.tablebind.TableBind;

@TableBind(pkName = "id", tableName = "CommodityRecord")
public class CommodityRecord extends BaseModel<CommodityRecord> {

	private static final long serialVersionUID = 1L;
	public static CommodityRecord dao = new CommodityRecord();

	public void operateModel(String id, String oper,
			CommodityRecord commodityRecord) {
		if (ConstantKit.BLANK_ID.equals(id)) {
			commodityRecord.save();
		} else {
			if (ConstantKit.OPER_EDIT.equals(oper)) {
				commodityRecord.set("id", id).update();
			} else {
				commodityRecord.set("id", id).delete();
			}
		}
	}
}
