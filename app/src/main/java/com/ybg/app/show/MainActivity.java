package com.ybg.app.show;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.ybg.app.show.adapter.ItemRecyclerAdapter;
import com.ybg.app.show.bean.ShowItem;
import com.ybg.app.show.decoration.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private List<ShowItem> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        list = getItemList();
        initView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private List<ShowItem> getItemList() {
        List<ShowItem> list = new ArrayList<ShowItem>();
        for (int i = 0; i < 100; i++) {
            list.add(new ShowItem("", "item " + String.format("%03d", i)));
        }
        return list;
    }

    private void initView() {
        mRecyclerView = (RecyclerView) this.findViewById(R.id.showGround);
        SpacesItemDecoration decoration = new SpacesItemDecoration(16);
        mRecyclerView.addItemDecoration(decoration);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));//设置RecyclerView布局管理器为2列垂直排布
        final ItemRecyclerAdapter adapter = new ItemRecyclerAdapter(this, list);
        mRecyclerView.setAdapter(adapter);
        adapter.setOnClickListener(new ItemRecyclerAdapter.OnItemClickListener() {
            @Override
            public void ItemClickListener(View view, int postion) {
                Toast.makeText(MainActivity.this, "点击了：" + postion, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void ItemLongClickListener(View view, int postion) {
                //长按删除
                list.remove(postion);
                adapter.notifyItemRemoved(postion);
            }
        });
    }
}
