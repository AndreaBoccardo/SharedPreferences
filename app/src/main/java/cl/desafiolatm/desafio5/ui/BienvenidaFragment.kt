package cl.desafiolatm.desafio5.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import cl.desafiolatm.desafio5.R
import cl.desafiolatm.desafio5.R.*
import cl.desafiolatm.desafio5.databinding.FragmentBienvenidaBinding


class BienvenidaFragment : Fragment() {

    lateinit var binding: FragmentBienvenidaBinding
    lateinit var archivo: SharedPreferences
    private val ARCHIVO_NAME = "mi_preferencia"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBienvenidaBinding.inflate(inflater,container,false)
        archivo = requireActivity().getSharedPreferences(ARCHIVO_NAME, Context.MODE_PRIVATE)

        with(binding){
            etNombreMsg.text = archivo.getString("name", "No_Name")
            etMensaje.text = getString(string.msg)
            btnSiguiente.setOnClickListener {
                if (archivo.getString("nick", "")!!.isEmpty()){
                    Navigation.findNavController(requireView())
                        .navigate(R.id.action_bienvenidaFragment_to_preferenciaFragment)
                }
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (archivo.getString("nick", "")!!.isNotEmpty()){
            Navigation.findNavController(requireView())
                .navigate(R.id.action_bienvenidaFragment_to_preferenciaFragment)
        }
    }
}