package com.javen205.demo.ui.activities;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.javen205.demo.R;
import com.javen205.utils.ImageUtils;
import com.javen205.utils.SizeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * <pre>
 *     desc  : Image工具类测试
 * </pre>
 */
public class ImageActivity extends Activity {

    @BindView(R.id.iv_src)
    ImageView ivSrc;
    @BindView(R.id.iv_view2Bitmap)
    ImageView ivView2Bitmap;
    @BindView(R.id.iv_round)
    ImageView ivRound;
    @BindView(R.id.iv_round_corner)
    ImageView ivRoundCorner;
    @BindView(R.id.iv_fast_blur)
    ImageView ivFastBlur;
    @BindView(R.id.iv_render_script_blur)
    ImageView ivRenderScriptBlur;
    @BindView(R.id.iv_stack_blur)
    ImageView ivStackBlur;
    @BindView(R.id.iv_add_frame)
    ImageView ivAddFrame;
    @BindView(R.id.iv_add_reflection)
    ImageView ivAddReflection;
    @BindView(R.id.iv_add_text_watermark)
    ImageView ivAddTextWatermark;
    @BindView(R.id.iv_add_image_watermark)
    ImageView ivAddImageWatermark;
    @BindView(R.id.iv_gray)
    ImageView ivGray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ButterKnife.bind(this);

        Bitmap src = ImageUtils.getBitmap(getResources(), R.drawable.lena);
        Bitmap watermark = ImageUtils.getBitmap(getResources(), R.mipmap.ic_launcher);

        SizeUtils.forceGetViewSize(ivSrc, new SizeUtils.onGetSizeListener() {
            @Override
            public void onGetSize(View view) {
                ivView2Bitmap.setImageBitmap(ImageUtils.view2Bitmap(ivSrc));
            }
        });
        ivRound.setImageBitmap(ImageUtils.toRound(src));
        ivRoundCorner.setImageBitmap(ImageUtils.toRoundCorner(src, 60));
        ivFastBlur.setImageBitmap(ImageUtils.fastBlur(this, src, 0.1f, 5));
        ivRenderScriptBlur.setImageBitmap(ImageUtils.renderScriptBlur(this, src, 10));
        src = ImageUtils.getBitmap(getResources(), R.drawable.lena);
        ivStackBlur.setImageBitmap(ImageUtils.stackBlur(src, 10, false));
        ivAddFrame.setImageBitmap(ImageUtils.addFrame(src, 16, Color.GREEN));
        ivAddReflection.setImageBitmap(ImageUtils.addReflection(src, 80));
        ivAddTextWatermark.setImageBitmap(ImageUtils.addTextWatermark(src, "blankj", 40, 0x8800ff00, 0, 0));
        ivAddImageWatermark.setImageBitmap(ImageUtils.addImageWatermark(src, watermark, 0, 0, 0x88));
        ivGray.setImageBitmap(ImageUtils.toGray(src));
    }
}