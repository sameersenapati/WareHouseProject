package in.nit.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class OrderMethodUtil {

	public void generatePie(String path,List<Object[]> data){
		//1.create dataset 
		DefaultPieDataset dataset=new DefaultPieDataset();
		for(Object[] arr:data) {
			//key-shipMode ,val-count
			dataset.setValue(arr[0].toString(), Double.valueOf(arr[1].toString()));
		}
		//2.create JFreeChat using ChartFactory 
		JFreeChart chart=ChartFactory.createPieChart3D("OrderMethodModes", dataset, true, true, false);
		//3.save as Image using ChartUtils
		try {
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/orderMethodA.jpg"), chart, 600, 500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void generateBar(String path,List<Object[]> data) {
		//1. Create DataSet
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		for(Object[] arr:data) {
			//value-index-1(y-axis), key-index-0(x-axis)
			dataset.setValue(Double.valueOf(arr[1].toString()),
					arr[0].toString(), "");
		}
		//2. Create JFreeChart using ChartFactory
		JFreeChart chart=ChartFactory.createBarChart("OrderMethodModes", "Modes", "COUNT", dataset);
		//3. Save as Image using ChartUtil
		try {
			ChartUtils.saveChartAsJPEG(new
					File(path+"/resources/images/orderMethodB.jpg"), chart, 500, 400);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}