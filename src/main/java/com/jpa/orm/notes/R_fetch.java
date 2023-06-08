package com.jpa.orm.notes;

public class R_fetch {
    //fetch adalah proses menampilkan data atau query SELECT data dari database.
    //terdapat beberapa aturan fetch pada entity yang mempunyai relasi dengan entity lain,
    //beberapa jenis relasi memiliki value fetch EAGER, artinya saat kita melakukan find Entity,
    //relasinya akan secara otomatis di JOIN, walaupun kita tidak membutuhkan relasinya.
    //Kebalikan dari EAGER adalah LAZY, dimana artinya relasi akan di QUERY ketika kita memanggil attribute nya, jika tidak, maka tidak akan di QUERY.
    //contoh beberapa relationship entity dan fetch type nya, @One to One = EAGER, @One to Many = LAZY, @Many to One = EAGER, @Many to Many = LAZy.
    //namun fetch type EAGER pada relationship entity bisa di ubah enjadi LAZY.
    //untuk mengetahui cara mengubah fetch type EAGER pada relationship entity menjadi LAZY lihat di package entities class Sale.
}
