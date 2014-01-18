package com.news.ialert;


import uk.co.jasonfry.android.tools.ui.PageControl;
import uk.co.jasonfry.android.tools.ui.SwipeView;
import uk.co.jasonfry.android.tools.ui.SwipeView.OnPageChangedListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;





public class homeFragment  extends SherlockFragment{

	SwipeView mSwipeView;
	 
	int[] images;
	String[] text;
	
	
	 @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
		 
		 
	    	
	    	
	        View rootView = inflater.inflate(R.layout.home, container, false);
	        
	      
	        PageControl mPageControl = (PageControl)rootView.findViewById(R.id.page_control);
	        mSwipeView = (SwipeView) rootView.findViewById(R.id.swipe_view);

	        loadImages();
	        
	        for(int i=0; i<7;i++)
	        {
	        	mSwipeView.addView(new FrameLayout(getActivity()));
	        }
	        
	       // ImageView i0 = new ImageView(getActivity());
	       // ImageView i1 = new ImageView(getActivity());
	       // i0.setImageResource(images[0]);
	       // i1.setImageResource(images[1]);
	        
	        TextView t0=new TextView(getActivity());
	        TextView t1=new TextView(getActivity());
	       t0.setTextSize(18);
	       t1.setTextSize(18);
	    
	        
	        t0.setText(text[0]);
	        t1.setText(text[1]);
	        
	        ((FrameLayout) mSwipeView.getChildContainer().getChildAt(0)).addView(t0);
	        ((FrameLayout) mSwipeView.getChildContainer().getChildAt(1)).addView(t1);
	        
	        SwipeImageLoader mSwipeImageLoader = new SwipeImageLoader();
	        
	        mSwipeView.setOnPageChangedListener(mSwipeImageLoader);
	        
	        mSwipeView.setPageControl(mPageControl);
	    	return rootView;
	    }
	    
	    private class SwipeImageLoader implements OnPageChangedListener
	    {

			public void onPageChanged(int oldPage, int newPage) 
			{
				if(newPage>oldPage)//going forwards
				{
					if(newPage != (mSwipeView.getPageCount()-1))//if at the end, don't load one page after the end
					{
						TextView v = new TextView(getActivity());
						v.setTextSize(18);
						v.setText(text[newPage+1]);
						((FrameLayout) mSwipeView.getChildContainer().getChildAt(newPage+1)).addView(v);
					}
					if(oldPage!=0)//if at the beginning, don't destroy one before the beginning
					{
						((FrameLayout) mSwipeView.getChildContainer().getChildAt(oldPage-1)).removeAllViews();
					}
					
				}
				else //going backwards
				{
					if(newPage!=0)//if at the beginning, don't load one before the beginning
					{
						TextView v = new TextView(getActivity());
						v.setTextSize(18);
						v.setText(text[newPage-1]);
						((FrameLayout) mSwipeView.getChildContainer().getChildAt(newPage-1)).addView(v);
					}
					if(oldPage != (mSwipeView.getPageCount()-1))//if at the end, don't destroy one page after the end
					{
						((FrameLayout) mSwipeView.getChildContainer().getChildAt(oldPage+1)).removeAllViews();
					}
				}
				
			}
	    	
	    }
	    

		
	       
		
	 
private void loadImages()
{
	//Not the most elegant way to do this, but it does enough for demo purposes...
	
	//The images are not actually being loaded into memory, but the resources 
	//ids are being put in a format that can be dealt with easily
	/*
	images = new int[25];
	images[0] = R.drawable.image001;
	images[1] = R.drawable.image002;
	images[2] = R.drawable.image003;
	images[3] = R.drawable.image004;
	images[4] = R.drawable.image005;
	images[5] = R.drawable.image006;
	images[6] = R.drawable.image007;
	*/
	
	text=new String[25];
	text[0]="You can use text, images, audio and video of  the news happening in your area let the nearest journalist to you be notified";
	text[1]="You can let the journalist Know your name and phone number by inserting them in the app settings";
	text[2]="";
	text[3]="";
	text[4]="";
	
	
	
}
}
