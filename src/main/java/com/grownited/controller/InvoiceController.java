package com.grownited.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.grownited.repository.InvoiceRepository;

@Controller
public class InvoiceController {

	@Autowired
	InvoiceRepository invoiceRepository;
	
	
}
