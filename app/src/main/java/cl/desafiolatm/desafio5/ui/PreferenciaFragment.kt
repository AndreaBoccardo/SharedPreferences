package cl.desafiolatm.desafio5.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cl.desafiolatm.desafio5.R
import cl.desafiolatm.desafio5.databinding.FragmentPreferenciaBinding

class PreferenciaFragment : Fragment() {

    lateinit var binding: FragmentPreferenciaBinding
    lateinit var archivo: SharedPreferences
    private val ARCHIVO_NAME = "mi_preferencia"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPreferenciaBinding.inflate(inflater,container,false)
        archivo = requireActivity().getSharedPreferences(ARCHIVO_NAME, Context.MODE_PRIVATE)

        with(binding){
             tvNombPref.text = archivo.getString("name", "No_Name")
                if (archivo.getString("nick", "")!!.isNotEmpty()){
                    tvSaludo.text = getString(R.string.ms_preferencia)
                    mostrarSP()
                } else {
                    tvSaludo.text = getString(R.string.ms_selec_prefe)
                    btnGuardar.setOnClickListener {
                        guardarSP()
                    }
                }
        }

        return binding.root
    }

    private fun guardarSP(){
        with(binding){
            if (cbEspaniol.isChecked){
                val eligeEspaniol = cbEspaniol.isChecked
                archivo.edit().putBoolean("espaniol", eligeEspaniol).commit()
            }
            if (cbIngles.isChecked){
                val eligeIngles = cbIngles.isChecked
                archivo.edit().putBoolean("ingles", eligeIngles).commit()
            }
            if (cbAleman.isChecked){
                val eligeAleman = cbAleman.isChecked
                archivo.edit().putBoolean("aleman", eligeAleman).commit()
            }
            if (cbOtro.isChecked){
                val eligeOtro = cbOtro.isChecked
                archivo.edit().putBoolean("otro", eligeOtro).commit()
            }
            if (tvIdioma.text.isNotEmpty()){
                val otroIdioma:String = tvIdioma.text.toString()
                archivo.edit().putString("otroIdioma", otroIdioma).commit()
            }
            if (tvIngresaNick.text.isNotEmpty()){
                val nick:String = tvIngresaNick.text.toString()
                archivo.edit().putString("nick", nick).commit()
            }
            if (tvEdad.text.isNotEmpty()){
                val edad:Int = tvEdad.text.toString().toInt()
                archivo.edit().putInt("edad", edad).commit()
            }
        }
    }

    private fun mostrarSP(){
        with(binding){
            val eligeSpaniol = archivo.getBoolean("espaniol", false)
            cbEspaniol.isChecked = eligeSpaniol
            val eligeIngles = archivo.getBoolean("ingles", false)
            cbIngles.isChecked = eligeIngles
            val eligeAleman = archivo.getBoolean("aleman", false)
            cbAleman.isChecked = eligeAleman
            val eligeOtro = archivo.getBoolean("otro", false)
            cbOtro.isChecked = eligeOtro
            tvNick.text = Editable.Factory.getInstance()
                .newEditable(archivo.getString("nick", ""))
            tvIdioma.text = Editable.Factory.getInstance()
                .newEditable(archivo.getString("otroIdioma", ""))
            tvIngresaNick.text = Editable.Factory.getInstance()
                .newEditable(archivo.getString("nick", ""))
            tvEdad.text = Editable.Factory.getInstance()
                .newEditable(archivo.getInt("edad", 0).toString())
        }
    }
}