package org.application.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;

@Getter
@Setter
@Entity
@Table(name = "client")
public class Client {

    @Id
    private int id;


    @Column
    private String name;
}
