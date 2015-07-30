/**
* Copyright 2015 IBM Corp.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.sample.starterandroid;

import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.worklight.wlclient.api.WLFailResponse;
import com.worklight.wlclient.api.WLResponse;
import com.worklight.wlclient.api.WLResponseListener;

public class MyInvokeListener implements WLResponseListener {
	
	private ArrayAdapter<Content.Item> adapter;
	private Activity activity;
	
	public MyInvokeListener(ArrayAdapter<Content.Item> adapter, Activity activity){
		super();
		this.adapter = adapter;
		this.activity = activity;
	}
	
	public void onSuccess(WLResponse response) {
		try {
			JSONArray items = (JSONArray) response.getResponseJSON().get("items");
			Log.d("InvokeSuccess",items.toString());
			
			if(items !=null && items.length()>0){
				Content.ITEMS.clear();
				for (int i = 0; i < items.length(); i++) {
						Content.addItem(new Content.Item(items.getJSONObject(i)));
				}
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		final ArrayAdapter<Content.Item> adapter = this.adapter;
		this.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
            	adapter.notifyDataSetChanged();
            }
        });

	}
	public void onFailure(WLFailResponse response) {
		String responseText = response.getResponseText();
		Log.d("InvokeFail", responseText);
	}
}
