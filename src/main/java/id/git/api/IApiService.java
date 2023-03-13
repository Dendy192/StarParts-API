package id.git.api;

import id.git.model.ResponseGetInvoice;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IApiService {
	@GET("eStatement_KonfirmasiHutang")
	Call<ResponseGetInvoice> getInvoice(
			@Query(value = "id", encoded = true) String id);

}
