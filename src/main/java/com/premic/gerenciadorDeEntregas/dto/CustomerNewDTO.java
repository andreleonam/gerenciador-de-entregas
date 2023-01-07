package com.premic.gerenciadorDeEntregas.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CustomerNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    private String name;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String street;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String number;

    private String complement;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String district;

    private String zipCode;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String city;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String state;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String phoneNumber01;
    private String phoneNumber02;
    private String phoneNumber03;

    public CustomerNewDTO() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhoneNumber01() {
        return phoneNumber01;
    }

    public void setPhoneNumber01(String phoneNumber01) {
        this.phoneNumber01 = phoneNumber01;
    }

    public String getPhoneNumber02() {
        return phoneNumber02;
    }

    public void setPhoneNumber02(String phoneNumber02) {
        this.phoneNumber02 = phoneNumber02;
    }

    public String getPhoneNumber03() {
        return phoneNumber03;
    }

    public void setPhoneNumber03(String phoneNumber03) {
        this.phoneNumber03 = phoneNumber03;
    }
}
