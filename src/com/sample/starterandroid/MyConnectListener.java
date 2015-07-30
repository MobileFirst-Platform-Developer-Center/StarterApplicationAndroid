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


