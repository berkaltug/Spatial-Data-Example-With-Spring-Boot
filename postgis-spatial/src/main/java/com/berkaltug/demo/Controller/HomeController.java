package com.berkaltug.demo.Controller;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.berkaltug.demo.Service.CityService;
import com.berkaltug.demo.Service.IlceService;
import com.berkaltug.demo.Service.SchoolService;
import com.berkaltug.demo.Service.SecmenService;
import com.berkaltug.demo.repository.CityRepo;
import com.berkaltug.demo.repository.IlceRepo;
import com.berkaltug.demo.repository.SecmenRepo;

import net.bytebuddy.asm.Advice.This;

@Controller
@RequestMapping(value="/")
public class HomeController {
	
	@Autowired
	private CityService cr;
	@Autowired
	private IlceService ir;
	@Autowired
	private SecmenService ss;
	@Autowired
	private SchoolService scs;
	
	
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
		model.addAttribute("merkez_okullar",this.ir.getIlceById(1).parseSchool(this.ir.getIlceById(1).getOkullar()));
		model.addAttribute("uzunkopru_okullar",this.ir.getIlceById(2).parseSchool(this.ir.getIlceById(2).getOkullar()));
		model.addAttribute("cankaya_okullar",this.ir.getIlceById(3).parseSchool(this.ir.getIlceById(3).getOkullar()));
		model.addAttribute("sincan_okullar",this.ir.getIlceById(4).parseSchool(this.ir.getIlceById(4).getOkullar()));
		model.addAttribute("m_o_koor",this.scs.getSchoolById(1).parseCoordinate(this.scs.getSchoolById(1).getKonum()));
		model.addAttribute("u_o_koor",this.scs.getSchoolById(2).parseCoordinate(this.scs.getSchoolById(2).getKonum()));
		model.addAttribute("c_o_koor",this.scs.getSchoolById(3).parseCoordinate(this.scs.getSchoolById(3).getKonum()));
		model.addAttribute("s_o_koor",this.scs.getSchoolById(4).parseCoordinate(this.scs.getSchoolById(4).getKonum()));
		model.addAttribute("merkez_secmen" ,this.scs.getSchoolById(1).getSecmenler());
		model.addAttribute("uzunkopru_secmen",this.scs.getSchoolById(2).getSecmenler());
		model.addAttribute("cankaya_secmen",this.scs.getSchoolById(3).getSecmenler());
		model.addAttribute("sincan_secmen",this.scs.getSchoolById(4).getSecmenler());
		
		return "index";
	}
	
}
