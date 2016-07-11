package com.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import com.dao.IUsersDAO;
import com.dao.UsersDAOImpl;
import com.entity.Sing;
import com.entity.User;
import com.services.ISingsServices;
import com.services.IUsersServices;

import java.io.PrintWriter;
public class SingsAction{
	//private IUsersDAO IUsersDao;
	private ISingsServices ISingsServices;
	private Sing sings;
	String sing_Name[],album_Id[];
	private String outMessage;//�����Ϣ	
	private HttpServletRequest request= ServletActionContext.getRequest();//����request����
	private HttpServletResponse response= ServletActionContext.getResponse();//����response����	
	//��¼
	private PrintWriter out;


	public ISingsServices getISingsServices() {
		return ISingsServices;
	}

	public void setISingsServices(ISingsServices iSingsServices) {
		ISingsServices = iSingsServices;
	}

	/**
	 * �û��б�
	 * @return
	 * @throws IOException
	 */
	public String dolist(){	
		//request.setAttribute("list", IUsersDao.findAll());
		request.setAttribute("list", ISingsServices.list());
		return "albumlist";
	}
	/**
	 * �鿴һ������
	 * @return  
	 * @throws IOException
	 */

	/**
	 * ɾ���û�
	 * @return
	 * @throws IOException
	 */
	public void dodelete(){	
		//request.setAttribute("list", IUsersDao.findAll());
		ISingsServices.delete(Integer.parseInt(request.getParameter("sings_Id")));
		
	}
	/**
	 * �����û�
	 * @return
	 * @throws IOException 
	 * @throws IOException
	 */
	public String singsadd() throws IOException{	
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
//		//IUsersDao.save(users);
		for(int i = 0 ; i < album_Id.length;i++){
			sings = new Sing();
			sings.setAlbum_Id(Integer.parseInt(album_Id[i]));
			sings.setSing_Name(sing_Name[i]);
			ISingsServices.add(sings);
		}
		out.println("�ɹ�"+album_Id.length);
//		out.println("<script language='javascript'>"+"alert('��ӳɹ�!');window.location.href='./list.action';"+"</script>");
		return null;
	}
	public String[] getSing_Name() {
		return sing_Name;
	}

	public void setSing_Name(String[] sing_Name) {
		this.sing_Name = sing_Name;
	}


	public String[] getAlbum_Id() {
		return album_Id;
	}

	public void setAlbum_Id(String[] album_Id) {
		this.album_Id = album_Id;
	}

	/**
	 * �޸��û�
	 * @return
	 * @throws IOException 
	 * @throws IOException
	 */
	public String doupdate() throws IOException{	
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//IUsersDao.save(users);
		ISingsServices.update(sings);
		out.println("<script language='javascript'>"+"alert('�޸ĳɹ�!');window.location.href='./list.action';"+"</script>");
		return null;
	}
	/*
	public IUsersDAO getIUsersDao() {
		return IUsersDao;
	}
	public void setIUsersDao(IUsersDAO iUsersDao) {
		IUsersDao = iUsersDao;
	}
	*/

	public ISingsServices getIAlbumsServices() {
		return ISingsServices;
	}

	public void setIAlbumsServices(ISingsServices iAlbumsServices) {
		ISingsServices = iAlbumsServices;
	}

	public Sing getAlbums() {
		return sings;
	}

	public void setAlbums(Sing albums) {
		albums = albums;
	}

	public String getOutMessage() {
		return outMessage;
	}

	public void setOutMessage(String outMessage) {
		this.outMessage = outMessage;
	}
	

}