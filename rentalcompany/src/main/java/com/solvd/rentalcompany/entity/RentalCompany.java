package com.solvd.rentalcompany.entity;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Users")
public class RentalCompany {
    @XmlElement
    public List<User> users = new ArrayList<>();
}
