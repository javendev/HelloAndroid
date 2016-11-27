package com.javen205.jpay.service;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.widget.Toast;

import com.javen205.jpay.entity.Order;
import com.javen205.jpay.utils.Constants;
import com.javen205.jpay.utils.HttpKit;
import com.tencent.mm.sdk.constants.Build;
import com.tencent.mm.sdk.modelpay.PayReq;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

import java.util.List;


public class IPayLogic {
	private static  IPayLogic mIPayLogic;
	private Context mContext;
	
	private IPayLogic(Context context) {
		mContext = context;
	}
	
	public static IPayLogic getIntance(Context context){
		if (mIPayLogic == null) {
			synchronized(IPayLogic.class){
				if (mIPayLogic == null) {
					mIPayLogic = new IPayLogic(context);
				}
			}
		}
		return mIPayLogic;
	}


    /**
	 * 测试获取预付订单  如需参数自行添加
	 * @return
     */
	public String testPay(Order order){
		String result=HttpKit.get(Constants.TESTPAY_URL);
		return result;
	}
	
	/**
	 * 调起支付
	 * @param appId
	 * @param partnerId
	 * @param prepayId
	 * @param nonceStr
	 * @param timeStamp
	 * @param sign
	 */
	public void startWXPay(String appId,String partnerId,String prepayId,
			String nonceStr,String timeStamp,String sign){

		IWXAPI api= WXAPIFactory.createWXAPI(mContext, null);
		api.registerApp(appId);
		
		boolean isPaySupported = api.getWXAppSupportAPI() >= Build.PAY_SUPPORTED_SDK_INT;
		if (!isPaySupported) {
			Toast.makeText(mContext, "请更新微信客户端", Toast.LENGTH_SHORT).show();
			return;
		}
		
		PayReq request = new PayReq();
		request.appId = appId;
		request.partnerId = partnerId;
		request.prepayId= prepayId;
		request.packageValue = "Sign=WXPay";
		request.nonceStr=nonceStr;
		request.timeStamp= timeStamp;
		request.sign= sign;
		api.sendReq(request);
	}

	
	/**
	 * 判断微信是否安装
	 * @return
	 */
	 public  boolean isWeixinAvilible() {
	        final PackageManager packageManager = mContext.getPackageManager();// 获取packagemanager
	        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);// 获取所有已安装程序的包信息
	        if (pinfo != null) {
	            for (int i = 0; i < pinfo.size(); i++) {
	                String pn = pinfo.get(i).packageName;
	                if (pn.equals("com.tencent.mm")) {
	                    return true;
	                }
	            }
	        }
	        return false;
	    }

}
