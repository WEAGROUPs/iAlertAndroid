package com.news.ialert;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Bottommenu extends Activity{
 
	TextView app_settings = null;
	private static final int   MENU1 = Menu.FIRST;
	private static final int   MENU2 = Menu.FIRST +1 ;
	private static final int   MENU3 = Menu.FIRST +2 ;
	private static final int   MENU4 = Menu.FIRST +3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.menu.main);
		app_settings = (TextView)findViewById(R.id.menu_settings);
		
	
		   
		}
		
	
	@Override//creates menu items
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main,menu);
		//menu.add(0, MENU1, 0, "Settings");
		//menu.add(0, MENU2, 0, "Quit");
	return true;
	}

	@Override//handles items selection
	
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		case R.id.menu_quit:
		finish();
		break;
		case R.id.menu_settings:
		
		}
		return true;
	} 
	
	
}
