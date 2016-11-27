package com.javen205.jpay;

import android.content.Context;
import android.widget.Toast;

import com.javen205.jpay.asyncTask.TestPayPrepay;
import com.javen205.jpay.entity.Order;
import com.javen205.jpay.service.IPayLogic;
import com.javen205.jpay.utils.Constants;


public class IPay {
	private static  IPay mIPay;
	private Context mContext;
	
	private IPay(Context context) {
		mContext = context;
	}
	
	
	
	public static IPay getIntance(Context context){
		if (mIPay == null) {
			synchronized(IPay.class){
				if (mIPay == null) {
					mIPay = new IPay(context);
				}
			}
		}
		return mIPay;
	}
	//支付结果回调
	public interface IPayListener{
		void onPay(int code);
	}


	/**
	 * WX支付入口
	 * @param order
	 * @param listener
     */
	public void toTestPay(Order order, IPayListener listener){
		if (order != null) {
			if (IPayLogic.getIntance(mContext.getApplicationContext()).isWeixinAvilible()) {
				Constants.payListener = listener;
				new TestPayPrepay(mContext).execute(order);
			}else {
				Toast.makeText(mContext, "未安装微信", Toast.LENGTH_LONG).show();
			}
		}else {
			Toast.makeText(mContext, "参数异常 order is null", Toast.LENGTH_LONG).show();
		}
	}
	
}
