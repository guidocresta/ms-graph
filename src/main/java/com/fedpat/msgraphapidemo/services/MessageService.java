package com.fedpat.msgraphapidemo.services;

import com.microsoft.graph.models.Message;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
//@RequiredArgsConstructor
public class MessageService {

    private MicrosoftGraphAuthentication microsoftGraphAuthentication;

//    MicrosoftGraphAuthentication microsoftGraphAuthentication;
//
//    public void getListMessages() throws Exception {
//        MessageCollectionResponse messageCollectionResponse = microsoftGraphAuthentication.getGraphClient().me().messages().get(requestConfiguration -> {
//            requestConfiguration.queryParameters.select = new String []{"sender", "subject"};
//        });
//
//        if (messageCollectionResponse != null && messageCollectionResponse.getValue() != null) {
//            for (Message message : messageCollectionResponse.getValue()) {
//                StringBuilder messageInfo = new StringBuilder();
//                messageInfo.append("#ID: ").append(message.getId())
//                        .append(", Asunto: ").append(message.getSubject())
//                        .append(", Remitente: ").append(message.getFrom().getEmailAddress());
//                System.out.println(messageInfo);
//            }
//        }
//    }

//    GraphServiceClient<?> graphClient;

    public List<Message> getListMessages() {
        // Fetch emails from the signed-in user's inbox
        return  microsoftGraphAuthentication.getGraphClient()
                .me()
                .mailFolders("inbox") // Specify the folder ("inbox", "sentitems", etc.)
                .messages()
                .buildRequest()
                .top(10) // Limit the number of messages
                .get()
                .getCurrentPage();
    }
}
