package com.news.ialert;

import android.graphics.Bitmap;


public class agentnews {
//Decleration of variables that the journalist
private String title;
private String details;
private String senderlocation;
private String lat;
private String longt;
private String name;
private String contact;
private String image;
private String face;
private String timendate;
private String video;
private String audio;
private String id;

public String getsenderlocation() {
    return senderlocation;
}
public void setsenderlocation(String senderlocation) {
    this.senderlocation = senderlocation;
}
public String gettimendate() {
    return timendate;
}
public void settimendate(String timendate) {
    this.timendate = timendate;
}

 
public String getTitle() {
    return title;
}
public void setTitle(String title) {
    this.title = title;
}


public String getDetails() {
    return details;
}
public void setDetails(String details) {
    this.details = details;
}


public String getface() {
	
    return face;
}
public void setface(String face) {
	
	 byte[] mess;

	 this.face =face;
	 
}
	    
public String getImage() {
    return image;
}
public void setImage(Bitmap image) {
	String data="";
    this.image = data;
}


public String getid() {
    return id;
}
public void setid(String id) {
	String data="";
    this.id = id;
}

public String getsender() {
    return name;
}
public void setsender(String name) {
	String data="";
    this.name = name;
}

public String getcontact() {
    return contact;
}
public void setcontact(String contact) {
	String data="";
    this.contact = contact;
}

public String getlat() {
    return lat;
}
public void setlat(String lat) {
	String data="";
    this.lat = lat;
}

public String getlongt() {
    return longt;
}
public void setlongt(String longt) {
	String data="";
    this.longt = longt;
}
public String getvideo() {
    return video;
}
public void setvideo(String video) {
	String data="";
    this.video = video;
}

public String getaudio() {
    return audio;
}
public void setaudio(String audio) {
	String data="";
    this.audio = audio;

}
}