package com.roysoft.localization;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvLang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         tvLang = findViewById(R.id.tv_lang);

         String lang = LocaleHelper.getPersistedData(this,null);
         if(lang == null){

             LocaleHelper.persist(this,"en");
         }

         //updateView(LocaleHelper.getPersistedData(this,null));

    }

    public void updateView(String lang){

        Context context = LocaleHelper.setLocale(this,lang);
        // tvLang.setText(context.getResources().getString(R.string.hello));

        startActivity(new Intent(this,MainActivity.class));
        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase,"en"));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.lang_en){

            LocaleHelper.persist(this,"en");
            updateView(LocaleHelper.getPersistedData(this,null));

        }

        else if (item.getItemId() == R.id.lang_hindi){

            LocaleHelper.persist(this,"hi");
            updateView(LocaleHelper.getPersistedData(this,null));

        }


        return super.onOptionsItemSelected(item);
    }
}