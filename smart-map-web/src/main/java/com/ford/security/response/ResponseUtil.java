package com.ford.security.response;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Slf4j
public class ResponseUtil {

    public static <T> Response<T> success(T object) {
        Response<T> result = new Response<>();
        result.setData(object);
        result.setMessage(HttpStatus.OK.getReasonPhrase());
        return result;
    }

    public static <T> Response<T> success() {
        return success(null);
    }

    public static <T> Response<T> error(int code, String message) {
        Response<T> result = new Response<>();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static ResponseEntity<byte[]> getResponseEntity(byte[] bytes, String fileName) throws UnsupportedEncodingException {
        String name = URLEncoder.encode(fileName, StandardCharsets.UTF_8.displayName()).replace("+", "%20");
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + name);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentLength(bytes.length);
        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
    }
}
