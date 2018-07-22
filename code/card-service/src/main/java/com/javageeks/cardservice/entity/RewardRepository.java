package com.javageeks.cardservice.entity;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface RewardRepository extends JpaRepository<Reward,Long>{
	
	@Modifying(flushAutomatically = true, clearAutomatically = true)
	@Transactional
	@Query("UPDATE Reward r SET r.rewardPoints=r.rewardPoints+?2 WHERE r.userId=?1")
	public void addReward(Long userId,Long points);
	
	@Query("SELECT r FROM Reward r WHERE r.userId=?1")
	public Reward findRewardByUserId(Long userId);

}
