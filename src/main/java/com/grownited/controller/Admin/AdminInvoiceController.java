package com.grownited.controller.Admin;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grownited.entity.InvoiceEntity;
import com.grownited.entity.ProjectEntity;
import com.grownited.repository.InvoiceRepository;
import com.grownited.repository.ProjectRepository;
import com.grownited.service.InvoiceService;

@Controller
@RequestMapping("/admin")
public class AdminInvoiceController {

	@Autowired
	private InvoiceRepository invoiceRepo;

	@Autowired
	private ProjectRepository projectRepo;

	@Autowired
	private InvoiceService invoiceService;

	// Show form
	@GetMapping("/generateInvoice")
	public String showForm(Model model) {
		
		List<ProjectEntity> projects = projectRepo.findAll();
		model.addAttribute("projects", projects);
		
		return "Admin/Invoice/GenerateInvoice";
	}

	// Generate Invoice
	@PostMapping("/generateInvoice")
	public String generateInvoice(@RequestParam Long projectId, @RequestParam Double totalHours,
			@RequestParam BigDecimal ratePerHour, @RequestParam String description, @RequestParam String paymentStatus,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate invoiceDate) throws Exception {

		InvoiceEntity invoice = new InvoiceEntity();

		invoice.setProject(projectRepo.findById(projectId).get());
		invoice.setTotalHours(totalHours);
		invoice.setRatePerHour(ratePerHour);

		BigDecimal total = ratePerHour.multiply(BigDecimal.valueOf(totalHours));
		invoice.setTotalAmount(total);

		invoice.setInvoiceDate(invoiceDate);
		invoice.setDescription(description);

		invoice.setPaymentStatus(InvoiceEntity.PaymentStatus.valueOf(paymentStatus));

		invoice.setInvoiceNumber("INV-" + System.currentTimeMillis());

		invoiceRepo.save(invoice);

		// Generate PDF
		String path = invoiceService.generatePdf(invoice);
		invoice.setPdfPath(path);

		invoiceRepo.save(invoice);

		return "redirect:/admin/invoiceList";
	}

	// List Page
	@GetMapping("/invoiceList")
	public String list(Model model) {
		model.addAttribute("invoices", invoiceRepo.findAll());
		return "Admin/Invoice/InvoiceList";
	}

	// Download
	@GetMapping("/downloadInvoice")
	public ResponseEntity<Resource> download(@RequestParam Long invoiceId) throws Exception {

		InvoiceEntity invoice = invoiceRepo.findById(invoiceId).get();

		Path path = Paths.get(invoice.getPdfPath());

		Resource resource = new UrlResource(path.toUri());

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + path.getFileName().toString())
				.body(resource);
	}
}
