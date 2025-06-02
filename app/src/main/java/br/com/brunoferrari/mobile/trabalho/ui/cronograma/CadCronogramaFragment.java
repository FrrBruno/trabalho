package br.com.brunoferrari.mobile.trabalho.ui.cronograma;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;

import br.com.brunoferrari.mobile.trabalho.R;
import br.com.brunoferrari.mobile.trabalho.model.Cronograma;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CadCronogramaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CadCronogramaFragment extends Fragment
        implements View.OnClickListener, Response.ErrorListener, Response.Listener {

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
    private RequestQueue requestQueue;
    private JsonObjectRequest jsonObjectRequest;



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
        //instanciando a fila de requests - caso o objeto seja o view
        this.requestQueue = Volley.newRequestQueue(view.getContext());
//inicializando a fila de requests do SO
        this.requestQueue.start();

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
            //REQUEST VOLLEY AQUI !!!!!!!
            JsonObjectRequest jsonObjectReq = new JsonObjectRequest(
                    Request.Method.POST,
                    "http://10.0.2.2/seg/comAutenticacao.php",
                    cronograma.toJsonObject(), this, this);
            requestQueue.add(jsonObjectReq);
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Snackbar mensagem = Snackbar.make(view,
                "Ops! Houve um problema ao realizar o cadastro: " +
                        error.toString(),Snackbar.LENGTH_LONG);
        mensagem.show();

    }

    @Override
    public void onResponse(Object response) {
        try {
            //instanciando objeto para manejar o JSON que recebemos
            JSONObject jason = new JSONObject(response.toString());
            //context e text são para a mensagem na tela o Toast
            Context context = view.getContext();
            //pegando mensagem que veio do json
            CharSequence mensagem = jason.getString("message");
            //duração da mensagem na tela
            int duration = Toast.LENGTH_SHORT;

            if (jason.getBoolean("success")){
                //limpar campos da tela
                this.editTextDate2.setText("");
                this.editTextText.setText("");
                this.editTextText2.setText("");
                this.editTextText5.setText("");
                this.editTextText3.setText("");
                this.editTextText6.setText("");
                this.intNome.setText("");
                //selecionando primeiro item dos spinners
                this.intNome.setSelection(0);

            }
            //mostrando a mensagem que veio do JSON
            Toast toast = Toast.makeText (context, mensagem, duration);
            toast.show();

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }


    }
}