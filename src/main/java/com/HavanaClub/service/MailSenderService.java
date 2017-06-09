package com.HavanaClub.service;

/**
 * Created by admin on 6/9/2017.
 */
public interface MailSenderService {

    void sendMail(String theme, String mailBody, String email);

}
