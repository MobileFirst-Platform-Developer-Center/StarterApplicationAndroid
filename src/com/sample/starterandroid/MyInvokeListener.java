/**
 * COPYRIGHT LICENSE: This information contains sample code provided in source code form. You may copy, modify, and distribute
 * these sample programs in any form without payment to IBM® for the purposes of developing, using, marketing or distributing
 * application programs conforming to the application programming interface for the operating platform for which the sample code is written.
 * Notwithstanding anything to the contrary, IBM PROVIDES THE SAMPLE SOURCE CODE ON AN "AS IS" BASIS AND IBM DISCLAIMS ALL WARRANTIES,
 * EXPRESS OR IMPLIED, INCLUDING, BUT NOT LIMITED TO, ANY IMPLIED WARRANTIES OR CONDITIONS OF MERCHANTABILITY, SATISFACTORY QUALITY,
 * FITNESS FOR A PARTICULAR PURPOSE, TITLE, AND ANY WARRANTY OR CONDITION OF NON-INFRINGEMENT. IBM SHALL NOT BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL OR CONSEQUENTIAL DAMAGES ARISING OUT OF THE USE OR OPERATION OF THE SAMPLE SOURCE CODE.
 * IBM HAS NO OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES, ENHANCEMENTS OR MODIFICATIONS TO THE SAMPLE SOURCE CODE.
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
