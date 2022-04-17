package com.geekwys.expresscheckout.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Configs {
    private String accessKey;
    private String ivKey;
    private String secretKey;
}
