package com.example.kenny.kennydemo;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.kenny.kennydemo.adapter.ViewPagerAdapter;
import com.example.kenny.kennydemo.fragment.ContentFragment;
import com.example.kenny.kennydemo.fragment.HistoryFragment;
import com.example.kenny.kennydemo.fragment.LoginFragment;
import com.example.kenny.kennydemo.R;
import com.example.kenny.kennydemo.util.UtilLog;

import java.util.ArrayList;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        Intent intent=getIntent();
        String message=intent.getStringExtra("key");
        Bundle bundle=intent.getExtras();
        int number=bundle.getInt("integer",0);
        int fakeNumber=bundle.getInt("fake",0);
        Book book=(Book)bundle.getSerializable("book") ;
        UtilLog.logD("ViewPagerActivity, value is: ",message);
        UtilLog.logD("ViewPagerActivity, number is: ",""+number);
        UtilLog.logD("ViewPagerActivity, fakeNumber is: ",String.valueOf(fakeNumber));


        initial();
    }
    private void initial(){
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        fragmentList.add(new LoginFragment());
        fragmentList.add(new ContentFragment());
        fragmentList.add(new HistoryFragment());
        ViewPagerAdapter viewPagerAdapter= new ViewPagerAdapter(this.getSupportFragmentManager());
        viewPagerAdapter.setContent(fragmentList);
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout = (TabLayout) findViewById(R.id.tab_Layout);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onBackPressed() {
        Intent intent =new Intent();
        intent.putExtra("message","ViewPager");
        setResult(RESULT_OK,intent);
        super.onBackPressed();
    }
}
