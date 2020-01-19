package com.example.fae;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static com.example.fae.FB.refUsers;


public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText etpNumber,eteAddress;
    Intent t;
    Boolean status;
    FirebaseAuth fbAuth;
    Users userdb;
    TextView tVuidview;
    Switch switch1;
    CheckBox cBconnectview;
    String stEmail,stPhone,uid;
    String popup1 = "Email:Pass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn); // Register Button
        eteAddress = (EditText) findViewById(R.id.et1); // Email Address
        etpNumber = (EditText) findViewById(R.id.et2); // Phone Number
        fbAuth = FirebaseAuth.getInstance();
        cBconnectview=(CheckBox)findViewById(R.id.cBconnectview);
    }
    public void OnStart() {
        super.onStart();
        FirebaseUser user = fbAuth.getCurrentUser();
//        name = user.getDisplayName();
//        tVnameview.setText(name);
        stEmail = user.getEmail();
        uid = user.getUid();
        tVuidview.setText(uid);
        SharedPreferences settings=getSharedPreferences("PREFS_NAME",MODE_PRIVATE);
        Boolean isChecked=settings.getBoolean("stayConnect",false);
        cBconnectview.setChecked(isChecked);
    }
    public void update(View view) {
        FirebaseUser user = fbAuth.getCurrentUser();
        if (!cBconnectview.isChecked()){
            fbAuth.signOut();
        }
        SharedPreferences settings=getSharedPreferences("PREFS_NAME",MODE_PRIVATE);
        SharedPreferences.Editor editor=settings.edit();
        editor.putBoolean("stayConnect",cBconnectview.isChecked());
        editor.commit();
        finish();
    }

    public void Register(View view){
        stEmail = eteAddress.getText().toString();
        stPhone = etpNumber.getText().toString();
        Toast.makeText(this, stEmail+stPhone, Toast.LENGTH_SHORT).show();
        FirebaseUser user = fbAuth.getCurrentUser();
        if (Switch.isChecked()) {
            status = true;
        }
        else status = false;
        userdb = new Users(stEmail,stPhone,uid);
        if (status) refUsers.child("Teachers").child(stEmail).setValue()
        fbAuth.createUserWithEmailAndPassword(stEmail, stPhone)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(popup1, "createUserWithEmail:success");
                            FirebaseUser user = fbAuth.getCurrentUser();
                        }
                    }
                });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String s= item.getTitle().toString();
        t=new Intent(this, MainActivity.class);
        if (s.equals("Authentication")){
            t=new Intent(this, MainActivity.class);
            startActivity(t);}

        if (s.equals("Database")){
            t=new Intent(this, Main2Activity.class);
            startActivity(t);
        }
        if (s.equals("Storage")){
            t=new Intent(this, Main3Activity.class);
            startActivity(t);
        }
        return super.onOptionsItemSelected(item);
    }
}
