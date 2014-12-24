package com.jfinal.aceadmin.common;

import java.util.Properties;

import com.jfinal.aceadmin.calendar.CalendarController;
import com.jfinal.aceadmin.controller.RecordController;
import com.jfinal.aceadmin.forms.FormsController;
import com.jfinal.aceadmin.gallery.GalleryController;
import com.jfinal.aceadmin.index.IndexController;
import com.jfinal.aceadmin.model.BaseModel;
import com.jfinal.aceadmin.morepage.MorePageController;
import com.jfinal.aceadmin.otherpage.OtherPageController;
import com.jfinal.aceadmin.tables.TablesController;
import com.jfinal.aceadmin.uielement.UIElementController;
import com.jfinal.aceadmin.widgets.WidgetsController;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.ext.plugin.tablebind.AutoTableBindPlugin;
import com.jfinal.plugin.druid.DruidPlugin;

public class JFinalAceAdminConfig extends JFinalConfig {
	
	public Properties loadProp(String pro, String dev) {
		try {return loadPropertyFile(pro);}
		catch (Exception e)
			{return loadPropertyFile(dev);}
	}
	
	public void configConstant(Constants me) {
		// 如果生产环境配置文件存在，则优先加载该配置，否则加载开发环境配置文件
		loadProp("a_little_config_pro.txt", "a_little_config.txt");
		me.setDevMode(getPropertyToBoolean("devMode", false));
	}
	
	public void configRoute(Routes me) {
		
		me.add("/admin/forms",FormsController.class);
		me.add("/admin/gallery",GalleryController.class);
		me.add("/admin", IndexController.class, "/admin/index");
		me.add("/admin/morepage", MorePageController.class, "/admin/more_pages");	
		me.add("/admin/otherpage",OtherPageController.class,"/admin/other_pages");
		me.add("/admin/tables",TablesController.class);
		me.add("/admin/ui",UIElementController.class, "/admin/ui_elements");
		me.add("/admin/widgets", WidgetsController.class);
		me.add("/admin/calendar", CalendarController.class);
		me.add("/admin/record/list",RecordController.class);
	}
	
	@SuppressWarnings("unchecked")
	public void configPlugin(Plugins p) {
		DruidPlugin druidPlugin = new DruidPlugin(getProperty("jdbcUrl"),
				getProperty("user"), getProperty("password"));
		AutoTableBindPlugin autoTableBindPlugin = new AutoTableBindPlugin(
				druidPlugin);
		autoTableBindPlugin.setShowSql(true);
		autoTableBindPlugin.addExcludeClasses(BaseModel.class);
		p.add(druidPlugin).add(autoTableBindPlugin);
		
		/*QuartzPlugin quartzPlugin = new QuartzPlugin("job.properties");
		p.add(new EhCachePlugin()).add(quartzPlugin);*/
	}
	
	public void configInterceptor(Interceptors me) {
		
	}
	
	public void configHandler(Handlers me) {
		me.add(new ContextPathHandler("contextPath"));//设置上下文路径  防止样式丢失
	}
	
	public static void main(String[] args) {
		JFinal.start("src/main/webapp", 8080, "/JFnialAdmin", 5);
	}
}
