package com.Spring.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.Spring.entity.CitizenPlan;
import com.Spring.repo.CitizenPlanRepository;

@Component
public class DataLoader implements ApplicationRunner {
	@Autowired
	private CitizenPlanRepository repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		repo.deleteAll();

		CitizenPlan c1 = new CitizenPlan();
		c1.setCitizenName("John Doe");
		c1.setGender("Male");
		c1.setPlanName("Cash");
		c1.setPlanStatus("Approved");
		c1.setPlanStartDate(LocalDate.of(2022, 1, 1));
		c1.setPlanEndDate(LocalDate.of(2022, 12, 31));
		c1.setBenefitAmount(1000.00);
		c1.setDenialReason("");
		c1.setTerminatedDate(null);
		c1.setTerminationReason("");

		CitizenPlan c2 = new CitizenPlan();
		c2.setCitizenName("Jane Doe");
		c2.setGender("Female");
		c2.setPlanName("Food");
		c2.setPlanStatus("Approved");
		c2.setPlanStartDate(LocalDate.of(2022, 2, 1));
		c2.setPlanEndDate(LocalDate.of(2022, 11, 30));
		c2.setBenefitAmount(500.00);
		c2.setDenialReason("");
		c2.setTerminatedDate(null);
		c2.setTerminationReason("");

		CitizenPlan c3 = new CitizenPlan();
		c3.setCitizenName("Bob Smith");
		c3.setGender("Male");
		c3.setPlanName("Employment");
		c3.setPlanStatus("Denied");
		c3.setPlanStartDate(LocalDate.of(2022, 3, 1));
		c3.setPlanEndDate(LocalDate.of(2022, 10, 31));
		c3.setBenefitAmount(0.00);
		c3.setDenialReason("Not eligible");
		c3.setTerminatedDate(null);
		c3.setTerminationReason("");

		CitizenPlan c4 = new CitizenPlan();
		c4.setCitizenName("Mary Smith");
		c4.setGender("Female");
		c4.setPlanName("Medical");
		c4.setPlanStatus("Approved");
		c4.setPlanStartDate(LocalDate.of(2022, 4, 1));
		c4.setPlanEndDate(LocalDate.of(2022, 9, 30));
		c4.setBenefitAmount(2000.00);
		c4.setDenialReason("");
		c4.setTerminatedDate(null);
		c4.setTerminationReason("");

		CitizenPlan c5 = new CitizenPlan();
		c5.setCitizenName("Tom Brown");
		c5.setGender("Male");
		c5.setPlanName("Cash");
		c5.setPlanStatus("Terminated");
		c5.setPlanStartDate(LocalDate.of(2022, 5, 1));
		c5.setPlanEndDate(LocalDate.of(2022, 8, 31));
		c5.setBenefitAmount(500.00);
		c5.setDenialReason("");
		c5.setTerminatedDate(LocalDate.of(2022, 6, 30));
		c5.setTerminationReason("Found employment");

		CitizenPlan c6 = new CitizenPlan();
		c6.setCitizenName("Anna Green");
		c6.setGender("Female");
		c6.setPlanName("Food");
		c6.setPlanStatus("Approved");
		c6.setPlanStartDate(LocalDate.of(2022, 6, 1));
		c6.setPlanEndDate(LocalDate.of(2022, 7, 31));
		c6.setBenefitAmount(250.00);
		c6.setDenialReason("");
		c6.setTerminatedDate(null);
		c6.setTerminationReason("");

		CitizenPlan c7 = new CitizenPlan();

		c7.setCitizenName("Jasmine");
		c7.setGender("Female");
		c7.setPlanName("Food");
		c7.setPlanStatus("Approved");
		c7.setPlanStartDate(LocalDate.of(2021, 7, 15));
		c7.setPlanEndDate(LocalDate.of(2022, 7, 15));
		c7.setBenefitAmount(10000.0);
		c7.setDenialReason(null);
		c7.setTerminatedDate(null);
		c7.setTerminationReason(null);

		CitizenPlan c8 = new CitizenPlan();

		c8.setCitizenName("Ethan");
		c8.setGender("Male");
		c8.setPlanName("Employment");
		c8.setPlanStatus("Denied");
		c8.setPlanStartDate(LocalDate.of(2021, 6, 1));
		c8.setPlanEndDate(LocalDate.of(2022, 6, 1));
		c8.setBenefitAmount(20000.0);
		c8.setDenialReason("Not eligible for benefits");
		c8.setTerminatedDate(null);
		c8.setTerminationReason(null);

		CitizenPlan c9 = new CitizenPlan();

		c9.setCitizenName("Sophie");
		c9.setGender("Female");
		c9.setPlanName("Medical");
		c9.setPlanStatus("Approved");
		c9.setPlanStartDate(LocalDate.of(2021, 3, 5));
		c9.setPlanEndDate(LocalDate.of(2022, 3, 5));
		c9.setBenefitAmount(50000.0);
		c9.setDenialReason(null);
		c9.setTerminatedDate(null);
		c9.setTerminationReason(null);

