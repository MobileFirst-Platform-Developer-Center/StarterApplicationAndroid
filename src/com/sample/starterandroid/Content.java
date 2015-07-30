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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class Content {
	
	/**
	 * An array of items.
	 */
	public static List<Item> ITEMS = new ArrayList<Item>();
	
	/**
	 * A map of items, by ID.
	 */
	public static Map<String, Item> ITEM_MAP = new HashMap<String, Item>();

	public static void addItem(Item item) {
		ITEMS.add(item);
		ITEM_MAP.put(item.id, item);
	}
	
	/**
	 * An item representing a piece of content.
	 */
	public static class Item {
		public String id;
		public String content;
		public String url;
		public String pubdate;
		public String title;

		public Item(String id, String content) {
			this.id = id;
			this.content = content;
		}
		
		public Item(JSONObject item){
			try {
				this.id = item.getString("link");
				this.content = item.getString("description");
				this.url = item.getString("link");
				this.pubdate = item.getString("pubDate");
				this.title = item.getString("title");
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}

		@Override
		public String toString() {
			return title;
		}
	}

}
