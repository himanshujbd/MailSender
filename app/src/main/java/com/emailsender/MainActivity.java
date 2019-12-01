package com.emailsender;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMail(View view)
    {
        new MailCreator().execute("");
    }

    public class MailCreator extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {

            try {

                MailSender sender = new MailSender(getBaseContext(), AppsConstants.SENDER_EMAIL,AppsConstants.SENDER_PASSWORD);
                sender.sendUserDetailWithImage("New User Added", "Hi", "Himanshu",
                        AppsConstants.RECIPEINT_MAIL, "Himanshu Verma", "xyz@gmail.com", "+91 6075959010", "02/02/1994", "25","New Delhi, India","");

            } catch (Exception e) {
                Log.e("SendMail", e.getMessage(), e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
//            Toast.makeText(getActivity(),"Mail Sent",Toast.LENGTH_LONG).show();
        }
    }
}
