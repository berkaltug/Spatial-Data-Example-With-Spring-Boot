package com.berkaltug.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.berkaltug.demo.Service.CityService;
import com.berkaltug.demo.Service.IlceService;
import com.berkaltug.demo.Service.SecmenService;
import com.berkaltug.demo.repository.CityRepo;
import com.berkaltug.demo.repository.IlceRepo;
import com.berkaltug.demo.repository.SecmenRepo;

@Controller
@RequestMapping(value="/")
public class HomeController {
	
	@Autowired
	private CityService cr;
	@Autowired
	private IlceService ir;
	@Autowired
	private SecmenService ss;
	
	
	@RequestMapping(value = "")
    public String index(Model model) {
		
		model.addAttribute("iller",this.cr.getCities());
		model.addAttribute("edirne_ilceler",this.cr.getCityById(1).parseIlce(this.cr.getCityById(1).getIlceler()));
		model.addAttribute("ankara_ilceler",this.cr.getCityById(2).parseIlce(this.cr.getCityById(2).getIlceler()));
		model.addAttribute("edirne", this.cr.getCityById(1).parseCoordinate(this.cr.getCityById(1).getKonum()));
		model.addAttribute("ankara", this.cr.getCityById(2).parseCoordinate(this.cr.getCityById(2).getKonum()));
		model.addAttribute("merkez", this.ir.getIlceById(1).parseCoordinate(this.ir.getIlceById(1).getKonum()));
		model.addAttribute("uzunkopru", this.ir.getIlceById(2).parseCoordinate(this.ir.getIlceById(2).getKonum()));
		model.addAttribute("cankaya", this.ir.getIlceById(3).parseCoordinate(this.ir.getIlceById(3).getKonum()));
		model.addAttribute("sincan", this.ir.getIlceById(4).parseCoordinate(this.ir.getIlceById(4).getKonum()));
		model.addAttribute("merkez_secmen" ,this.ir.getIlceById(1).getSecmenler());
		model.addAttribute("uzunkopru_secmen",this.ir.getIlceById(2).getSecmenler());
		model.addAttribute("cankaya_secmen",this.ir.getIlceById(3).getSecmenler());
		model.addAttribute("sincan_secmen",this.ir.getIlceById(4).getSecmenler());
		
		return "index";
	}
	
}
