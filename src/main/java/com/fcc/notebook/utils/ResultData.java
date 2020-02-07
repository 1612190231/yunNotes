package com.fcc.notebook.utils;

public class ResultData {

    private String url;

    private boolean uploaded;


    public static ResultData createSuc(String url) {

        return new ResultData(url, true);
    }


    public static ResultData createErr() {
        return new ResultData(null, false);
    }


    public ResultData(String url, boolean uploaded) {
        this.url = url;
        this.uploaded = uploaded;
    }


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public boolean getUploaded() {
		return uploaded;
	}


	public void setUploaded(boolean uploaded) {
		this.uploaded = uploaded;
	}

    
}

