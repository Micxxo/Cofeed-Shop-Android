package com.mico.jobsheet1_praktikumviewsviewgroupsassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    val nama: String = ""
    val email: String = ""
    val notelp: String = ""
    val tanggal: String = ""
    val kopi: String = ""
    val snack = ArrayList<String>()
    val metodePembayaran: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val namaPemesan: EditText = findViewById(R.id.namaPemesan)
        val email: EditText = findViewById(R.id.emailPemesan)
        val telpon: EditText = findViewById(R.id.noPemesan)
        val tgl: EditText = findViewById(R.id.tglPesanan)
        val Menukopi: Spinner = findViewById(R.id.menu)
        val bayar: RadioGroup = findViewById(R.id.pembayaran)
        val btnSubmit: Button = findViewById(R.id.submit)

        btnSubmit.setOnClickListener {
            val nama = namaPemesan.text.toString()
            val email = email.text.toString()
            val telp = telpon.text.toString()
            val tanggal = tgl.text.toString()
            val kopi = Menukopi.selectedItem.toString()
            val pembayaran: Int = bayar.checkedRadioButtonId
            val pembayaranRadio: RadioButton = findViewById(pembayaran)
            val bayar = pembayaranRadio.text.toString()

            val i = Intent(this, Hasil::class.java)
            i.putExtra("NAMA", nama)
            i.putExtra("EMAIL", email)
            i.putExtra("TELPON", telp)
            i.putExtra("TGL", tanggal)
            i.putExtra("KOPI", kopi)
            i.putExtra("PEMBAYARAN", bayar)
            i.putStringArrayListExtra("MAKANAN", snack)
            startActivity(i)
        }
    }
    fun pilihMakan(v: View) {
        val Cb: CheckBox = v as CheckBox
        if (Cb.isChecked) {
            snack.add(Cb.text.toString())
        }else {
            snack.remove(Cb.text.toString())
        }
    }
}