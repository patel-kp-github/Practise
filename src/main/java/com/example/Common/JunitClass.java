package com.example.Common;

import java.io.InputStream;
import java.io.StringWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class JunitClass {

	public void m() {

	}

	public int m(int s) {
		return 0;
	}

	public void testLogin() {

		Collections.synchronizedMap(new HashMap());// all methods are synchronized block level
		new ConcurrentHashMap<>(); // put operation is synchronized
		new Vector<>();// all methods

		System.gc();
//		System.
		Runtime.getRuntime().gc();
		String URL = "unauthURL()";
		String restURLpath = URL + "/login";
		System.out.println("restURLpath : " + restURLpath);
		try {
			HttpClient client = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(restURLpath);
			// String authHeader = authHeader();
			// httppost.addHeader("Authorization", authHeader);
			HttpResponse response;
			httppost.addHeader("Accept", "application/xml");
			HttpEntity entity = new StringEntity(
					"<?xml version='1.0' encoding='UTF-8'?><map><username>manutv007@yahoo.com</username>"
							+ "<password>Manu@123</password></map>",
					"application/xml", null);
			httppost.setEntity(entity);
			response = client.execute(httppost);
			System.out.println("Response status code: " + response.getStatusLine());
			HttpEntity entity2 = response.getEntity();
			if (entity2 != null) {
				InputStream instream = entity2.getContent();
				StringWriter writer = new StringWriter();
				String str = IOUtils.toString(instream);
				// System.out.println(str);
				System.out.println(str);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
