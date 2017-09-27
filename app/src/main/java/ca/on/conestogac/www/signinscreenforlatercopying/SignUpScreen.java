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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpScreen extends Fragment implements OnClickListener {
    private static View view;
    private static EditText fullName, emailId,
            password, confirmPassword;
    private static TextView login;
    private static Button signUpButton;
    private static CheckBox terms_conditions;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_sign_up_screen, container, false);
        initViews();
        setListeners();
        return view;
    }

    private void initViews() {
        fullName =  view.findViewById(R.id.fullName);
        emailId =  view.findViewById(R.id.userEmailId);
        password =  view.findViewById(R.id.password);
        confirmPassword =  view.findViewById(R.id.confirmPassword);
        signUpButton =  view.findViewById(R.id.signUpBtn);
        login =  view.findViewById(R.id.already_user);
        terms_conditions =  view.findViewById(R.id.terms_conditions);}

    private void setListeners() {
        signUpButton.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signUpBtn:

                checkValidation();
                break;

            case R.id.already_user:
            //REDIRECT TO LOGIN SCREEN
                break;
        }

    }

    private void checkValidation() {

        String getFullName = fullName.getText().toString();
        String getEmailId = emailId.getText().toString();
        String getPassword = password.getText().toString();
        String getConfirmPassword = confirmPassword.getText().toString();

        Pattern p = Pattern.compile(Utilities.regEx);
        Matcher m = p.matcher(getEmailId);

        if (getFullName.equals("") || getFullName.length() == 0
                || getEmailId.equals("") || getEmailId.length() == 0
                || getPassword.equals("") || getPassword.length() == 0
                || getConfirmPassword.equals("")
                || getConfirmPassword.length() == 0)

            new customToastJava().Show_Toast(getActivity(), view,
                    "All fields are required.");

        else if (!m.find())
            new customToastJava().Show_Toast(getActivity(), view,
                    "Your Email Id is Invalid.");

        else if (!getConfirmPassword.equals(getPassword))
            new customToastJava().Show_Toast(getActivity(), view,
                    "Both password doesn't match.");

        else if (!terms_conditions.isChecked())
            new customToastJava().Show_Toast(getActivity(), view,
                    "Please select Terms and Conditions.");

        else
            Toast.makeText(getActivity(), "Do SignUp.", Toast.LENGTH_SHORT)
                    .show();

    }
}