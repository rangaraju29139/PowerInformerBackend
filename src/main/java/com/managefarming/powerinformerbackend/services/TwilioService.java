package com.managefarming.powerinformerbackend.services;

import com.managefarming.powerinformerbackend.DTO.contactInfo.ContactInfoDto;
import com.managefarming.powerinformerbackend.entities.Device;
import com.managefarming.powerinformerbackend.enums.DeviceEventType;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;
import com.twilio.type.Twiml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TwilioService {

    @Autowired
    private ContactInfoService contactInfoService;




    @Value("${twilio.secrets.TWILIO_CLIENT_ID}")
    private  String ACCOUNT_SID ;
    @Value("${twilio.secrets.TWILIO_CLIENT_SECRET}")
    private  String AUTH_TOKEN;

    @Value("${twilio.secrets.TWILIO_FROM_PHONENUMBER}")
    private String FROM_PHONENUMBER;

    @Value("${twilio.secrets.TWILIO_DEFAULT_TO_PHONENUMBER}")
    private String DEFAULT_T0_PHONENUMBER;


    public void sendInformation(Device device, DeviceEventType deviceEventType) {
        List<ContactInfoDto> contactList= contactInfoService.getAllContactInfoByDeviceId(device.getDeviceId());

        String message = "Hello  we are calling from PowerInformer, There is a power "+ deviceEventType.toString() + "happened at your device "+device.getDeviceName();

        makeCall(contactList,message);


    }

    public  void makeCall(List<ContactInfoDto> contactList, String message) {
        ContactInfoDto firstContact = contactList.get(0);
        String completePhoneNumber = firstContact.getCountryCode()+""+firstContact.getPhoneNumber();

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        String from = FROM_PHONENUMBER;
        String to = completePhoneNumber;

        Call call = Call.creator(new PhoneNumber(to), new PhoneNumber(from),
                new Twiml(message)).create();

        System.out.println(call.getSid());
    }

    public  void makeCall() {

        String completePhoneNumber = DEFAULT_T0_PHONENUMBER;

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        String from = FROM_PHONENUMBER;
        String to = completePhoneNumber;

        Call call = Call.creator(new PhoneNumber(to), new PhoneNumber(from),
                new Twiml("Hello")).create();

        System.out.println(call.getSid());
    }


}
