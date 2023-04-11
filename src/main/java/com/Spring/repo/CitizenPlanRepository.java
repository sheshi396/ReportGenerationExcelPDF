package com.Spring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Spring.entity.CitizenPlan;
import com.Spring.request.SearchRequest;

public interface CitizenPlanRepository extends JpaRepository<CitizenPlan, Long> {

	@Query("select distinct(planName) from CitizenPlan")
	public List<String> getPlanNames();

	@Query("select distinct(planStatus) from CitizenPlan")
	public List<String> getPlanStatus();

//	public List<CitizenPlan> findByPlanNameAndPlanStatus(String planName, String planStatus);
//
//	public List<CitizenPlan> findByPlanName(String planName);
//
//	public List<CitizenPlan> findByPlanStatus(String planStatus);

}
