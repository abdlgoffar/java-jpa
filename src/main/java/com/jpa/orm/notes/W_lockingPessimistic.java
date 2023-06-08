package com.jpa.orm.notes;

public class W_lockingPessimistic {
    //looking pessimistic adalah ketika terjadi multiple transaksi data di database khususnya UPDATE data maka akan terjadi antrian transaksi,
    //misal terjadi dua transaksi yang sama-sama akan UPDATE data maka transaksi kedua akan menunggu transaksi pertama selesai sebelum transaksi kedua tersebut dimulai/dilakukan.
    //untuk mengetahui cara pembuatan looking pessimistic lihat di package test class LookingPessimisticTesting.

}