		CitizenPlan c10 = new CitizenPlan();

		c10.setCitizenName("Oscar");
		c10.setGender("Male");
		c10.setPlanName("Cash");
		c10.setPlanStatus("Terminated");
		c10.setPlanStartDate(LocalDate.of(2021, 1, 1));
		c10.setPlanEndDate(LocalDate.of(2022, 1, 1));
		c10.setBenefitAmount(30000.0);
		c10.setDenialReason(null);
		c10.setTerminatedDate(LocalDate.of(2021, 11, 1));
		c10.setTerminationReason("Found employment");

		CitizenPlan c11 = new CitizenPlan();

		c11.setCitizenName("John Smith");
		c11.setGender("Male");
		c11.setPlanName("Cash");
		c11.setPlanStatus("Approved");
		c11.setPlanStartDate(LocalDate.of(2021, 1, 1));
		c11.setPlanEndDate(LocalDate.of(2021, 12, 31));
		c11.setBenefitAmount(10000.0);
		c11.setDenialReason("");
		c11.setTerminatedDate(null);
		c11.setTerminationReason("");

		CitizenPlan c12 = new CitizenPlan();

		c12.setCitizenName("Emily Davis");
		c12.setGender("Female");
		c12.setPlanName("Food");
		c12.setPlanStatus("Approved");
		c12.setPlanStartDate(LocalDate.of(2021, 2, 1));
		c12.setPlanEndDate(LocalDate.of(2021, 11, 30));
		c12.setBenefitAmount(5000.0);
		c12.setDenialReason("");
		c12.setTerminatedDate(null);
		c12.setTerminationReason("");

		CitizenPlan c13 = new CitizenPlan();

		c13.setCitizenName("Samuel Johnson");
		c13.setGender("Male");
		c13.setPlanName("Employment");
		c13.setPlanStatus("Denied");
		c13.setPlanStartDate(LocalDate.of(2021, 3, 1));
		c13.setPlanEndDate(LocalDate.of(2021, 10, 31));
		c13.setBenefitAmount(0.0);
		c13.setDenialReason("Not eligible for program");
		c13.setTerminatedDate(null);
		c13.setTerminationReason("");

		CitizenPlan c14 = new CitizenPlan();

		c14.setCitizenName("Avery Wilson");
		c14.setGender("Male");
		c14.setPlanName("Medical");
		c14.setPlanStatus("Approved");
		c14.setPlanStartDate(LocalDate.of(2021, 4, 1));
		c14.setPlanEndDate(LocalDate.of(2021, 9, 30));
		c14.setBenefitAmount(8000.0);
		c14.setDenialReason("");
		c14.setTerminatedDate(null);
		c14.setTerminationReason("");

		CitizenPlan c15 = new CitizenPlan();

		c15.setCitizenName("Olivia Garcia");
		c15.setGender("Female");
		c15.setPlanName("Cash");
		c15.setPlanStatus("Terminated");
		c15.setPlanStartDate(LocalDate.of(2021, 5, 1));
		c15.setPlanEndDate(LocalDate.of(2021, 8, 31));
		c15.setBenefitAmount(5000.0);
		c15.setDenialReason("");
		c15.setTerminatedDate(LocalDate.of(2021, 7, 15));
		c15.setTerminationReason("Found employment");

		CitizenPlan c16 = new CitizenPlan();

		c16.setCitizenName("William Brown");
		c16.setGender("Male");
		c16.setPlanName("Food");
		c16.setPlanStatus("Approved");
		c16.setPlanStartDate(LocalDate.of(2021, 6, 1));
		c16.setPlanEndDate(LocalDate.of(2021, 7, 31));
		c16.setBenefitAmount(2500.0);
		c16.setDenialReason("");
		c16.setTerminatedDate(null);
		c16.setTerminationReason("");

		CitizenPlan c17 = new CitizenPlan();

		c17.setCitizenName("Mary");
		c17.setGender("Female");
		c17.setPlanName("Cash");
		c17.setPlanStatus("Approved");
		c17.setPlanStartDate(LocalDate.of(2022, 3, 15));
		c17.setPlanEndDate(LocalDate.of(2023, 3, 14));
		c17.setBenefitAmount(1500.00);
		c17.setDenialReason("");
		c17.setTerminatedDate(null);
		c17.setTerminationReason("");

		CitizenPlan c18 = new CitizenPlan();

		c18.setCitizenName("James");
		c18.setGender("Male");
		c18.setPlanName("Food");
		c18.setPlanStatus("Denied");
		c18.setPlanStartDate(LocalDate.of(2022, 3, 1));
		c18.setPlanEndDate(LocalDate.of(2023, 2, 28));
		c18.setBenefitAmount(500.00);
		c18.setDenialReason("Not eligible");
		c18.setTerminatedDate(null);
		c18.setTerminationReason("");

