package ucucite.edu.getfits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class list extends AppCompatActivity {

    CheckBox Checkboxone,Checkboxtwo,Checkboxthree,Checkboxfour,checkboxfive;
    ToggleButton toggleButton;
    TextView dateset,timeset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Checkboxone=findViewById(R.id.Pizza);
        Checkboxtwo=findViewById(R.id.Burger);
        Checkboxthree=findViewById(R.id.Hotdog);
        Checkboxfour=findViewById(R.id.Noodle);
        toggleButton=findViewById(R.id.togglebt);
        checkboxfive=findViewById(R.id.pushup);

        dateset=findViewById(R.id.To_date);
        timeset=findViewById(R.id.To_Time);


        Intent intent1 = getIntent();
        String dates = intent1.getStringExtra("message1");
        String times = intent1.getStringExtra("message2");
        dateset.setText(dates);
        timeset.setText(times);


        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (!Checkboxone.isChecked()){
//
//                }
                if(!Checkboxone.isChecked() || !Checkboxtwo.isChecked() || !Checkboxthree.isChecked() || !Checkboxfour.isChecked() || !checkboxfive.isChecked()){
                    Toast.makeText(list.this, "Please Select before going to Proceed!", Toast.LENGTH_SHORT).show();
                }

                if (toggleButton.isChecked()){
                    Drawable drawable=getResources().getDrawable(R.drawable.buttongreen);
                    toggleButton.setBackgroundDrawable(drawable);
//                    int toatalAmount=0;
                    StringBuffer Result=new StringBuffer( );
                    Result.append("Selected:");
                    if (Checkboxone.isChecked()){
                        Result.append("\n 20 Body weight Squats");
//                        toatalAmount+=100;
//                        Intent intent = new Intent(list.this, Receipt.class);
//                        String dates = Checkboxone.getText().toString();
//                        intent.putExtra("messageone", dates);
//                        startActivity(intent);
                    }
                    if (Checkboxtwo.isChecked()){
                        Result.append("\n 30 Jumping Jacks");
//                        toatalAmount+=100;
                    }
                    if (Checkboxthree.isChecked()){
                        Result.append("\n 15 Seconds Planks");
//                        toatalAmount+=120;
                    }
                    if (Checkboxfour.isChecked()){
                        Result.append("\n 20 Leg Lifts");
//                        toatalAmount+=200;
                    }
                    if (checkboxfive.isChecked()){
                        Result.append("\n 10 Push Ups");
//                        toatalAmount+=200;
                    }
//                    Result.append("\nSave Successfully:"+toatalAmount+" ");
                    Result.append("\nSave Successfully!");
                    Toast.makeText(list.this,Result.toString(), Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(list.this, Receipt.class);
                    String resulta = Result.toString();
                    String dateq = dateset.getText().toString();
                    String timeq = timeset.getText().toString();
                    intent.putExtra("messageone", resulta);
                    intent.putExtra("messagetwo", dateq);
                    intent.putExtra("messagethree", timeq);
                    startActivity(intent);


                }

                else{
                    Drawable drawabletwo=getResources().getDrawable(R.drawable.button);
                    toggleButton.setBackgroundDrawable(drawabletwo);
                }
            }
        });
    }

    public void gonow(View view) {

    }
}