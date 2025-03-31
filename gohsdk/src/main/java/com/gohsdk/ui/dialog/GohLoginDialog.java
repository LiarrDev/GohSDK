package com.gohsdk.ui.dialog;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.gohsdk.utils.ResourceUtil;

public class GohLoginDialog extends GohBaseDialog {

    private boolean isRegister = false;     // 登录还是注册
    private RadioGroup radioGroup;
    private RadioButton rbAccount, rbSms;
    private View accountLoginLayout, accountRegisterLayout, smsLoginLayout;
    private EditText etLoginAccount, etLoginPassword, etRegisterAccount, etRegisterPassword, etMobile, etSmsCode;
    private Button btnAccountLogin, btnAccountRegister, btnGetSms, btnSmsLogin;
    private TextView tvAccountRegister, tvAccountLogin;

    public GohLoginDialog(Context context) {
        super(context);
    }

    @Override
    protected void initViews(View rootView) {
        initComponents(rootView);
        radioGroup.setOnCheckedChangeListener((new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == rbAccount.getId()) {
                    if (isRegister) {
                        showAccountRegisterLayout();
                    } else {
                        showAccountLoginLayout();
                    }
                } else if (checkedId == rbSms.getId()) {
                    showSmsLoginLayout();
                }
            }
        }));
        radioGroup.check(rbAccount.getId());

        btnAccountLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doAccountLogin();
            }
        });
        tvAccountRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRegister = true;
                rbAccount.setText("账号注册");
                showAccountRegisterLayout();
            }
        });

        btnAccountRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doAccountRegister();
            }
        });
        tvAccountLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRegister = false;
                rbAccount.setText("账号登录");
                showAccountLoginLayout();
            }
        });

        btnGetSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSmsCode();
            }
        });
        btnSmsLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doSmsLogin();
            }
        });
    }

    private void doAccountLogin() {
        String account = etLoginAccount.getText().toString();
        String password = etLoginPassword.getText().toString();
        if (account.length() < 6 || password.length() < 6) {
            // TODO: 提示
            return;
        }
        // TODO: 账号登录
    }

    private void doAccountRegister() {
        String account = etRegisterAccount.getText().toString();
        String password = etRegisterPassword.getText().toString();
        if (account.length() < 6 || password.length() < 6) {
            // TODO: 提示
            return;
        }
        // TODO: 账号注册
    }

    private void getSmsCode() {
        String mobile = etMobile.getText().toString();
        if (mobile.isEmpty()) {
            // TODO: 提示
            return;
        }
        // TODO: 获取验证码
    }

    private void doSmsLogin() {
        String mobile = etMobile.getText().toString();
        String smsCode = etSmsCode.getText().toString();
        if (mobile.isEmpty() || smsCode.isEmpty()) {
            // TODO: 提示
            return;
        }
        // TODO: 验证码登录
    }

    private void showAccountLoginLayout() {
        accountLoginLayout.setVisibility(View.VISIBLE);
        accountRegisterLayout.setVisibility(View.GONE);
        smsLoginLayout.setVisibility(View.GONE);
    }

    private void showSmsLoginLayout() {
        accountLoginLayout.setVisibility(View.GONE);
        accountRegisterLayout.setVisibility(View.GONE);
        smsLoginLayout.setVisibility(View.VISIBLE);
    }

    private void showAccountRegisterLayout() {
        accountLoginLayout.setVisibility(View.GONE);
        accountRegisterLayout.setVisibility(View.VISIBLE);
        smsLoginLayout.setVisibility(View.GONE);
    }

    @Override
    protected String getLayoutName() {
        return "goh_dialog_login";
    }

    private void initComponents(View rootView) {
        radioGroup = rootView.findViewById(ResourceUtil.getViewId("radio_group"));
        rbAccount = rootView.findViewById(ResourceUtil.getViewId("rb_account"));
        rbSms = rootView.findViewById(ResourceUtil.getViewId("rb_sms"));

        accountLoginLayout = rootView.findViewById(ResourceUtil.getViewId("layout_account_login"));
        etLoginAccount = rootView.findViewById(ResourceUtil.getViewId("et_login_account"));
        etLoginPassword = rootView.findViewById(ResourceUtil.getViewId("et_login_password"));
        btnAccountLogin = rootView.findViewById(ResourceUtil.getViewId("btn_account_login"));
        tvAccountRegister = rootView.findViewById(ResourceUtil.getViewId("tv_account_register"));

        accountRegisterLayout = rootView.findViewById(ResourceUtil.getViewId("layout_account_register"));
        etRegisterAccount = rootView.findViewById(ResourceUtil.getViewId("et_register_account"));
        etRegisterPassword = rootView.findViewById(ResourceUtil.getViewId("et_register_password"));
        btnAccountRegister = rootView.findViewById(ResourceUtil.getViewId("btn_account_register"));
        tvAccountLogin = rootView.findViewById(ResourceUtil.getViewId("tv_account_login"));

        smsLoginLayout = rootView.findViewById(ResourceUtil.getViewId("layout_sms_login"));
        etMobile = rootView.findViewById(ResourceUtil.getViewId("et_mobile"));
        etSmsCode = rootView.findViewById(ResourceUtil.getViewId("et_sms_code"));
        btnGetSms = rootView.findViewById(ResourceUtil.getViewId("btn_get_sms"));
        btnSmsLogin = rootView.findViewById(ResourceUtil.getViewId("btn_sms_login"));
    }
}
