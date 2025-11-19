package com.minorproject.mailingAssistant.Service;

import com.minorproject.mailingAssistant.Model.EmailRequest;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
public class EmailGeneratorService {

    public String GenerateEmailReply(EmailRequest emailRequest){
    //Build prompt
        String prompt=buildPrompt(emailRequest);

        // craft request
        Map<String, Object> requestBody=Map.of(
                "contents" ,new Object[] {
                        Map.of(
                                "parts",new Object[]{
                                        Map.of(
                                                "text",prompt
                                        )
                                }
                        )
                }
        );

        // Do request and get response



        // return response

        return null;
    }

    private String buildPrompt(EmailRequest emailRequest) {
        StringBuilder prompt=new StringBuilder();
        prompt.append("Generate a professional email reply for the following email Content. Please don't generate a subject line ");
        if(emailRequest.getTone() !=null && !emailRequest.getTone().isEmpty()){
        prompt.append("Use a").append(emailRequest.getTone()).append(" tone. ");

        }
        prompt.append("\n Original email : \n").append(emailRequest.getEmailContent());

        return prompt.toString();
    }

}
