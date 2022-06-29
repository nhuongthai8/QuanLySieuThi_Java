/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BieuDo;

import DTO.ChiTietHDDTO;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author ADMIN
 */
public class QLBieuDoController {
    
    private BieuDoService bdservice = null;
    
    public QLBieuDoController(){
        bdservice = new BieuDoServiceImplements();
    }
    
    public void setDataChart1(JPanel jpnItem){
        List<ChiTietHDDTO> listItem = bdservice.getListCTHD();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if(listItem != null){
            for(ChiTietHDDTO item : listItem){
            dataset.addValue(item.getThanhTien(), "Doanh Thu Trong Ngày", item.getNgayNhap());
             //dataset.addValue(item.getSoLuong(), "Tổng Tiền", item.getNgayNhap());
             //dataset.getValue(item.getGiaTien(), item.getNgayNhap());
            }
        }
           
        JFreeChart barChart = ChartFactory.createBarChart("Biểu đồ thống kê Doanh thu".toUpperCase(), "Thời Gian", "Mức Doanh Thu", dataset);
        ChartPanel chartpanel = new ChartPanel(barChart);
        chartpanel.setPreferredSize(new Dimension(jpnItem.getWidth(),321));
        
        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartpanel);
        jpnItem.validate();
        jpnItem.repaint();
    }
}
