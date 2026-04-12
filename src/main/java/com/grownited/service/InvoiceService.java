package com.grownited.service;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Service;

import com.grownited.entity.InvoiceEntity;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class InvoiceService {

	public String generatePdf(InvoiceEntity invoice) throws Exception {

		String folder = "uploads/invoices/";
		new File(folder).mkdirs();

		String filePath = folder + invoice.getInvoiceNumber() + ".pdf";

		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(filePath));

		document.open();

		Font titleFont = new Font(Font.HELVETICA, 18, Font.BOLD);
		Font normal = new Font(Font.HELVETICA, 12);

		document.add(new Paragraph("INVOICE", titleFont));
		document.add(new Paragraph(" "));

		document.add(new Paragraph("Invoice No: " + invoice.getInvoiceNumber(), normal));
		document.add(new Paragraph("Date: " + invoice.getInvoiceDate(), normal));
		document.add(new Paragraph("Project: " + invoice.getProject().getProjectName(), normal));

		document.add(new Paragraph(" "));

		PdfPTable table = new PdfPTable(3);
		table.addCell("Hours");
		table.addCell("Rate");
		table.addCell("Total");

		table.addCell(invoice.getTotalHours().toString());
		table.addCell(invoice.getRatePerHour().toString());
		table.addCell(invoice.getTotalAmount().toString());

		document.add(table);

		document.add(new Paragraph(" "));
		document.add(new Paragraph("Description: " + invoice.getDescription()));

		document.close();

		return filePath;
	}
}
