package com.itsara.todolist.models;

import org.springframework.http.HttpStatus;

import java.util.List;

public class Response {
  private HttpStatus statue;
  private Integer code;
  private List<Task> data;

  public Response() {}
  public Response(HttpStatus statue, List<Task> data) {
    this.statue = statue;
    this.code = statue.value();
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

  public List<Task> getData() {
    return data;
  }

  public void setData(List<Task> data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "Response{" +
            "statue=" + statue +
            ", code=" + code +
            ", data=" + data +
            '}';
  }
}
