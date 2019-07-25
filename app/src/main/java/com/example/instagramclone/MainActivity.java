package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class MainActivity extends AppCompatActivity {
    private ImageView ivFacebook, ivTwitter, ivGoogle;
    private EditText etUserName, etPassword;
    private TextView tvSign;
    private Button btnLogin;
    private CheckBox cbRemember;
    private TextView getTe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getTe = findViewById(R.id.getTe);

        ivFacebook = findViewById(R.id.ivFacebook);
        ivGoogle = findViewById(R.id.ivGoogle);
        ivTwitter = findViewById(R.id.ivTwitter);

        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);

        tvSign = findViewById(R.id.tvSign);

        btnLogin = findViewById(R.id.btnLogin);

        cbRemember = findViewById(R.id.cbRemember);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ParseUser.logInInBackground(etUserName.getText().toString(),
                etPassword.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if(user!=null&& e==null)
                        {
                            FancyToast.makeText(MainActivity.this, user.get("username") + " is logged in succesfully", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
                        } else {
                            FancyToast.makeText(MainActivity.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                        }
                    }
                });
            }
        });

        ivFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.gmail.com"));
                startActivity(intent);
            }
        });

        ivGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.gmail.com"));
                startActivity(intent);
            }
        });

        ivTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.twitter.com"));
                startActivity(intent);
            }
        });

        tvSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.instagramclone.RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}


  /*  public void helloWorldTapped(View view)
    {
        ParseObject boxer = new ParseObject("Boxer");
        boxer.put("punch_speed", 200);
        boxer.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e == null)
                {
                    Toast.makeText(MainActivity.this,"Boxer object is saved successfully",Toast.LENGTH_SHORT).show();
                }

            }
        });*/

        /* ParseObject kickBoxer = new ParseObject("KickBoxer");
         kickBoxer.put("name","john");
         kickBoxer.put("punchSpeed",1000);
         kickBoxer.put("punchPower",400);
         kickBoxer.put("kickPower",100);
         kickBoxer.saveInBackground(new SaveCallback() {
             @Override
             public void done(ParseException e) {
                 if(e == null)
                 {
                     Toast.makeText(MainActivity.this,"Boxer object is saved successfully",Toast.LENGTH_SHORT).show();
                 }


             }
         });*/

   /* ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("KickBoxer");
                parseQuery.getInBackground("pPgk66eJT4", new GetCallback<ParseObject>() {
@Override
public void done(ParseObject object, ParseException e) {
        if(object!=null && e==null)
        {
        getTe.setText(object.get("name")+ "");
        }

        }
        });*/


