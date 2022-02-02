package ucucite.edu.getfits;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

    }

    public void start(View view) {
        Intent intent = new Intent(this,start.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.logout){
//            Intent intent = new Intent(homepage.this, MainActivity.class);
//            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            startActivity(intent);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
//        alertDialogBuilder.setMessage("Are you sure you want to Exit?");
                alertDialogBuilder.setMessage(Html.fromHtml("<font color='#000000'>Are you sure you want to Log-Out?</font>"));
                alertDialogBuilder.setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {

                                Intent intent = new Intent(homepage.this, MainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                            }
                        });

                alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        return super.onOptionsItemSelected(item);
        }





    public void aboutus(View view) {
            new AlertDialog.Builder(homepage.this)
                    .setTitle(Html.fromHtml("<font color='#000000'>GetFits Developers</font>"))
                    .setMessage(Html.fromHtml("<center><font color='#000000'>Richmond S. Guerrero</font>" + "<br>" +
                            "<font color='#000000'>Harold Aquino</font>" + "<br>" ))
//                            "<font color='#000000'>Christian F. Alavazo</font>" + "<br>" +
//                            "<font color='#000000'>Christian F. Alavazo</font>"))
                    .setIcon(R.drawable.getfit)
                    .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
//
                            dialog.cancel();
                        }
                    }).show();
        }


    public void profile(View view) {
        Intent intent = new Intent(this,ProfileActivity.class);
        startActivity(intent);
    }


    //    backpressed button
    @Override
    public void onBackPressed() {
        exitbackpressed();
    }

    //Alert Dialog of Back pressed
    private void exitbackpressed() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
//        alertDialogBuilder.setMessage("Are you sure you want to Exit?");
        alertDialogBuilder.setMessage(Html.fromHtml("<font color='#000000'>Are you sure you want to Log-Out?</font>"));
        alertDialogBuilder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                        Intent intent = new Intent(homepage.this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
                });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }


}