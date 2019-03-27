package com.solvd.carinademoapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.solvd.carinademoapplication.test_screens.FragmentCharts;
import com.solvd.carinademoapplication.test_screens.FragmentMap;
import com.solvd.carinademoapplication.test_screens.FragmentUiElements;
import com.solvd.carinademoapplication.test_screens.FragmentWebView;

import java.util.ArrayList;

public class ActivityTestScreens extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ImageSlider imageSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_screens);

        drawerLayout = findViewById(R.id.drawer_layout);

        imageSlider = findViewById(R.id.image_slider);
        initImageSlider();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(menuItem -> {
            onSideMenuSelected(menuItem);

            return true;
        });

        setInitialScreenState(navigationView);
    }

    private void handleAdClicked(int position) {
        String siteLink;

        switch (position) {
            case 0:
                siteLink = "https://www.carina-core.io";
                break;

            case 1:
                siteLink = "https://mobiletesting.farm";
                break;

            case 2:
                siteLink = "https://www.qps-infra.io/";
                break;

            default:
                siteLink = null;
        }

        if (siteLink != null) {
            openLink(siteLink);
        }
    }

    private void openLink(String siteLink) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(siteLink));
        startActivity(browserIntent);
    }

    private void initImageSlider() {
        ArrayList<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.img_banner_carina));
        imageList.add(new SlideModel(R.drawable.img_banner_mcloud));
        imageList.add(new SlideModel(R.drawable.img_banner_qpsinfra));
        imageList.add(new SlideModel(R.drawable.img_banner_zafira));
        imageList.add(new SlideModel(R.drawable.img_banner_zebrunner));

        imageSlider.setImageList(imageList);
        imageSlider.setItemClickListener(this::handleAdClicked);
    }

    private void setInitialScreenState(NavigationView navigationView) {
        navigationView.setCheckedItem(R.id.nav_webView);
        replaceFragmentById(R.id.nav_webView);
        setTitle(R.string.web_view);
    }

    private void onSideMenuSelected(MenuItem menuItem) {
        menuItem.setChecked(true);
        drawerLayout.closeDrawers();

        replaceFragmentById(menuItem.getItemId());
        setTitle(menuItem.getTitle());
    }

    private void replaceFragmentById(int itemId) {
        Fragment newFragment = null;

        switch (itemId) {
            case R.id.nav_webView:
                newFragment = new FragmentWebView();
                break;

            case R.id.nav_charts:
                newFragment = new FragmentCharts();
                break;

            case R.id.nav_map:
                newFragment = new FragmentMap();
                break;

            case R.id.nav_uiElements:
                newFragment = new FragmentUiElements();
                break;
        }

        if (newFragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_frame, newFragment)
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
