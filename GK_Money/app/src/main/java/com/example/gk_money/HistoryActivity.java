package com.example.gk_money;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.gk_money.Adapters.AdapterHistory;
import com.example.gk_money.Models.History;
import com.example.gk_money.Ultils.CurrencySQLiteHelpers;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    private ImageView btnBack;
    private ListView lsvHistory;
    private AdapterHistory adapterHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        CurrencySQLiteHelpers helpers = new CurrencySQLiteHelpers(this);
        ArrayList<History> histories = helpers.getList();

        lsvHistory = findViewById(R.id.lsvHistory);
        adapterHistory = new AdapterHistory(this, R.layout.item_history, histories);
        lsvHistory.setAdapter(adapterHistory);

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(e -> {
            finish();
        });
    }
}