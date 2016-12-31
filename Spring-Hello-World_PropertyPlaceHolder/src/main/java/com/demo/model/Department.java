/**
 * 
 */
package com.demo.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Shree
 *
 */

/*<bean id="department" name="mydepartment" class="com.demo.model.Department"> -->
<!-- 		<property name="deptHead" value="${dept.deprtmentHead}"></property> -->
<!-- 		<property name="deptName" value="${dept.deprtmentHead}"></property> -->
<!-- 	</bean> -->*/

@Component("mydepartment")
public class Department {

	@Value("${dept.deprtmentHead}")
	private String deptName;
	@Value("${dept.departmentName}")
	private String deptHead;

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptHead() {
		return deptHead;
	}

	public void setDeptHead(String deptHead) {
		this.deptHead = deptHead;
	}

}
