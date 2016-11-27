package com.javen205.jpaydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.javen205.jpay.IPay;
import com.javen205.jpay.entity.Order;

import mayihuijia.com.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void testJPay(View view){
        Toast.makeText(this, "测试", Toast.LENGTH_SHORT).show();

        Order order = new Order();
        order.setBody("会员充值中心");
        order.setParaTradeNo(System.currentTimeMillis()+"");
        order.setTotalFee(20);
        order.setAttach("json");//附加参数
        order.setNofityUrl("http://www.baidu.com");//支付成功服务端回调通知的地址

        IPay.getIntance(this).toTestPay(order,new IPay.IPayListener() {

            @Override
            public void onPay(int code) {
                System.out.println("回调过来的状态》"+code);
                if (code == 0){
                    //显示充值成功的页面和需要的操作
                }
                if (code == -1){
                    //错误
                }
                if (code == -2){
                    //用户取消
                }
                Toast.makeText(MainActivity.this, "回调过来的状态》" + code, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
