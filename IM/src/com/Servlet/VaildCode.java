package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class VaildCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VaildCode() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   
        public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
        //������֤��֤��
        {
            String piccode=(String) request.getSession().getAttribute("piccode");
            String checkCode=request.getParameter("checkCode");  //ȡֵ
            checkCode=checkCode.toUpperCase();  //���ַ�ȫ��ת��Ϊ��д�ģ���������������֤�벻���ִ�Сд��
            response.setContentType("text/html;charset=gbk");//�����������
            String str = "";
            PrintWriter out=response.getWriter();
            if(checkCode.equals(piccode))
            {
                str ="{'name':1}";
            }
            else
            {
                str ="{'name':2}";
            }
            JSONObject jo = new JSONObject(str);
            out.print(jo.toString());
            out.flush();//����ˢ��
            out.close();//�����ر�
        }

}
