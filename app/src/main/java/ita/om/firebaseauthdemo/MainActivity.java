package ita.om.firebaseauthdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
EditText userId, password;
FirebaseAuth auth;
FirebaseDatabase database;
private Button signin;
    private FirebaseAuth mAuth;
    private EditText inputEmail, inputPassword,currentUser;
    private Button btnSignup, btnSignin, btnReset;


    @Override
   public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        userId=(EditText) findViewById(R.id.name);
        password=(EditText) findViewById(R.id.password);
        auth= FirebaseAuth.getInstance();
        final Button signin= (Button) findViewById(R.id.signin);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }

    public void onClickSignin(View view) {
        String user= userId.getText().toString().trim();
        String pass= password.getText().toString().trim();
        
    }


    public void onClickSignup(View view) {
        String user= userId.getText().toString().trim();
        String pass= password.getText().toString().trim();
        if(TextUtils.isEmpty(user)){
            Toast.makeText(this, "Provide User ID", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pass)){
            Toast.makeText(this, "Provide User Password", Toast.LENGTH_SHORT).show();
            return;
        }
        if(pass.length()<6){
            Toast.makeText(this, "Password Should Be More Thane six Character ", Toast.LENGTH_SHORT).show();
            return;
        }
        auth.createUserWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                  String str = auth.getCurrentUser().toString();
                    Log.d("Current User is: ", str);
                }
                else {
                    Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_SHORT);
                }
            }
        });
    }
}
