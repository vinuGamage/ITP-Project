package pojo_model.employee_hr_payroll_management.generators;

import dao_service.RetrieveDAO;

public class PrimaryKeyGenerator {
	public int newSecurityId() {
		int last = RetrieveDAO.getLastSecurityId();
		last++;
		return last;
	}
	
	public String personIdGenerator() {
		String last = RetrieveDAO.getLastPersonId();
		String newId = null;
		if(last != null && !last.equals("")) {
			int orderInt = Integer.parseInt(last.substring(4));
			orderInt++;
			String orderIntString = null;
			
			if(orderInt <= 9999) {
				if(orderInt > 0 && orderInt < 10)
					orderIntString = "000" + orderInt;
				
				else if(orderInt > 9 && orderInt < 100)
					orderIntString = "00" + orderInt;
				
				else if(orderInt > 99 && orderInt < 1000)
					orderIntString = "0" + orderInt;
				
				else if(orderInt > 999 && orderInt < 10000)
					orderIntString = Integer.toString(orderInt);
				
				newId = last.substring(0, 4).concat(orderIntString);
			} else {
				char subCat01 = last.charAt(2);
				char subCat02 = last.charAt(3);
				char newSubCat02;
				char newSubCat01;
				
				if(subCat02 != 'Z') {
					newSubCat01 = subCat01;
					newSubCat02 = (char) (subCat02 + 1);
				} else {
					newSubCat01= (char) (subCat01 + 1);
					newSubCat02 = 'A';
				}
				newId = newSubCat01 + newSubCat02 + "0001";
			}
		} else {
			newId = "PRAA0001";
		}
	return newId;
	}
}
