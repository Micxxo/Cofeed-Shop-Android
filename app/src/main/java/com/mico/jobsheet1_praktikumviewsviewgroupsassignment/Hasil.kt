package com.mico.jobsheet1_praktikumviewsviewgroupsassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class Hasil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil)

        supportActionBar?.hide()

        val viewNama: TextView = findViewById(R.id.namaPemesan)
        val viewEmail: TextView = findViewById(R.id.emailPemesan)
        val viewTelpon: TextView = findViewById(R.id.noPemesan)
        val viewTgl: TextView = findViewById(R.id.tglPesanan)
        val viewKopi: TextView = findViewById(R.id.kopi)
        val viewSnacks: TextView = findViewById(R.id.snack)
        val viewPembayaran: TextView = findViewById(R.id.pembayaran)

        val data = intent.extras
        if(data != null) {
            viewNama.text = data.getString("NAMA")
            viewEmail.text = data.getString("EMAIL")
            viewTelpon.text = data.getString("TELPON")
            viewTgl.text = data.getString("TGL")
            viewKopi.text = data.getString("KOPI")
            viewPembayaran.text = data.getString("PEMBAYARAN")
            var StringSnack: String = "";
            for (snack in data.getStringArrayList("MAKANAN")!!) {
                StringSnack += "$snack\n"
            }
            viewSnacks.text = StringSnack
        }
    }
}