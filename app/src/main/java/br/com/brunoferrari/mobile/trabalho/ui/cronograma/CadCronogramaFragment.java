package br.com.brunoferrari.mobile.trabalho.ui.cronograma;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;

import br.com.brunoferrari.mobile.trabalho.R;
import br.com.brunoferrari.mobile.trabalho.model.Cronograma;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CadCronogramaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CadCronogramaFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View view;
    //objetos telas
    private EditText intNome;
    private EditText editTextText;
    private EditText editTextText2;
    private EditText editTextText3;
    private EditText editTextText5;
    private EditText editTextText6;
    private EditText editTextDate2;
    private Button button;



    public CadCronogramaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CadCronogramaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CadCronogramaFragment newInstance(String param1, String param2) {
        CadCronogramaFragment fragment = new CadCronogramaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.view = inflater.inflate(R.layout.fragment_cad_cronograma, container, false);
        //Binding
        this.intNome = view.findViewById(R.id.intNome);
        this.editTextText = view.findViewById(R.id.editTextText);
        this.editTextText2 = view.findViewById(R.id.editTextText2);
        this.editTextText3 = view.findViewById(R.id.editTextText3);
        this.editTextText5 = view.findViewById(R.id.editTextText5);
        this.editTextText6 = view.findViewById(R.id.editTextText6);
        this.editTextDate2 = view.findViewById(R.id.editTextDate2);
        this.button = view.findViewById(R.id.button);

        this.button.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.button){
            Cronograma cronograma = new Cronograma();

            cronograma.setCliente(this.editTextText.getText().toString());
            cronograma.setDate(this.editTextDate2.getText().toString());
            cronograma.setDescricaoServico(this.editTextText2.getText().toString());
            cronograma.setHorasPorPessoa(this.editTextText3.getText().toString());
            cronograma.setQuantidadePessoas(this.editTextText5.getText().toString());
            cronograma.setMaterial(this.editTextText6.getText().toString());
            cronograma.setNome(this.intNome.getText().toString());

            Toast.makeText(view.getContext(), "Sucesso" , Toast.LENGTH_SHORT).show();
        }
    }
}