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

import java.net.URI;
import java.net.URISyntaxException;

import android.app.Activity;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.worklight.wlclient.api.WLResourceRequest;
import com.worklight.wlclient.api.WLFailResponse;

import com.worklight.wlclient.api.WLResponse;
import com.worklight.wlclient.api.WLResponseListener;

public class MyConnectListener implements WLResponseListener  {
	
	private ArrayAdapter<Content.Item> adapter;
	private Activity activity;
	
	public MyConnectListener(ArrayAdapter<Content.Item> adapter, Activity activity){
		super();
		this.adapter = adapter;
		this.activity = activity;
	}
	
	public void onSuccess(WLResponse response) {
		try{
			
			URI adapterPath = new URI("/adapters/StarterApplicationAdapter/getEngadgetFeeds");
			WLResourceRequest request = new WLResourceRequest(adapterPath,WLResourceRequest.GET);
			request.send(new MyInvokeListener(this.adapter, this.activity));
		}catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	public void onFailure(WLFailResponse response) {
		Log.d("starter", response.getErrorMsg());
	}
}


