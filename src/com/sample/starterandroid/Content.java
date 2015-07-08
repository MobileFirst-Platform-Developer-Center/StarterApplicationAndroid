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
