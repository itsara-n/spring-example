package com.itsara.todolist.models;

import org.springframework.http.HttpStatus;

import java.util.List;

public class Response {
  private HttpStatus statue;
  private Integer code;
  private String message;
  private List<Task> data;

  public Response() {}
  public Response(HttpStatus statue, Integer code, String message, List<Task> data) {
    this.statue = statue;
    this.code = code;
    this.message = message;
    this.data = data;
  }

  public HttpStatus getStatue() {
    return statue;
  }

  public void setStatue(HttpStatus statue) {
    this.statue = statue;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public List<Task> getData() {
    return data;
  }

  public void setData(List<Task> data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "SuccessResponse{" +
        "statue=" + statue +
        ", code=" + code +
        ", message='" + message + '\'' +
        ", data=" + data +
        '}';
  }
}
