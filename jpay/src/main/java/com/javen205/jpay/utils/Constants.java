package com.javen205.jpay.utils;


import com.javen205.jpay.IPay;

public class Constants {
	public static String APP_ID="";//不能删除 回调的WXPayEntryActivity中需要使用
	public static IPay.IPayListener payListener;
	//服务端获取预付订单的接口访问地址
	public static final String TESTPAY_URL="http://192.168.1.100:8080/pay/appPay";
	
}
