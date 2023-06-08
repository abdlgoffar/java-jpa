package com.jpa.orm.notes;

public class M_updateCollectionOrMapField {
    //saat melakukan update pada data collection or map maka semua data di table field collection or map akan dihapus
    //dan semua index data tesebut akan berubah, oleh karena itu disarankan data pada field collection or map tidak dijadikan foreign key.
    //jika ingin menggunakan data collection or map sebagai foreign key, maka harus menggunakan konsep jpa relationship.
    //untuk mengetahui cara pembuatan collection or map field updata data lihat di package test class FieldCollectionOrMapUpdate.
}
