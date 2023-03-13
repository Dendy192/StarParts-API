package id.git.api.service;

import java.util.List;

import id.git.api.IApiService;
import id.git.model.DataItem;
import id.git.model.ListDetailItem;
import id.git.model.ResponseGetInvoice;
import id.git.utils.Function;
import id.git.utils.RetrofitInstance;
import id.git.utils.SQLData;
import retrofit2.Call;
import retrofit2.Response;

public class GetAPIData {

	public String getInvoice(String id) {
		String result = "";
		try {
			IApiService api = RetrofitInstance.getRetrofitClient()
					.create(IApiService.class);
			Call<ResponseGetInvoice> call = api.getInvoice(id);
			Response<ResponseGetInvoice> response = call.execute();
			ResponseGetInvoice rgi = response.body();
			System.out.println("test");
			int i = 0;
			List<DataItem> lidi = rgi.getData();
			for (DataItem di : lidi) {
				// System.out.println(di);
				List<ListDetailItem> lidim = di.getListDetail();
				if (!lidim.isEmpty()) {
					System.out.println("masuk sini");
					for (ListDetailItem ldi : lidim) {
						System.out.println("Masuk sini: " + ldi);
						if (SQLData.checkSTGInvoice(di.getOUTLET_ID(),
								ldi.getINVOICE_NO()) == false) {
							System.out.println("masuk sini");
							String result1 = SQLData.insertSTGInvoice(di.getOUTLET_ID(),
									ldi.getINVOICE_DATE(), ldi.getBRAND(),
									ldi.getINVOICE_DUE(), ldi.getINVOICE_NO(),
									ldi.getAMOUNT(), ldi.getREMAINING_AMOUNT(),
									ldi.getTOTAL(), di.getOUTLETNAME(),
									di.getOUTLETADDRESS(), di.getTTDFADMGR(),
									di.getCOMPANYNAME(), di.getCOMPANYADDRESS(),
									Function.getPeriod());
							if(result1.equals("success")){
								result = "success";
							}else {
								result = "failed";
							}
							System.out.println(result + " dalem");
						}

					}
					// System.out.println("di sini");
				}
				// System.out.println(lidim);

			}

		} catch (Exception e) {
			e.printStackTrace();
			result = e.getMessage();
		}
		return result;
	}

}
