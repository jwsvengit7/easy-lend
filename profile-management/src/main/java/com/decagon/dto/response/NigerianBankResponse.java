package com.decagon.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NigerianBankResponse {
    private List<String> data;
}