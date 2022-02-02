package ucucite.edu.getfits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Receipt extends AppCompatActivity {
    TextView resibo,banner2,getBanner3;

    Button homenow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        resibo=findViewById(R.id.bannerko);
        banner2=findViewById(R.id.bannerko2);
        getBanner3=findViewById(R.id.bannerko3);
        homenow=findViewById(R.id.homenow);

        Intent intent = getIntent();
        String as = intent.getStringExtra("messageone");
        String two = intent.getStringExtra("messagetwo");
        String three = intent.getStringExtra("messagethree");
        resibo.setText(as);
        banner2.setText(two);
        getBanner3.setText(three);

        homenow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(Receipt.this, homepage.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }
}