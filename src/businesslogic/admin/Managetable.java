//$Id$
package businesslogic.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import beans.Addbean;
import beans.Adminviewbean;
import daos.managetable.ManageDao;
import beans.Managebean;

public class Managetable {
	private ManageDao managedao;
	public boolean cancelBookings(List<Adminviewbean> list) {
		managedao=new ManageDao();
		int val=0;
		try {
			val = managedao.updateCancel(list);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if(val!=0) {
			return true;
		}
		return false;
	}
	public boolean checkIfPresent(int table_no,HashMap<Integer,Addbean> hm) {
		boolean status=false;
		for(Addbean num:hm.values()) {
			if(num.getTableno()==table_no) {
				status=true;
			}
		}
		return status;	
	}
	public boolean updateModify(List<Addbean> list,HashMap<Integer,Addbean> hmList) {
		boolean checkStatus=true;
		List<Addbean> readyList=new ArrayList<>();
		for(Addbean addBeanObj:list) {
			Addbean hmBeanObj=hmList.get(addBeanObj.getTableid());
			if(hmBeanObj.getTableno()!=addBeanObj.getTableno()) {
				if(checkIfPresent(addBeanObj.getTableno(),hmList)) {
					checkStatus=false;
					System.out.println("already this table number is present");
				}
				else {
					readyList.add(addBeanObj);
					continue;
				}
			}
			else if(addBeanObj.getNoseats()!=hmBeanObj.getNoseats()) {
				readyList.add(addBeanObj);
				continue;
			}
			else if(addBeanObj.getPrice()!=hmBeanObj.getPrice()) {
				readyList.add(addBeanObj);
				continue;
			}
		
		}
		if(checkStatus==false) {
			System.out.println("some not updated");	
		}
		System.out.println("ready List size:"+readyList.size());
		boolean updateStatus=false;
		if(readyList!=null&&readyList.size()!=0) {
		managedao=new ManageDao();
		int result=0;
		try {
			result=managedao.updateTableDetails(readyList);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result==readyList.size()) {
			updateStatus=true;
		}
		}
		return checkStatus;
	}
	public List<Addbean> getAllTables(){
		managedao=new ManageDao();
		List<Addbean> list=null;
		try {
			list=managedao.retrieveTables();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public boolean addTable(Addbean addbean) {
		int val=0;
		boolean status=false;
		managedao=new ManageDao();
		try {
			val=managedao.updateDetails(addbean);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if(val!=0) {
			status=true;
			try {
				List<Managebean> list=managedao.getDetails(addbean);
				List<Managebean>  timelist=managedao.retrieveTimeDetails();
				List<Integer> li=new ArrayList<>();
				for(Managebean managebean:timelist){
					li.add(managebean.getTimeid());
				}
				managedao.updateStatus(list.get(0), li);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		}
		return status;
		
	}
	public boolean removeTable(List<Addbean> beanlist) {
		boolean status=false;
		managedao=new ManageDao();
		int num=0;
		try {
			num=managedao.updateTable(beanlist);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(num==beanlist.size()) {
			status=true;
		}
		return status;
	}

}
