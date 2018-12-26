package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.model.Employee;
import com.util.DbUtil;

public class EmpDao {
	public static Session session;

	public static int insert(Employee e) {
		int status = 0;
		try {
			Connection con = DbUtil.getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into register(name,email,password,token) values(?,?,?,?)");
			ps.setString(1, e.getName());
			ps.setString(2, e.getEmail());
			ps.setString(3, e.getPassword());
			String random = genderate();
			ps.setString(4, random);
			sendEmail(e.getEmail(), random, e.getName());
			status = ps.executeUpdate();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return status;
	}

	public static String genderate() {
		int left = 97;
		int right = 122;
		int maxString = 12;
		Random random = new Random();
		StringBuilder builder = new StringBuilder(maxString);
		for (int i = 0; i < maxString; i++) {
			int randomint = (int) (left + (random.nextFloat() * (right - left + 1)));
			builder.append((char) randomint);
		}
		String generateString = builder.toString();
		System.out.println(generateString);
		return generateString;
	}

	public static void sendEmail(String toEmail, String random, String name) {
		final String fromEmail = "your email id";
		final String password = "your password";

		System.out.println("TLSEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		Authenticator auth = new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		session = Session.getInstance(props, auth);

		try {
			MimeMessage msg = new MimeMessage(session);
			// set message headers
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

			msg.setFrom(new InternetAddress("infantsnursingcaresystem@gmail.com", "NoReply-Pinal"));

			msg.setReplyTo(InternetAddress.parse("infantsnursingcaresystem@gmail.com", false));
			String subject = "activate your account ";

			msg.setSubject(subject, "UTF-8");
			String body = "click here for activate your account " + name
					+ "  <a href='http://localhost:8080/CrudWithEmail/ActivationUser?email=" + toEmail + "&&token="
					+ random + "'>http://localhost:8080/CrudWithEmail/ActivationUser?email='"+toEmail+"'&&token='"+random+"'" + "</a>";

			msg.setContent(body, "text/html; charset=utf-8");
			// msg.setText(body, "UTF-8");

			msg.setSentDate(new Date());

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
			System.out.println("Message is ready");
			Transport.send(msg);

			System.out.println("EMail Sent Successfully!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void resetPasswordEmail(String toEmail, String random, String name) {
		final String fromEmail = "infantsnursingcaresystem@gmail.com";
		final String password = "patel@5291#";

		System.out.println("TLSEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		Authenticator auth = new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		session = Session.getInstance(props, auth);

		try {
			MimeMessage msg = new MimeMessage(session);
			// set message headers
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

			msg.setFrom(new InternetAddress("infantsnursingcaresystem@gmail.com", "NoReply-Pinal"));

			msg.setReplyTo(InternetAddress.parse("infantsnursingcaresystem@gmail.com", false));
			String subject = "reset your password  ";

			msg.setSubject(subject, "UTF-8");
			String body = "click here for reset your password " + name
					+ "  <a href='http://localhost:8080/CrudWithEmail/ForgotPasswordController?email=" + toEmail + "&&token="
					+ random + "'>http://localhost:8080/CrudWithEmail/ForgotPasswordController?email='"+toEmail+"'&&token='"+random+"'" + "</a>";

			msg.setContent(body, "text/html; charset=utf-8");
			// msg.setText(body, "UTF-8");

			msg.setSentDate(new Date());

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
			System.out.println("Message is ready");
			Transport.send(msg);

			System.out.println("EMail Sent Successfully!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static boolean isEmailExixst(String email) {
		boolean res = false;
		try {
			Connection con = DbUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from register where email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			res = rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public static boolean login(String email, String password) {
		boolean res = false;
		try {
			Connection con = DbUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from register where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			res = rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public static String activateStatus(String email) {
		String status = null;
		try {
			// System.out.println(email);
			Connection con = DbUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from register where email='" + email + "'");
			// System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				status = rs.getString(6);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static String checkToken(String email, String token) {
		String status = null;

		try {
			Connection con = DbUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("select token from register where email='" + email + "'");
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				status = rs.getString("token");
				System.out.println(status);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static int activeAccount(String email) {
		int status = 0;
		try {
			Connection con=DbUtil.getConnection();
			PreparedStatement ps=con.prepareStatement("update register set status='yes' where email='"+email+"'");
			System.out.println(ps);
			status=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static int resetAccount(String email)
	{
		int status = 0;
		try {
			Connection con=DbUtil.getConnection();
			String random = genderate();
			resetPasswordEmail(email, random, email);
			PreparedStatement ps=con.prepareStatement("update register set token=? where email=?");
			ps.setString(1, random);
			ps.setString(2, email);
			status =ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public static int changePassword(String email,String password)
	{
		int status=0;
		try {
			Connection con=DbUtil.getConnection();
			PreparedStatement ps=con.prepareStatement("update register set password=? where email=?");
			ps.setString(1, password);
			ps.setString(2, email);
			status=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
