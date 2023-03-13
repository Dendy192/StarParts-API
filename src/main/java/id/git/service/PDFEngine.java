package id.git.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.log4j.Logger;

import id.git.conn.DBEngine;
import id.git.utils.Function;
import id.git.utils.SQLData;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

public class PDFEngine {

	private static Logger log = Logger.getLogger(PDFEngine.class.getName());

	public String getData(String name1, String idCustomer, String phone) {

		System.out.println("masuk ke sini apa kaga");
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String result = "";
		String period = Function.getPeriod();
		try {
			HashMap<String, String> source = SQLData.getParameter();
			String sourcePDF = source.get("pdf.source.file");
			String pathReport = "";
			if (name1.contains("/")) {
				name1 = name1.replace("/", "//");
			}
			String query = "SELECT DISTINCT \"OUTLET_NAME\",\"OUTLET_ID\" ,\"INVOICE_DATE\", \"INVOICE_DUE\", "
					+ "\"BRAND\", \"INVOICE_NO\", \"AMOUNT\", \"REMAINING_AMOUNT\", \"TTD_FAD_MGR\" "
					+ "FROM \"SP_STG_INVOICE\" WHERE \"OUTLET_NAME\" = ?";
			System.out.println(query);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String date1 = sdf.format(date);
			conn = DBEngine.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, name1);
			rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("masuk di if");
				String id = rs.getString("OUTLET_ID");
				String[] result1 = generateFile(id, period, name1, pathReport,
						sourcePDF, source);
				if (result1[0].equals("success")) {
					SendEngine se = new SendEngine();
					se.prepare(idCustomer, name1, phone, result1[1], source);
					result = "success";
				}
			}

			else {
				System.out.println("ga ada data");
				log.info("no data");
				result = "no data";
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.info("tes: " + e.getMessage());
			result = e.getMessage();
		}
		return result;
	}
	public String[] generateFile(String id, String period, String name1,
			String pathReport, String sourcePDF,
			HashMap<String, String> source) {
		String result = "";
		List<String> contentPDF = SQLData.getContentPDF();

		JasperReport jasperReport = null;
		Connection conn2 = null;
		String path = "";
		String idInvoice = generate();

		String foot1 = contentPDF.get(0);
		String foot2 = contentPDF.get(1);
		String foot3 = contentPDF.get(2);
		String src = source.get("pdf.path.report");
		try {
			System.out.println("masuk if di get data");
			File dir = new File(src + period);
			dir.mkdir();
			conn2 = DBEngine.getConnection();

			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("tableParam1", name1);
			parameters.put("idInvoice", idInvoice);
			parameters.put("foot1", foot1);
			parameters.put("foot2", foot2);
			parameters.put("foot3", foot3);
			JRPdfExporter exporter = new JRPdfExporter();
			InputStream is = new FileInputStream(new File(sourcePDF));
			jasperReport = (JasperReport) JRLoader.loadObject(is);
			System.out.println("connection");
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
					parameters, conn2);
			System.out.println("fill report");
			exporter.setParameter(JRExporterParameter.JASPER_PRINT,
					jasperPrint);
			ByteArrayOutputStream byteOS = new ByteArrayOutputStream();
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, byteOS);
			pathReport = src + period + "/";
			path = pathReport + name1 + ".pdf";
			// System.out.println("view");
			// JasperViewer.viewReport(jasperPrint);
			exporter.exportReport();
			log.error("coba di sini dah");
			FileOutputStream outputStream = new FileOutputStream(
					new File(path));
			byteOS.writeTo(outputStream);
			byteOS.flush();
			byteOS.close();
			outputStream.flush();
			outputStream.close();
			log.info(id + " " + period);
			// SQLData.recordInvoice(id, period);
//			SQLData.deleteSTG(id, period);
			result = "success";
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.getMessage());
			result = e.getMessage();
		}
		String[] result1 = {result, path, idInvoice};
		return result1;
	}

	public String generate() {
		String result = "";
		try {
			Date date = new Date();
			SimpleDateFormat dtf = new SimpleDateFormat("MMYY");
			String dateFormat = dtf.format(date);
			String randomSt = generateRandom();
			String randomSc = generateRandom();
			String finalInvo = dateFormat + "/SPM-FAD/" + randomSt + "/"
					+ randomSc;
			if (SQLData.checkGenerateID(finalInvo) == true) {
				do {
					finalInvo = reGenerate();
				} while (SQLData.checkGenerateID(finalInvo) == false);
			}
			result = finalInvo;
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();

			// TODO: handle exception
		}
		return result;
	}
	public String generateRandom() {
		String result = "";
		try {
			// String tes1 = "";
			for (int i = 0; i < 4; i++) {
				int randomNum = ThreadLocalRandom.current().nextInt(0, 9 + 1);
				String tes2 = String.valueOf(randomNum);
				if (!result.equals("")) {
					// System.out.println("masuk if");
					result = result + tes2;
				} else {
					// System.out.println("masuk else");
					result = tes2;
				}
			}
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
			// TODO: handle exception
		}
		return result;
	}
	public String reGenerate() {
		String result = "";
		try {
			Date date = new Date();
			SimpleDateFormat dtf = new SimpleDateFormat("MMYY");
			String dateFormat = dtf.format(date);
			String randomSt = generateRandom();
			String randomSc = generateRandom();
			result = dateFormat + "/SPM-FAD/" + randomSt + "/" + randomSc;
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();

			// TODO: handle exception
		}
		return result;
	}

}
