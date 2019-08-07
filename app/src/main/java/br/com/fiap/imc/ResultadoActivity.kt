package br.com.fiap.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_resultado.*
import kotlin.math.pow

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val peso = intent.getDoubleExtra("PESO", 0.0)
        val altura = intent.getDoubleExtra("ALTURA", 0.0)
        val sexo = intent.getStringExtra("SEXO")

        val imc = peso / altura * altura

        when (sexo) {
            getString(R.string.label_masculino) -> calcularMasculino(imc)
            getString(R.string.label_feminino) -> calcularFeminino(imc)
            else -> {
            }
        }
    }

    private fun calcularMasculino(imc: Double) {
        tvIMC.text = imc.toFixed(2)

        if (imc < 20) {
            tvStatusIMC.text = "Abaixo do peso"
            configuraImagem(R.drawable.masc_abaixo)
        } else if (imc < 25) {
            tvStatusIMC.text = "Normal"
            configuraImagem(R.drawable.masc_ideal)
        } else if (imc < 30) {
            tvStatusIMC.text = "Obesidade Leve"
            configuraImagem(R.drawable.masc_sobre)
        } else if (imc < 43) {
            tvStatusIMC.text = "Obesidade Moderada"
            configuraImagem(R.drawable.masc_obeso)
        } else {
            tvStatusIMC.text = "Obesidade extrema"
            configuraImagem(R.drawable.masc_extremo_obeso)
        }
    }

    private fun configuraImagem(resourceId: Int) {
        ivIMC.setImageDrawable(
            ContextCompat.getDrawable(this, resourceId)
        )
    }

    private fun calcularFeminino(imc: Double) {

    }

}
