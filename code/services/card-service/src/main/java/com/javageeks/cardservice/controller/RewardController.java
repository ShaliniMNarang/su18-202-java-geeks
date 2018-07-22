package com.javageeks.cardservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javageeks.cardservice.entity.Card;
import com.javageeks.cardservice.entity.Reward;
import com.javageeks.cardservice.entity.RewardRepository;

@RestController
@RequestMapping("/api/reward")
public class RewardController {

	private Long DEFAULT_POINT=10L;
	
	@Autowired
	private RewardRepository rewardRepository;
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String test() {
		return "Test";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Reward> getReward(@PathVariable Long id) {
		return new ResponseEntity<Reward>(rewardRepository.findById(id).get(),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Reward>> getRewards() {
		return new ResponseEntity<List<Reward>>(rewardRepository.findAll(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/user/{userId}",method=RequestMethod.GET)
	public ResponseEntity<Reward> getRewardByUserId(@PathVariable Long userId) {
		return new ResponseEntity<Reward>(rewardRepository.findRewardByUserId(userId),HttpStatus.OK);
	}
	
	@RequestMapping(value="/user/{userId}",method=RequestMethod.POST)
	public ResponseEntity<Reward> addReward(@PathVariable Long userId) {
		if (rewardRepository.findRewardByUserId(userId) != null)
			rewardRepository.addReward(userId,DEFAULT_POINT);
		else {
			Reward reward=new Reward();
			reward.setUserId(userId);
			reward.setRewardPoints(DEFAULT_POINT);
			rewardRepository.save(reward);
		}
			
		return new ResponseEntity<Reward>(rewardRepository.findRewardByUserId(userId),HttpStatus.CREATED);
	}
	
	
}
