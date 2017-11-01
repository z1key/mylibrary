package org.z1key.projects.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by User on 07.04.2017.
 */
@Entity
@Table(name = "tickets")
public class Ticket implements DomainObject {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "code", nullable = false, updatable = false)
    private String ticketCode;

    @Column(name = "expDate")
    private Date expDate;

    @Enumerated
    @Column(name="type", nullable = false)
    private Type type = Type.BASIC;

    enum Type {
        BASIC,
        VIP;

        Type() {
        }
    }
}
