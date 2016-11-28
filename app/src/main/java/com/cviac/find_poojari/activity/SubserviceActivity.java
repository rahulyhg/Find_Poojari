package com.cviac.find_poojari.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.cviac.find_poojari.R;
import com.cviac.find_poojari.adapter.ServiceinfoAdapter;
import com.cviac.find_poojari.datamodel.ServiceInfo;

import java.util.List;

public class SubserviceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subservice);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        ServiceInfo child = (ServiceInfo) i.getSerializableExtra("child");
        setTitle(child.getServiceNAME());

        ServiceinfoAdapter adapter;
        adapter = new ServiceinfoAdapter(SubserviceActivity.this, R.layout.program_list, child.getSublist());
        final ListView lv = (ListView) findViewById(R.id.subservicelist);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent det = new Intent(SubserviceActivity.this, ServicedetailsActivity.class);
                startActivity(det);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
}
