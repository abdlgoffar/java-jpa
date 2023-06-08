package com.jpa.orm.notes;

public class Y_schema {
    //schema adalah nama-nama penjelasan dari elemen, relasi-relasi antar tabel, dan logika model di database.
    //jpa mempunyai fitur untuk membuat schema secara otomatis, namun fitur ini sangat tidak di sarankan karena nanti penamaan-penamaan relasi dan element akan random
    //sehingga sulit diingat dan dilacak.
    //namun apabila ingin menggunakn fitur ini cukup menambahkan config di file .xml dengan code seperti contoh di bawah
    //<property name="jakarta.persistence.schema-generation.database.action" value="drop-and-create"/>
    //untuk value pada property tersedia "drop-and-create" artinya hapus semua table dahulu lalu buat lagi, "create" artinya buat table, "drop" hapus semua table,
    //lalu "none" tidak membuat dan menghapus table apapun.
}
