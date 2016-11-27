package xxx.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.LinearLayout;

import com.javen205.jpay.IPay;
import com.javen205.jpay.utils.Constants;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler{
    private IWXAPI api;
	private IPay.IPayListener payListener;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题
        LinearLayout ll = new LinearLayout(this);
        setContentView(ll);
    	api = WXAPIFactory.createWXAPI(this, Constants.APP_ID);
        api.handleIntent(getIntent(), this);
        finish();
    }

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		setIntent(intent);
        api.handleIntent(intent, this);
	}

	@Override
	public void onReq(BaseReq req) {
	}

	@Override
	public void onResp(BaseResp resp) {
		payListener = Constants.payListener;
		int code = resp.errCode;  
		System.out.println("onResp errCode>"+code);
		if (payListener!=null) {
			payListener.onPay(code);
			System.out.println("payListener callback");
		}else {
			System.out.println("payListener not callback");
		}
	}
}