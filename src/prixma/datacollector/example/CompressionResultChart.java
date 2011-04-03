package prixma.datacollector.example;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Collection;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import prixma.datacollector.compression.Record;


public class CompressionResultChart extends ApplicationFrame {

	private final Collection<Record> rawData;
	private final Collection<Record> compressedData;
	private static final int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private static final int HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 3;
	
	public CompressionResultChart(Collection<Record> rawData, Collection<Record> compressedData) {
		super("Compression Result");
		this.rawData = rawData;
		this.compressedData = compressedData;
		setLayout(new BorderLayout());
	}
	
	private ChartPanel renderChart(String title, XYSeries ...series){
		
	    final XYSeriesCollection data = new XYSeriesCollection();
	    
	    boolean legend = false;
	    boolean shapes = true;
	    
	    if(series.length > 1){
	    	legend = true;
	    	shapes = false;
	    }
	    
	    for(XYSeries serie : series){
	    	data.addSeries(serie);
	    }
	    
	    final JFreeChart chart = ChartFactory.createXYLineChart(
	        title,
	        "Timestamp", 
	        "Value", 
	        data,
	        PlotOrientation.VERTICAL,
	        legend,
	        true,
	        false
	    );

	    chart.setAntiAlias(true);
	    chart.setTextAntiAlias(true);
	   
	    XYPlot plot = (XYPlot) chart.getPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, true);
        renderer.setSeriesShapesVisible(0, shapes);  
        renderer.setSeriesLinesVisible(1, true);
        renderer.setSeriesShapesVisible(1, shapes); 
        renderer.setSeriesShape(0, new Rectangle2D.Double(-3, -3, 6, 6));
        renderer.setSeriesShape(1, new Ellipse2D.Double(-3, -3.0, 6, 6));
        
        plot.setRenderer(renderer);
        
	    final ChartPanel chartPanel = new ChartPanel(chart, false);
	    chartPanel.setMouseZoomable(true, false);
	 
	   
	    chartPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
	  
	    return chartPanel;
	    
		
	}
	
	private XYSeries createSeries(Collection<Record> records, String name){
		
		final XYSeries series = new XYSeries(name);
		
		for (Record record : records){
			series.add((double)record.getTimestamp(), record.getValue());
		}
		
		return series;
	}
	
	public void render(){
		
		XYSeries rawSerie = createSeries(rawData, "Raw Data");
		XYSeries compressedSerie = createSeries(compressedData, "Compressed Data");
		
		ChartPanel chart1 = renderChart("Raw Data", rawSerie);
		ChartPanel chart2 = renderChart("Compressed Data", compressedSerie);
		ChartPanel chart3 = renderChart("Result (Overlapping Data)", compressedSerie, rawSerie);
		
		getContentPane().add(chart1, BorderLayout.NORTH);
		getContentPane().add(chart2, BorderLayout.CENTER);
		getContentPane().add(chart3, BorderLayout.SOUTH);
		
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		RefineryUtilities.centerFrameOnScreen(this);
		pack();
		setVisible(true);
	}
	
	
}
