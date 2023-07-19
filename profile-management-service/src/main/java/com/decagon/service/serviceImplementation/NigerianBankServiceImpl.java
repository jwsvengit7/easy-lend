//package com.decagon.service.serviceImplementation;
//
//import com.decagon.dto.request.AccountNameRequest;
//import com.decagon.dto.response.AccountNameResponse;
//import com.decagon.dto.response.NigerianBankResponse;
//import com.decagon.service.NigerianBankService;
//import lombok.AllArgsConstructor;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Service;
//import org.springframework.web.reactive.function.client.WebClient;
//
//import java.util.List;
//
//@Service
//@AllArgsConstructor
//public class NigerianBankServiceImpl implements NigerianBankService {
//    private static final String NIBSS_API_URL = "https://nibss-plc.com.ng/cbn-lookup/api/";
//
//    private final WebClient webClient;
//
//    @Override
//    public List<String> getNigerianBanks() {
//        return webClient.get()
//                .uri(NIBSS_API_URL + "banks")
//                .retrieve()
//                .bodyToMono(NigerianBankResponse.class)
//                .map(NigerianBankResponse::getData)
//                .block();
//    }
//
//    @Override
//    public String getAccountName(AccountNameRequest request) {
//        // Make API request to fetch the account name based on the bank and account number
//        String bank = request.getBank();
//        String accountNumber = request.getAccountNumber();
//
//        // Perform the API request and retrieve the account name
//        String accountName = performAccountNameApiRequest(bank, accountNumber);
//
//        return accountName;
//    }
//
//    private String performAccountNameApiRequest(String bank, String accountNumber) {
//        String apiUrl = "https://api.nigerianbank.com/account/name";
//
//        AccountNameRequest requestBody = new AccountNameRequest(bank, accountNumber);
//
//        return webClient.post()
//                .uri(apiUrl)
//                .contentType(MediaType.APPLICATION_JSON)
//                .bodyValue(requestBody)
//                .retrieve()
//                .bodyToMono(AccountNameResponse.class)
//                .map(AccountNameResponse::getAccountName)
//                .block();
//    }
//
//}
//
//
