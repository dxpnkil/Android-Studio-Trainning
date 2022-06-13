package com.example.mail_app_ui;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class ItemAdapter extends BaseAdapter {

    List<Item> items;
    Integer[] background = {
            R.drawable.avatar1,
            R.drawable.avatar2,
            R.drawable.avatar3,
            R.drawable.avatar4,
            R.drawable.avatar5,
            R.drawable.avatar6,
            R.drawable.avatar7,
    };
    Random random = new Random();

    public ItemAdapter(List<Item> items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;

        if (view ==null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_layout, null);

            viewHolder = new ViewHolder();
            viewHolder.avatar = view.findViewById(R.id.button_avatar);
            viewHolder.name = view.findViewById(R.id.name);
            viewHolder.header = view.findViewById(R.id.header);
            viewHolder.content = view.findViewById(R.id.content);
            viewHolder.star = view.findViewById(R.id.star);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        Item item = items.get(i);

        viewHolder.avatar.setText(Character.toString(item.getName().charAt(0)));
        viewHolder.avatar.setBackgroundResource(background[random.nextInt(background.length)]);
        viewHolder.name.setText(item.getName());
        viewHolder.header.setText(item.getHeader());
        viewHolder.content.setText(item.getContent());

        viewHolder.star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item.setToggle(!item.isToggle());
                if(!item.isToggle()) {
                    viewHolder.star.setImageResource(R.drawable.ic_baseline_star_outline_24);
                    Log.v("TAG", getItemId(i) + "is selevted");
                } else {
                    viewHolder.star.setImageResource(R.drawable.ic_baseline_star_24);
                    Log.v("TAG", getItemId(i) + "is selevted");
                }
            }
        });
        return view;
    }

    private class ViewHolder {
        public Button avatar;
        public TextView name;
        public TextView header;
        public TextView content;
        public ImageView star;
    }
}
