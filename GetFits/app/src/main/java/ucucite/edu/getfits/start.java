package ucucite.edu.getfits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class start extends AppCompatActivity {

    EditText date_in;
    EditText time_in;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        date_in=findViewById(R.id.date_input);
        time_in=findViewById(R.id.time_input);


        date_in.setInputType(InputType.TYPE_NULL);
        time_in.setInputType(InputType.TYPE_NULL);


        date_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog(date_in);
            }
        });

        time_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimeDialog(time_in);
            }
        });


    }


    private void showTimeDialog(final EditText time_in) {
        final Calendar calendar=Calendar.getInstance();

        TimePickerDialog.OnTimeSetListener timeSetListener=new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//                calendar.setTimeZone(TimeZone.getTimeZone("GMT+8"));
//                calendar.setTimeZone(TimeZone.getTimeZone("etc/UTC"));
                calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
                calendar.set(Calendar.MINUTE,minute);
//                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm", Locale.getDefault());
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("hh:mm a");
                time_in.setText(simpleDateFormat.format(calendar.getTime()));
            }
        };

        new TimePickerDialog(start.this,timeSetListener,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false).show();
    }

    private void showDateDialog(final EditText date_in) {
        final Calendar calendar=Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
//                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yy-MM-dd");
//                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("MM-dd-yy");
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("MMM d, yyyy E");
                date_in.setText(simpleDateFormat.format(calendar.getTime()));

            }
        };

        new DatePickerDialog(start.this,dateSetListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    public void gotolist(View view) {
        String datein = date_in.getText().toString().trim();
        String timein = time_in.getText().toString().trim();

        if(TextUtils.isEmpty(datein)){
            date_in.setError("Set the Date!");
            return;
        }

        if(TextUtils.isEmpty(timein)){
            time_in.setError("Set the Time!");
            return;
        }

        Intent intent = new Intent(start.this, list.class);
        String dates = date_in.getText().toString();
        String times = time_in.getText().toString();
        intent.putExtra("message1", dates);
        intent.putExtra("message2", times);
        startActivity(intent);
    }
}