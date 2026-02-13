package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.InvoiceEntity;
import com.grownited.repository.InvoiceRepository;

@Controller
public class InvoiceController {

	@Autowired
	InvoiceRepository invoiceRepository;
	
	@GetMapping("/createInvoice")
	public String createInvoice() {
		return "Invoice/GenerateInvoice";
	}
	
	@PostMapping("/generateInvoice")
	public String generateInvoice(InvoiceEntity invoiceEntity) {
		invoiceRepository.save(invoiceEntity);
		return "redirect:/invoiceList";
	}
	
	@GetMapping("/invoiceList")
	public String invoiceList(Model model) {
		List<InvoiceEntity> invoices = invoiceRepository.findAll();
		model.addAttribute("invoices", invoices);
		return "Invoice/InvoiceList";
	}
	
	@GetMapping("/deleteInvoice")
	public String deleteInvoice(Integer invoiceId) {
		invoiceRepository.deleteById(invoiceId);
		return "redirect:/invoiceList";
	}
}
