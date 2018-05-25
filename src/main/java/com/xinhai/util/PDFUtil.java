//package com.xinhai.util;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStreamWriter;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.poi.xwpf.converter.core.BasicURIResolver;
//import org.apache.poi.xwpf.converter.core.FileImageExtractor;
//import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
//import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
//import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
//import org.apache.poi.xwpf.usermodel.XWPFDocument;
//import org.apache.poi.xwpf.usermodel.XWPFParagraph;
//import org.apache.poi.xwpf.usermodel.XWPFRun;
//
//public class PDFUtil {
//
//	private static String filePath = "/download";
//
//	@SuppressWarnings("resource")
//	public static String createWord(List<Map<String, Object>> datas, String realPath, String title) throws IOException {
//		String fileName = System.currentTimeMillis() + ".docx";
//		XWPFDocument xDocument = new XWPFDocument();
//
//		StringBuffer fileUrl = new StringBuffer(realPath).append(filePath).append("/").append(fileName);
//		File fileObj = new File(fileUrl.toString());
//		if (!fileObj.getParentFile().exists()) {
//			fileObj.getParentFile().mkdirs();
//		}
//		FileOutputStream out = new FileOutputStream(fileObj);
//		// 添加标题
//		XWPFParagraph titleParagraph = xDocument.createParagraph();
//		// 设置段落居中
//		titleParagraph.setAlignment(ParagraphAlignment.CENTER);
//		XWPFRun titleParagraphRun = titleParagraph.createRun();
//		titleParagraphRun.setText(title);
//		titleParagraphRun.setColor("000000");
//		titleParagraphRun.setFontSize(20);
//		// 段落
//		XWPFParagraph firstParagraph = xDocument.createParagraph();
//		XWPFRun run = firstParagraph.createRun();
//		run.setText("预警信息数量 ：" + (null == datas ? 0 : datas.size()));
//		if (null != datas) {
//			for (Map<String, Object> map : datas) {
//				run.addBreak();
//				run.setText("预警标题：" + map.get("title"));
//				run.addBreak();
//				run.setText("预警主信息：" + map.get("message"));
//				run.addBreak();
//				run.setText("预警生成时间" + DateUtil.curDateByStr(map.get("create_time") + "", DateUtil.YMDHMS));
//			}
//		}
//		run.setColor("696969");
//		run.setFontSize(12);
//		xDocument.write(out);
//		out.close();
//		return fileUrl.toString();
//	}
//
//	public static String docx2Html(String docFilePath, String realPath) throws FileNotFoundException, IOException {
//		String htmlPath = "";
//		String imagePathStr = "d:";
//		if (StrUtil.isBlank(realPath)) {
//			htmlPath = docFilePath.substring(0, docFilePath.lastIndexOf(".")) + ".html";
//		} else {
//			htmlPath = new StringBuffer(realPath).append(filePath).append("/")
//					.append(System.currentTimeMillis() + ".html").toString();
//		}
//		OutputStreamWriter outputStreamWriter = null;
//		try {
//			XWPFDocument document = new XWPFDocument(new FileInputStream(docFilePath));
//			XHTMLOptions options = XHTMLOptions.create();
//			// 存放图片的文件夹
//			options.setExtractor(new FileImageExtractor(new File(imagePathStr)));
//			// html中图片的路径
//			options.URIResolver(new BasicURIResolver("image"));
//			outputStreamWriter = new OutputStreamWriter(new FileOutputStream(htmlPath), "utf-8");
//			XHTMLConverter xhtmlConverter = (XHTMLConverter) XHTMLConverter.getInstance();
//			xhtmlConverter.convert(document, outputStreamWriter, options);
//		} finally {
//			if (outputStreamWriter != null) {
//				outputStreamWriter.close();
//			}
//		}
//		return htmlPath;
//	}
//
//	public static String html2PDF(String htmlFilePath, String realPath) throws IOException {
//		String pdfPath = "";
//		if (StrUtil.isBlank(realPath)) {
//			pdfPath = htmlFilePath.substring(0, htmlFilePath.lastIndexOf(".")) + ".pdf";
//		} else {
//			pdfPath = new StringBuffer(realPath).append(filePath).append("/")
//					.append(System.currentTimeMillis() + ".pdf").toString();
//		}
//
//		// 获得html文件了流
//		// Document document = new Document();
//
//		return pdfPath;
//	}
//
//	public static void main(String[] arg) throws IOException {
//
//		// try {
//		// // String createWord = PDFUtil.createWord(new ArrayList<Map<String,
//		// Object>>(),
//		// // "d:", "cheshi");
//		// // System.err.println(createWord);
//		// // String docx2Html = PDFUtil.docx2Html("d:/download/1525680650522.docx",
//		// "");
//		// // System.err.println(docx2Html);
//		//
//		// // PDFUtil.html2PDF("D:/download/1525680650522.html", "");
//		// } catch (FileNotFoundException e) {
//		// // TODO Auto-generated catch block
//		// e.printStackTrace();
//		// }
//	}
//
//}
