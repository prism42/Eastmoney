package com.tkid.eastmoney.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.tkid.eastmoney.R;

/**
 * author : Prism
 * Believe and act as if it were impossible to fail.
 * 心怀不败之志，脚踏不凡之路.
 * He who has a why to live can bear almost any how.
 * 知生命之意者，亦可承其重.
 * desc   :
 */
public class AmountView extends LinearLayout implements View.OnClickListener, TextWatcher {

    private static final String TAG = "AmountView";

    private double amount = 0; //数量

    private double goods_storage = 99999999999L; //库存数

    private OnAmountChangeListener mListener; //数量变化的回调接口

    private EditText etAmount;//数量

    private ImageButton btnDecrease;//-按钮
    private ImageButton iBtnDelete;//删除按钮

    private ImageButton btnIncrease;//+按钮

    public AmountView(Context context) {

        this(context, null);

    }
//构造方法

    public AmountView(Context context, AttributeSet attrs) {

        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.view_amount, this);

        etAmount = findViewById(R.id.etAmount);

        btnDecrease = findViewById(R.id.btnDecrease);

        iBtnDelete = findViewById(R.id.iBtnDelete);

        btnIncrease = findViewById(R.id.btnIncrease);

        btnDecrease.setOnClickListener(this);

        btnIncrease.setOnClickListener(this);
        iBtnDelete.setOnClickListener(this);

        etAmount.addTextChangedListener(this);

        //, AmountView_btnWidth, AmountView_tvWidth, AmountView_tvTextSize, AmountView_btnTextSize  ，是res/Values下的定义的  attrs.xml 内容，分别代表左右2边+-按钮的宽度 ，中间TextView的宽度，字体大小，btnTextSize

        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.AmountView);

        int btnWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AmountView_btnWidth, LayoutParams.WRAP_CONTENT);
        int btnHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AmountView_btnHeight, LayoutParams.MATCH_PARENT);

        int tvWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AmountView_tvWidth, 80);

        int tvTextSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AmountView_tvTextSize, 0);

        int btnTextSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AmountView_btnTextSize, 0);

        obtainStyledAttributes.recycle();
        Log.e("测试", "高度" + btnHeight);

        LayoutParams btnParams = new LayoutParams(btnWidth, LayoutParams.MATCH_PARENT);

        btnDecrease.setLayoutParams(btnParams);

        btnIncrease.setLayoutParams(btnParams);

        LayoutParams textParams = new LayoutParams(0, LayoutParams.MATCH_PARENT, 1.0f);

        etAmount.setLayoutParams(textParams);

        if (tvTextSize != 0) {

            etAmount.setTextSize(tvTextSize);

        }

    }

    //数量变化的回调接口

    public void setOnAmountChangeListener(OnAmountChangeListener onAmountChangeListener) {

        this.mListener = onAmountChangeListener;

    }

    //设置库存数量

    public void setGoods_storage(double goods_storage) {

        this.goods_storage = goods_storage;

    }

//加减按钮的点击事件，当数值改变时，调用OnAmountChangeListener回调接口

    @Override

    public void onClick(View v) {

        int i = v.getId();

        if (i == R.id.btnDecrease) {
            if (TextUtils.isEmpty(etAmount.getText().toString().trim())) {
                return;
            }

            if (amount > 0) {

                amount -= 0.01;

                etAmount.setText(String.format("%.2f", amount));

            }

        } else if (i == R.id.btnIncrease) {
            if (TextUtils.isEmpty(etAmount.getText().toString().trim())) {
                return;
            }
            if (amount < goods_storage) {

                amount += 0.01;

                etAmount.setText(String.format("%.2f", amount));

            }

        } else if (i == R.id.iBtnDelete) {
            etAmount.setText("");
        }

        etAmount.clearFocus();


        if (mListener != null) {

            mListener.onAmountChange(this, amount);

        }

    }

    @Override

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override

    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override

    public void afterTextChanged(Editable s) {
        if (TextUtils.isEmpty(s)) {
//            etAmount.setGravity(Gravity.CENTER_VERTICAL);
            iBtnDelete.setVisibility(GONE);
        } else {
//            etAmount.setGravity(Gravity.CENTER);
            iBtnDelete.setVisibility(VISIBLE);
            etAmount.setSelection(s.length());
        }

        if (s.toString().isEmpty()) {
            return;
        }

        amount = Double.valueOf(s.toString());

        if (amount > goods_storage) {
            etAmount.setText(String.format("%.2f", goods_storage));
            return;

        }

        if (mListener != null) {

            mListener.onAmountChange(this, amount);

        }

    }

    public interface OnAmountChangeListener {

        void onAmountChange(View view, double amount);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // 宽模式
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        // 宽大小
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        // 宽模式
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        // 宽大小
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        Log.e("测试", "" + widthMode + " " + widthSize + " " + heightMode + " " + heightSize);
        // 高大小
//        int heightSize;
//        // 只有宽的值是精确的才对高做精确的比例校对
//        if (widthMode == MeasureSpec.EXACTLY && mRatio > 0) {
//            heightSize = (int) (widthSize / mRatio + 0.5f);
//            heightMeasureSpec = MeasureSpec.makeMeasureSpec(heightSize,
//                    MeasureSpec.EXACTLY);
//        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        btnDecrease.setMinimumWidth(heightSize);
        btnDecrease.setMinimumHeight(heightSize);
        btnIncrease.setMinimumWidth(heightSize);
        btnIncrease.setMinimumHeight(heightSize);
    }
}
