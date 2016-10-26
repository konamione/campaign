package com.webcam.wbcp.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.webcam.wbcp.vo.Dict;
import com.webcam.wbcp.vo.Group;
import com.webcam.wbcp.vo.JoinGroupRecord;
import com.webcam.wbcp.vo.Logger;
import com.webcam.wbcp.vo.Msg;
import com.webcam.wbcp.vo.QQ;
import com.webcam.wbcp.vo.QQMsgRecord;
import com.webcam.wbcp.vo.SendMsgRecord;

/**
 * 配置类  继承自JFinalConfig
 * @author konami
 *
 */
public class Config extends JFinalConfig{

	/**
	 * 配置系统常量及参数
	 */
	@Override
	public void configConstant(Constants me) {
		loadPropertyFile("log4j.properties");
		loadPropertyFile("db_conn_config.txt");
		me.setDevMode(true);					//设置是否开发模式
		me.setViewType(ViewType.FREE_MARKER);	//设置视图模式
	}

	/**
	 * 配置控制器（controller）访问路由
	 */
	@Override
	public void configRoute(Routes me) {
//		me.add("/user", UserController.class);
//		me.add("/nev",NevController.class);
//		me.add("/inv",InventoryController.class);
//		me.add("/goods",GoodsController.class);
//		me.add("/sell",SellController.class);
//		me.add("/pro",ProController.class);
//		me.add("/cash",CashController.class);
//		me.add("/report",ReportController.class);
	}

	/**
	 * 配置第三方插件
	 */
	@Override
	public void configPlugin(Plugins me) {
		C3p0Plugin cp = new C3p0Plugin(loadPropertyFile("a_little_config.txt"));
		me.add(cp);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);
		arp.setShowSql(true);
		me.add(arp);
		arp.addMapping("dict", Dict.class);
		arp.addMapping("group", Group.class);
		arp.addMapping("join_group_record", JoinGroupRecord.class);
		arp.addMapping("logger", Logger.class);
		arp.addMapping("msg", Msg.class);
		arp.addMapping("qq", QQ.class);
		arp.addMapping("qq_message_record", QQMsgRecord.class);
		arp.addMapping("send_message_record", SendMsgRecord.class);
	}

	/**
	 * 配置拦截器
	 */
	@Override
	public void configInterceptor(Interceptors me) {
//		me.add(new GloablInterceptor());
		me.add(new Tx());
	}

	/**
	 * 配置Handler
	 */
	@Override
	public void configHandler(Handlers me) {
		me.add(new ContextPathHandler("contextPath"));//设置上下文路径
	}

}
