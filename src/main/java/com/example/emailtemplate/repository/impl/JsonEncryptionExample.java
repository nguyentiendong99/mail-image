package com.example.emailtemplate.repository.impl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

public class JsonEncryptionExample {

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        // Tạo một đối tượng ví dụ
        MyObject myObject = new MyObject();
        myObject.setName("Example Name");
        myObject.setValue(123);

        try {
            // Chuyển đổi đối tượng thành chuỗi JSON
            String jsonString = objectMapper.writeValueAsString(myObject);
            System.out.println("Chuỗi JSON: " + jsonString);

            // Định nghĩa khóa mã hóa (phải là 16, 24 hoặc 32 ký tự)
            String encryptionKey = "0123456789abcdef";

            // Mã hóa chuỗi JSON
            String encryptedJson = AESUtil.encrypt(jsonString, encryptionKey);
            System.out.println("Chuỗi JSON đã mã hóa: " + encryptedJson);

            // Giải mã chuỗi JSON
            String decryptedJson = AESUtil.decrypt(encryptedJson, encryptionKey);
            System.out.println("Chuỗi JSON đã giải mã: " + decryptedJson);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

@Setter
@Getter
class MyObject {
    // Getter và Setter
    private String name;
    private int value;

}

