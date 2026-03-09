package com.grownited.controller.Admin;

import java.time.LocalDate;
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
	
	@GetMapping("/admin/createInvoice")
	public String createInvoice() {
		return "Admin/Invoice/GenerateInvoice";
	}
	
	@PostMapping("/admin/generateInvoice")
	public String generateInvoice(InvoiceEntity invoiceEntity) {
		invoiceEntity.setInvoiceDate(LocalDate.now());
		invoiceRepository.save(invoiceEntity);
		return "redirect:/admin/invoiceList";
	}
	
	@GetMapping("/admin/invoiceList")
	public String invoiceList(Model model) {
		List<InvoiceEntity> invoices = invoiceRepository.findAll();
		model.addAttribute("invoices", invoices);
		return "Admin/Invoice/InvoiceList";
	}
	
	@GetMapping("/admin/deleteInvoice")
	public String deleteInvoice(Integer invoiceId) {
		invoiceRepository.deleteById(invoiceId);
		return "redirect:/admin/invoiceList";
	}
}
