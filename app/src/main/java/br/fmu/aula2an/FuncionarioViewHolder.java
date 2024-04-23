package br.fmu.aula2an;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class FuncionarioViewHolder extends RecyclerView.ViewHolder {
    final TextView re;
    final TextView nome;
    final TextView dataAdmissao;
    final TextView salario;
    public FuncionarioViewHolder(View itemView) {
        super(itemView);
        re = itemView.findViewById(R.id.item_re);
        nome = itemView.findViewById(R.id.item_nome);
        dataAdmissao = itemView.findViewById(R.id.item_data);
        salario = itemView.findViewById(R.id.item_salario);
    }
}
