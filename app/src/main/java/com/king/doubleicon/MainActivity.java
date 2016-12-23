package com.king.doubleicon;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    TextView toolbarTitleTv;

    Toolbar toolbar;

    ViewPager homeViewPager;

    BottomNavigationView bottomNavView;

    LinearLayout activityBottomNavigationT;

    MenuItem prevMenuItem;

    private void initView() {
        toolbarTitleTv = (TextView) findViewById(R.id.toolbar_title_tv);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        homeViewPager = (ViewPager) findViewById(R.id.home_view_pager);
        bottomNavView = (BottomNavigationView) findViewById(R.id.bottom_nav_view);
        activityBottomNavigationT = (LinearLayout) findViewById(R.id.activity_bottom_navigation_t);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        //初始化Toolbar
        initToolbar();

        //初始化Viewpager
        initViewPager();

        //初始化Bottom Navigation
        initBottomNav();
    }


    private void initToolbar() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }


    private void initViewPager() {
        homeViewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                switch (position) {
                    case 0:
                        fragment = new HomeFragment();
                        break;
                    case 1:
                        fragment = new HomeFragment();
                        break;
                    case 2:
                        fragment = new HomeFragment();
                        break;
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return 3;
            }
        });

        homeViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                invalidateOptionsMenu();
                /**
                 * 该方法只有在有新的页面被选中时才会回调
                 * 如果 preMenuItem 为 null，说明该方法还没有被回调过
                 * 则ViewPager从创建到现在都处于 position 为 0 的页面
                 * 所以当该方法第一次被回调的时候，直接将 position 为 0 的页面的 selected 状态设为 false 即可
                 *
                 * 如果 preMenuItem 不为 null，说明该方法内的
                 * "prevMenuItem = bottomNavView.getMenu().getItem(position);"
                 * 之前至少被调用过一次
                 * 所以当该方法再次被回调的时候，直接将上一个 prevMenuItem 的 selected 状态设为 false 即可
                 * 在做完上一句的事情后，将当前页面设为 prevMenuItem，以备下次调用

                 */
                if (prevMenuItem == null) {
                    bottomNavView.getMenu().getItem(0).setChecked(false);
                } else {
                    prevMenuItem.setChecked(false);
                }

                bottomNavView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavView.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private void initBottomNav() {
        bottomNavView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        homeViewPager.setCurrentItem(item.getOrder());
                        return true;
                    }
                });
    }

}
