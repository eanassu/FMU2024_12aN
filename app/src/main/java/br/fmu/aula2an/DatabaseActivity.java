package br.fmu.aula2an;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatabaseActivity extends AppCompatActivity {

    private EditText editTextRe;
    private EditText editTextNome;
    private EditText editTextDataAdmissao;
    private EditText editTextSalario;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        editTextRe = findViewById(R.id.editTextRe);
        editTextNome = findViewById(R.id.editTextNome);
        editTextDataAdmissao = findViewById(R.id.editTextDataAdmissao);
        editTextSalario = findViewById(R.id.editTextSalario);
    }

    private void limpar() {
        editTextRe.getText().clear();
        editTextNome.getText().clear();
        editTextDataAdmissao.getText().clear();
        editTextSalario.getText().clear();
    }

    public void cadastrar(View view ) {
        AppDatabase db = AppDatabase.getInstance(this);
        FuncionarioDao dao = db.funcionarioDao();
        int re = Integer.parseInt(editTextRe.getText().toString());
        String nome = editTextNome.getText().toString();

        Date dataAdmissao;
        try {
            dataAdmissao = dateFormat.parse(editTextDataAdmissao.getText().toString());
        } catch( ParseException r ) {
            dataAdmissao = new Date();
        }
        double salario = Double.parseDouble(editTextSalario.getText().toString());
        Funcionario f = new Funcionario(re, nome, dataAdmissao, salario);
        if ( view.getId() == R.id.button3 ) {
            dao.insert(f);
        } else if ( view.getId() == R.id.button5) {
            dao.update(f);
        } else {
            dao.delete(f);
        }
        limpar();
    }

    public void buscar( View view ) {
        AppDatabase db = AppDatabase.getInstance(this);
        FuncionarioDao dao = db.funcionarioDao();
        int re = Integer.parseInt(editTextRe.getText().toString());
        Funcionario f = dao.buscarPeloRe(re);
        editTextNome.setText(f.getNome());
        editTextDataAdmissao.setText(dateFormat.format(f.getDataAdmissao()));
        editTextSalario.setText(Double.toString(f.getSalario()));
    }

    public void lista(View view) {
        Intent intent = new Intent( this, ListaActivity.class );
        startActivity(intent);
    }
 }