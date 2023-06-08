package com.jpa.orm.notes;

public class S_singleTableInheritance {
    //single table inheritance adalah jenis relationship table yang tidak didukung oleh database, konsep ini masuk ke konsep ISA relationship.
    //single table inheritance hanya membutuhkan satu table untuk menyimpan data entity nya.
    //keuntungan dari konsep ini adalah mudah dan cepat, tidak butuh melakukan join.
    //konsep ini terdiri dari parent entity dan child entity untuk membuat data sesuai kebutuhan field pada entity.
    //intinya parent entity dan child entity itu nanti akan bisa menambahkah data ke dalam table yang sama.
    //untuk mengetahui cara pembuatan parent entity konsep single table inheritance lihat di package entities class Employee1,
    //untuk mengetahui cara pembuatan child entity konsep single table inheritance lihat di package entities class Manager dan Director.
}
