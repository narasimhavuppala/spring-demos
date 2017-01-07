package com.spring.jdbc.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.demo.dao.DepartmentRepository;
import com.spring.jdbc.demo.dao.impl.DepartmentRepositoryImpl;

public class TestJdbcTemplate {

	public static void main(String[] args) throws Exception {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appconfig.xml");
		DepartmentRepository objDeptdao = context.getBean(DepartmentRepositoryImpl.class);
		// Department

		// Create 10 objects

		List<Department> objDepartmentList = new ArrayList<Department>();

		int[] batchIds = new int[20000];

		for (int i = 0; i < 20000; i++) {
			Department objDepartment = new Department();
			objDepartment.setDepartmentId(i);
			batchIds[i] = i;
			objDepartment.setDepartmentName("DeptName" + i);
			objDepartment.setDepartmentHead("DeptHead" + i);
			objDepartmentList.add(i, objDepartment);

		}

		int chunkSize = 20;
		int threads = (objDepartmentList.size() / (chunkSize * 5));
		ExecutorService batchExecutor = Executors.newFixedThreadPool(10);

		for (int i = 0; i < objDepartmentList.size(); i = i + chunkSize) {
			int subListStart = i;
			int subListends = ((i + chunkSize) > objDepartmentList.size()) ? objDepartmentList.size() : i + chunkSize;

			//System.out.println("Start =" + subListStart + " and end=" + subListends);
			ChunkProcessIng obj = new ChunkProcessIng(objDeptdao, objDepartmentList.subList(subListStart, subListends),
					Arrays.copyOfRange(batchIds, subListStart, subListends));
			batchExecutor.execute(obj);
		}
		long end = System.currentTimeMillis();
		Thread.currentThread().join();
        if(batchExecutor.isTerminated() ==false){
        	
        }
	}

}

class ChunkProcessIng implements Runnable {

	DepartmentRepository objDeptdao;
	List<Department> objDepartmentList;
	int[] batchIds;

	public ChunkProcessIng(DepartmentRepository objDeptdao, List<Department> objDepartmentList, int[] batchIds) {

		this.batchIds = batchIds;
		this.objDepartmentList = objDepartmentList;
		this.objDeptdao = objDeptdao;
	}

	@Override
	public void run() {

		// Delete and Insert query
		//System.out.println("Thread " + Thread.currentThread().getName() + " Started");
		long start = System.currentTimeMillis();
		objDeptdao.deleteBatchDepartment(batchIds);
		objDeptdao.createDepartment(objDepartmentList);

		long end = System.currentTimeMillis();

		System.out.println("Thread " + Thread.currentThread().getName() + " Completed in = " + ((end - start) / 1000));

	}

}
