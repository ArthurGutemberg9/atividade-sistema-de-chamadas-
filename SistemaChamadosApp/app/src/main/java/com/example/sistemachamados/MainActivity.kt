
package com.example.sistemachamados

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sistemachamados.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ChamadoAdapter

    private val chamados = listOf(
        Chamado("Erro no Login", "Usuário não consegue acessar o sistema", "Aberto"),
        Chamado("Atualização do Servidor", "Servidor passará por manutenção", "Em andamento"),
        Chamado("Troca de Senha", "Solicitação de redefinição de senha", "Concluído"),
        Chamado("Falha na Impressora", "Impressora do setor financeiro parada", "Aberto"),
        Chamado("Internet Instável", "Quedas frequentes de conexão", "Em andamento")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ChamadoAdapter(chamados)

        binding.recyclerChamados.layoutManager = LinearLayoutManager(this)
        binding.recyclerChamados.adapter = adapter

        binding.chipTodos.setOnClickListener {
            adapter.atualizarLista(chamados)
        }

        binding.chipAberto.setOnClickListener {
            adapter.atualizarLista(chamados.filter { it.status == "Aberto" })
        }

        binding.chipAndamento.setOnClickListener {
            adapter.atualizarLista(chamados.filter { it.status == "Em andamento" })
        }

        binding.chipConcluido.setOnClickListener {
            adapter.atualizarLista(chamados.filter { it.status == "Concluído" })
        }
    }
}
