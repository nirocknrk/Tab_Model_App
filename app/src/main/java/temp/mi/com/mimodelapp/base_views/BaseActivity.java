package temp.mi.com.mimodelapp.base_views;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.app.FragmentPagerAdapter;

import temp.mi.com.mimodelapp.R;
import temp.mi.com.mimodelapp.ui.ActivityTwo;
import temp.mi.com.mimodelapp.ui.MainActivity;
import temp.mi.com.mimodelapp.ui.adapters.TabsPagerAdapter;

/**
 * Created by Niroshan on 6/15/2016.
 */
public abstract class BaseActivity  extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    public static final int DYNAMIC_MENU_ITEM_ID_PREFIX=900;
    private NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public ActionBar getSupportActionBar() {
        return super.getSupportActionBar();
    }

    @Override
    public void onStart() {
        super.onStart();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void setupViewPager(ViewPager viewPager) {
        // create an adapter
        TabsPagerAdapter adapter = new TabsPagerAdapter(getSupportFragmentManager());

        // add your fragments to the adapter
//        adapter.addFragment(new Mp3list() , "MP3");
//        adapter.addFragment(new Mp4list() , "MP4");

        // set the adapter to the ViewPager
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        } else if (id == R.id.nav_gallery) {
            startActivity(new Intent(getApplicationContext(), ActivityTwo.class));

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }else  {
            onDynamicNavigationItemSelected(item);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public abstract boolean onDynamicNavigationItemSelected(MenuItem item);

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /**
     * add dynamic Navigation Menu Items
     Parameters:
     groupId - The group identifier that this item should be part of. This can also be used to define groups of items for batch state changes. Normally use NONE(Menu.NONE) if an item should not be in a group.
     itemId - Unique item ID. Use NONE(Menu.NONE) if you do not need a unique ID. Recommended to use unique ID to handle click event
     order - The order for the item. Use NONE if you do not care about the order. See MenuItem.getOrder().
     titleRes - Resource identifier of title string.
     icon - drawable resource for icon for the newly adding item. If no icon needed use null
     menuItemClickListener -  Use the customised event on menu item click. Use null if not needed.
     Returns:
     The newly added menu item.
     */
    public MenuItem addNavigationMenuItem(int groupId, int itemId, int order, CharSequence title, Drawable icon, MenuItem.OnMenuItemClickListener menuItemClickListener){
        final Menu menu = navigationView.getMenu();
        MenuItem item =menu.add(groupId,itemId,order,title).setIcon(icon);
        if(icon!=null){
            item.setIcon(icon);//menu.findItem(itemId).setIcon(icon);    //MenuItem item = menu.getItem(9000+i);
                            // item.setIcon(icon);//ActionView(imageView);
        }
//        // adding a section and items into it
//        final SubMenu subMenu = menu.addSubMenu("SubMenu Title");
//        for (int i = 1; i <= 2; i++) {
//            subMenu.add("SubMenu Item " + i);
//        }
        if(menuItemClickListener!=null){
            item.setOnMenuItemClickListener(menuItemClickListener);
        }

        return item;
    }
}
