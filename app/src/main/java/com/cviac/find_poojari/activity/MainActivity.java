package com.cviac.find_poojari.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.*;

import com.cviac.find_poojari.adapter.ServiceinfoAdapter;
import com.cviac.find_poojari.R;
import com.cviac.find_poojari.datamodel.ServiceInfo;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    GridView grid;
    ServiceInfo root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Pooja Services");
        loadServices();

        ServiceinfoAdapter adapter = new ServiceinfoAdapter(MainActivity.this,R.layout.grid_single,root.getSublist());
        grid = (GridView) findViewById(R.id.gridview12);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                ServiceInfo child = root.getSublist().get(i);

                Intent ssa = new Intent(MainActivity.this,
                        SubserviceActivity.class);
                ssa.putExtra("child",child);
                startActivity(ssa);
            }
        });



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
//            Toast.makeText(MainActivity.this,"You Clicked @home", Toast.LENGTH_LONG).show();
        }
        else if (id == R.id.nav_gallery) {

            Intent photo=new Intent(MainActivity.this, PhotosActivity.class);
            startActivity(photo);
//            Toast.makeText(MainActivity.this,"You Clicked @Photos", Toast.LENGTH_LONG).show();
        }
        else if (id == R.id.nav_videos) {

            Intent video=new Intent(MainActivity.this, VideosActivity.class);
            startActivity(video);
//            Toast.makeText(MainActivity.this,"You Clicked @Videos", Toast.LENGTH_LONG).show();
        }
        else if (id == R.id.nav_contactus) {

            Intent call=new Intent(MainActivity.this, ContactActivity.class);
            startActivity(call);
//            Toast.makeText(MainActivity.this,"You Clicked @Contact us", Toast.LENGTH_LONG).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void loadServices(){

        root=new ServiceInfo(0,"root");

        ServiceInfo ch1=new ServiceInfo(R.mipmap.grid,"SMARTHAM");
        root.add(ch1);

        ServiceInfo ch11=new ServiceInfo(R.mipmap.grid,"MARRIAGE");
        ch1.add(ch11);
        ServiceInfo ch12=new ServiceInfo(R.mipmap.grid,"UPANAYANAM");
        ch1.add(ch12);
        ServiceInfo ch13=new ServiceInfo(R.mipmap.grid,"NAMAKARANAM");
        ch1.add(ch13);
        ServiceInfo ch14=new ServiceInfo(R.mipmap.grid,"ANNAPRASANA");
        ch1.add(ch14);
        ServiceInfo ch15=new ServiceInfo(R.mipmap.grid,"GRUHAPRAVESHAM");
        ch1.add(ch15);
        ServiceInfo ch16=new ServiceInfo(R.mipmap.grid,"VAASTHU POOJA");
        ch1.add(ch16);
        ServiceInfo ch17=new ServiceInfo(R.mipmap.grid,"GANAPTHI HOMAM");
        ch1.add(ch17);
        ServiceInfo ch18=new ServiceInfo(R.mipmap.grid,"RUDRA HOMAM");
        ch1.add(ch18);
        ServiceInfo ch19=new ServiceInfo(R.mipmap.grid,"AYUSH HOMAM ");
        ch1.add(ch19);
        ServiceInfo ch110=new ServiceInfo(R.mipmap.grid,"MONTHLY /ANNUAL CERMONIES(ABDIKAM)");
        ch1.add(ch110);

        ServiceInfo ch2=new ServiceInfo(R.mipmap.grid,"POOJAS & VRATALU");
        root.add(ch2);

        ServiceInfo ch21=new ServiceInfo(R.mipmap.grid,"SATYANARAYANA VRATAM");
        ch2.add(ch21);
        ServiceInfo ch22=new ServiceInfo(R.mipmap.grid,"VARALAKSHMI VRATAM");
        ch2.add(ch22);
        ServiceInfo ch23=new ServiceInfo(R.mipmap.grid,"GANAPATHI POOJA");
        ch2.add(ch23);
        ServiceInfo ch24=new ServiceInfo(R.mipmap.grid,"DURGA POOJA");
        ch2.add(ch24);
        ServiceInfo ch25=new ServiceInfo(R.mipmap.grid,"GANESH NAVARATRULU");
        ch2.add(ch25);
        ServiceInfo ch26=new ServiceInfo(R.mipmap.grid,"DURGA NAVARATRULU");
        ch2.add(ch26);
        ServiceInfo ch27=new ServiceInfo(R.mipmap.grid,"NAVAGRAHA SHANTHI");
        ch2.add(ch27);
        ServiceInfo ch28=new ServiceInfo(R.mipmap.grid,"NAVAGRAHA JAPAM");
        ch2.add(ch28);
        ServiceInfo ch29=new ServiceInfo(R.mipmap.grid,"HOMALU & ABHISHEKALU");
        ch2.add(ch29);

        ServiceInfo ch3=new ServiceInfo(R.mipmap.grid,"ASTROLOGY/JYOTHISH");
        root.add(ch3);

        ServiceInfo ch31=new ServiceInfo(R.mipmap.grid,"PREPARING HOROSCOPE");
        ch3.add(ch31);
        ServiceInfo ch32=new ServiceInfo(R.mipmap.grid,"STUDYING HOROSCOPE");
        ch3.add(ch32);
        ServiceInfo ch33=new ServiceInfo(R.mipmap.grid,"SUGGEST REMEDIES");
        ch3.add(ch33);
        ServiceInfo ch34=new ServiceInfo(R.mipmap.grid,"MATCHING HOROSCOPES FOR MARRIAGE");
        ch3.add(ch34);

        ServiceInfo ch4=new ServiceInfo(R.mipmap.grid,"VAASTHU");
        root.add(ch4);

        ServiceInfo ch41=new ServiceInfo(R.mipmap.grid,"STUDYING THE SITE OR HOUSE PLAN");
        ch4.add(ch41);
        ServiceInfo ch42=new ServiceInfo(R.mipmap.grid,"SUGGEST REMEDIES");
        ch4.add(ch42);

        ServiceInfo ch5=new ServiceInfo(R.mipmap.grid,"APARAM");
        root.add(ch5);

        ServiceInfo ch51=new ServiceInfo(R.mipmap.grid,"DEATH CEREMONY");
        ch5.add(ch51);
        ServiceInfo ch52=new ServiceInfo(R.mipmap.grid,"ALL KARMA KANDALU - 1-12 DAYS CEREMONY ");
        ch5.add(ch52);
        ServiceInfo ch53=new ServiceInfo(R.mipmap.grid,"MONTHLY /ANNUAL CERMONIES(ABDIKAM)");
        ch5.add(ch53);

        ServiceInfo ch6=new ServiceInfo(R.mipmap.grid,"OTHERS");
        root.add(ch6);

        ServiceInfo ch61=new ServiceInfo(R.mipmap.grid,"ALL TEMPLE RELATED POOJALU");
        ch6.add(ch61);
        ServiceInfo ch62=new ServiceInfo(R.mipmap.grid,"PRATISHTA");
        ch6.add(ch62);
        ServiceInfo ch63=new ServiceInfo(R.mipmap.grid,"KALYANAM");
        ch6.add(ch63);
        ServiceInfo ch64=new ServiceInfo(R.mipmap.grid,"BRAHMOTSAVAM");
        ch6.add(ch64);
        ServiceInfo ch65=new ServiceInfo(R.mipmap.grid,"ALAMKARAMS TO DIETTIES");
        ch6.add(ch65);
        ServiceInfo ch66=new ServiceInfo(R.mipmap.grid,"YAGNEEKAM - YAGNAM");
        ch6.add(ch66);
        ServiceInfo ch67=new ServiceInfo(R.mipmap.grid,"ARCHAKATVAM");
        ch6.add(ch67);
        ServiceInfo ch68=new ServiceInfo(R.mipmap.grid,"CATERING");
        ch6.add(ch68);
    }
}
