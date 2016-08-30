/**
 * 
 */
package com.newgen.myapp.controller;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.newgen.myapp.dao.AddressDao;
import com.newgen.myapp.dao.VoterDao;
import com.newgen.myapp.pojo.Address;
import com.newgen.myapp.pojo.StatesAndCities;
import com.newgen.myapp.pojo.Voter;

/**
 * @author Admin
 * 
 */
@Controller
public class VoterController {
	private static final Logger logger = LoggerFactory
			.getLogger(VoterController.class);
	@Autowired
	private VoterDao voterDao;

	@Autowired
	private AddressDao addressDao;

	@RequestMapping(value = "/insertVoterDetails", method = RequestMethod.GET)
	public ModelAndView registerVoter(
			@ModelAttribute("insertVoter") Voter insertVoter) {
		logger.debug("in voterController method: registerVoter()");
		ModelAndView model = new ModelAndView("insertVoterDetails");
		Set<String> stateList = addressDao.getStateList();
		model.addObject("stateList", stateList);
		logger.debug("ouside voterController method: registerVoter()");
		return model;
	}

	@RequestMapping(value = "/selectCity", method = RequestMethod.GET)
	public ModelAndView selectCity(
			@ModelAttribute("insertVoter") Voter insertVoter,
			@ModelAttribute("stateName") StatesAndCities state,
			@ModelAttribute("cityName") StatesAndCities city) {
		logger.debug("in voterController method: selectCity()");
		String stateName = state.getStateName();
		List<String> cityList = addressDao.getCityList(stateName);
		System.out.println("cityList========================="
				+ cityList.size());
		ModelAndView model = new ModelAndView("insertVoterDetails");
		model.addObject("cityList", cityList);
		logger.debug("ouside voterController method: selectCity()");
		return model;
	}

	@RequestMapping(value = "/saveVoterDetails", method = RequestMethod.POST)
	public ModelAndView saveVoterDetails(@ModelAttribute Voter voter,
			String voterId, Address address) {
		logger.debug("in voterController method: saveVoterDetails()");
		if (voter != null) {
			voterId = voterDao.saveVoterDetails(voter);
		}
		ModelAndView model = new ModelAndView("getVoterDetails");
		model.addObject("voterId", voterId);
		logger.debug("ouside voterController method: saveVoterDetails()");
		return model;
	}

	@RequestMapping(value = "/getVoterList", method = RequestMethod.GET)
	public ModelAndView getVoterList(
			@ModelAttribute("listVoter") Voter listVoter) {
		logger.debug("in voterController method: getVoterList()");

		List<Voter> voterList = voterDao.getVoterList();
		ModelAndView model = new ModelAndView("getVoterList");
		model.addObject("voterList", voterList);
		logger.debug("ouside voterController method: getVoterList()");
		return model;
	}

	@RequestMapping(value = "/getVoterDetails", method = RequestMethod.GET)
	public ModelAndView getVoterDetails(@RequestParam("voterId") String voterId) {
		logger.debug("in voterController method: getVoterDetails()");

		Voter voter = voterDao.getVoterDetails(voterId);
		ModelAndView model = new ModelAndView("getVoterDetails");
		model.addObject("voter", voter);
		logger.debug("ouside voterController method: getVoterDetails()");
		return model;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updateVoterDetails(
			@ModelAttribute("updateVoter") Voter updateVoter) {
		logger.debug("in voterController method: updateVoterDetails()");

		String voterId = updateVoter.getVoterId();
		if (voterId != null) {
			voterDao.updateVoterDetails(updateVoter);
		}
		ModelAndView model = new ModelAndView("getVoterList");
		model.addObject("message",
				"Details submitted by you has been updated successfully! for VoterId: "
						+ voterId);
		logger.debug("ouside voterController method: updateVoterDetails()");
		return model;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteVoter(@RequestParam("voterId") String voterId) {
		logger.debug("in voterController method: deleteVoter()");
		if (voterId != null) {
			voterDao.deleteVoter(voterId);
		}
		ModelAndView model = new ModelAndView("getVoterList");
		model.addObject("message",
				"Records has been deleted successfully! for VoterId: "
						+ voterId);
		logger.debug("ouside voterController method: deleteVoter()");
		return model;
	}
}
