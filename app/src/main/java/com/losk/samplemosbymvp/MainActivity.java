package com.losk.samplemosbymvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.losk.samplemosbymvp.mvp.lce.activity.CountriesActivity;
import com.losk.samplemosbymvp.mvp.lce.viewpager.ViewPagerActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @BindView(R.id.listView)
    ListView listView;

    Demo[] demos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        demos = createDemos();
        listView.setAdapter(new ArrayAdapter<Demo>(this,
                android.R.layout.simple_list_item_1, demos));
        listView.setOnItemClickListener(this);
    }

    private Demo[] createDemos() {
        return new Demo[]{
                new Demo("Simple LpeView", new Intent(this, CountriesActivity.class)),
                new Demo("View Pager", new Intent(this, ViewPagerActivity.class))
        };
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        startActivity(demos[position].intent);
    }


    static class Demo {
        String name;
        Intent intent;

        private Demo(String name, Intent intent) {
            this.name = name;
            this.intent = intent;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
