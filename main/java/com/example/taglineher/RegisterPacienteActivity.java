package com.example.taglineher;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterPacienteActivity extends AppCompatActivity {
    EditText codigo, nome, aniversario, cidade, rua, numero, telefone;
    Button submit;
    Button exibir;
    DBHelperPaciente MyDB;

 // Inicio Codigo para cadastrar Pacientes
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_paciente);

        codigo = (EditText) findViewById(R.id.codigo);
        nome = (EditText) findViewById(R.id.nome);
        aniversario = (EditText) findViewById(R.id.aniversario);
        cidade = (EditText) findViewById(R.id.cidade);
        rua = (EditText) findViewById(R.id.rua);
        numero = (EditText) findViewById(R.id.numero);
        telefone = (EditText) findViewById(R.id.telefone);

        submit = (Button) findViewById(R.id.submit);

        MyDB = new DBHelperPaciente(this);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String codigo1 = codigo.getText().toString();
                String nome1 = nome.getText().toString();
                String aniversario1 = aniversario.getText().toString();
                String cidade1 = cidade.getText().toString();
                String rua1 = rua.getText().toString();
                String numero1 = numero.getText().toString();
                String telefone1 = telefone.getText().toString();

                if(codigo.equals("") || nome.equals("") || aniversario.equals("") || cidade.equals("") || rua.equals("") || numero.equals("") || telefone.equals(""))
                {
                    Toast.makeText(RegisterPacienteActivity.this, "Fill all the fields", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    Boolean result = MyDB.check(codigo1);
                    if(result == false)
                    {
                        Boolean res = MyDB.insertData(codigo1, nome1, aniversario1, cidade1, rua1, numero1, telefone1);
                        if(res==true)
                        {
                            Toast.makeText(RegisterPacienteActivity.this,"Registrado com SUCESSO!!!!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), PacienteActivity.class);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(RegisterPacienteActivity.this,"O Registro FALHOU!!!", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else{
                        Toast.makeText(RegisterPacienteActivity.this, "Paciente já existe!!!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), RegisterPacienteActivity.class);
                        startActivity(intent);
                    }

                }
            }
        });
    }
 // Final Codigo para cadastrar Pacientes


}