package com.example.CustomAdapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private ListView lv;
    private List<Map<String,Object>>data;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        lv = (ListView)findViewById(R.id.lv);
        data = getData();
        MyAdapter adapter = new MyAdapter(this);
        lv.setAdapter(adapter);
    }

    private List<Map<String ,Object>> getData(){
        List<Map<String ,Object>> list = new ArrayList<Map<String, Object>>();
        Map<String,Object> map;
        for (int i = 0;i<19;i++){
            map = new HashMap<String, Object>();
            map.put("img",R.drawable.ic_launcher);
            map.put("title","跆拳道i");
            map.put("info","哇卡卡卡卡卡卡卡卡卡卡卡");
            list.add(map);
        }
        return list;
    }
    static class ViewHolder{
        public ImageView img;
        public TextView title;
        public TextView info;
    }
    public class MyAdapter extends BaseAdapter{
        private LayoutInflater mInflater =  null;
        private MyAdapter(Context context){
            // 根据context上下文加载布局,这里的是本身Activity
            this.mInflater= LayoutInflater.from(context);
        }
        @Override
        public int  getCount(){
            // 再次适配器中所代表的数据集中的条目数
            return  data.size();
        }
        @Override
        public Object getItem(int position){
            // 获取数据集中于指定索引对应的数据项
            return position;
        }
        @Override
        public long getItemId(int position){
            //获取在列表中于指定索引对应的行id
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            ViewHolder holder = null;
            if (convertView == null){
                holder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.list_item,null);
                holder.img = (ImageView)convertView.findViewById(R.id.img);
                holder.title = (TextView) convertView.findViewById(R.id.tv);
                holder.info = (TextView)convertView.findViewById(R.id.info);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder)convertView.getTag();
            }
            holder.img.setBackgroundResource((Integer)data.get(position).get("img"));
            holder.title.setText((String)data.get(position).get("title"));
            holder.info.setText((String)data.get(position).get("info"));
            return convertView;
        }
    }
}
