package br.com.fiap.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btCalcular.setOnClickListener {
            navigateToResult()
        }

        btLimpar.setOnClickListener {
            cleanFields()
        }
    }

    fun navigateToResult() {
        val intent = Intent(this, ResultadoActivity::class.java)
        intent.putExtra("PESO", inputPeso.text.toString().toDouble())
        intent.putExtra("ALTURA", inputAltura.text.toString().toDouble())
        intent.putExtra("SEXO", spSexo.selectedItem.toString())
        startActivity(intent)
    }

    fun cleanFields() {
        inputAltura.setText("")
        inputPeso.setText("")
    }
}
