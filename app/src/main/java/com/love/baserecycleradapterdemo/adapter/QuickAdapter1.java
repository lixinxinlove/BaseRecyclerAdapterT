package com.love.baserecycleradapterdemo.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.love.baserecycleradapterdemo.R;
import com.love.baserecycleradapterdemo.bean.User;

import java.util.List;

/**
 * Created by lixinxin on 2016/7/1.
 */
public class QuickAdapter1 extends BaseQuickAdapter<User> {

    public QuickAdapter1(int layoutResId, List<User> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, User user) {
        holder.setText(R.id.tv_name, user.getUserName());
        holder.setText(R.id.tv_age, user.getAge() + "");
        holder.setText(R.id.tv_phone, user.getPhone());
        holder.setOnClickListener(R.id.tv_name, new OnItemChildClickListener());
    }
}
