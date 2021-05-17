package nexgen.automation.framework.sendmail;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.config.ReadConfig;





import nexgen.automation.framework.constant.ExecutionResult;

import nexgen.automation.framework.util.BaseClassUtil;
import nexgen.automation.framework.util.XLUtils;


public class SendMailSSLWithAttachment {
	
	final  Logger log = Logger.getLogger(SendMailSSLWithAttachment.class);

	public void sendmail() throws Exception {
		
		BaseClassUtil util = new BaseClassUtil();

		ReadConfig mailconfig = new ReadConfig();
		
		// Create object of Property file
		Properties props = new Properties();

		// this will set host of server- you can change based on your requirement
		props.put("mail.smtp.host", mailconfig.emailHost());

		// set the port of socket factory
		props.put("mail.smtp.socketFactory.port", mailconfig.mailPort());

		// set socket factory
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		// set the authentication to true
		props.put("mail.smtp.auth", "true");

		// set the port of SMTP server
		props.put("mail.smtp.port", mailconfig.mailPort());

		// This will handle the complete authentication
		Session session = Session.getDefaultInstance(props,

				new javax.mail.Authenticator() {

					protected PasswordAuthentication getPasswordAuthentication() {

						return new PasswordAuthentication(mailconfig.mailUserName(), mailconfig.mailPassword());

					}

				});

		try {

			// Create object of MimeMessage class
			Message message = new MimeMessage(session);

			// Set the from address
			message.setFrom(new InternetAddress(mailconfig.mailUserName()));

			// Set the recipient address
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailconfig.to()));

			message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(mailconfig.cc()));
			
			message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(mailconfig.bcc()));
			
			// Add the subject link
			message.setSubject("NextGen iCEDQ Automation Report");

			// Create object to add multimedia type content
			BodyPart messageBodyPart1 = new MimeBodyPart();

			// Set the body of email

			StringBuilder mailBody = new StringBuilder();
			mailBody.append("Hi <b>Team</b>,");
			mailBody.append("<br/>");
			mailBody.append("<br/>");
			mailBody.append("Automation Scripts has been run on <b>" + util.gethost()
					+ "</b> and following are the result.");
			mailBody.append("<br/><br/>");
			mailBody.append("<html><body style='font-family:arial'><div align=\"center\">")
					.append("<table style='font-size:10pt' >");

			// add columns in mail
			mailBody.append(
					"<table bgcolor=\"#e0e0e0\" style=\"BORDER-TOP:8px solid;\" width=\"800\" height=\"104\" align=\"center\" border=\"1\"><tr align=\"center\"><th>"
							+ "Start Time (IST)  " + "</th> <th>" +"End Time (IST)  " + "</th> <th>" + "TestSuite Name  "
							+ "</th> <th><html><font color=\"green\">" + "Passed "
							+ "</th> <th><html><font color=\"red\">" + "Failed "
							+ "</th> <th><html><font color=\"blue\">" + "Skipped ");

			// add the column results in mail body
			mailBody.append("<tr align=\"center\">");
			mailBody.append("<td>");
			mailBody.append(BaseSuite.timesp);
			mailBody.append("</td>");
			mailBody.append("<td>");
			mailBody.append(BaseSuite.endTime);

			mailBody.append("</td>");
			mailBody.append("<td>");
			mailBody.append(ExecutionResult.suitename);
			mailBody.append("</td>");

			mailBody.append("<td>");
			mailBody.append("<html><font color=\"green\">").append(ExecutionResult.passedTC).append("</font></html>");
			mailBody.append(" </td>");
			mailBody.append("<td>");
			mailBody.append("<html><font color=\"red\">").append(ExecutionResult.failedTC).append("</font></html>");
			mailBody.append(" </td>");
			mailBody.append("<td>");
			mailBody.append("<html><font color=\"blue\">").append(ExecutionResult.testskip).append("</font></html>");
			mailBody.append(" </td>");
			mailBody.append("</table>");
			mailBody.append("</table></div></body></html>");
			mailBody.append("<br/><br/>");
			mailBody.append("Application URL : ").append("<b>").append(BaseSuite.baseURL).append("</b>");
			mailBody.append("<br/><br/>");
			mailBody.append("Total number of test cases : ").append("<b>").append(ExecutionResult.totalcount).append("</b>");
			mailBody.append("<br/><br/>");
			mailBody.append("All the test cases status are updated in X-Ray test execution.");
			mailBody.append("<br/><br/>");
			mailBody.append("X-Ray test execution URL : ").append("<b>").append(mailconfig.xRayBaseUrl()+BaseSuite.executionKey).append("</b>");;
			mailBody.append("<br/><br/>");
			mailBody.append("<b>Note</b> :This email was sent automatically by ");
			mailBody.append("<html><font color=\"orange\">").append("<b>"+mailconfig.companyName()+"</b>").append("</font></html>");
			mailBody.append(" System. Please do not reply.");
			mailBody.append("<br/><br/>");
			mailBody.append("<br><b>Thanks,</b><br><b><i>"+mailconfig.mailSignatureName()+".</i></b><br><br>");

			messageBodyPart1.setContent(mailBody.toString(), "text/html");

			MimeBodyPart messageBodyPart2 = new MimeBodyPart();

			// Mention the file which you want to send
			String filename = System.getProperty("user.dir") + "/reports/"+ExecutionResult.suitename+"-reports"+"/"+ BaseSuite.reportname;

			log.info(filename);

			// Create data source and pass the filename
			DataSource source = new FileDataSource(filename);

			// set the handler
			messageBodyPart2.setDataHandler(new DataHandler(source));

			// set the file
			messageBodyPart2.setFileName(new File(filename).getName());

			// Create object of MimeMultipart class
			Multipart multipart = new MimeMultipart();

			// add body part 1
			multipart.addBodyPart(messageBodyPart2);

			// add body part 2
			multipart.addBodyPart(messageBodyPart1);

			// set the content
			message.setContent(multipart);

			// finally send the email
			Transport.send(message);

			log.info("=====Email Sent=====");

		} catch (MessagingException e) {


			  log.error(e.getMessage());;

			  //log.error(e.getMessage());;
			throw new RuntimeException(e);


		}

	}

}