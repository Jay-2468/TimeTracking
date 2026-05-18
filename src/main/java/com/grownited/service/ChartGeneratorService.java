package com.grownited.service;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.Map;

@Service
public class ChartGeneratorService {

	/**
	 * PROJECT report: Bar chart — Hours per day Returns Base64-encoded PNG string
	 */
	public String generateBarChartBase64(Map<String, Double> dailyHours) throws Exception {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dailyHours.forEach((date, hours) -> dataset.addValue(hours, "Hours Logged", date));

		JFreeChart chart = ChartFactory.createBarChart("Hours Logged Per Day", "Date", "Hours", dataset,
				PlotOrientation.VERTICAL, true, true, false);

		// Style the chart
		chart.setBackgroundPaint(Color.WHITE);
		CategoryPlot plot = chart.getCategoryPlot();
		plot.setBackgroundPaint(new Color(245, 245, 245));
		plot.setRangeGridlinePaint(Color.LIGHT_GRAY);

		// Rotate x-axis labels so dates don't overlap
		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);

		BarRenderer renderer = (BarRenderer) plot.getRenderer();
		renderer.setSeriesPaint(0, new Color(54, 162, 235));

		return toBase64Png(chart, 700, 350);
	}

	/**
	 * PRODUCTIVITY report: Pie chart — Completed vs Pending Returns Base64-encoded
	 * PNG string
	 */
	public String generatePieChartBase64(int completed, int pending) throws Exception {
		DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
		dataset.setValue("Completed (" + completed + ")", completed);
		dataset.setValue("Pending (" + pending + ")", pending);

		JFreeChart chart = ChartFactory.createPieChart("Task Completion Breakdown", dataset, true, true, false);

		chart.setBackgroundPaint(Color.WHITE);

		return toBase64Png(chart, 500, 350);
	}

	private String toBase64Png(JFreeChart chart, int width, int height) throws Exception {
		BufferedImage image = chart.createBufferedImage(width, height);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(image, "PNG", baos);
		return Base64.getEncoder().encodeToString(baos.toByteArray());
	}
}