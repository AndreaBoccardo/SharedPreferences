package cl.desafiolatm.desafio5.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import cl.desafiolatm.desafio5.R
import cl.desafiolatm.desafio5.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding
    lateinit var archivo: SharedPreferences
    private val ARCHIVO_NAME = "mi_preferencia"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        archivo = requireActivity().getSharedPreferences(ARCHIVO_NAME, Context.MODE_PRIVATE)

        with(binding){
            btnIngresar.setOnClickListener {
                if (etNombre.text.isNotEmpty()){
                    val usuario = etNombre.text.toString()
                        archivo.edit().putString("name", usuario).putBoolean("login", true).commit()
                        Navigation.findNavController(requireView())
                            .navigate(R.id.action_loginFragment_to_bienvenidaFragment)

                } else {
                    Toast.makeText(context, getString(R.string.ms_nombre), Toast.LENGTH_LONG).show()
                }
            }
        }

        return binding.root
    }
}