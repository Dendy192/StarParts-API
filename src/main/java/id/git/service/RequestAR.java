package id.git.service;

import id.git.api.service.GetAPIData;
import id.git.utils.Config;

public class RequestAR {

	public String request(String id, String name, String phone) {
		// TODO Auto-generated constructor stub
		Config.init();
		String result = "";
//		GetAPIData gap = new GetAPIData();
//		String test = gap.getInvoice(id);
//		System.out.println(test);
		// if (!test.equals("success")) {
			result = "failed";
		// }
		PDFEngine pdf = new PDFEngine();
		result = pdf.getData(name, id, phone);
		return result;
	}

//	public RequestAR() {
//		request("BDG000024", "ALEX SPORT RACING", "6287887693187");
//	}
//	public static void main(String[] args) {
//		new RequestAR();
//	}

}
