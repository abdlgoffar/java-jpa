package com.jpa.orm.notes;

public class T_joinedTableInheritance {
    //joined table inheritance adalah jenis relationship table yang tidak didukung oleh database, konsep ini masuk ke konsep ISA relationship.
    //joined table inheritance membutuhkan table sesuai dengan jumlah entity parent dan child yang ada setiap entity child nantinya yang
    //akan melakukan join primary key dengan table Parent Entity nya.
    //setiap child entity akan memppunyai table yang id nya akan dijadikan foreign key.
    //untuk mengetahui cara pembuatan parent entity konsep joined table inheritance lihat di package entities class Payment,
    //untuk mengetahui cara pembuatan child entity konsep joined table inheritance lihat di package entities class PaymentCreditCard dan PaymentOVO.
}
