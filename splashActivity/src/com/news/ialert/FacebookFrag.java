package com.news.ialert;

import uk.co.jasonfry.android.tools.ui.SwipeView;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.actionbarsherlock.app.SherlockFragment;

public class FacebookFrag extends SherlockFragment{

	SwipeView mSwipeView;
	 
	int[] images;
	
	 @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
		 
		 
	    	
	    	
	        View rootView = inflater.inflate(R.layout.facebook, container, false);
	       
	        
	        WebView myWebView = (WebView)rootView. findViewById(R.id.webview);
	        WebSettings webSettings = myWebView.getSettings();
	        webSettings.setJavaScriptEnabled(true);
	        myWebView.loadUrl("https://www.facebook.com/chelseafc.london.560");
	      
	        
	    	return rootView;
	    }
	    
	  


}
