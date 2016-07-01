package com.love.baserecycleradapterdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.love.baserecycleradapterdemo.adapter.QuickAdapter1;
import com.love.baserecycleradapterdemo.bean.User;

import java.util.ArrayList;
import java.util.List;

public class RecyclerDemo1Activity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {


    private RecyclerView recyclerView;
    private SwipeRefreshLayout refreshLayout;
    private QuickAdapter1 quickAdapter1;
    private List<User> userList;
    private List<User> longMoreList;

    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_demo1);


        initView();
        initData();
        initEvent();

        recyclerView.setAdapter(quickAdapter1);

    }


    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        refreshLayout = (SwipeRefreshLayout) findViewById(R.id.refreshLayout);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fab = (FloatingActionButton) findViewById(R.id.fab);

    }

    private void initData() {

        userList = new ArrayList<>();
        longMoreList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            User user = new User("德玛西亚" + i, i, "1111111" + i);
            userList.add(user);
        }


        quickAdapter1 = new QuickAdapter1(R.layout.item1, userList);

        View header = View.inflate(this, R.layout.header, null);
        View footer = View.inflate(this, R.layout.footer, null);
        View empty = View.inflate(this, R.layout.empty, null);
       quickAdapter1.addHeaderView(header);
        // quickAdapter1.addFooterView(footer);
        quickAdapter1.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
       // quickAdapter1.setEmptyView(empty);

    }

    private void initEvent() {

        refreshLayout.setOnRefreshListener(this);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.smoothScrollToPosition(0);

            }
        });
        quickAdapter1.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                Toast.makeText(RecyclerDemo1Activity.this, "点击事件", Toast.LENGTH_SHORT).show();
            }
        });

        quickAdapter1.setOnRecyclerViewItemLongClickListener(new BaseQuickAdapter.OnRecyclerViewItemLongClickListener() {
            @Override
            public boolean onItemLongClick(View view, int i) {
                Toast.makeText(RecyclerDemo1Activity.this, "长按事件", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        quickAdapter1.setOnRecyclerViewItemChildClickListener(new BaseQuickAdapter.OnRecyclerViewItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                switch (view.getId()) {
                    case R.id.tv_name:
                        Toast.makeText(RecyclerDemo1Activity.this, ((User) baseQuickAdapter.getItem(i)).getUserName(), Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });


        quickAdapter1.openLoadMore(10, true);
        quickAdapter1.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {

                recyclerView.post(new Runnable() {
                    @Override
                    public void run() {
                        // Toast.makeText(RecyclerDemo1Activity.this, "加载更多", Toast.LENGTH_SHORT).show();
                        for (int i = 0; i < 10; i++) {
                            longMoreList.add(new User("加载更多" + i, i, "88888888" + i));
                        }
                        quickAdapter1.notifyDataChangedAfterLoadMore(longMoreList, true);
                        // quickAdapter1.addData(userList);
                    }
                });

            }
        });
    }

    @Override
    public void onRefresh() {
        userList.get(0).setUserName("李鑫鑫");
        refreshLayout.setRefreshing(false);
        quickAdapter1.notifyDataSetChanged();

        Toast.makeText(RecyclerDemo1Activity.this, "userList的长度=" + userList.size(), Toast.LENGTH_SHORT).show();

    }
}
