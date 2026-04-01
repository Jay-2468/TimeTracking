package com.grownited.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.grownited.entity.InvoiceEntity;

public class InvoiceDto {

    private Long invoiceId;
    
    private Long projectId;
    
    private Long generatedByUserId;

    private Double totalHours;

    private BigDecimal ratePerHour;
   
    private BigDecimal totalAmount;

    private LocalDate invoiceDate;
    
    private InvoiceEntity.PaymentStatus paymentStatus; 

    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;

    // Getters and Setters

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getGeneratedByUserId() {
        return generatedByUserId;
    }

    public void setGeneratedByUserId(Long generatedByUserId) {
        this.generatedByUserId = generatedByUserId;
    }

    public Double getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(Double totalHours) {
        this.totalHours = totalHours;
    }

    public BigDecimal getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(BigDecimal ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public InvoiceEntity.PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(InvoiceEntity.PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}