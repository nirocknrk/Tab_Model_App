package temp.mi.com.mimodelapp.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import temp.mi.com.mimodelapp.R;
import temp.mi.com.mimodelapp.base_views.BaseActivity;
import temp.mi.com.mimodelapp.ui.adapters.TabsPagerAdapter;

/**
 * Created by Niroshan on 6/15/2016.
 */
public class ActivityTwo extends BaseActivity {

    ViewPager mViewPager;
    TabsPagerAdapter mDemoCollectionTabsPagerAdapter;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ViewPager and its adapters use support library
        // fragments, so use getSupportFragmentManager.
//        mDemoCollectionTabsPagerAdapter = new TabsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        if (mViewPager != null) {
            setupViewPager(mViewPager);
        }
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        setupTabIcons();
//        mViewPager.setAdapter(mDemoCollectionTabsPagerAdapter);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);




        //adding sample Navigation drawer Item with fixed event and dynamic event
        Drawable iconForItem= ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_menu_gallery);
        addNavigationMenuItem(Menu.NONE, DYNAMIC_MENU_ITEM_ID_PREFIX + 1, Menu.NONE, "DYNAMIC MENU ITEM 1", iconForItem,null);
        addNavigationMenuItem(Menu.NONE, Menu.NONE, Menu.NONE, "DYNAMIC MENU ITEM 2", iconForItem, new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(getApplicationContext(),"DYNAMIC MENU ITEM 2 DYNAMIC listener",Toast.LENGTH_SHORT).show();
                return false;
            }
        });


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

    @Override
    public boolean onDynamicNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == DYNAMIC_MENU_ITEM_ID_PREFIX+1) {
            Toast.makeText(getApplicationContext(),"Clicked DYNAMIC MENU ITEM 1",Toast.LENGTH_SHORT).show();;
        }

        return true;
    }


    private void setupTabIcons() {

        //read more @ https://developer.android.com/reference/android/support/design/widget/TabLayout.Tab.html#setCustomView(int)

        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tabview, null);
        tabOne.setText("ONE");
//        tabOne.setBackgroundColor(getResources().getColor(R.color.colorTab1));
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_menu_camera, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tabview, null);
        tabTwo.setText("TWO");
//        tabTwo.setBackgroundColor(getResources().getColor(R.color.colorTab2));
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_menu_gallery, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tabview, null);
        tabThree.setText("THREE");
//        tabThree.setBackgroundColor(getResources().getColor(R.color.colorTab3));
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_menu_share, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree).setText("News " + "➊");

        TextView tab4 = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tabview, null);
        tab4.setText("Four");
//        tab4.setBackgroundColor(getResources().getColor(R.color.colorTab4));
        tab4.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_menu_manage, 0, 0);
        tabLayout.getTabAt(3).setCustomView(tab4).setText("News " + "➊");

        TextView tab5 = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tabview, null);
        tab5.setText("Five");
//        tab5.setBackgroundColor(getResources().getColor(R.color.colorTab5));
        tab5.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_menu_slideshow, 0, 0);
        tabLayout.getTabAt(4).setText("News " + "➊");
    }
}
