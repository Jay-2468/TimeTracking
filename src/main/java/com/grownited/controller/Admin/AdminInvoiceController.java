package com.grownited.controller.Admin;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grownited.entity.InvoiceEntity;
import com.grownited.repository.InvoiceRepository;

@Controller
@RequestMapping("/admin")
public class AdminInvoiceController {

	@Autowired
	InvoiceRepository invoiceRepository;
	
	@GetMapping("/createInvoice")
	public String createInvoice() {
		return "Admin/Invoice/GenerateInvoice";
	}
	
	@PostMapping("/generateInvoice")
	public String generateInvoice(InvoiceEntity invoiceEntity) {
		invoiceEntity.setInvoiceDate(LocalDate.now());
		invoiceRepository.save(invoiceEntity);
		return "redirect:/admin/invoiceList";
	}
	
	@GetMapping("/invoiceList")
	public String invoiceList(Model model) {
		List<InvoiceEntity> invoices = invoiceRepository.findAll();
		model.addAttribute("invoices", invoices);
		return "Admin/Invoice/InvoiceList";
	}
	
	@GetMapping("/deleteInvoice")
	public String deleteInvoice(Integer invoiceId) {
		invoiceRepository.deleteById(invoiceId);
		return "redirect:/admin/invoiceList";
	}
}
