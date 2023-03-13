package id.git.api;

import id.git.api.service.GetAPIData;
import id.git.utils.Config;

public class GetInvoice {

	public GetInvoice() {
		Get();
		// TODO Auto-generated constructor stub
	}
	public void Get() {
		Config.init();
		GetAPIData gap = new GetAPIData();
		gap.getInvoice("BDG000024");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GetInvoice();
	}

}
