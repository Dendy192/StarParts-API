package id.git.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import id.git.model.Document;
import id.git.model.Message;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SendEngine {
	private static Logger log = Logger.getLogger(SendEngine.class.getName());

	public String prepare(String idCustomer, String name, String phone,
			String path, HashMap<String, String> parameter) {
		String result = "";
		String messaging_product = parameter.get("wa.product");
		String url = parameter.get("wa.url") + "/" + parameter.get("wa.version")
				+ "/" + parameter.get("wa.id");
		String token = parameter.get("wa.token");
		System.out.println(url);
		String upl = uploadPDF(messaging_product, path, url, token);
		System.out.println("id abis upload" + upl);
		String tmp = "Hallo {{1}}\n"
				+ "Berikut laporan AR-Statment yang anda punya\n"
				+ "Terimakasih";
		String caption = tmp.replace("{{1}}", name);

		String send = sendPDF(messaging_product, phone, "document", upl,
				caption, name, url, token);
		if (send.contains("error")) {
			result = "error";
			System.out.println("masuk ke error");
			System.out.println(send);
		} else {
			result = "success";
			System.out.println(send);
		}
		return result;

	}
	public String sendPDF(String messaging_product, String to, String type,
			String id, String caption, String filename, String url,
			String token) {
		String result = "Success";
		try {
		OkHttpClient client = new OkHttpClient().newBuilder().build();

		// HashMap<String, String> j1 = new HashMap<String, String>();
		// HashMap<String, String> j2 = new HashMap<String, String>();
		Document dc = new Document();
		dc.setId(id);
		dc.setCaption(caption);
		dc.setFilename(filename);
		Message msg = new Message();
		msg.setMessaging_product(messaging_product);
		msg.setTo(to);
		msg.setType(type);
		msg.setDocument(dc);
		JSONObject js = new JSONObject(msg);

		// System.out.println(js);
		System.out.println(js);
		MediaType mediaType = MediaType.get("application/json; charset=utf-8");
		RequestBody body = RequestBody.create(mediaType, js.toString());
		Request request = new Request.Builder().url(url + "/messages")
				.method("POST", body)
				.addHeader("Authorization", "Bearer " + token).build();
		
			Response response = client.newCall(request).execute();
			result = response.body().string();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public String uploadPDF(String product, String file, String url,
			String token) {
		String result = "";
		try {
			OkHttpClient client = new OkHttpClient().newBuilder().build();
			MediaType mediaType = MediaType.parse("text/plain");
			RequestBody body = new MultipartBody.Builder()
					.setType(MultipartBody.FORM)
					.addFormDataPart("messaging_product", product)
					.addFormDataPart("file", file, RequestBody.create(
							MediaType.parse("application/pdf"), new File(file)))
					.build();
			Request request = new Request.Builder()
					// .url("https://graph.facebook.com/v14.0/110402461834248/media")
					.url(url + "/media").method("POST", body)
					.addHeader("Authorization", "Bearer " + token).build();
			Response response = client.newCall(request).execute();
			String id = response.body().string();
			System.out.println(id);
			if (!id.contains("error")) {
				// System.out.println("masuk 123 error");
				JSONObject res = new JSONObject(id);
				String idFin = res.getString("id");
				System.out.println("masuk ke id: " + idFin);
				result = idFin;

			}
			// String newId = id.replace("\"", "").replace("id:",
			// "").replace("{", "").replace("}", "");
			// System.out.println(newId);
			// System.out.println(response.body());
			// Object test = response.body().
			// System.out.println(id.replace("", ""));
			// String new_id = id.substring(7, 22);
			// System.out.println(id.substring(7, 22));
			// System.out.println(id.length());
			// System.out.println(id);
			// System.out.println(new_id);
			// System.out.println(response.body().string());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return result;
	}

}
