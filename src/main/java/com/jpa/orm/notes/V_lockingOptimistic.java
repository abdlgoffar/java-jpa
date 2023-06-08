package com.jpa.orm.notes;

public class V_lockingOptimistic {
    //locking optimistic adalah ketika terjadi multiple transaksi data di database khususnya UPDATE data, maka transaksi UPDATE data paling cepat
    //yang akan di save/commit oleh database sementara transaksi yang belakangan akan dibuat failed/rollback oleh database.
    //locking optimistic sangat cepat karena tidak butuh melakukan lock data, sehingga tidak perlu menunggu transaksi yang melakukan lock,
    //Konsekuensinya, Pada Optimistic Locking, transaksi akan sering melakukan rollback jika ternyata data yang di commit sudah berubah.
    //untuk membuat locking optimistic maka dibutuhkan tambahan column sebagai penanda bahwa data tersebut pernah di UPDATE, pada java jpa column
    //penanda locking optimistic harus diberi annotation @Version dan type datanya Long atau Timestamp, nanti column penanda tersebut akan otomatis
    //di update oleh java jpa sesuai transaksi UPDATE yang pernah ada pada data tersebut.
}
