/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BieuDo;

import DTO.ChiTietHDDTO;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class BieuDoServiceImplements implements BieuDoService{

    private BieuDoDAO bdDAO = null;
    
    public BieuDoServiceImplements(){
        bdDAO = new BieuDoDAOImplements();
    }
    
    @Override
    public List<ChiTietHDDTO> getListCTHD() {
        return bdDAO.getListCTHD();
    }
    
}
