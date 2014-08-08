package com.example.getcurrentlocation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import models.Template;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import api.ApiService;
import api.ServiceFactory;

public class ListTemplates extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.templates_list_view);
        final ApiService apiService = ServiceFactory.getApiService();
        List<Template> templates = apiService.getTemplates();
        final ListView listview = (ListView) findViewById(R.id.list);
        final StableArrayAdapter adapter = new StableArrayAdapter(this,
                R.layout.template_text_view, templates);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				
                Template item = adapter.getItem(position);
                apiService.postCheckin(null, item.getId());
			}
		});
        
        Button button = (Button) findViewById(R.id.show_map);
        button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
			    Intent i = new Intent(getApplicationContext(),GetCurrentLocation.class);
			    startActivity(i);
			    setContentView(R.layout.main);
			}
        	
        });
    }

    private class StableArrayAdapter extends ArrayAdapter<Template> {

    	LayoutInflater inflater;
    	
        HashMap<Template, Integer> mIdMap = new HashMap<Template, Integer>();

        public StableArrayAdapter(Context context, int textViewResourceId,
            List<Template> objects) {
          super(context, textViewResourceId, objects);
          inflater = LayoutInflater.from(context);
          for (int i = 0; i < objects.size(); ++i) {
            mIdMap.put(objects.get(i), objects.get(i).getId());
          }
        }

        @Override
        public long getItemId(int position) {
          Template item = getItem(position);
          return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
          return true;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
        	Template item = getItem(position);
            LinearLayout view;
            if(convertView == null) {
            	convertView = inflater.inflate(R.layout.template_text_view, null);
            }
        	TextView tv = (TextView) convertView.findViewById(R.id.text);
        	tv.setText(item.getText());
            return convertView;
        }
      }

}
