package com.danijelcopic.example15dc.activities;


import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.danijelcopic.example15dc.R;
import com.danijelcopic.example15dc.model.Ingridient;
import com.danijelcopic.example15dc.provider.CategoryProvider;
import com.danijelcopic.example15dc.provider.JeloProvider;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class SecondActivity extends Activity {

    private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_relative);

        final int position = getIntent().getIntExtra("position", 0);


        //jelo slika
        ImageView ivImage = (ImageView) findViewById(R.id.iv_image_jelo);
        InputStream is = null;
        try {
            is = getAssets().open(JeloProvider.getJeloById(position).getImage());
            Drawable drawable = Drawable.createFromStream(is, null);
            ivImage.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // jelo naziv
        TextView jeloName = (TextView) findViewById(R.id.tv_name_jelo);
        jeloName.setText(JeloProvider.getJeloById(position).getName());

        // rating bar
        RatingBar rbRating = (RatingBar) findViewById(R.id.rb_rating);
        rbRating.setRating(JeloProvider.getJeloById(position).getRating());

        // jelo opis
        TextView jeloOpis = (TextView) findViewById(R.id.tv_destription_des);
        jeloOpis.setText(JeloProvider.getJeloById(position).getDescription());


        // spinner za kategoriju
        Spinner category = (Spinner) findViewById(R.id.sp_category);
        List<String> categories = CategoryProvider.getCategoryNames();
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, categories);
        category.setAdapter(adapter);
        category.setSelection((int) JeloProvider.getJeloById(position).getCategory2().getId());


        // jelo grupa
//        TextView jeloGrupa = (TextView) findViewById(R.id.tv_category_des);
//        jeloGrupa.setText(JeloProvider.getJeloById(position).getCategory());

        // jelo sastojci ... treba izmeniti i dodati ListView
//        TextView jeloSastojci = (TextView) findViewById(R.id.tv_ingridients_des);
//        jeloSastojci.setText(JeloProvider.getJeloById(position).getIngridients());

        ListView listView = (ListView) findViewById(R.id.lv_list_view);
        List<Ingridient> list = JeloProvider.getJeloById(position).getIngridients2();
        ArrayAdapter<String> adapter2 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter2);

        // jelo kalorije
        TextView jeloKalorije = (TextView) findViewById(R.id.tv_calorie_des);
        jeloKalorije.setText(JeloProvider.getJeloById(position).getCalory());

        // jelo cena
        TextView jeloCena = (TextView) findViewById(R.id.tv_price);
        String stringdouble = Double.toString(JeloProvider.getJeloById(position).getPrice());
        jeloCena.setText(stringdouble);

        // dugme za narucivanje
        Button btnBuy = (Button) findViewById(R.id.bt_button_order);
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(v.getContext(), "You've bought " + JeloProvider.getJeloById(position).getName() + "!", Toast.LENGTH_LONG);
                toast.show();
            }
        });

    }
}
