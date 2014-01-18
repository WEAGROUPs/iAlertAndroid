package com.news.ialert;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.actionbarsherlock.app.SherlockActivity;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.Html;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class notificationReceiver extends SherlockActivity{
	Button close;
	Button call;
	Button pvideo;
	Button paudio;
	String mylocation;
	String mydetails ;
	String mytitle;
	String myid;
	String myvideo;
	String myaudio;
	String mytime;
	String mysender;
	String mylat;
	String mylongt;
	String mycontact;
	;
	String myimage;
	  public static final String TAG_SUCCESS = "success";
		
		 boolean isLight;
		 JSONParser jsonParser = new JSONParser();
		 private static final String TAG_PRODUCTS = "station";
		 TextView titletv;
		  TextView nametv;
		  TextView lattv;
		  TextView longttv;
		  ImageView imagetv;
	       TextView detailstv;
	       TextView locationtv;
	List<agentnews> apps;
	int succ=0;
	 private ProgressDialog dialog;

	
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			
			
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			 setContentView(R.layout.agentnews);
			 
			
			 getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_background));
			 getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>Ialert</font>"));
			
		        
					  titletv=(TextView)findViewById(R.id.title);
					 nametv=(TextView)findViewById(R.id.name);
					  lattv=(TextView)findViewById(R.id.lat);
					   longttv=(TextView)findViewById(R.id.longt);
					  
				     detailstv=(TextView)findViewById(R.id.details);
				    locationtv=(TextView)findViewById(R.id.location);
				      String no1="no";
				  
				      
				       
				      imagetv=(ImageView)findViewById(R.id.image);
				      call=(Button)findViewById(R.id.btncall);
				       Button ok=(Button)findViewById(R.id.btnok);
				       pvideo=(Button)findViewById(R.id.videos);
				       paudio=(Button)findViewById(R.id.audios);
				       
				
				       
					     
					      SharedPreferences preferences2 = getSharedPreferences("news",
			     	    			MODE_PRIVATE);
			     	    		
			     	    		  String   uid = preferences2.getString("news_id", "");
			        	   
			                     myid=uid;
			                     String url = "http://ialert.ugisoft.com/ialert/getagentnews.php";
			                     
			                     
				     
			                     getdetailsTask ts= new getdetailsTask();
			                     ts.execute(url,myid);
				       byte[] mess;
				       
				       /*
				        
				       if(myvideo.equalsIgnoreCase(no1))
					      {
					    	  
					    	pvideo.setVisibility(View.INVISIBLE);  
					    	  
					      }
					      if(myaudio.equalsIgnoreCase(no1))
					      {
					    	  
					    	paudio.setVisibility(View.INVISIBLE);  
					    	  
					      }
					      */
				      
					 ok.setOnClickListener(new View.OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							
						finish();
							
							
						}
					});
					
					 
					 call.setOnClickListener(new View.OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							String no="";
							if(mycontact.equalsIgnoreCase(no))
							{
								
								Toast.makeText(getApplicationContext(), "No contact for the sender provided", Toast.LENGTH_LONG).show() ;
				            	 	
								
								
							}
							else
							{
								
								callsender();	
								
							}
						}
					});
					 pvideo.setOnClickListener(new View.OnClickListener() {
							
							@Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
								
								 Bundle b = new Bundle();
								 String  videourl="http://ialert.ugisoft.com/ialert/video_uploads/"+myvideo;
				            	 b.putString("video", videourl );
				            	String no="no";
				            	 if(myvideo.equalsIgnoreCase(no))
				            	 {
				            		Toast.makeText(getApplicationContext(), "no video attached", Toast.LENGTH_LONG).show() ;
				            	 }
				            	 else
				            	 {
				            	 
				            	  Intent i = new Intent(getApplicationContext(),
				            		         playActivity.class);
				            	  i.putExtras(b);
				            	  startActivity(i);
						
								
				            	 }
							}
						});
					 
					 paudio.setOnClickListener(new View.OnClickListener() {
							
							@Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
								
								 Bundle b = new Bundle();
								 
								 
								 String  videourl="http://ialert.ugisoft.com/ialert/audio_uploads/"+myaudio;
				            	 b.putString("video", videourl );
				            	 
				            	String no="no";
				            	 if(myaudio.equalsIgnoreCase(no))
				            	 {
				            		 Toast.makeText(getApplicationContext(), "no Audio attached", Toast.LENGTH_LONG).show() ;	 
				            	 }
				            	 else
				            	 {
				            	  Intent i = new Intent(getApplicationContext(),
				            		         playActivity.class);
				            	  i.putExtras(b);
				            	  startActivity(i);
						
				            	 }
								
							}
						});
						
						
		}

		@Override
		public void onBackPressed() {
			// TODO Auto-generated method stub
			
		
			super.onBackPressed();
		}
		
		/*
		private void callsupplier() {
		    try {
		        Intent callIntent = new Intent(Intent.ACTION_CALL);
		        callIntent.setData(Uri.parse("tel:"+myphonenumber));
		        startActivity(callIntent);
		    } catch (ActivityNotFoundException activityException) {
		         Log.e("Contacting Supplier", "Call failed");
		    }
		}
		*/
	  
		
		
		 class getdetailsTask extends AsyncTask<String, Void, String> {
			 
		        /**
		         * Before starting background thread Show Progress Dialog
		         * */
		        @Override
		        protected void onPreExecute() {
		            super.onPreExecute();
		            
		       
		        }
		 
		        /**
		         * Creating product
		         * */
		        protected String doInBackground(String... args) {
		        	//String login_name=args[0];
		            
		 
		            // Building Parameters
		        	// Building Parameters
		            List<NameValuePair> params = new ArrayList<NameValuePair>();
		            params.add(new BasicNameValuePair("myid", args[1]));
		 
		            // getting JSON Object
		    JSONObject json = jsonParser.makeHttpRequest(args[0], "GET", params);
		            Log.d("Create Response", json.toString());
		 
		            // check for success tag
		            try {
		                int success = json.getInt(TAG_SUCCESS);
		 
		                if (success == 1) {
		                	
		                	succ=1;
		                	
		                	JSONArray  stationss = json.getJSONArray(TAG_PRODUCTS);
		                	 
		                	  apps = new ArrayList<agentnews>();
		                	 
		                     // looping through All messages
		                	 for (int i = 0; i < stationss.length(); i++) {
		                         JSONObject c = stationss.getJSONObject(i);

		                    
		                      
		                      myaudio=c.getString("audio");
		                      mytime=c.getString("timendate");
		                      mytitle=c.getString("title");
		                      mydetails=c.getString("description");
		                      myimage=c.getString("face_image");
		                      myvideo=c.getString("video");
		                      
		                      mylocation=c.getString("cat");
		                      myid=c.getString("id");
		                      mylat=c.getString("lat");
		                      mylongt=c.getString("longt");
		                      mysender=c.getString("sender_name");
		                     mycontact=c.getString("sender_contact");
		                     
		                    
		                 
		                   }
		                	
		                }
		                
		                
		                else {
		                	
		                }
		            } catch (JSONException e) {
		                e.printStackTrace();
		            }
		 
		            return null;
		        }
		 
		        /**
		         * After completing background task Dismiss the progress dialog
		         * **/
		        protected void onPostExecute(String file_url) {
		            
		            if(succ==1)
		            {
		            	
		            	 SharedPreferences preferences =getSharedPreferences("news",
		                   	        MODE_PRIVATE);
		                   	    SharedPreferences.Editor editor = preferences.edit();
		                       
		                   	    
		                   	    String news_id="";
		                   	
		                   	    editor.putString("news_id", news_id);
		                   	    
		                   	    editor.commit();
		                   	    
		                   	 String no1="no";
	                         if(myvideo.equalsIgnoreCase(no1))
						      {
						    	  
						    	pvideo.setVisibility(View.INVISIBLE);  
						    	  
						      }
						      if(myaudio.equalsIgnoreCase(no1))
						      {
						    	  
						    	paudio.setVisibility(View.INVISIBLE);  
						    	  
						      }
	                  
		                   	    
		            	
		            	 titletv.setText(mytitle);
						 nametv.setText(mysender);
						  lattv.setText(mylat);
						   longttv.setText(mylongt);
						  
					     detailstv.setText(mydetails);
					    locationtv.setText(mylocation);	 
					    ImageDownloader imageManager = new ImageDownloader();
		        		
		        		String url_news_updates = "http://ialert.ugisoft.com/ialert/image_uploads/"+myimage;
		        		String imaged=imageManager.download(url_news_updates, imagetv);
		        		
		            }
		            else
		            {
		            	
		            	
		            	
		            
		            }
		        }
		 
		
		 
		 
		 
		 }
		 
		 private void callsender() {
			    try {
			        Intent callIntent = new Intent(Intent.ACTION_CALL);
			        callIntent.setData(Uri.parse("tel:"+mycontact));
			        startActivity(callIntent);
			    } catch (ActivityNotFoundException activityException) {
			         Log.e("Contacting Sender", "Call failed");
			    }
			}
}