		CitizenPlan c19 = new CitizenPlan();

		c19.setCitizenName("Olivia");
		c19.setGender("Female");
		c19.setPlanName("Medical");
		c19.setPlanStatus("Approved");
		c19.setPlanStartDate(LocalDate.of(2022, 1, 1));
		c19.setPlanEndDate(LocalDate.of(2022, 12, 31));
		c19.setBenefitAmount(2000.00);
		c19.setDenialReason("");
		c19.setTerminatedDate(null);
		c19.setTerminationReason("");

		CitizenPlan c20 = new CitizenPlan();

		c20.setCitizenName("David");
		c20.setGender("Male");
		c20.setPlanName("Employment");
		c20.setPlanStatus("Terminated");
		c20.setPlanStartDate(LocalDate.of(2022, 2, 1));
		c20.setPlanEndDate(LocalDate.of(2023, 1, 31));
		c20.setBenefitAmount(1000.00);
		c20.setDenialReason("");
		c20.setTerminatedDate(LocalDate.of(2022, 11, 15));
		c20.setTerminationReason("Found employment");

		CitizenPlan c21 = new CitizenPlan();

		c21.setCitizenName("Emma");
		c21.setGender("Female");
		c21.setPlanName("Cash");
		c21.setPlanStatus("Approved");
		c21.setPlanStartDate(LocalDate.of(2021, 12, 15));
		c21.setPlanEndDate(LocalDate.of(2022, 12, 14));
		c21.setBenefitAmount(1500.00);
		c21.setDenialReason("");
		c21.setTerminatedDate(null);
		c21.setTerminationReason("");

		CitizenPlan c22 = new CitizenPlan();

		c22.setCitizenName("Jane Doe");
		c22.setGender("Female");
		c22.setPlanName("Medical");
		c22.setPlanStatus("Terminated");
		c22.setPlanStartDate(LocalDate.of(2021, 5, 1));
		c22.setPlanEndDate(LocalDate.of(2022, 4, 30));
		c22.setBenefitAmount(5000.00);
		c22.setDenialReason("N/A");
		c22.setTerminatedDate(LocalDate.of(2022, 1, 15));
		c22.setTerminationReason("Completed treatment");

		// c23
		CitizenPlan c23 = new CitizenPlan();

		c23.setCitizenName("John Smith");
		c23.setGender("Male");
		c23.setPlanName("Employment");
		c23.setPlanStatus("Approved");
		c23.setPlanStartDate(LocalDate.of(2021, 10, 1));
		c23.setPlanEndDate(LocalDate.of(2022, 9, 30));
		c23.setBenefitAmount(10000.00);
		c23.setDenialReason("N/A");
		c23.setTerminatedDate(null);
		c23.setTerminationReason(null);

		// c24
		CitizenPlan c24 = new CitizenPlan();

		c24.setCitizenName("Sarah Lee");
		c24.setGender("Female");
		c24.setPlanName("Food");
		c24.setPlanStatus("Denied");
		c24.setPlanStartDate(LocalDate.of(2021, 3, 1));
		c24.setPlanEndDate(LocalDate.of(2022, 2, 28));
		c24.setBenefitAmount(2000.00);
		c24.setDenialReason("Exceeded income limit");
		c24.setTerminatedDate(null);
		c24.setTerminationReason(null);

		// c25
		CitizenPlan c25 = new CitizenPlan();

		c25.setCitizenName("Michael Johnson");
		c25.setGender("Male");
		c25.setPlanName("Cash");
		c25.setPlanStatus("Approved");
		c25.setPlanStartDate(LocalDate.of(2022, 1, 1));
		c25.setPlanEndDate(LocalDate.of(2022, 12, 31));
		c25.setBenefitAmount(1500.00);
		c25.setDenialReason("N/A");
		c25.setTerminatedDate(null);
		c25.setTerminationReason(null);

		// c26
		CitizenPlan c26 = new CitizenPlan();

		c26.setCitizenName("Emily Chen");
		c26.setGender("Female");
		c26.setPlanName("Medical");
		c26.setPlanStatus("Terminated");
		c26.setPlanStartDate(LocalDate.of(2021, 6, 1));
		c26.setPlanEndDate(LocalDate.of(2022, 5, 31));
		c26.setBenefitAmount(6000.00);
		c26.setDenialReason("N/A");
		c26.setTerminatedDate(LocalDate.of(2022, 4, 15));
		c26.setTerminationReason("Moved out of state");

		List<CitizenPlan> list = Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16,
				c17, c18, c19, c20, c21, c22, c23, c24, c25, c26);
		repo.saveAll(list);

	}
}
