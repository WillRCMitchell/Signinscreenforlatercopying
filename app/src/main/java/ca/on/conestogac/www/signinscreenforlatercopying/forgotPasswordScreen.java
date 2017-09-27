package ca.on.conestogac.www.signinscreenforlatercopying;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class forgotPasswordScreen extends Fragment implements
        OnClickListener {
    private static View view;

    private static EditText emailId;
    private static TextView submit, back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_forgot_password_screen, container,
                false);
        initViews();
        setListeners();
        return view;
    }

    private void initViews() {
        emailId =  view.findViewById(R.id.registered_emailid);
        submit =  view.findViewById(R.id.forgot_button);
        back = view.findViewById(R.id.backToLoginBtn);
    }

    private void setListeners() {
        back.setOnClickListener(this);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backToLoginBtn:

                //REDIRECT TO LOGIN SCREEN
                break;

            case R.id.forgot_button:

                submitButtonTask();
                break;

        }

    }

    private void submitButtonTask() {
        String getEmailId = emailId.getText().toString();


        Pattern p = Pattern.compile(Utilities.regEx);

        Matcher m = p.matcher(getEmailId);

        if (getEmailId.equals("") || getEmailId.length() == 0)

            new customToastJava().Show_Toast(getActivity(), view,
                    "Please enter your Email Id.");

        else if (!m.find())
            new customToastJava().Show_Toast(getActivity(), view,
                    "Your Email Id is Invalid.");

        else
            Toast.makeText(getActivity(), "Get Forgot Password.",
                    Toast.LENGTH_SHORT).show();
    }
}
