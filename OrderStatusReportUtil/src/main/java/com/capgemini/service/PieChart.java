package com.capgemini.service;

import java.awt.Color;
import java.io.*;
import java.text.DecimalFormat;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class PieChart {
   
   public void createPieChart( ) throws Exception {
	  System.out.println("in PieChart createPieChart method");
      DefaultPieDataset dataset = new DefaultPieDataset( );
      dataset.setValue("Completed Orders", new Double( 318 ) );
      dataset.setValue("In-Progress Orders", new Double( 78 ) );
      dataset.setValue("Scheduled Orders", new Double( 30 ) );
      dataset.setValue("Errored Orders", new Double( 23 ) );
      dataset.setValue("Expired Orders", new Double( 15 ) );

      JFreeChart chart = ChartFactory.createPieChart(
         "Order Status Report",   // chart title
         dataset,          // data
         true,             // include legend
         true,
         false);
      PiePlot plot = (PiePlot) chart.getPlot();
      plot.setSectionPaint("Completed Orders", Color.green);
      plot.setSectionPaint("Errored Orders", Color.red);
      plot.setSectionPaint("In-Progress Orders", Color.yellow);
      plot.setSectionPaint("Scheduled Orders", Color.blue);
      plot.setSectionPaint("Expired Orders", Color.cyan);
      PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
              "{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
      plot.setLabelGenerator(gen);
      int width = 640;   /* Width of the image */
      int height = 480;  /* Height of the image */ 
      File pieChart = new File( "PieChart.jpeg" ); 
      ChartUtilities.saveChartAsJPEG( pieChart , chart , width , height );
      System.out.println("Pie Chart created and saved in file");
   }
}
